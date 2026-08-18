package semantic;

import FlaskStatement.*;
import SymbolsTable.Scope;
import SymbolsTable.Symbol;
import SymbolsTable.Types;

import java.util.Map;

/**
 * Type inference for miniFlask expressions.
 * <p>
 * The previous version returned {@code unknown} for everything except plain
 * literals, which meant the mismatch check could never fire. The difference here is
 * that inference follows a name to the expression it was bound to, so
 * {@code products[0]["price"]} can be traced through the list to the dict to the
 * literal and come back as {@code number}.
 */
public class TypeSystem {

    /** Return types of the calls miniFlask knows about. */
    private static final Map<String, String> RETURN_TYPES = Map.ofEntries(
            Map.entry("len", Types.NUMBER),
            Map.entry("int", Types.NUMBER),
            Map.entry("float", Types.NUMBER),
            Map.entry("str", Types.STRING),
            Map.entry("range", Types.LIST),
            Map.entry("render_template", Types.STRING),
            Map.entry("url_for", Types.STRING),
            Map.entry("redirect", Types.STRING),
            Map.entry("send_from_directory", Types.STRING),
            Map.entry("Flask", Types.OBJECT),
            Map.entry("append", Types.NONE)
    );

    /** Attributes of Flask's request object that carry a known type. */
    private static final Map<String, String> REQUEST_ATTRIBUTES = Map.of(
            "method", Types.STRING,
            "form", Types.DICT,
            "args", Types.DICT,
            "files", Types.DICT,
            "url", Types.STRING,
            "path", Types.STRING
    );

    /** Types that cannot be indexed with {@code [...]}. */
    private static boolean isSubscriptable(String type) {
        return Types.isUnknown(type)
                || Types.LIST.equals(type)
                || Types.DICT.equals(type)
                || Types.STRING.equals(type)
                || Types.OBJECT.equals(type);
    }

    // ============================================================
    //                        Inference
    // ============================================================

    public String infer(Expression expr, Scope scope) {
        if (expr == null) return Types.UNKNOWN;

        if (expr instanceof Literal literal) {
            if (literal.isString()) return Types.STRING;
            if (literal.isNumber()) return Types.NUMBER;
            if (literal.isTrue() || literal.isFalse()) return Types.BOOL;
            if (literal.isNone()) return Types.NONE;
            return Types.UNKNOWN;
        }
        if (expr instanceof ListExpr) return Types.LIST;
        if (expr instanceof DictExpr) return Types.DICT;

        if (expr instanceof Name name) {
            Symbol symbol = resolve(scope, name.id);
            return (symbol != null) ? symbol.getType() : Types.UNKNOWN;
        }

        if (expr instanceof Subscript subscript) {
            Expression element = elementOf(subscript, scope);
            return (element != null) ? infer(element, scope) : Types.UNKNOWN;
        }

        if (expr instanceof Attribute attribute) {
            return inferAttribute(attribute, scope);
        }

        if (expr instanceof FunctionCall call) {
            return RETURN_TYPES.getOrDefault(calleeName(call), Types.UNKNOWN);
        }

        if (expr instanceof BinaryOperation binary) {
            return inferBinary(binary, scope);
        }

        return Types.UNKNOWN;
    }

    private String inferAttribute(Attribute attribute, Scope scope) {
        if (attribute.object instanceof Name base && "request".equals(base.id)) {
            return REQUEST_ATTRIBUTES.getOrDefault(attribute.attribute, Types.UNKNOWN);
        }
        // A dict literal reached through dot notation, e.g. inside a Jinja context.
        Expression bound = boundExpression(attribute.object, scope);
        if (bound instanceof DictExpr dict) {
            Expression value = dict.pairs.get(attribute.attribute);
            if (value != null) return infer(value, scope);
        }
        return Types.UNKNOWN;
    }

    private String inferBinary(BinaryOperation binary, Scope scope) {
        if (isComparison(binary.op)) return Types.BOOL;

        String left = infer(binary.left, scope);
        String right = infer(binary.right, scope);
        if (Types.isUnknown(left)) return right;
        if (Types.isUnknown(right)) return left;
        return left.equals(right) ? left : Types.UNKNOWN;
    }

