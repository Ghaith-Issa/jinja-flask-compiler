package server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import util.TemplateNames;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Serves the generated site and turns form submissions back into compiler work.
 * <p>
 * Built on the JDK's own {@link HttpServer}, so the project keeps its single
 * dependency. A GET returns a file straight from the output folder — the pages really
 * are plain HTML on disk. A POST is handed to {@link LiveSession}, which replays it
 * through the interpreter, and the pages are rewritten before the browser is
 * redirected, so the reload shows freshly generated files.
 */
public class DevServer {

    private static final DateTimeFormatter CLOCK =
            DateTimeFormatter.ofPattern("HH:mm:ss", Locale.ROOT);

    private static final Map<String, String> CONTENT_TYPES = Map.ofEntries(
            Map.entry("html", "text/html; charset=utf-8"),
            Map.entry("css", "text/css; charset=utf-8"),
            Map.entry("js", "application/javascript; charset=utf-8"),
            Map.entry("json", "application/json; charset=utf-8"),
            Map.entry("png", "image/png"),
            Map.entry("jpg", "image/jpeg"),
            Map.entry("jpeg", "image/jpeg"),
            Map.entry("gif", "image/gif"),
            Map.entry("svg", "image/svg+xml"),
            Map.entry("ico", "image/x-icon"),
            Map.entry("py", "text/plain; charset=utf-8")
    );

    /**
     * Swapped wholesale when a source edit forces a full rebuild. Volatile because the
     * watcher thread replaces it while request threads are reading it; requests either
     * see the old session or the new one, never a half-built one.
     */
    private volatile LiveSession session;

    private final int port;
    private HttpServer server;

    public DevServer(LiveSession session, int port) {
        this.session = session;
        this.port = port;
    }

    /** Serves from a freshly compiled session from now on. */
    public void setSession(LiveSession session) {
        this.session = session;
    }

    // ============================================================

    public void start() throws IOException {
        server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/", this::handle);
        server.setExecutor(null);   // one request at a time keeps regeneration ordered
        server.start();

        System.out.println("Server running at http://localhost:" + port + "/");
        System.out.println("  serving : " + session.getOutputDir().toAbsolutePath());
        System.out.println("  routes  :");
        session.routes().forEach((route, view) ->
                System.out.println("      " + route + "  ->  " + view + "()"));
        System.out.println("  Press Ctrl+C to stop.");
        System.out.println();
    }

    public void stop() {
        if (server != null) server.stop(0);
    }

    // ============================================================
    //                        Dispatch
    // ============================================================

    private void handle(HttpExchange exchange) throws IOException {
        try {
            if ("POST".equalsIgnoreCase(exchange.getRequestMethod())) {
                handlePost(exchange);
            } else {
                handleGet(exchange);
            }
        } catch (RuntimeException e) {
            // A bad request must never take the server down.
            respond(exchange, 500, "text/plain; charset=utf-8",
                    ("Server error: " + e).getBytes(StandardCharsets.UTF_8));
        } finally {
            exchange.close();
        }
    }

    // ============================================================
    //                          GET
    // ============================================================

    private void handleGet(HttpExchange exchange) throws IOException {
        String requested = exchange.getRequestURI().getPath();
        Path file = resolve(requested);

        if (file == null) {
            respond(exchange, 404, "text/html; charset=utf-8", notFound(requested));
            return;
        }
        byte[] body = Files.readAllBytes(file);
        respond(exchange, 200, contentTypeOf(file), body);
    }

    /**
     * Maps a URL onto a file in the output folder. A bare route such as {@code /add}
     * also matches the page generated for it, so links written for Flask still work.
     */
    private Path resolve(String urlPath) throws IOException {
        Path root = session.getOutputDir().toAbsolutePath().normalize();

        String relative = urlPath.startsWith("/") ? urlPath.substring(1) : urlPath;
        if (relative.isEmpty()) relative = "index.html";

        Path candidate = root.resolve(relative).normalize();
        // Refuse anything that climbs out of the output folder.
        if (!candidate.startsWith(root)) return null;
        if (Files.isRegularFile(candidate)) return candidate;

        Path asHtml = root.resolve(TemplateNames.outputName(relative)).normalize();
        if (asHtml.startsWith(root) && Files.isRegularFile(asHtml)) return asHtml;

        // /add -> the page generated by the view that owns that route
        String pageForRoute = pageForRoute(urlPath);
        if (pageForRoute != null) {
            Path page = root.resolve(pageForRoute).normalize();
            if (page.startsWith(root) && Files.isRegularFile(page)) return page;
        }
        return null;
    }

    private String pageForRoute(String urlPath) {
        for (var page : session.getPages()) {
            if (urlPath.equals(page.concreteUrl())) return page.getOutputFileName();
        }
        return null;
    }

