package ASTJinja2withHTMLandCSS.Jinja2;
import ASTJinja2withHTMLandCSS.ASTNode;

import java.util.List;

public class StatementNode extends ASTNode {
    private final String text;

    public StatementNode(int line, String text) {
        super("Statement", line);
        this.text = text;
    }

    public String getText() { return text; }

    @Override
    public List<ASTNode> getChildren() {
        return List.of();
    }
    @Override
    protected String getNodeValue() {
        return text;
    }

    @Override
    public void print(String indent) {
        System.out.println(header(indent) + " \"" + text + "\"");
    }

}

