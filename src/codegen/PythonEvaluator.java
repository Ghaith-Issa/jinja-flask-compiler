package codegen;

import FlaskStatement.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Executes the miniFlask subset of Python over the AST.
 * <p>
 * The generator needs real values, not types: {@code render_template("index.html",
 * products=products)} only becomes a page once {@code products} is an actual list of
 * dicts. This walks the tree and produces those values.
 */
public class PythonEvaluator {

    /** A user-defined function, stored as a value so routes can be called. */
    public record FunctionValue(FunctionDef definition) {
        @Override
        public String toString() {
            return "<function " + definition.getName() + ">";
        }
    }

    /** Marker for a redirect; carries no page of its own. */
    public record Redirect(String location) {}

    /** A builtin whose name the evaluator recognises but does not model in depth. */
    private record Opaque(String name) {
        @Override
        public String toString() { return "<" + name + ">"; }
    }

    // --- control flow, signalled rather than returned ---
    private static class BreakSignal extends RuntimeException {
        private static final long serialVersionUID = 1L;
        BreakSignal() { super(null, null, false, false); }
    }
    private static class ContinueSignal extends RuntimeException {
        private static final long serialVersionUID = 1L;
        ContinueSignal() { super(null, null, false, false); }
    }
    private static class ReturnSignal extends RuntimeException {
        private static final long serialVersionUID = 1L;
        final transient Object value;
        ReturnSignal(Object value) { super(null, null, false, false); this.value = value; }
    }

    private final Environment globals = new Environment();
    private final List<String> log = new ArrayList<>();

    /** Endpoint name to URL, filled in by the caller so url_for() can resolve. */
    private final Map<String, String> routesByEndpoint = new LinkedHashMap<>();

    public Environment getGlobals() { return globals; }
    public List<String> getLog()    { return log; }

    public void registerRoute(String endpoint, String url) {
        if (endpoint != null && url != null) routesByEndpoint.put(endpoint, url);
    }

    // ============================================================
    //                      Module execution
    // ============================================================

    /** Runs the top level of the program: assignments, defs and imports. */
    public void run(Program program) {
        seedFlaskGlobals();
        for (Statement statement : program.statements) {
            try {
                execute(statement, globals);
            } catch (ReturnSignal | BreakSignal | ContinueSignal signal) {
                // Reachable when a parse error leaves a return outside any function.
                // These are control-flow markers, not errors to propagate: letting one
                // escape would abort the whole compiler with a bare stack trace.
                log.add("line " + statement.line + ": "
                        + signal.getClass().getSimpleName().replace("Signal", "").toLowerCase()
                        + " outside a function was ignored");
            }
        }
    }

    /**
     * Request is seeded as a GET with no form data, so a view guarded by
     * {@code if request.method == "POST"} generates its GET page — which is the page
     * a browser would first see.
     */
    private void seedFlaskGlobals() {
        globals.define("request", newRequest("GET", new LinkedHashMap<>()));
        globals.define("__name__", "__main__");
    }

    private Map<String, Object> newRequest(String method, Map<String, Object> form) {
        Map<String, Object> request = new LinkedHashMap<>();
        request.put("method", method);
        request.put("form", form);
        request.put("args", new LinkedHashMap<String, Object>());
        return request;
    }

    /**
     * Replaces the request object before a view is called.
     * The live server uses this to replay a real form submission through the same
     * interpreter that produced the pages, so {@code request.form["name"]} and
     * {@code products.append(...)} behave exactly as the source says they should.
     */
    public void setRequest(String method, Map<String, Object> form) {
        globals.assign("request", newRequest(method, form != null ? form : new LinkedHashMap<>()));
    }

    /** Looks up a global by name, or null when it is not defined. */
    public Object global(String name) {
        return globals.has(name) ? globals.get(name) : null;
    }

    // ============================================================
    //                        Statements
    // ============================================================

    private void execute(Statement statement, Environment env) {
        if (statement == null) return;

        if (statement instanceof ImportStatement || statement instanceof GlobalStatement) {
            return;                                   // names come from builtins / globals
        }

        if (statement instanceof FunctionDef function) {
            env.define(function.getName(), new FunctionValue(function));
            return;
        }
        if (statement instanceof Assignment assignment) {
            executeAssignment(assignment, env);
            return;
        }
        if (statement instanceof ExpressionStatement expression) {
            evaluate(expression.getExpression(), env);
            return;
        }
        if (statement instanceof ReturnStatement ret) {
            throw new ReturnSignal(ret.returnsValue() ? evaluate(ret.getExpression(), env) : null);
        }
        if (statement instanceof BreakStatement)    throw new BreakSignal();
        if (statement instanceof ContinueStatement) throw new ContinueSignal();

        if (statement instanceof IfStatement conditional) {
            executeIf(conditional, env);
            return;
        }
        if (statement instanceof ForStatement loop) {
            executeFor(loop, env);
            return;
        }
        if (statement instanceof Decorator) {
            return;                                   // routes are read statically
        }

        log.add("skipped unsupported statement: " + statement.getClass().getSimpleName()
                + " at line " + statement.line);
    }

