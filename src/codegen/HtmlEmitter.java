package codegen;

import ASTJinja2withHTMLandCSS.ASTNode;
import ASTJinja2withHTMLandCSS.ProgramNode;
import ASTJinja2withHTMLandCSS.Jinja2.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Turns a Jinja AST plus a context into finished HTML.
 * <p>
 * Everything static is copied straight out of the source using the character spans
 * the parser recorded, and only the dynamic nodes are replaced. That is what keeps
 * the whitespace intact.
 */
public class HtmlEmitter implements Emitter {

    private static final Pattern URL_FOR = Pattern.compile("^url_for\\s*\\((.*)\\)$");
    private static final Pattern ARGUMENT =
            Pattern.compile("(?:(\\w+)\\s*=\\s*)?['\"]([^'\"]*)['\"]");

    /** Attributes whose value is a link and therefore needs rewriting. */
    private static final List<String> LINK_ATTRIBUTES = List.of("href", "src", "action");

    private final LinkResolver links;
    private final List<String> log = new ArrayList<>();

    private String source;
    private StringBuilder out;

    public HtmlEmitter(LinkResolver links) {
        this.links = links;
    }

    public List<String> getLog() {
        return log;
    }

    // ============================================================

    @Override
    public String emit(ASTNode root, Map<String, Object> context) {
        if (!(root instanceof ProgramNode program) || program.getSourceText() == null) {
            throw new EvaluationException("template was not parsed with its source attached");
        }
        this.source = program.getSourceText();
        this.out = new StringBuilder(source.length() + 256);

        Environment env = new Environment();
        context.forEach(env::define);

        emitNode(program, env);
        return out.toString();
    }

    // ============================================================
    //                        Node dispatch
    // ============================================================

    private void emitNode(ASTNode node, Environment env) {
        if (node == null) return;

        if (node instanceof JinjaExpressionNode expression) { emitExpression(expression, env); return; }
        if (node instanceof ForBlockNode block)             { emitForBlock(block, env); return; }
        if (node instanceof IfBlockNode ifBlock)           { emitIfBlock(ifBlock, env); return; }
        if (node instanceof SetNode setNode)               { emitSetStatement(setNode, env); return; }
        if (node instanceof NamedBlockNode namedBlock)     { emitNamedBlock(namedBlock, env); return; }
        if (node instanceof AttributeNode attr)            { emitAttribute(attr, env); return; }

        List<ASTNode> children = node.getChildren();
        if (children.isEmpty()) {
            emitRaw(node.getStartIndex(), node.getStopIndex() + 1);
            return;
        }
        emitSequence(children, node.getStartIndex(), node.getStopIndex() + 1, env);
    }

    /**
     * Emits children in order, copying the untouched source that lies between them.
     */
    private void emitSequence(List<ASTNode> children, int from, int to, Environment env) {
        int cursor = from;
        for (ASTNode child : children) {
            if (child == null) continue;
            int start = child.getStartIndex();
            if (start >= cursor) emitRaw(cursor, start);
            emitNode(child, env);
            cursor = Math.max(cursor, child.getStopIndex() + 1);
        }
        emitRaw(cursor, to);
    }

    private void emitRaw(int from, int to) {
        if (from < 0 || to > source.length() || from >= to) return;
        out.append(source, from, to);
    }

    // ============================================================
    //                       Dynamic nodes
    // ============================================================

    /** {{ product.name }} or any Jinja expression */
    private void emitExpression(JinjaExpressionNode expression, Environment env) {
        Object value = evaluateExpr(expression.getExpr(), env);
        out.append(escapeText(Values.display(value)));
    }

    /** {% for p in products %} ... {% endfor %} */
    private void emitForBlock(ForBlockNode block, Environment env) {
        int headerEnd = source.indexOf("%}", block.getStartIndex());
        int footerStart = source.lastIndexOf("{%", block.getStopIndex());
        if (headerEnd < 0 || footerStart < 0) {
            log.add("line " + block.getLineNumber() + ": could not locate the bounds of the for block");
            return;
        }
        headerEnd += 2;

        Object collection = block.getCollectionExpr() != null
                ? evaluateExpr(block.getCollectionExpr(), env)
                : resolveChain(block.getCollection(), env);

        if (collection == null) {
            log.add("line " + block.getLineNumber() + ": '" + block.getCollection()
                    + "' is not in the context; the loop produced nothing");
            return;
        }
        if (!(collection instanceof Iterable<?> items)) {
            log.add("line " + block.getLineNumber() + ": '" + block.getCollection()
                    + "' is a " + Values.typeName(collection) + " and cannot be iterated");
            return;
        }

        List<ASTNode> body = block.getContent();
        for (Object item : items) {
            Environment iteration = env.child();
            iteration.define(block.getIterator(), item);
            emitSequence(body, headerEnd, footerStart, iteration);
        }
    }

