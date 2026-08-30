package ASTJinja2withHTMLandCSS.Jinja2;

import ASTJinja2withHTMLandCSS.ASTNode;
import java.util.ArrayList;
import java.util.List;

public class AttributeNode extends ASTNode {
    private final String name;
    private final List<ASTNode> valueParts = new ArrayList<>();

    public AttributeNode(int line, String name) {
        super("Attribute", line);
        this.name = name;
    }

    public AttributeNode(int line, String name, List<ASTNode> valueParts) {
        super("Attribute", line);
        this.name = name;
        if (valueParts != null) {
            this.valueParts.addAll(valueParts);
        }
    }

    public String getName() {
        return name;
    }

    public List<ASTNode> getValueParts() {
        return valueParts;
    }

    public void addValuePart(ASTNode part) {
        if (part != null) {
            valueParts.add(part);
        }
    }

    public String getValue() {
        if (valueParts.isEmpty()) return null;
        StringBuilder sb = new StringBuilder();
        for (ASTNode part : valueParts) {
            if (part instanceof AttrTextNode textNode) {
                sb.append(textNode.getText());
            } else if (part instanceof JinjaExpressionNode exprNode) {
                sb.append("{{ ").append(exprNode.getNodeValue()).append(" }}");
            } else if (part != null) {
                sb.append(part.nodeValue());
            }
        }
        return sb.toString();
    }

    @Override
    public List<ASTNode> getChildren() {
        return new ArrayList<>(valueParts);
    }

    @Override
    protected String getNodeValue() {
        return name;
    }

    @Override
    public void print(String indent) {
        System.out.println(header(indent) + " " + name + (valueParts.isEmpty() ? "" : "=\"" + getValue() + "\""));
        for (var part : valueParts) {
            part.print(indent + "  ");
        }
    }
}