    private void executeBlock(List<Statement> body, Environment env) {
        for (Statement statement : body) execute(statement, env);
    }

    private void executeAssignment(Assignment assignment, Environment env) {
        Object value = evaluate(assignment.getRight(), env);
        Expression target = assignment.getLeft();

        if (target instanceof Name name) {
            env.assign(name.id, value);
            return;
        }
        if (target instanceof Subscript subscript) {
            Object container = evaluate(subscript.value, env);
            Object key = evaluate(subscript.index, env);
            store(container, key, value, assignment.line);
            return;
        }
        throw new EvaluationException("cannot assign to " + target, assignment.line);
    }

    @SuppressWarnings("unchecked")
    private void store(Object container, Object key, Object value, int line) {
        if (container instanceof Map) {
            ((Map<String, Object>) container).put(String.valueOf(key), value);
            return;
        }
        if (container instanceof List && key instanceof Number index) {
            ((List<Object>) container).set(index.intValue(), value);
            return;
        }
        throw new EvaluationException("cannot index-assign into " + Values.typeName(container), line);
    }

    private void executeIf(IfStatement conditional, Environment env) {
        if (Values.isTruthy(evaluate(conditional.getConditionExpression(), env))) {
            executeBlock(conditional.getBody(), env.child());
        } else if (conditional.getElseBody() != null && !conditional.getElseBody().isEmpty()) {
            executeBlock(conditional.getElseBody(), env.child());
        }
    }

    private void executeFor(ForStatement loop, Environment env) {
        Object iterable = evaluate(loop.getIterableExpression(), env);
        for (Object item : asIterable(iterable, loop.line)) {
            Environment body = env.child();
            body.define(loop.getIteratorName(), item);
            try {
                executeBlock(loop.getBody(), body);
            } catch (ContinueSignal ignored) {
                // next item
            } catch (BreakSignal stop) {
                break;
            }
        }
    }

    @SuppressWarnings("unchecked")
    private Iterable<Object> asIterable(Object value, int line) {
        if (value instanceof List<?> list) return (List<Object>) list;
        if (value instanceof Map<?, ?> map) return new ArrayList<>(map.keySet());
        if (value instanceof String text) {
            List<Object> chars = new ArrayList<>();
            for (char c : text.toCharArray()) chars.add(String.valueOf(c));
            return chars;
        }
        throw new EvaluationException("cannot iterate over " + Values.typeName(value), line);
    }

    // ============================================================
    //                       Expressions
    // ============================================================

    public Object evaluate(Expression expression, Environment env) {
        if (expression == null) return null;

        if (expression instanceof Literal literal)   return literal.value;
        if (expression instanceof Name name)         return env.get(name.id);
        if (expression instanceof ListExpr list)     return evaluateList(list, env);
        if (expression instanceof DictExpr dict)     return evaluateDict(dict, env);
        if (expression instanceof Subscript sub)     return evaluateSubscript(sub, env);
        if (expression instanceof Attribute attr)    return evaluateAttribute(attr, env);
        if (expression instanceof BinaryOperation b) return evaluateBinary(b, env);
        if (expression instanceof FunctionCall call) return evaluateCall(call, env);

        throw new EvaluationException(
                "unsupported expression " + expression.getClass().getSimpleName(), expression.line);
    }

    private Object evaluateList(ListExpr list, Environment env) {
        List<Object> values = new ArrayList<>();
        if (list.expressions != null) {
            for (Expression element : list.expressions) values.add(evaluate(element, env));
        }
        return values;
    }

    private Object evaluateDict(DictExpr dict, Environment env) {
        Map<String, Object> values = new LinkedHashMap<>();
        if (dict.pairs != null) {
            for (Map.Entry<String, Expression> pair : dict.pairs.entrySet()) {
                values.put(pair.getKey(), evaluate(pair.getValue(), env));
            }
        }
        return values;
    }

