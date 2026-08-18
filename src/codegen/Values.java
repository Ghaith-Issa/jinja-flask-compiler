package codegen;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Runtime value helpers.
 * <p>
 * miniFlask values are ordinary Java objects — {@code Double}/{@code Long} for
 * numbers, {@code String}, {@code Boolean}, {@code null} for None,
 * {@code List<Object>} and {@code Map<String,Object>}. Nothing is wrapped, so the
 * template emitter can hand them straight to the page.
 */
public final class Values {

    private Values() {}

    // ============================================================
    //                        Presentation
    // ============================================================

    /** How a value appears in generated HTML. */
    public static String display(Object value) {
        if (value == null) return "";
        if (value instanceof Boolean b) return b ? "True" : "False";
        if (value instanceof Double d) {
            // 999.0 came from arithmetic, not from the source; show it as 999.
            if (!d.isInfinite() && !d.isNaN() && d == Math.floor(d)) {
                return String.valueOf((long) (double) d);
            }
        }
        return String.valueOf(value);
    }

    /** Python truthiness: empty containers, zero, "" and None are false. */
    public static boolean isTruthy(Object value) {
        if (value == null) return false;
        if (value instanceof Boolean b) return b;
        if (value instanceof Number n) return n.doubleValue() != 0.0;
        if (value instanceof String s) return !s.isEmpty();
        if (value instanceof List<?> list) return !list.isEmpty();
        if (value instanceof Map<?, ?> map) return !map.isEmpty();
        return true;
    }

    // ============================================================
    //                        Arithmetic
    // ============================================================

    public static Object add(Object left, Object right) {
        if (left instanceof String || right instanceof String) {
            if (left instanceof String a && right instanceof String b) return a + b;
            throw new EvaluationException("cannot add " + typeName(left) + " and " + typeName(right));
        }
        if (left instanceof List<?> a && right instanceof List<?> b) {
            List<Object> merged = new ArrayList<>(a);
            merged.addAll(b);
            return merged;
        }
        return arithmetic(left, right, '+');
    }

    public static Object subtract(Object left, Object right) { return arithmetic(left, right, '-'); }

    public static Object multiply(Object left, Object right) {
        if (left instanceof String s && right instanceof Number n) return s.repeat(Math.max(0, n.intValue()));
        if (left instanceof Number n && right instanceof String s) return s.repeat(Math.max(0, n.intValue()));
        return arithmetic(left, right, '*');
    }

    /** Python's {@code /} always produces a float. */
    public static Object divide(Object left, Object right) {
        double divisor = requireNumber(right, "/").doubleValue();
        if (divisor == 0.0) throw new EvaluationException("division by zero");
        return requireNumber(left, "/").doubleValue() / divisor;
    }

    private static Object arithmetic(Object left, Object right, char op) {
        Number a = requireNumber(left, String.valueOf(op));
        Number b = requireNumber(right, String.valueOf(op));

        // Integers stay integers, so ids and counts do not turn into 3.0.
        if (isIntegral(a) && isIntegral(b)) {
            long x = a.longValue();
            long y = b.longValue();
            return switch (op) {
                case '+' -> x + y;
                case '-' -> x - y;
                default -> x * y;
            };
        }
        double x = a.doubleValue();
        double y = b.doubleValue();
        return switch (op) {
            case '+' -> x + y;
            case '-' -> x - y;
            default -> x * y;
        };
    }

    // ============================================================
    //                        Comparison
    // ============================================================

    public static boolean equal(Object left, Object right) {
        if (left == null || right == null) return left == right;
        if (left instanceof Number a && right instanceof Number b) {
            return a.doubleValue() == b.doubleValue();
        }
        return left.equals(right);
    }

    /** Ordering comparison; both sides must be numbers or both strings. */
    public static int compare(Object left, Object right, String op) {
        if (left instanceof Number a && right instanceof Number b) {
            return Double.compare(a.doubleValue(), b.doubleValue());
        }
        if (left instanceof String a && right instanceof String b) {
            return a.compareTo(b);
        }
        throw new EvaluationException(
                "cannot compare " + typeName(left) + " with " + typeName(right) + " using " + op);
    }

    // ============================================================
    //                         Helpers
    // ============================================================

    public static boolean isIntegral(Number n) {
        return n instanceof Integer || n instanceof Long || n instanceof java.math.BigInteger;
    }

    private static Number requireNumber(Object value, String op) {
        if (value instanceof Number n) return n;
        if (value instanceof Boolean b) return b ? 1 : 0;
        throw new EvaluationException("operator '" + op + "' needs a number but got " + typeName(value));
    }

    public static String typeName(Object value) {
        if (value == null) return "None";
        if (value instanceof String) return "string";
        if (value instanceof Boolean) return "bool";
        if (value instanceof Number) return "number";
        if (value instanceof List) return "list";
        if (value instanceof Map) return "dict";
        return value.getClass().getSimpleName();
    }
}
