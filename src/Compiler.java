import ASTJinja2withHTMLandCSS.Jinja2Runner;
import FlaskStatement.Program;
import SymbolsTable.SymbolsTable;
import antlr.grammar.flask.AntlrToProgram;
import antlr.grammar.flask.FlaskExprLexer;
import antlr.grammar.flask.FlaskExprParser;
import codegen.CodeGenerator;
import codegen.EvaluationException;
import codegen.GeneratedPage;
import codegen.PythonEvaluator;
import codegen.RouteRunner;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import report.ReportWriter;
import semantic.SemanticAnalyzer;
import semantic.SemanticError;
import semantic.TemplateBinding;
import util.Sources;
import util.SyntaxErrorCollector;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * One end-to-end compilation: parse, analyse, execute, generate, report.
 * <p>
 * Written as a re-runnable unit because the watcher calls it again on every save.
 * That is also why {@link #resetSharedState()} exists — the symbol tables are
 * singletons, and a second run over stale entries would report names that no longer
 * exist in the source.
 */
public class Compiler {

    /** What one run produced. */
    public record Result(Program pythonAST,
                         Map<String, ASTJinja2withHTMLandCSS.ASTNode> templates,
                         List<SemanticError> errors,
                         List<TemplateBinding> bindings,
                         List<GeneratedPage> pages,
                         List<Path> writtenFiles,
                         List<String> notes,
                         List<SyntaxErrorCollector.SyntaxError> syntaxErrors,
                         PythonEvaluator evaluator,
                         long elapsedMillis,
                         String failure) {

        public boolean failed() {
            return failure != null;
        }

        /** True when nothing can be trusted downstream of the parser. */
        public boolean hasSyntaxErrors() {
            return !syntaxErrors.isEmpty();
        }
    }

    private final Options options;

    /** Parse errors from both front ends, collected across one run. */
    private final List<SyntaxErrorCollector.SyntaxError> syntaxErrors = new ArrayList<>();

    public Compiler(Options options) {
        this.options = options;
    }

    // ============================================================

    public Result run() {
        long startedAt = System.currentTimeMillis();
        resetSharedState();

        List<String> notes = new ArrayList<>();
        List<GeneratedPage> pages = new ArrayList<>();
        List<Path> written = new ArrayList<>();
        syntaxErrors.clear();

        Program pythonAST;
        Map<String, ASTJinja2withHTMLandCSS.ASTNode> templates;
        try {
            pythonAST = parseFlaskApp(options.projectDir().resolve("app.py"), notes);
            templates = parseTemplates(notes);
        } catch (Exception e) {
            return failure(e.getMessage(), notes, startedAt);
        }

        SymbolsTable symbols = SymbolsTable.getFlaskInstance();
        SemanticAnalyzer analyzer = new SemanticAnalyzer(symbols);
        analyzer.analyzePythonProgram(pythonAST, "app.py");
        analyzer.checkTemplateFiles(templates.keySet());
        templates.forEach(analyzer::analyzeTemplate);
        List<TemplateBinding> bindings = analyzer.getRoutes().getBindings();

        PythonEvaluator evaluator = new PythonEvaluator();
        if (!options.astOnly()) {
            pages = executeRoutes(evaluator, pythonAST, notes);
            written.addAll(writeSite(pythonAST, pages, templates, notes));
        }

        long elapsed = System.currentTimeMillis() - startedAt;
        written.addAll(writeReports(pythonAST, templates, analyzer.getErrors(),
                bindings, pages, notes, elapsed));

        return new Result(pythonAST, templates, analyzer.getErrors(), bindings,
                pages, written, notes, List.copyOf(syntaxErrors), evaluator, elapsed, null);
    }

    /**
     * Clears state that outlives a run. Both symbol tables are singletons, so
     * without this a rebuild would keep symbols from files the user has since edited.
     */
    private void resetSharedState() {
        SymbolsTable.getFlaskInstance().clearFlaskST();
        SymbolsTable.getHtmlInstance().clearHtmlST();
    }

    private Result failure(String message, List<String> notes, long startedAt) {
        notes.add(message);
        return new Result(null, Map.of(), List.of(), List.of(), List.of(), List.of(),
                notes, List.copyOf(syntaxErrors), null,
                System.currentTimeMillis() - startedAt, message);
    }

    // ============================================================
    //                        Front end
    // ============================================================

    private Program parseFlaskApp(Path appFile, List<String> notes) throws IOException {
        if (!Files.isRegularFile(appFile)) {
            throw new IOException("app.py not found at " + appFile);
        }
        String code = Sources.read(appFile);

        FlaskExprLexer lexer = new FlaskExprLexer(CharStreams.fromString(code));
        FlaskExprParser parser = new FlaskExprParser(new CommonTokenStream(lexer));

        // Without this, ANTLR prints to the console and the run still reports
        // "0 errors" for a file that never parsed.
        SyntaxErrorCollector collector = new SyntaxErrorCollector("app.py");
        parser.removeErrorListeners();
        parser.addErrorListener(collector);

        ParseTree tree = parser.program();
        syntaxErrors.addAll(collector.getErrors());

        AntlrToProgram visitor = new AntlrToProgram();
        Program program = visitor.visit(tree);
        visitor.getBuildErrors().forEach(error -> notes.add("build: " + error));
        return program;
    }

    /** Parses every template once; the trees feed analysis, generation and reports. */
    private Map<String, ASTJinja2withHTMLandCSS.ASTNode> parseTemplates(List<String> notes)
            throws Exception {
        Map<String, ASTJinja2withHTMLandCSS.ASTNode> templates = new LinkedHashMap<>();
        for (Path file : templateFiles()) {
            Jinja2Runner.TemplateParse parsed =
                    Jinja2Runner.parseTemplate(file.toString().replace('\\', '/'));
            syntaxErrors.addAll(parsed.errors());
            if (parsed.ok()) {
                templates.put(file.getFileName().toString(), parsed.ast());
            } else {
                notes.add("template did not parse: " + file.getFileName());
            }
        }
        return templates;
    }

    /** Both extensions: the spec names templates .jinja, this project uses .html. */
    private List<Path> templateFiles() throws IOException {
        Path templatesDir = options.projectDir().resolve("templates");
        if (!Files.isDirectory(templatesDir)) return List.of();
        try (Stream<Path> files = Files.list(templatesDir)) {
            List<Path> templates = new ArrayList<>(files
                    .filter(Files::isRegularFile)
                    .filter(path -> {
                        String name = path.getFileName().toString().toLowerCase();
                        return name.endsWith(".jinja") || name.endsWith(".html");
                    })
                    .toList());
            templates.sort(Path::compareTo);
            return templates;
        }
    }

    // ============================================================
    //                        Generation
    // ============================================================

    private List<GeneratedPage> executeRoutes(PythonEvaluator evaluator,
                                             Program pythonAST,
                                             List<String> notes) {
        try {
            evaluator.run(pythonAST);
        } catch (EvaluationException e) {
            notes.add("could not execute app.py: " + e.getMessage());
            return List.of();
        }

        RouteRunner runner = new RouteRunner(evaluator);
        List<GeneratedPage> pages = runner.run(pythonAST);
        notes.addAll(evaluator.getLog());
        notes.addAll(runner.getLog());
        return pages;
    }

    private List<Path> writeSite(Program pythonAST,
                                 List<GeneratedPage> pages,
                                 Map<String, ASTJinja2withHTMLandCSS.ASTNode> templates,
                                 List<String> notes) {
        CodeGenerator generator = new CodeGenerator(
                options.projectDir(), options.siteDir(), templates);
        try {
            generator.clean();
            List<Path> written = generator.generate(pythonAST, pages);
            notes.addAll(generator.getLog());
            return written;
        } catch (IOException e) {
            notes.add("generation failed: " + e.getMessage());
            return List.of();
        }
    }

    private List<Path> writeReports(Program pythonAST,
                                    Map<String, ASTJinja2withHTMLandCSS.ASTNode> templates,
                                    List<SemanticError> errors,
                                    List<TemplateBinding> bindings,
                                    List<GeneratedPage> pages,
                                    List<String> notes,
                                    long elapsedMillis) {
        ReportWriter writer = new ReportWriter(options.reportDir());
        String projectName = options.projectDir().toString();
        try {
            List<Path> written = new ArrayList<>(List.of(
                    writer.writePythonAst("app.py", pythonAST),
                    writer.writeJinjaAst(templates),
                    writer.writeSemanticReport(projectName, errors, bindings, syntaxErrors)));
            if (!options.astOnly()) {
                written.add(writer.writeGenerationLog(
                        projectName, options.siteDir(), pages, notes, elapsedMillis));
            }
            return written;
        } catch (IOException e) {
            notes.add("could not write reports: " + e.getMessage());
            return List.of();
        }
    }
}
