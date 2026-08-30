package ASTJinja2withHTMLandCSS.Jinja2;

import ASTJinja2withHTMLandCSS.ASTNode;
import java.util.List;

public class LiteralNode extends JinjaExprNode {
    private final Object value;
    private final String rawText;

    public LiteralNode(int line, Object value, String rawText) {
        super("Literal", line);
        this.value = value;
        this.rawText = rawText;
    }

    public Object getValue() {
        return value;
    }

    public String getRawText() {
        return rawText;
    }

    @Override
    public String asString() {
        return rawText != null ? rawText : String.valueOf(value);
    }

    @Override
    public List<ASTNode> getChildren() {
        return List.of();
    }

    @Override
    public void print(String indent) {
        System.out.println(header(indent) + " " + asString());
    }
}