    private Object evaluateSubscript(Subscript subscript, Environment env) {
        Object container = evaluate(subscript.value, env);
        Object key = evaluate(subscript.index, env);
        return read(container, key, subscript.line);
    }

    private Object read(Object container, Object key, int line) {
        if (container instanceof Map<?, ?> map) {
            String name = String.valueOf(key);
            if (!map.containsKey(name)) {
                throw new EvaluationException("key '" + name + "' is not in the dict", line);
            }
            return map.get(name);
        }
        if (container instanceof List<?> list) {
            if (!(key instanceof Number index)) {
                throw new EvaluationException("list index must be a number", line);
            }
            int i = index.intValue();
            if (i < 0) i += list.size();
            if (i < 0 || i >= list.size()) {
                throw new EvaluationException("list index " + index + " is out of range", line);
            }
            return list.get(i);
        }
        if (container instanceof String text && key instanceof Number index) {
            return String.valueOf(text.charAt(index.intValue()));
        }
        throw new EvaluationException("cannot index " + Values.typeName(container), line);
    }

    private Object evaluateAttribute(Attribute attribute, Environment env) {
        Object target = evaluate(attribute.object, env);
        if (target instanceof Map<?, ?> map && map.containsKey(attribute.attribute)) {
            return map.get(attribute.attribute);
        }
        // Method access such as products.append — resolved when it is called.
        return new BoundMethod(target, attribute.attribute);
    }

    /** An attribute that turned out to be a method, kept until the call site. */
    public record BoundMethod(Object receiver, String name) {}

    private Object evaluateBinary(BinaryOperation binary, Environment env) {
        Object left = evaluate(binary.left, env);
        Object right = evaluate(binary.right, env);

        return switch (binary.op) {
            case ADD -> Values.add(left, right);
            case SUB -> Values.subtract(left, right);
            case MUL -> Values.multiply(left, right);
            case DIV -> Values.divide(left, right);
            case EQ  -> Values.equal(left, right);
            case NEQ -> !Values.equal(left, right);
            case GT  -> Values.compare(left, right, ">") > 0;
            case LT  -> Values.compare(left, right, "<") < 0;
            case GTE -> Values.compare(left, right, ">=") >= 0;
            case LTE -> Values.compare(left, right, "<=") <= 0;
        };
    }

    // ============================================================
    //                          Calls
    // ============================================================

    private Object evaluateCall(FunctionCall call, Environment env) {
        List<Object> args = new ArrayList<>();
        for (Expression argument : call.args) args.add(evaluate(argument, env));

        Map<String, Object> kwargs = new LinkedHashMap<>();
        for (Map.Entry<String, Expression> entry : call.kwargs.entrySet()) {
            kwargs.put(entry.getKey(), evaluate(entry.getValue(), env));
        }

        // A method call: products.append(x)
        if (call.called instanceof Attribute attribute) {
            Object receiver = resolveReceiver(attribute, env);
            if (receiver != null) {
                return callMethod(receiver, attribute.attribute, args, call.line);
            }
        }

        if (call.called instanceof Name name) {
            if (env.has(name.id) && env.get(name.id) instanceof FunctionValue function) {
                return callFunction(function, args, call.line);
            }
            return callBuiltin(name.id, args, kwargs, call.line);
        }

        Object callee = evaluate(call.called, env);
        if (callee instanceof FunctionValue function) return callFunction(function, args, call.line);
        if (callee instanceof BoundMethod method) {
            return callMethod(method.receiver(), method.name(), args, call.line);
        }
        throw new EvaluationException("value of type " + Values.typeName(callee) + " is not callable",
                call.line);
    }

    /** The object a method is called on, or null when it is not a real value. */
    private Object resolveReceiver(Attribute attribute, Environment env) {
        try {
            Object target = evaluate(attribute.object, env);
            return (target instanceof Opaque) ? null : target;
        } catch (EvaluationException e) {
            return null;
        }
    }

