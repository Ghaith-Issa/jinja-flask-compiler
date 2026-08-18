package server;

import ASTJinja2withHTMLandCSS.ASTNode;
import FlaskStatement.Attribute;
import FlaskStatement.Decorator;
import FlaskStatement.FunctionCall;
import FlaskStatement.FunctionDef;
import FlaskStatement.Literal;
import FlaskStatement.Program;
import FlaskStatement.Statement;
import codegen.CodeGenerator;
import codegen.EvaluationException;
import codegen.GeneratedPage;
import codegen.PythonEvaluator;
import codegen.RouteRunner;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * The compiler kept alive between requests.
 * <p>
 * A one-shot compile parses, evaluates and exits, so the data dies with the process.
 * Here the {@link PythonEvaluator} and its globals stay in memory: a form submission
 * is replayed through the very same interpreter that produced the pages, the program's
 * own {@code products.append(...)} mutates the live list, and the pages are written
 * again from the new values. Nothing about the language is special-cased.
 */
public class LiveSession {

    private final Path projectDir;
    private final Path outputDir;

    private final Program program;
    private final Map<String, ASTNode> templates;
    private final PythonEvaluator evaluator;

    private final List<String> log = new ArrayList<>();
    private List<GeneratedPage> pages = List.of();

    public LiveSession(Path projectDir,
                       Path outputDir,
                       Program program,
                       Map<String, ASTNode> templates,
                       PythonEvaluator evaluator) {
        this.projectDir = projectDir;
        this.outputDir = outputDir;
        this.program = program;
        this.templates = templates;
        this.evaluator = evaluator;
    }

    public List<GeneratedPage> getPages() { return pages; }
    public List<String> getLog()          { return log; }
    public Path getOutputDir()            { return outputDir; }

    // ============================================================
    //                       Regeneration
    // ============================================================

    /**
     * Runs every view against the current in-memory data and rewrites the pages.
     * Called once at startup and again after each submission.
     */
    public synchronized List<GeneratedPage> regenerate() throws IOException {
        log.clear();

        RouteRunner runner = new RouteRunner(evaluator);
        pages = runner.run(program);
        log.addAll(runner.getLog());

        CodeGenerator generator = new CodeGenerator(projectDir, outputDir, templates);
        generator.clean();
        generator.generate(program, pages);
        log.addAll(generator.getLog());

        return pages;
    }

    // ============================================================
    //                    Form submissions
    // ============================================================

    /** Where the browser should go after a submission. */
    public record SubmitResult(String location, String error) {
        public boolean ok() { return error == null; }
    }

    /**
     * Replays a POST through the view that owns the given route.
     * The request object is set to POST with the submitted fields, the view runs,
     * and whatever it does to the program's data is what the next regeneration sees.
     */
    public synchronized SubmitResult submit(String route, Map<String, Object> form) {
        FunctionDef view = viewForRoute(route);
        if (view == null) {
            return new SubmitResult(null, "no route matches " + route);
        }

        Object result;
        try {
            evaluator.setRequest("POST", form);
            result = evaluator.callFunction(new PythonEvaluator.FunctionValue(view), List.of(), view.line);
        } catch (EvaluationException e) {
            return new SubmitResult(null, view.getName() + "(): " + e.getMessage());
        } finally {
            // Later page generation must see a plain GET again, or every view would
            // keep taking its POST branch.
            evaluator.setRequest("GET", new LinkedHashMap<>());
        }

        String location = (result instanceof PythonEvaluator.Redirect redirect)
                ? redirect.location()
                : route;
        return new SubmitResult(location, null);
    }

    /** Snapshot of a named global, for the status endpoint. */
    public synchronized Object data(String name) {
        return evaluator.global(name);
    }

    // ============================================================

    /** The view function declaring this route, ignoring a trailing slash. */
    private FunctionDef viewForRoute(String route) {
        String wanted = normalise(route);
        for (Statement statement : program.statements) {
            if (!(statement instanceof FunctionDef function)) continue;
            String declared = routeOf(function);
            if (declared != null && normalise(declared).equals(wanted)) return function;
        }
        return null;
    }

    private String normalise(String route) {
        if (route == null) return "/";
        String trimmed = route.trim();
        if (trimmed.length() > 1 && trimmed.endsWith("/")) {
            trimmed = trimmed.substring(0, trimmed.length() - 1);
        }
        return trimmed.isEmpty() ? "/" : trimmed;
    }

    private String routeOf(FunctionDef function) {
        if (function.getDecorators() == null) return null;
        for (Decorator decorator : function.getDecorators()) {
            if (!(decorator.expr instanceof FunctionCall call)) continue;
            if (!(call.called instanceof Attribute attribute)) continue;
            if (!"route".equals(attribute.attribute)) continue;
            if (call.args.isEmpty()) continue;
            if (call.args.get(0) instanceof Literal literal && literal.value instanceof String path) {
                return path;
            }
        }
        return null;
    }

    /** Routes the app declares, paired with their view names. */
    public Map<String, String> routes() {
        Map<String, String> routes = new LinkedHashMap<>();
        for (Statement statement : program.statements) {
            if (!(statement instanceof FunctionDef function)) continue;
            String route = RouteRunner.routeOf(function);
            if (route != null) routes.put(route, function.getName());
        }
        return routes;
    }
}
