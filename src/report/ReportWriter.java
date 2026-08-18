package report;

import FlaskStatement.Program;
import codegen.GeneratedPage;
import semantic.ErrorType;
import semantic.SemanticError;
import semantic.TemplateBinding;
import util.SyntaxErrorCollector;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Writes the four analysis artefacts into {@code compiler_output/}.
 * <p>
 * These are the compiler's record of what it understood and what it produced; they
 * are kept apart from {@code output/}, which holds only the runnable site.
 */
public class ReportWriter {

    private static final DateTimeFormatter TIMESTAMP =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.ROOT);

    private static final String RULE = "=".repeat(72);

    private final Path outputDir;
    private final AstJsonWriter astWriter = new AstJsonWriter();

    public ReportWriter(Path outputDir) {
        this.outputDir = outputDir;
    }

    public Path getOutputDir() {
        return outputDir;
    }

    // ============================================================

    public Path writePythonAst(String fileName, Program program) throws IOException {
        return write("ast_python.json", astWriter.pythonAst(fileName, program));
    }

    public Path writeJinjaAst(Map<String, ASTJinja2withHTMLandCSS.ASTNode> templates)
            throws IOException {
        return write("ast_jinja.json", astWriter.jinjaAst(templates));
    }

    // ============================================================
    //                     Semantic report
    // ============================================================

    public Path writeSemanticReport(String projectName,
                                    List<SemanticError> errors,
                                    List<TemplateBinding> bindings) throws IOException {
        return writeSemanticReport(projectName, errors, bindings, List.of());
    }

    public Path writeSemanticReport(String projectName,
                                    List<SemanticError> errors,
                                    List<TemplateBinding> bindings,
                                    List<SyntaxErrorCollector.SyntaxError> syntaxErrors)
            throws IOException {
        StringBuilder report = new StringBuilder();

        report.append(RULE).append('\n');
        report.append("SEMANTIC ANALYSIS REPORT\n");
        report.append("project   : ").append(projectName).append('\n');
        report.append("generated : ").append(LocalDateTime.now().format(TIMESTAMP)).append('\n');
        report.append(RULE).append("\n\n");

        if (!syntaxErrors.isEmpty()) {
            report.append("SYNTAX ERRORS (").append(syntaxErrors.size()).append(")\n")
                    .append("-".repeat(72)).append('\n');
            syntaxErrors.forEach(error -> report.append("  ").append(error).append('\n'));
            report.append("\nEverything below was derived from a tree that failed to parse.\n\n");
        }

        report.append("TEMPLATE BINDINGS\n").append("-".repeat(72)).append('\n');
        if (bindings.isEmpty()) {
            report.append("  (no render_template calls found)\n");
        } else {
            for (TemplateBinding binding : bindings) {
                report.append(String.format(Locale.ROOT, "  %-20s <- %-18s %s%n",
                        binding.getTemplateName(),
                        binding.getFunctionName() + "()",
                        binding.getContext().keySet()));
                if (binding.getRoute() != null) {
                    report.append("      route: ").append(binding.getRoute()).append('\n');
                }
            }
        }
        report.append('\n');

        report.append("SUMMARY\n").append("-".repeat(72)).append('\n');
        for (ErrorType type : ErrorType.values()) {
            long count = errors.stream().filter(e -> e.getType() == type).count();
            report.append(String.format(Locale.ROOT, "  %-24s %d%n", type.label(), count));
        }
        report.append(String.format(Locale.ROOT, "  %-24s %d%n", "TOTAL", errors.size()));
        report.append('\n');

        if (errors.isEmpty()) {
            report.append("No semantic errors found.\n");
        } else {
            // Grouped by kind so a reader can work through one class of problem at a time.
            for (ErrorType type : ErrorType.values()) {
                List<SemanticError> ofType = new ArrayList<>(
                        errors.stream().filter(e -> e.getType() == type).toList());
                if (ofType.isEmpty()) continue;

                Collections.sort(ofType);
                report.append(type.label().toUpperCase(Locale.ROOT))
                        .append(" (").append(ofType.size()).append(")\n")
                        .append("-".repeat(72)).append('\n');
                for (SemanticError error : ofType) {
                    report.append("  ").append(error.getFile()).append(':')
                            .append(error.getLine()).append("  ")
                            .append(error.getMessage()).append('\n');
                    if (error.getHint() != null) {
                        report.append("      hint: ").append(error.getHint()).append('\n');
                    }
                }
                report.append('\n');
            }
        }

        return write("semantic_report.txt", report.toString());
    }

    // ============================================================
    //                     Generation log
    // ============================================================

    public Path writeGenerationLog(String projectName,
                                   Path siteDir,
                                   List<GeneratedPage> pages,
                                   List<String> entries,
                                   long elapsedMillis) throws IOException {
        StringBuilder log = new StringBuilder();

        log.append(RULE).append('\n');
        log.append("GENERATION LOG\n");
        log.append("project   : ").append(projectName).append('\n');
        log.append("output    : ").append(siteDir.toAbsolutePath()).append('\n');
        log.append("generated : ").append(LocalDateTime.now().format(TIMESTAMP)).append('\n');
        log.append("duration  : ").append(elapsedMillis).append(" ms\n");
        log.append(RULE).append("\n\n");

        log.append("PAGES (").append(pages.size()).append(")\n").append("-".repeat(72)).append('\n');
        for (GeneratedPage page : pages) {
            log.append(String.format(Locale.ROOT, "  %-20s <- %-18s %s%n",
                    page.getOutputFileName(), page.getTemplateName(), page.getContext().keySet()));
            if (page.concreteUrl() != null) {
                log.append("      url: ").append(page.concreteUrl()).append('\n');
            }
        }
        log.append('\n');

        log.append("STEPS\n").append("-".repeat(72)).append('\n');
        if (entries.isEmpty()) {
            log.append("  (nothing to report)\n");
        } else {
            entries.forEach(entry -> log.append("  ").append(entry).append('\n'));
        }

        return write("generation_log.txt", log.toString());
    }

    // ============================================================

    private Path write(String fileName, String content) throws IOException {
        Files.createDirectories(outputDir);
        Path target = outputDir.resolve(fileName);
        Files.writeString(target, content, StandardCharsets.UTF_8);
        return target;
    }
}
