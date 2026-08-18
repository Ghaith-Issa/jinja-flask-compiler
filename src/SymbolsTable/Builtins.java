package SymbolsTable;

import java.util.Set;

/**
 * The names miniFlask provides without a declaration.
 * <p>
 * Single source of truth: the AST builder and the semantic analyzer both consult
 * this. They used to keep separate lists that had drifted apart, so a call the
 * analyzer accepted could still be rejected while the tree was being built.
 */
public final class Builtins {

    /** Callable names. */
    public static final Set<String> FUNCTIONS = Set.of(
            "print", "len", "int", "float", "str", "range",
            "Flask", "render_template", "redirect", "url_for", "send_from_directory",
            "jsonify", "abort", "flash",
            // methods reached through attribute access
            "route", "append", "get", "keys", "values", "items"
    );

    /** Objects and values Flask makes available globally. */
    public static final Set<String> GLOBALS = Set.of(
            "app", "request", "session", "config", "__name__"
    );

    /** Everything a name lookup may resolve to without a user declaration. */
    public static final Set<String> ALL = union(FUNCTIONS, GLOBALS);

    /** Names Jinja resolves on its own inside a template. */
    public static final Set<String> JINJA_GLOBALS = Set.of(
            "url_for", "request", "config", "session", "loop", "get_flashed_messages"
    );

    private Builtins() {}

    public static boolean isFunction(String name) {
        return FUNCTIONS.contains(name);
    }

    public static boolean isKnown(String name) {
        return ALL.contains(name);
    }

    private static Set<String> union(Set<String> a, Set<String> b) {
        java.util.Set<String> merged = new java.util.LinkedHashSet<>(a);
        merged.addAll(b);
        return Set.copyOf(merged);
    }
}
