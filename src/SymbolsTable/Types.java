package SymbolsTable;

/**
 * The type names miniFlask works with. Kept as constants rather than an enum so a
 * type can travel through the AST and the reports as a plain string.
 */
public final class Types {
    public static final String NUMBER   = "number";
    public static final String STRING   = "string";
    public static final String BOOL     = "bool";
    public static final String NONE     = "none";
    public static final String LIST     = "list";
    public static final String DICT     = "dict";
    public static final String OBJECT   = "object";
    public static final String FUNCTION = "function";
    public static final String MODULE   = "module";
    public static final String UNKNOWN  = "unknown";

    private Types() {}

    /** True when the type carries no information, so checks should stay silent. */
    public static boolean isUnknown(String type) {
        return type == null || UNKNOWN.equals(type);
    }

    public static boolean isNumeric(String type) {
        return NUMBER.equals(type);
    }

    /** Types that can appear on the right of {@code for x in ...}. */
    public static boolean isIterable(String type) {
        return LIST.equals(type) || DICT.equals(type) || STRING.equals(type);
    }
}
