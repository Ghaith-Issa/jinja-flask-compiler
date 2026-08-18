package report;

import java.util.Collection;
import java.util.Map;

/**
 * Minimal JSON writer.
 * <p>
 * Hand-rolled because the project's only dependency is the ANTLR jar, and the AST
 * dumps need nothing more than objects, arrays, strings and numbers.
 */
public final class Json {

    private final StringBuilder out = new StringBuilder();
    private int depth = 0;

    public String build() {
        return out.toString();
    }

    // ============================================================
    //                        Structure
    // ============================================================

    public Json openObject() {
        out.append('{');
        depth++;
        return this;
    }

    public Json closeObject() {
        depth--;
        newline();
        out.append('}');
        return this;
    }

    public Json openArray() {
        out.append('[');
        depth++;
        return this;
    }

    public Json closeArray() {
        depth--;
        newline();
        out.append(']');
        return this;
    }

    /** Writes a key on its own line, ready for a value. */
    public Json key(String name, boolean first) {
        if (!first) out.append(',');
        newline();
        out.append(quote(name)).append(": ");
        return this;
    }

    public Json separator(boolean first) {
        if (!first) out.append(',');
        newline();
        return this;
    }

    // ============================================================
    //                          Values
    // ============================================================

    public Json value(Object value) {
        out.append(literal(value));
        return this;
    }

    public Json field(String name, Object value, boolean first) {
        key(name, first);
        return value(value);
    }

    /** Writes a field only when the value is present and non-empty. */
    public boolean optionalField(String name, Object value, boolean first) {
        if (value == null) return first;
        if (value instanceof String s && s.isEmpty()) return first;
        if (value instanceof Collection<?> c && c.isEmpty()) return first;
        if (value instanceof Map<?, ?> m && m.isEmpty()) return first;
        field(name, value, first);
        return false;
    }

    private void newline() {
        out.append('\n').append("  ".repeat(depth));
    }

    // ============================================================
    //                         Encoding
    // ============================================================

    public static String literal(Object value) {
        if (value == null) return "null";
        if (value instanceof Boolean || value instanceof Number) return String.valueOf(value);

        if (value instanceof Collection<?> items) {
            StringBuilder array = new StringBuilder("[");
            boolean first = true;
            for (Object item : items) {
                if (!first) array.append(", ");
                array.append(literal(item));
                first = false;
            }
            return array.append(']').toString();
        }

        if (value instanceof Map<?, ?> map) {
            StringBuilder object = new StringBuilder("{");
            boolean first = true;
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                if (!first) object.append(", ");
                object.append(quote(String.valueOf(entry.getKey()))).append(": ")
                        .append(literal(entry.getValue()));
                first = false;
            }
            return object.append('}').toString();
        }

        return quote(String.valueOf(value));
    }

    public static String quote(String text) {
        StringBuilder quoted = new StringBuilder(text.length() + 2).append('"');
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            switch (c) {
                case '"'  -> quoted.append("\\\"");
                case '\\' -> quoted.append("\\\\");
                case '\n' -> quoted.append("\\n");
                case '\r' -> quoted.append("\\r");
                case '\t' -> quoted.append("\\t");
                case '\b' -> quoted.append("\\b");
                case '\f' -> quoted.append("\\f");
                default -> {
                    if (c < 0x20) quoted.append(String.format("\\u%04x", (int) c));
                    else quoted.append(c);
                }
            }
        }
        return quoted.append('"').toString();
    }
}