    /** {% if condition %} ... {% else %} ... {% endif %} */
    private void emitIfBlock(IfBlockNode ifBlock, Environment env) {
        int headerEnd = source.indexOf("%}", ifBlock.getStartIndex());
        int footerStart = source.lastIndexOf("{%", ifBlock.getStopIndex());
        if (headerEnd < 0 || footerStart < 0) {
            log.add("line " + ifBlock.getLineNumber() + ": could not locate the bounds of the if block");
            return;
        }
        headerEnd += 2;

        Object condVal = evaluateExpr(ifBlock.getCondition(), env);
        boolean truthy = isTruthy(condVal);

        int elseIndex = -1;
        if (!ifBlock.getElseBody().isEmpty()) {
            // Find {% else %} between headerEnd and footerStart
            elseIndex = source.indexOf("{% else %}", headerEnd);
            if (elseIndex < 0) {
                elseIndex = source.indexOf("{%else%}", headerEnd);
            }
        }

        if (truthy) {
            int toIndex = (elseIndex > 0) ? elseIndex : footerStart;
            emitSequence(ifBlock.getThenBody(), headerEnd, toIndex, env);
        } else if (!ifBlock.getElseBody().isEmpty() && elseIndex > 0) {
            int elseEnd = source.indexOf("%}", elseIndex) + 2;
            emitSequence(ifBlock.getElseBody(), elseEnd, footerStart, env);
        }
    }

    /** {% set x = ... %} */
    private void emitSetStatement(SetNode setNode, Environment env) {
        Object val = evaluateExpr(setNode.getValue(), env);
        env.define(setNode.getVarName(), val);
    }

    /** {% block name %} ... {% endblock %} */
    private void emitNamedBlock(NamedBlockNode namedBlock, Environment env) {
        int headerEnd = source.indexOf("%}", namedBlock.getStartIndex());
        int footerStart = source.lastIndexOf("{%", namedBlock.getStopIndex());
        if (headerEnd >= 0 && footerStart >= 0) {
            headerEnd += 2;
            emitSequence(namedBlock.getBody(), headerEnd, footerStart, env);
        } else {
            for (ASTNode child : namedBlock.getBody()) {
                emitNode(child, env);
            }
        }
    }

    /** Attribute emission */
    private void emitAttribute(AttributeNode attr, Environment env) {
        String name = attr.getName();
        if (attr.getValueParts().isEmpty()) {
            out.append(name);
            return;
        }

        StringBuilder valBuilder = new StringBuilder();
        for (ASTNode part : attr.getValueParts()) {
            if (part instanceof AttrTextNode textNode) {
                valBuilder.append(textNode.getText());
            } else if (part instanceof JinjaExpressionNode exprNode) {
                Object val = evaluateExpr(exprNode.getExpr(), env);
                valBuilder.append(Values.display(val));
            } else if (part != null) {
                valBuilder.append(part.nodeValue());
            }
        }

        String resolved = valBuilder.toString();
        if (LINK_ATTRIBUTES.contains(name.toLowerCase())) {
            resolved = links.resolve(resolved);
        }

        out.append(name).append("=\"").append(escapeAttribute(resolved)).append("\"");
    }

    // ============================================================
    //                   Expression Evaluation
    // ============================================================

    public Object evaluateExpr(JinjaExprNode expr, Environment env) {
        if (expr == null) return null;

        if (expr instanceof NameExprNode nameNode) {
            String name = nameNode.getName();
            return env.get(name);
        }

        if (expr instanceof LiteralNode lit) {
            return lit.getValue();
        }

        if (expr instanceof MemberAccessNode mem) {
            return resolveChain(mem.asString(), env);
        }

        if (expr instanceof CallExprNode call) {
            return evaluateCallExpr(call, env);
        }

        if (expr instanceof FilterExprNode filter) {
            Object target = evaluateExpr(filter.getTarget(), env);
            return applyFilter(target, filter.getFilterName(), filter.getArgs(), env);
        }

        if (expr instanceof BinaryExprNode bin) {
            Object left = evaluateExpr(bin.getLeft(), env);
            Object right = evaluateExpr(bin.getRight(), env);
            return evaluateBinary(left, bin.getOp(), right);
        }

        if (expr instanceof UnaryExprNode un) {
            Object operand = evaluateExpr(un.getOperand(), env);
            if ("not".equalsIgnoreCase(un.getOp())) {
                return !isTruthy(operand);
            }
            return operand;
        }

        if (expr instanceof SubscriptExprNode sub) {
            Object target = evaluateExpr(sub.getTarget(), env);
            Object index = evaluateExpr(sub.getIndex(), env);
            if (target instanceof Map<?, ?> map && index != null) {
                return map.get(index.toString());
            }
            if (target instanceof List<?> list && index instanceof Number num) {
                int idx = num.intValue();
                if (idx >= 0 && idx < list.size()) return list.get(idx);
            }
            return null;
        }

        return null;
    }

