package codegen;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Rewrites the URLs a template was written against into the file names the
 * generator actually produces.
 * <p>
 * Templates link to Flask routes — {@code href="/add"}, {@code href="/product/2"} —
 * but a generated site is opened from disk, where those paths lead nowhere. Without
 * this step every page renders correctly and every link is broken.
 */
public class LinkResolver {

    /** Concrete route URL to output file, e.g. /product/2 -> product_2.html */
    private final Map<String, String> urlToFile = new LinkedHashMap<>();

    /** Endpoint name to output file, for url_for("home"). */
    private final Map<String, String> endpointToFile = new LinkedHashMap<>();

    public LinkResolver(List<GeneratedPage> pages) {
        for (GeneratedPage page : pages) {
            String url = page.concreteUrl();
            if (url != null) urlToFile.put(normalise(url), page.getOutputFileName());
            // A parameterised endpoint has several pages; the first stands for it.
            endpointToFile.putIfAbsent(page.getEndpoint(), page.getOutputFileName());
        }
    }

    /**
     * Turns one link into something that works from the output folder.
     * Known routes become their page; anything else that is absolute becomes
     * relative, so /images/laptop.jpg finds the copied images folder.
     */
    public String resolve(String link) {
        if (link == null || link.isEmpty()) return link;
        if (isExternal(link)) return link;

        String page = urlToFile.get(normalise(link));
        if (page != null) return page;

        return link.startsWith("/") ? link.substring(1) : link;
    }

    /** Resolves an endpoint name, as {@code url_for("home")} needs. */
    public String resolveEndpoint(String endpoint) {
        return endpointToFile.get(endpoint);
    }

    private boolean isExternal(String link) {
        String lower = link.toLowerCase();
        return lower.startsWith("http://") || lower.startsWith("https://")
                || lower.startsWith("//") || lower.startsWith("mailto:")
                || lower.startsWith("tel:") || lower.startsWith("#")
                || lower.startsWith("data:");
    }

    /** Trailing slashes must not make /add and /add/ look like different routes. */
    private String normalise(String url) {
        if (url.length() > 1 && url.endsWith("/")) return url.substring(0, url.length() - 1);
        return url;
    }

    public Map<String, String> getUrlToFile() {
        return urlToFile;
    }
}