    // ============================================================
    //                          POST
    // ============================================================

    private void handlePost(HttpExchange exchange) throws IOException {
        String urlPath = exchange.getRequestURI().getPath();
        Map<String, Object> form = readForm(exchange);
        String route = routeFor(urlPath);

        System.out.println("[" + LocalTime.now().format(CLOCK) + "] POST " + urlPath
                + "  ->  route " + route + "  " + form.keySet());

        LiveSession.SubmitResult result = session.submit(route, form);
        if (!result.ok()) {
            respond(exchange, 400, "text/html; charset=utf-8", error(result.error()));
            return;
        }

        List<?> pages = session.regenerate();
        System.out.println("    regenerated " + pages.size() + " page(s)");
        session.getLog().stream()
                .filter(entry -> entry.startsWith("generated"))
                .forEach(entry -> System.out.println("      " + entry));

        // 303 makes the browser follow with a GET, so a refresh will not resubmit.
        String location = locationFor(result.location());
        exchange.getResponseHeaders().add("Location", location);
        exchange.sendResponseHeaders(303, -1);
    }

    /**
     * The declared route a submission belongs to. A generated form posts to its own
     * page ({@code /add_product.html}), which has to be traced back to {@code /add}.
     */
    private String routeFor(String urlPath) {
        for (var page : session.getPages()) {
            String pageUrl = "/" + page.getOutputFileName();
            if (pageUrl.equals(urlPath) && page.getRoute() != null) return page.getRoute();
        }
        return urlPath;
    }

    /** Turns the view's redirect target into something the browser can follow. */
    private String locationFor(String target) {
        if (target == null || target.isBlank()) return "/";
        for (var page : session.getPages()) {
            if (target.equals(page.concreteUrl()) || target.equals(page.getOutputFileName())) {
                return "/" + page.getOutputFileName();
            }
        }
        return target.startsWith("/") ? target : "/" + target;
    }

    private Map<String, Object> readForm(HttpExchange exchange) throws IOException {
        byte[] raw;
        try (InputStream in = exchange.getRequestBody()) {
            raw = in.readAllBytes();
        }
        return parseUrlEncoded(new String(raw, StandardCharsets.UTF_8));
    }

    static Map<String, Object> parseUrlEncoded(String body) {
        Map<String, Object> form = new LinkedHashMap<>();
        if (body == null || body.isBlank()) return form;

        for (String pair : body.split("&")) {
            if (pair.isEmpty()) continue;
            int equals = pair.indexOf('=');
            String key = (equals >= 0) ? pair.substring(0, equals) : pair;
            String value = (equals >= 0) ? pair.substring(equals + 1) : "";
            form.put(decode(key), decode(value));
        }
        return form;
    }

    private static String decode(String text) {
        return URLDecoder.decode(text, StandardCharsets.UTF_8);
    }

    // ============================================================
    //                        Responses
    // ============================================================

    private void respond(HttpExchange exchange, int status, String contentType, byte[] body)
            throws IOException {
        exchange.getResponseHeaders().set("Content-Type", contentType);
        // The pages change under the browser's feet; caching them would hide that.
        exchange.getResponseHeaders().set("Cache-Control", "no-store");
        exchange.sendResponseHeaders(status, body.length);
        try (OutputStream out = exchange.getResponseBody()) {
            out.write(body);
        }
    }

    private String contentTypeOf(Path file) {
        String name = file.getFileName().toString().toLowerCase(Locale.ROOT);
        int dot = name.lastIndexOf('.');
        String extension = (dot >= 0) ? name.substring(dot + 1) : "";
        return CONTENT_TYPES.getOrDefault(extension, "application/octet-stream");
    }

    private byte[] notFound(String requested) {
        StringBuilder page = new StringBuilder();
        page.append("<!DOCTYPE html><html><head><meta charset=\"UTF-8\">")
                .append("<title>404</title></head><body>")
                .append("<h1>404 - not generated</h1><p><code>").append(escape(requested))
                .append("</code> is not in the output folder.</p><h2>Available pages</h2><ul>");
        for (var generated : session.getPages()) {
            String file = generated.getOutputFileName();
            page.append("<li><a href=\"/").append(file).append("\">").append(file).append("</a></li>");
        }
        page.append("</ul></body></html>");
        return page.toString().getBytes(StandardCharsets.UTF_8);
    }

    private byte[] error(String message) {
        String page = "<!DOCTYPE html><html><head><meta charset=\"UTF-8\"><title>Error</title></head>"
                + "<body><h1>Submission failed</h1><pre>" + escape(message) + "</pre>"
                + "<p><a href=\"/\">Back</a></p></body></html>";
        return page.getBytes(StandardCharsets.UTF_8);
    }

    private String escape(String text) {
        return String.valueOf(text)
                .replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
    }
}
