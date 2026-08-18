package codegen;

import ASTJinja2withHTMLandCSS.ASTNode;
import ASTJinja2withHTMLandCSS.Jinja2Runner;
import FlaskStatement.Program;
import util.TemplateNames;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Writes the generated site.
 * <p>
 * Templates become finished HTML pages; app.py, the stylesheet, the script and the
 * images are copied through untouched, because the announcement treats them as
 * companions of the output rather than inputs to the translation.
 */
public class CodeGenerator {

    /** Files copied beside the generated pages, relative to the project. */
    private static final List<String> COMPANION_FILES = List.of(
            "app.py", "static/style.css", "static/script.js"
    );

    /** Folders copied wholesale, relative to the project. */
    private static final List<String> COMPANION_FOLDERS = List.of("images");

    private final Path projectDir;
    private final Path outputDir;
    private final List<String> log = new ArrayList<>();

    /** Templates already parsed by the caller, so no file is parsed twice per run. */
    private final Map<String, ASTNode> templates = new HashMap<>();

    /** True when the caller supplied the templates and this class must not re-parse. */
    private boolean templatesPreParsed = false;

    public CodeGenerator(Path projectDir, Path outputDir) {
        this.projectDir = projectDir;
        this.outputDir = outputDir;
    }

    public CodeGenerator(Path projectDir, Path outputDir, Map<String, ASTNode> parsedTemplates) {
        this(projectDir, outputDir);
        if (parsedTemplates != null) {
            this.templates.putAll(parsedTemplates);
            this.templatesPreParsed = true;
        }
    }

    public List<String> getLog() {
        return log;
    }

    // ============================================================

    /** Renders every page and copies the companion files. Returns the files written. */
    public List<Path> generate(Program program, List<GeneratedPage> pages) throws IOException {
        Files.createDirectories(outputDir);

        LinkResolver links = new LinkResolver(pages);
        HtmlEmitter emitter = new HtmlEmitter(links);

        List<Path> written = new ArrayList<>();

        for (GeneratedPage page : pages) {
            // Re-parsing a template the caller already tried would repeat its errors.
            ASTNode template = templatesPreParsed
                    ? findTemplate(page.getTemplateName())
                    : templates.computeIfAbsent(page.getTemplateName(), this::parseTemplate);
            if (template == null) {
                log.add("skipped " + page.getOutputFileName()
                        + ": template '" + page.getTemplateName() + "' did not parse");
                continue;
            }

            try {
                String html = emitter.emit(template, page.getContext());
                Path target = outputDir.resolve(page.getOutputFileName());
                Files.writeString(target, html, StandardCharsets.UTF_8);
                written.add(target);
                log.add("generated " + page.getOutputFileName()
                        + " from " + page.getTemplateName()
                        + " (" + html.length() + " chars)");
            } catch (RuntimeException e) {
                log.add("failed " + page.getOutputFileName() + ": " + e.getMessage());
            }
        }

        log.addAll(emitter.getLog());
        written.addAll(copyCompanions());
        return written;
    }

    /** Finds a parsed template whose name matches ignoring the extension. */
    private ASTNode findTemplate(String templateName) {
        ASTNode exact = templates.get(templateName);
        if (exact != null) return exact;
        for (Map.Entry<String, ASTNode> entry : templates.entrySet()) {
            if (TemplateNames.sameTemplate(entry.getKey(), templateName)) return entry.getValue();
        }
        return null;
    }

    private ASTNode parseTemplate(String templateName) {
        Path templatesDir = projectDir.resolve("templates");
        Path file = templatesDir.resolve(templateName);

        // The spec names templates .jinja while this project uses .html.
        if (!Files.exists(file)) {
            Path alternative = templatesDir.resolve(swapExtension(templateName));
            if (Files.exists(alternative)) file = alternative;
        }
        if (!Files.exists(file)) {
            log.add("template not found: " + templateName);
            return null;
        }

        try {
            return Jinja2Runner.parseFile(file.toString().replace('\\', '/'));
        } catch (Exception e) {
            log.add("could not parse " + templateName + ": " + e.getMessage());
            return null;
        }
    }

    private String swapExtension(String name) {
        if (name.endsWith(".html")) return name.substring(0, name.length() - 5) + ".jinja";
        if (name.endsWith(".jinja")) return name.substring(0, name.length() - 6) + ".html";
        return name;
    }

    // ============================================================
    //                    Companion files
    // ============================================================

    private List<Path> copyCompanions() throws IOException {
        List<Path> copied = new ArrayList<>();

        for (String relative : COMPANION_FILES) {
            Path source = projectDir.resolve(relative);
            if (!Files.isRegularFile(source)) continue;

            // The stylesheet lands beside the pages, because url_for('static', ...)
            // is emitted as a bare file name.
            Path target = outputDir.resolve(source.getFileName().toString());
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            copied.add(target);
            log.add("copied " + relative + " -> " + target.getFileName());
        }

        for (String relative : COMPANION_FOLDERS) {
            Path source = projectDir.resolve(relative);
            if (!Files.isDirectory(source)) continue;
            copied.addAll(copyTree(source, outputDir.resolve(relative)));
            log.add("copied folder " + relative + "/");
        }
        return copied;
    }

    private List<Path> copyTree(Path source, Path target) throws IOException {
        List<Path> copied = new ArrayList<>();
        Files.walkFileTree(source, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
                    throws IOException {
                Files.createDirectories(target.resolve(source.relativize(dir)));
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                    throws IOException {
                Path destination = target.resolve(source.relativize(file));
                Files.copy(file, destination, StandardCopyOption.REPLACE_EXISTING);
                copied.add(destination);
                return FileVisitResult.CONTINUE;
            }
        });
        return copied;
    }

    /** Removes generated pages from a previous run so deletions take effect. */
    public void clean() throws IOException {
        if (!Files.isDirectory(outputDir)) return;
        try (Stream<Path> files = Files.list(outputDir)) {
            for (Path file : files.toList()) {
                if (Files.isRegularFile(file) && file.getFileName().toString().endsWith(".html")) {
                    Files.delete(file);
                }
            }
        }
    }
}
