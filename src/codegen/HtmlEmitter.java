package codegen;

import ASTJinja2withHTMLandCSS.ASTNode;
import ASTJinja2withHTMLandCSS.ProgramNode;
import ASTJinja2withHTMLandCSS.Jinja2.AttributeValueNode;
import ASTJinja2withHTMLandCSS.Jinja2.BlockNode;
import ASTJinja2withHTMLandCSS.Jinja2.ExpressionNode;
import ASTJinja2withHTMLandCSS.Jinja2.JinjaStatementNode;
import ASTJinja2withHTMLandCSS.Jinja2.MemberAccessNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Turns a Jinja AST plus a context into finished HTML.
 * <p>
 * Everything static is copied straight out of the source using the character spans
 * the parser recorded, and only the dynamic nodes are replaced. That is what keeps
 * the whitespace intact — a node's own text cannot describe the space that sits
 * <em>between</em> it and its sibling, so {@code $ {{ p.price }}} would otherwise
 * come out as {@code $999}.
 */
public class HtmlEmitter implements Emitter {

    private static final Pattern INTERPOLATION = Pattern.compile("\\{\\{(.+?)}}");
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

        if (node instanceof ExpressionNode expression) { emitExpression(expression, env); return; }
        if (node instanceof BlockNode block)           { emitForBlock(block, env); return; }
        if (node instanceof JinjaStatementNode stmt)   { emitJinjaStatement(stmt, env); return; }
        if (node instanceof AttributeValueNode value)  { emitAttributeValue(value, env); return; }

        List<ASTNode> children = node.getChildren();
        if (children.isEmpty()) {
            emitRaw(node.getStartIndex(), node.getStopIndex() + 1);
            return;
        }
        emitSequence(children, node.getStartIndex(), node.getStopIndex() + 1, env);
    }

    /**
     * Emits children in order, copying the untouched source that lies between them.
     * That gap is where indentation and the space in {@code $ {{ price }}} live.
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

    /** {{ product.name }} */
    private void emitExpression(ExpressionNode expression, Environment env) {
        for (ASTNode child : expression.getChildren()) {
            if (child instanceof MemberAccessNode member) {
                Object value = resolveChain(member.asString(), env);
                out.append(escapeText(Values.display(value)));
                return;
            }
        }
    }

    /** {% for p in products %} ... {% endfor %} */
    private void emitForBlock(BlockNode block, Environment env) {
        int headerEnd = source.indexOf("%}", block.getStartIndex());
        int footerStart = source.lastIndexOf("{%", block.getStopIndex());
        if (headerEnd < 0 || footerStart < 0) {
            log.add("line " + block.getLineNumber() + ": could not locate the bounds of the for block");
            return;
        }
        headerEnd += 2;

        Object collection = resolveChain(block.getCollection(), env);
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

        List<ASTNode> body = block.getChildren();
        for (Object item : items) {
            Environment iteration = env.child();
            iteration.define(block.getIterator(), item);
            emitSequence(body, headerEnd, footerStart, iteration);
        }
    }

    /** {% set x = ... %} and any other directive; produces no output of its own. */
    private void emitJinjaStatement(JinjaStatementNode statement, Environment env) {
        String content = statement.getContent().trim();
        String[] parts = content.split("\\s+");

        if (content.startsWith("set ") && parts.length >= 4 && "=".equals(parts[2])) {
            env.define(parts[1], stripQuotes(parts[3]));
            return;
        }
        log.add("line " + statement.getLineNumber() + ": directive {% " + content + " %} was skipped");
    }

    /**
     * Attribute values arrive with their {{ ... }} unparsed, because the STRING token
     * swallows the braces. They are interpolated here and, for link attributes,
     * rewritten to the generated file name.
     */
    private void emitAttributeValue(AttributeValueNode node, Environment env) {
        String raw = node.getValue();
        String resolved = interpolate(raw, env);

        if (isLinkAttribute(node)) resolved = links.resolve(resolved);

        out.append('"').append(escapeAttribute(resolved)).append('"');
    }

    private boolean isLinkAttribute(AttributeValueNode node) {
        // The attribute name sits immediately before the '=' preceding this value.
        int equals = source.lastIndexOf('=', node.getStartIndex());
        if (equals <= 0) return false;
        int end = equals;
        while (end > 0 && Character.isWhitespace(source.charAt(end - 1))) end--;
        int start = end;
        while (start > 0 && (Character.isLetterOrDigit(source.charAt(start - 1))
                || source.charAt(start - 1) == '-')) start--;
        return LINK_ATTRIBUTES.contains(source.substring(start, end).toLowerCase());
    }

    // ============================================================
    //                       Interpolation
    // ============================================================

    /** Replaces every {{ ... }} inside a plain string. */
    private String interpolate(String text, Environment env) {
        if (text == null || !text.contains("{{")) return text;

        Matcher matcher = INTERPOLATION.matcher(text);
        StringBuilder result = new StringBuilder();
        while (matcher.find()) {
            Object value = evaluateInline(matcher.group(1).trim(), env);
            matcher.appendReplacement(result, Matcher.quoteReplacement(Values.display(value)));
        }
        matcher.appendTail(result);
        return result.toString();
    }

    /**
     * Evaluates the small expression language that appears inside {{ }}:
     * a member chain, or a url_for() call. Anything else is logged and left empty.
     */
    private Object evaluateInline(String expression, Environment env) {
        Matcher urlFor = URL_FOR.matcher(expression);
        if (urlFor.matches()) return evaluateUrlFor(urlFor.group(1));

        Object value = resolveChain(expression, env);
        if (value == null && !env.has(rootOf(expression))) {
            log.add("expression {{ " + expression + " }} could not be resolved");
        }
        return value;
    }

    /**
     * url_for('static', filename='style.css') gives style.css, because the generated
     * pages sit next to their assets; url_for('home') gives that route's page.
     */
    private String evaluateUrlFor(String argumentText) {
        List<String> positional = new ArrayList<>();
        String filename = null;

        Matcher matcher = ARGUMENT.matcher(argumentText);
        while (matcher.find()) {
            String keyword = matcher.group(1);
            String value = matcher.group(2);
            if (keyword == null) positional.add(value);
            else if ("filename".equals(keyword)) filename = value;
        }

        String endpoint = positional.isEmpty() ? "" : positional.get(0);
        if ("static".equals(endpoint)) return (filename != null) ? filename : "";

        String page = links.resolveEndpoint(endpoint);
        if (page != null) return page;

        log.add("url_for('" + endpoint + "') has no generated page; left as a path");
        return "/" + endpoint;
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

    private String rootOf(String chain) {
        return (chain == null) ? "" : chain.trim().split("\\.")[0];
    }

    private String stripQuotes(String text) {
        if (text.length() >= 2
                && (text.charAt(0) == '"' || text.charAt(0) == '\'')
                && text.charAt(0) == text.charAt(text.length() - 1)) {
            return text.substring(1, text.length() - 1);
        }
        return text;
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
