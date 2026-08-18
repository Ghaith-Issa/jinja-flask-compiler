import FlaskStatement.ASTPrettyPrinter;
import SymbolsTable.SymbolsTable;
import codegen.GeneratedPage;
import semantic.ErrorType;
import semantic.SemanticError;
import semantic.TemplateBinding;
import server.DevServer;
import server.LiveSession;
import util.SyntaxErrorCollector;
import watch.ProjectWatcher;

import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/**
 * Command line front end.
 * <p>
 * Three ways to run: a single build, a watcher that rebuilds on every save, or a live
 * server that does both — it answers form submissions <em>and</em> watches the
 * sources, which is the combination the project is normally demonstrated with.
 */
public class Main {

    private static final DateTimeFormatter CLOCK =
            DateTimeFormatter.ofPattern("HH:mm:ss", Locale.ROOT);

    /** One save fires several filesystem events; this collapses them into one build. */
    private static final long DEBOUNCE_MILLIS = 250;

    public static void main(String[] args) throws Exception {
        Options options = Options.parse(args);

        if (options.error() != null) {
            System.out.println(options.error());
            System.out.println();
        }
        if (options.help()) {
            System.out.println(Options.usage());
            return;
        }

        Compiler compiler = new Compiler(options);

        if (options.serve()) {
            serve(compiler, options);
        } else if (options.watch()) {
            watch(compiler, options);
        } else {
            Compiler.Result result = compiler.run();
            report(result, options);
            // A parse failure or an unusable project is a failed build.
            if (result.failed() || result.hasSyntaxErrors()) System.exit(1);
        }
    }

    // ============================================================
    //                        Serve mode
    // ============================================================

    /**
     * Keeps the compiler in memory behind an HTTP server. Form submissions are run
     * through the interpreter, which mutates the program's own data, and the pages
     * are written again before the browser is redirected.
     */
    private static void serve(Compiler compiler, Options options) throws Exception {
        Compiler.Result result = compiler.run();
        report(result, options);

        if (result.failed() || result.hasSyntaxErrors()) {
            System.out.println("Not serving: fix the errors above first.");
            System.exit(1);
        }

        DevServer server = new DevServer(newSession(options, result), options.port());
        server.start();
        Runtime.getRuntime().addShutdownHook(new Thread(server::stop));

        // The server also watches the sources, so both kinds of change are covered:
        // a form submission mutates the live data, an edit rebuilds from the file.
        try (ProjectWatcher watcher = new ProjectWatcher(
                options.projectDir(),
                changed -> reload(compiler, options, server, changed),
                DEBOUNCE_MILLIS)) {

            System.out.println("Also watching for source changes:");
            for (Path directory : watcher.getRegisteredDirectories()) {
                System.out.println("  " + directory);
            }
            System.out.println();

            Runtime.getRuntime().addShutdownHook(new Thread(watcher::stop));
            watcher.watch();
        } catch (IOException e) {
            System.out.println("Serving without a watcher: " + e.getMessage());
            Thread.currentThread().join();
        }
    }

    /**
     * Rebuilds from the sources and hands the server the new session.
     * <p>
     * A source edit reruns the whole pipeline, so anything added through the browser
     * since the last build is gone — app.py declares the data, and the file is the
     * authority. The old session keeps serving if the rebuild fails, so a half-typed
     * edit does not take the site down.
     */
    private static void reload(Compiler compiler, Options options,
                               DevServer server, Set<Path> changed) {
        System.out.println("[" + LocalTime.now().format(CLOCK) + "] changed: "
                + changed.stream().map(p -> p.getFileName().toString()).sorted().toList());

        Compiler.Result result;
        try {
            result = compiler.run();
        } catch (RuntimeException e) {
            System.out.println("    rebuild failed: " + e + " - still serving the last good build");
            return;
        }

        if (result.failed() || result.hasSyntaxErrors()) {
            printSyntaxErrors(result.syntaxErrors());
            System.out.println("    rebuild has errors - still serving the last good build");
            return;
        }

        try {
            server.setSession(newSession(options, result));
            System.out.println("    rebuilt " + result.pages().size()
                    + " page(s) in " + result.elapsedMillis()
                    + " ms (data reloaded from app.py)");
        } catch (IOException e) {
            System.out.println("    could not write the site: " + e.getMessage());
        }
    }

    private static LiveSession newSession(Options options, Compiler.Result result)
            throws IOException {
        LiveSession session = new LiveSession(
                options.projectDir(), options.siteDir(),
                result.pythonAST(), result.templates(), result.evaluator());
        session.regenerate();
        return session;
    }

    // ============================================================
    //                        Watch mode
    // ============================================================

