import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Command line configuration.
 *
 * <pre>
 *   java Main [project] [options]
 *
 *   --in &lt;dir&gt;        project to compile (same as the positional argument)
 *   --out &lt;dir&gt;       where the generated site goes      (default: output)
 *   --reports &lt;dir&gt;   where the analysis files go        (default: compiler_output)
 *   --watch           keep running and rebuild on change
 *   --ast-only        analyse and report, generate nothing
 *   --quiet           print the summary only
 *   --help            show this text
 * </pre>
 */
public record Options(Path projectDir,
                      Path siteDir,
                      Path reportDir,
                      boolean watch,
                      boolean serve,
                      int port,
                      boolean astOnly,
                      boolean quiet,
                      boolean help,
                      String error) {

    private static final Path DEFAULT_PROJECT = Paths.get("Testing Project/FlaskTestingApp");
    private static final Path DEFAULT_SITE = Paths.get("output");
    private static final Path DEFAULT_REPORTS = Paths.get("compiler_output");

    public static Options parse(String[] args) {
        Path project = DEFAULT_PROJECT;
        Path site = DEFAULT_SITE;
        Path reports = DEFAULT_REPORTS;
        boolean watch = false;
        boolean serve = false;
        int port = 8080;
        boolean astOnly = false;
        boolean quiet = false;
        boolean help = false;

        for (int i = 0; i < args.length; i++) {
            String argument = args[i];
            switch (argument) {
                case "--watch"    -> watch = true;
                case "--serve"    -> serve = true;
                case "--port"     -> {
                    if (i + 1 >= args.length) return error("--port needs a number");
                    try {
                        port = Integer.parseInt(args[++i]);
                    } catch (NumberFormatException e) {
                        return error("--port must be a number, got: " + args[i]);
                    }
                }
                case "--ast-only" -> astOnly = true;
                case "--quiet"    -> quiet = true;
                case "--help", "-h" -> help = true;
                case "--in", "--out", "--reports" -> {
                    if (i + 1 >= args.length) {
                        return error(argument + " needs a directory");
                    }
                    Path value = Paths.get(args[++i]);
                    switch (argument) {
                        case "--in"      -> project = value;
                        case "--out"     -> site = value;
                        default          -> reports = value;
                    }
                }
                default -> {
                    if (argument.startsWith("-")) return error("unknown option: " + argument);
                    project = Paths.get(argument);      // positional project directory
                }
            }
        }

        return new Options(project, site, reports, watch, serve, port, astOnly, quiet, help, null);
    }

    private static Options error(String message) {
        return new Options(DEFAULT_PROJECT, DEFAULT_SITE, DEFAULT_REPORTS,
                false, false, 8080, false, false, true, message);
    }

    public static String usage() {
        return """
                miniFlask compiler

                usage: java Main [project] [options]

                  --in <dir>        project to compile (same as the positional argument)
                  --out <dir>       where the generated site goes      (default: output)
                  --reports <dir>   where the analysis files go        (default: compiler_output)
                  --watch           rebuild when a source file changes (no server)
                  --serve           live server: serves the pages, accepts form
                                    submissions, AND watches the sources.
                                    A form submission edits the live data;
                                    a source edit rebuilds from app.py, which
                                    discards anything added through the browser.
                  --port <n>        port for --serve                    (default: 8080)
                  --ast-only        analyse and report, generate nothing
                  --quiet           print the summary only
                  --help            show this text

                examples:
                  java Main
                  java Main "Testing Project/SemanticErrorsDemo"
                  java Main --watch
                  java Main --serve --port 8080
                """;
    }
}