    // ============================================================
    //                     Structure walking
    // ============================================================

    /**
     * The expression a name is ultimately bound to, following one hop through the
     * symbol table. Returns the input unchanged when it is not a name.
     */
    public Expression boundExpression(Expression expr, Scope scope) {
        if (expr instanceof Name name) {
            Symbol symbol = resolve(scope, name.id);
            if (symbol == null || !(symbol.getValue() instanceof Expression bound) || bound == expr) {
                return null;
            }
            // A loop variable is bound to the collection it walks, so it stands for
            // one element of it: for p in products makes p a product, not the list.
            if (symbol.getKind() == Symbol.Kind.LOOP_VAR) {
                return iterationElementOf(bound, scope);
            }
            return boundExpression(bound, scope);
        }
        if (expr instanceof Subscript subscript) {
            return elementOf(subscript, scope);
        }
        return expr;
    }

    /** The expression produced by {@code target[index]}, when it can be traced. */
    public Expression elementOf(Subscript subscript, Scope scope) {
        Expression target = boundExpression(subscript.value, scope);
        if (target == null) return null;

        if (target instanceof ListExpr list) {
            if (list.expressions == null || list.expressions.isEmpty()) return null;
            // Every element of a miniFlask list has the same shape, so element 0
            // stands in for whichever index was written.
            return list.expressions.get(0);
        }
        if (target instanceof DictExpr dict) {
            String key = literalKey(subscript.index);
            return (key != null) ? dict.pairs.get(key) : null;
        }
        return null;
    }

    /** The element expression produced by iterating this expression. */
    public Expression iterationElementOf(Expression iterable, Scope scope) {
        Expression target = boundExpression(iterable, scope);
        if (target instanceof ListExpr list
                && list.expressions != null && !list.expressions.isEmpty()) {
            return list.expressions.get(0);
        }
        return null;
    }

    private String literalKey(Expression index) {
        if (index instanceof Literal literal && literal.value instanceof String key) return key;
        return null;
    }

    // ============================================================
    //                      Operator rules
    // ============================================================

    public static boolean isComparison(BinaryOperation.Operator op) {
        return switch (op) {
            case GT, LT, GTE, LTE, EQ, NEQ -> true;
            default -> false;
        };
    }

    /**
     * Whether an operator accepts this pair of operand types.
     * Unknown operands always pass, so incomplete inference never invents errors.
     */
    public boolean accepts(BinaryOperation.Operator op, String left, String right) {
        if (Types.isUnknown(left) || Types.isUnknown(right)) return true;

        return switch (op) {
            case ADD -> left.equals(right)
                    && (Types.NUMBER.equals(left) || Types.STRING.equals(left) || Types.LIST.equals(left));
            case SUB, DIV -> Types.isNumeric(left) && Types.isNumeric(right);
            case MUL -> (Types.isNumeric(left) && Types.isNumeric(right))
                    || (Types.STRING.equals(left) && Types.isNumeric(right))
                    || (Types.isNumeric(left) && Types.STRING.equals(right))
                    || (Types.LIST.equals(left) && Types.isNumeric(right));
            case EQ, NEQ -> left.equals(right)
                    || Types.NONE.equals(left) || Types.NONE.equals(right);
            case GT, LT, GTE, LTE -> left.equals(right)
                    && (Types.isNumeric(left) || Types.STRING.equals(left));
        };
    }

    /** True when indexing this type with {@code [...]} is meaningful. */
    public boolean allowsSubscript(String type) {
        return isSubscriptable(type);
    }

    /** Name of the thing being called, or the empty string if it cannot be read. */
    public static String calleeName(FunctionCall call) {
        if (call.called instanceof Name name) return name.id;
        if (call.called instanceof Attribute attribute) return attribute.attribute;
        return "";
    }

    private Symbol resolve(Scope scope, String name) {
        return (scope != null) ? scope.resolve(name) : null;
    }
}
