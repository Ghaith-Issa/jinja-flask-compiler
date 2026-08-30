package report;

import FlaskStatement.*;
import SymbolsTable.Scope;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Serialises both syntax trees to JSON for {@code compiler_output/}.
 * <p>
 * The two trees are unrelated class hierarchies, so each gets its own walk. Node
 * types carry different interesting fields, which is why the writer names them
 * explicitly instead of dumping everything reflectively.
 */
public class AstJsonWriter {

    // ============================================================
    //                       Python AST
    // ============================================================

    public String pythonAst(String fileName, Program program) {
        Json json = new Json();
        json.openObject();
        json.field("file", fileName, true);
        json.field("language", "miniFlask (Python subset)", false);
        json.key("ast", false);
        writePython(json, program);
        json.closeObject();
        return json.build();
    }

    private void writePython(Json json, ASTNode node) {
        if (node == null) {
            json.value(null);
            return;
        }

        json.openObject();
        boolean first = true;

        json.field("type", node.getClass().getSimpleName(), first);
        first = false;
        json.field("line", node.line, false);

        Scope scope = node.getScope();
        if (scope != null) json.field("scope", scope.qualifiedName(), false);

        Map<String, Object> properties = pythonProperties(node);
        json.optionalField("props", properties, false);

        List<ASTNode> children = node.getChildren();
        if (!children.isEmpty()) {
            json.key("children", false);
            json.openArray();
            boolean firstChild = true;
            for (ASTNode child : children) {
                json.separator(firstChild);
                writePython(json, child);
                firstChild = false;
            }
            json.closeArray();
        }

        json.closeObject();
    }

    private Map<String, Object> pythonProperties(ASTNode node) {
        Map<String, Object> props = new java.util.LinkedHashMap<>();

        if (node instanceof Name name) {
            props.put("id", name.id);
        } else if (node instanceof Literal literal) {
            props.put("value", literal.value == null ? null : String.valueOf(literal.value));
            props.put("kind", literalKind(literal));
        } else if (node instanceof BinaryOperation binary) {
            props.put("operator", binary.op.symbol);
        } else if (node instanceof Attribute attribute) {
            props.put("attribute", attribute.attribute);
        } else if (node instanceof FunctionCall call) {
            props.put("callee", String.valueOf(call.called));
            props.put("argCount", call.args.size());
            if (!call.kwargs.isEmpty()) props.put("keywords", new ArrayList<>(call.kwargs.keySet()));
        } else if (node instanceof FunctionDef function) {
            props.put("name", function.getName());
            props.put("parameters", function.getParameters());
        } else if (node instanceof ForStatement loop) {
            props.put("iterator", loop.getIteratorName());
        } else if (node instanceof ImportStatement) {
            props.put("statement", String.valueOf(node));
        } else if (node instanceof Decorator decorator) {
            props.put("expression", String.valueOf(decorator.expr));
        } else if (node instanceof DictExpr dict) {
            props.put("keys", new ArrayList<>(dict.pairs.keySet()));
        } else if (node instanceof ListExpr list) {
            props.put("size", list.expressions == null ? 0 : list.expressions.size());
        } else if (node instanceof ReturnStatement ret) {
            props.put("returnsValue", ret.returnsValue());
        } else if (node instanceof Program program) {
            props.put("statements", program.statements.size());
        }
        return props;
    }

    private String literalKind(Literal literal) {
        if (literal.isString()) return "string";
        if (literal.isNumber()) return "number";
        if (literal.isTrue() || literal.isFalse()) return "bool";
        if (literal.isNone()) return "none";
        return "unknown";
    }

    // ============================================================
    //                        Jinja AST
    // ============================================================

    /** One document per template, so a single file covers the whole templates folder. */
    public String jinjaAst(Map<String, ASTJinja2withHTMLandCSS.ASTNode> templates) {
        Json json = new Json();
        json.openObject();
        json.field("language", "Jinja2 + HTML + CSS", true);
        json.field("templateCount", templates.size(), false);
        json.key("templates", false);
        json.openArray();

        boolean first = true;
        for (Map.Entry<String, ASTJinja2withHTMLandCSS.ASTNode> entry : templates.entrySet()) {
            json.separator(first);
            json.openObject();
            json.field("file", entry.getKey(), true);
            json.key("ast", false);
            writeJinja(json, entry.getValue());
            json.closeObject();
            first = false;
        }

        json.closeArray();
        json.closeObject();
        return json.build();
    }

    private void writeJinja(Json json, ASTJinja2withHTMLandCSS.ASTNode node) {
        if (node == null) {
            json.value(null);
            return;
        }

        json.openObject();
        json.field("type", node.getClass().getSimpleName(), true);
        json.field("line", node.getLineNumber(), false);

        if (node.getStartIndex() >= 0) {
            json.field("span", List.of(node.getStartIndex(), node.getStopIndex()), false);
        }
        json.optionalField("value", node.nodeValue(), false);

        if (node instanceof ASTJinja2withHTMLandCSS.Jinja2.ForBlockNode block) {
            json.field("iterator", block.getIterator(), false);
            json.field("collection", block.getCollection(), false);
        } else if (node instanceof ASTJinja2withHTMLandCSS.Jinja2.AttributeNode attribute) {
            json.field("attribute", attribute.getName(), false);
            json.optionalField("attributeValue", attribute.getValue(), false);
        }

        List<ASTJinja2withHTMLandCSS.ASTNode> children = node.getChildren();
        if (!children.isEmpty()) {
            json.key("children", false);
            json.openArray();
            boolean firstChild = true;
            for (ASTJinja2withHTMLandCSS.ASTNode child : children) {
                if (child == null) continue;
                json.separator(firstChild);
                writeJinja(json, child);
                firstChild = false;
            }
            json.closeArray();
        }

        json.closeObject();
    }
}
