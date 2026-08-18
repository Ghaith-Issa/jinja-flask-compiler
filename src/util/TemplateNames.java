package util;

import java.util.List;
import java.util.Locale;

/**
 * Matches template references to template files across extensions.
 * <p>
 * The spec names templates {@code index.jinja} while ordinary Flask code writes
 * {@code render_template("index.html")}. Comparing the names literally meant a
 * project that mixed the two generated nothing and reported the template as both
 * missing and never rendered, so references are compared by base name instead.
 */
public final class TemplateNames {

    /** Extensions a template file may carry. */
    private static final List<String> EXTENSIONS = List.of(".jinja", ".html", ".htm");

    private TemplateNames() {}

    /** {@code index.jinja} and {@code index.html} both give {@code index}. */
    public static String baseOf(String name) {
        if (name == null) return "";
        String lower = name.toLowerCase(Locale.ROOT);
        for (String extension : EXTENSIONS) {
            if (lower.endsWith(extension)) {
                return name.substring(0, name.length() - extension.length());
            }
        }
        return name;
    }

    /** True when two names refer to the same template regardless of extension. */
    public static boolean sameTemplate(String a, String b) {
        return baseOf(a).equalsIgnoreCase(baseOf(b));
    }

    /** The generated page's file name: always .html, whatever the source was. */
    public static String outputName(String templateName) {
        return baseOf(templateName) + ".html";
    }
}