    public Object callFunction(FunctionValue function, List<Object> args, int line) {
        FunctionDef definition = function.definition();
        List<String> parameters = definition.getParameters();
        if (args.size() != parameters.size()) {
            throw new EvaluationException("'" + definition.getName() + "' takes "
                    + parameters.size() + " argument(s) but got " + args.size(), line);
        }

        Environment frame = globals.child();
        for (int i = 0; i < parameters.size(); i++) frame.define(parameters.get(i), args.get(i));

        try {
            executeBlock(definition.getBody(), frame);
        } catch (ReturnSignal ret) {
            return ret.value;
        } catch (BreakSignal | ContinueSignal signal) {
            throw new EvaluationException("'"
                    + signal.getClass().getSimpleName().replace("Signal", "").toLowerCase()
                    + "' outside a loop in " + definition.getName() + "()", line);
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    private Object callMethod(Object receiver, String method, List<Object> args, int line) {
        if (receiver instanceof List<?> list) {
            switch (method) {
                case "append" -> {
                    ((List<Object>) list).add(args.isEmpty() ? null : args.get(0));
                    return null;
                }
                case "remove" -> {
                    if (!args.isEmpty() && args.get(0) != null) {
                        Object target = args.get(0);
                        ((List<Object>) list).removeIf(item -> Values.equal(item, target));
                    }
                    return null;
                }
                case "pop" -> {
                    if (list.isEmpty()) throw new EvaluationException("pop from empty list", line);
                    return ((List<Object>) list).remove(list.size() - 1);
                }

                default -> { }
            }
        }
        if (receiver instanceof Map<?, ?> map) {
            switch (method) {
                case "get"    -> { return map.get(String.valueOf(args.isEmpty() ? "" : args.get(0))); }
                case "keys"   -> { return new ArrayList<Object>(map.keySet()); }
                case "values" -> { return new ArrayList<Object>(map.values()); }
                default -> { }
            }
        }
        // app.route(...) and friends: recognised, no runtime effect.
        return new Opaque(method);
    }

    private Object callBuiltin(String name, List<Object> args, Map<String, Object> kwargs, int line) {
        Object first = args.isEmpty() ? null : args.get(0);

        return switch (name) {
            case "render_template" -> new RenderRequest(String.valueOf(first), kwargs);
            case "redirect"        -> new Redirect(String.valueOf(first));
            case "url_for"         -> urlFor(args, kwargs);
            case "len"             -> (long) lengthOf(first, line);
            case "int"             -> toNumber(first, line).longValue();
            case "float"           -> toNumber(first, line).doubleValue();
            case "str"             -> Values.display(first);
            case "range"           -> range(args, line);
            case "print"           -> { log.add("print: " + Values.display(first)); yield null; }
            case "Flask"           -> new Opaque("Flask app");
            case "send_from_directory" -> joinPath(args);
            default -> throw new EvaluationException("unknown function '" + name + "'", line);
        };
    }

    /**
     * Resolves an endpoint to its URL. {@code url_for('static', filename='x.css')}
     * keeps the file name, because generated pages sit next to their assets.
     */
    private String urlFor(List<Object> args, Map<String, Object> kwargs) {
        String endpoint = args.isEmpty() ? "" : String.valueOf(args.get(0));
        if ("static".equals(endpoint)) {
            Object filename = kwargs.get("filename");
            return (filename != null) ? String.valueOf(filename) : "";
        }
        return routesByEndpoint.getOrDefault(endpoint, "/" + endpoint);
    }

    private String joinPath(List<Object> args) {
        StringBuilder path = new StringBuilder();
        for (Object part : args) {
            if (!path.isEmpty()) path.append('/');
            path.append(Values.display(part));
        }
        return path.toString();
    }

    private int lengthOf(Object value, int line) {
        if (value instanceof List<?> list) return list.size();
        if (value instanceof Map<?, ?> map) return map.size();
        if (value instanceof String text) return text.length();
        throw new EvaluationException("len() needs a list, dict or string", line);
    }

    private Number toNumber(Object value, int line) {
        if (value instanceof Number n) return n;
        if (value instanceof String s) {
            try {
                return Double.parseDouble(s.trim());
            } catch (NumberFormatException e) {
                throw new EvaluationException("cannot convert '" + s + "' to a number", line);
            }
        }
        throw new EvaluationException("cannot convert " + Values.typeName(value) + " to a number", line);
    }

    private List<Object> range(List<Object> args, int line) {
        if (args.isEmpty()) throw new EvaluationException("range() needs at least one argument", line);
        long start = (args.size() > 1) ? toNumber(args.get(0), line).longValue() : 0;
        long stop = toNumber(args.get(args.size() > 1 ? 1 : 0), line).longValue();
        long step = (args.size() > 2) ? toNumber(args.get(2), line).longValue() : 1;
        if (step == 0) throw new EvaluationException("range() step cannot be zero", line);

        List<Object> values = new ArrayList<>();
        for (long i = start; (step > 0) ? i < stop : i > stop; i += step) values.add(i);
        return values;
    }
}