    private static void watch(Compiler compiler, Options options) throws Exception {
        report(compiler.run(), options);

        try (ProjectWatcher watcher = new ProjectWatcher(
                options.projectDir(), changed -> rebuild(compiler, options, changed),
                DEBOUNCE_MILLIS)) {

            System.out.println("Watching for changes. Press Ctrl+C to stop.");
            for (Path directory : watcher.getRegisteredDirectories()) {
                System.out.println("  " + directory);
            }
            System.out.println();

            Runtime.getRuntime().addShutdownHook(new Thread(watcher::stop));
            watcher.watch();
        } catch (IOException e) {
            System.out.println("Could not watch " + options.projectDir() + ": " + e.getMessage());
            System.exit(1);
        }
    }

    private static void rebuild(Compiler compiler, Options options, Set<Path> changed) {
        System.out.println("[" + LocalTime.now().format(CLOCK) + "] changed: "
                + changed.stream().map(p -> p.getFileName().toString()).sorted().toList());
        try {
            report(compiler.run(), options);
        } catch (RuntimeException e) {
            // A rebuild must never take the watcher down with it.
            System.out.println("  rebuild failed: " + e);
        }
        System.out.println("Watching for changes. Press Ctrl+C to stop.");
        System.out.println();
    }

    // ============================================================
    //                         Reporting
    // ============================================================

    private static void report(Compiler.Result result, Options options) {
        if (result.failed()) {
            System.out.println("Compilation failed: " + result.failure());
            return;
        }

        printSyntaxErrors(result.syntaxErrors());

        if (!options.quiet()) {
            printBindings(result.bindings());
            printErrors(result.errors());
            printSymbols();
            printPages(result.pages());
            printNotes(result.notes());
        }

        printSummary(result, options);

        if (options.astOnly() && !options.quiet()) {
            System.out.println("=== PYTHON AST ===");
            ASTPrettyPrinter.print(result.pythonAST());
        }
    }

    private static void printSyntaxErrors(List<SyntaxErrorCollector.SyntaxError> errors) {
        if (errors.isEmpty()) return;
        System.out.println("=== SYNTAX ERRORS ===");
        errors.forEach(error -> System.out.println("  " + error));
        System.out.println();
    }

    private static void printBindings(List<TemplateBinding> bindings) {
        System.out.println("=== TEMPLATE BINDINGS ===");
        if (bindings.isEmpty()) {
            System.out.println("  (none)");
        } else {
            bindings.forEach(binding -> System.out.println("  " + binding));
        }
        System.out.println();
    }

    private static void printErrors(List<SemanticError> errors) {
        System.out.println("=== SEMANTIC ANALYSIS ===");
        if (errors.isEmpty()) {
            System.out.println("  No errors found.");
        } else {
            errors.stream().sorted().forEach(error -> System.out.println("  " + error));
            System.out.println();
            for (ErrorType type : ErrorType.values()) {
                long count = errors.stream().filter(e -> e.getType() == type).count();
                if (count > 0) {
                    System.out.printf(Locale.ROOT, "  %-24s %d%n", type.label(), count);
                }
            }
        }
        System.out.println();
    }

    private static void printSymbols() {
        System.out.println("=== FLASK SYMBOL TABLE ===");
        System.out.println();
        SymbolsTable.getFlaskInstance().printFlaskSymbols();
    }

    private static void printPages(List<GeneratedPage> pages) {
        System.out.println("=== CONTEXT DATA (generation) ===");
        if (pages.isEmpty()) {
            System.out.println("  (no pages)");
        } else {
            for (GeneratedPage page : pages) {
                System.out.println("  " + page);
                for (Map.Entry<String, Object> entry : page.getContext().entrySet()) {
                    System.out.println("      " + entry.getKey() + " = " + preview(entry.getValue()));
                }
            }
        }
        System.out.println();
    }

    private static void printNotes(List<String> notes) {
        if (notes.isEmpty()) return;
        System.out.println("=== GENERATION LOG ===");
        notes.forEach(note -> System.out.println("  " + note));
        System.out.println();
    }

    private static void printSummary(Compiler.Result result, Options options) {
        System.out.printf(Locale.ROOT, "%s  %d syntax  %d semantic  %d page(s)  %d file(s)  %d ms%n",
                options.astOnly() ? "Analysed" : "Compiled",
                result.syntaxErrors().size(),
                result.errors().size(),
                result.pages().size(),
                result.writtenFiles().size(),
                result.elapsedMillis());
        if (!options.astOnly()) {
            System.out.println("  site    : " + options.siteDir().toAbsolutePath());
        }
        System.out.println("  reports : " + options.reportDir().toAbsolutePath());
        System.out.println();
    }

    /** Shortens long collections so the console stays readable. */
    private static String preview(Object value) {
        String text = String.valueOf(value);
        return (text.length() <= 160) ? text : text.substring(0, 157) + "...";
    }
}