    private Object evaluateCallExpr(CallExprNode call, Environment env) {
        String callee = call.getCallee();
        if ("url_for".equals(callee)) {
            String endpoint = "";
            String filename = null;
            for (CallExprNode.Arg arg : call.getArgs()) {
                if ("filename".equals(arg.name())) {
                    Object val = evaluateExpr(arg.expr(), env);
                    filename = val != null ? val.toString() : null;
                } else if (arg.name() == null && endpoint.isEmpty()) {
                    Object val = evaluateExpr(arg.expr(), env);
                    endpoint = val != null ? val.toString() : "";
                }
            }
            if ("static".equals(endpoint)) {
                return (filename != null) ? filename : "";
            }
            String page = links.resolveEndpoint(endpoint);
            if (page != null) return page;
            log.add("url_for('" + endpoint + "') has no generated page; left as a path");
            return "/" + endpoint;
        }
        log.add("unknown function call: " + callee);
        return null;
    }

    private Object applyFilter(Object target, String filterName, List<JinjaExprNode> args, Environment env) {
        if (target == null) return "";
        String s = target.toString();
        switch (filterName.toLowerCase()) {
            case "upper": return s.toUpperCase();
            case "lower": return s.toLowerCase();
            case "length":
                if (target instanceof List<?> l) return l.size();
                if (target instanceof Map<?, ?> m) return m.size();
                return s.length();
            case "capitalize":
                return s.isEmpty() ? s : Character.toUpperCase(s.charAt(0)) + s.substring(1);
            case "trim": return s.trim();
            default:
                log.add("unknown filter: " + filterName);
                return target;
        }
    }

    private Object evaluateBinary(Object left, String op, Object right) {
        if (op == null) return null;
        switch (op) {
            case "+":
                if (left instanceof Number n1 && right instanceof Number n2) {
                    if (left instanceof Double || right instanceof Double)
                        return n1.doubleValue() + n2.doubleValue();
                    return n1.longValue() + n2.longValue();
                }
                return String.valueOf(left != null ? left : "") + (right != null ? right : "");
            case "-":
                if (left instanceof Number n1 && right instanceof Number n2)
                    return n1.doubleValue() - n2.doubleValue();
                return 0;
            case "*":
                if (left instanceof Number n1 && right instanceof Number n2)
                    return n1.doubleValue() * n2.doubleValue();
                return 0;
            case "/":
                if (left instanceof Number n1 && right instanceof Number n2 && n2.doubleValue() != 0)
                    return n1.doubleValue() / n2.doubleValue();
                return 0;
            case "==": return Objects.equals(left, right) || String.valueOf(left).equals(String.valueOf(right));
            case "!=": return !Objects.equals(left, right) && !String.valueOf(left).equals(String.valueOf(right));
            case "<":
                if (left instanceof Number n1 && right instanceof Number n2)
                    return n1.doubleValue() < n2.doubleValue();
                return false;
            case ">":
                if (left instanceof Number n1 && right instanceof Number n2)
                    return n1.doubleValue() > n2.doubleValue();
                return false;
            case "<=":
                if (left instanceof Number n1 && right instanceof Number n2)
                    return n1.doubleValue() <= n2.doubleValue();
                return false;
            case ">=":
                if (left instanceof Number n1 && right instanceof Number n2)
                    return n1.doubleValue() >= n2.doubleValue();
                return false;
            case "and": return isTruthy(left) ? right : left;
            case "or": return isTruthy(left) ? left : right;
            case "in":
                if (right instanceof Iterable<?> iter) {
                    for (Object o : iter) if (Objects.equals(left, o)) return true;
                    return false;
                }
                if (right instanceof Map<?, ?> m) return m.containsKey(String.valueOf(left));
                if (right instanceof String str) return str.contains(String.valueOf(left));
                return false;
            case "is":
                if ("none".equalsIgnoreCase(String.valueOf(right))) return left == null;
                if ("defined".equalsIgnoreCase(String.valueOf(right))) return left != null;
                return Objects.equals(left, right);
            default:
                return null;
        }
    }

    private boolean isTruthy(Object val) {
        if (val == null) return false;
        if (val instanceof Boolean b) return b;
        if (val instanceof Number n) return n.doubleValue() != 0.0;
        if (val instanceof String s) return !s.isEmpty();
        if (val instanceof List<?> l) return !l.isEmpty();
        if (val instanceof Map<?, ?> m) return !m.isEmpty();
        return true;
    }

    /** Walks {@code p.name} through the context. */
    private Object resolveChain(String chain, Environment env) {
        if (chain == null || chain.isBlank()) return null;

        String[] parts = chain.trim().split("\\.");
        if (!env.has(parts[0])) return null;

        Object current = env.get(parts[0]);
        for (int i = 1; i < parts.length && current != null; i++) {
            if (current instanceof Map<?, ?> map) {
                current = map.get(parts[i]);
            } else {
                log.add("cannot read '" + parts[i] + "' from a " + Values.typeName(current));
                return null;
            }
        }
        return current;
    }

    // ============================================================
    //                         Escaping
    // ============================================================

    /** Jinja autoescapes; values must not be able to inject markup. */
    private String escapeText(String text) {
        return text.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;");
    }

    private String escapeAttribute(String text) {
        return escapeText(text).replace("\"", "&quot;");
    }
}
