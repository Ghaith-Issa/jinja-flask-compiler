package ASTJinja2withHTMLandCSS.Jinja2;

import ASTJinja2withHTMLandCSS.ASTNode;
import java.util.List;

public class NameExprNode extends JinjaExprNode {
    private final String name;

    public NameExprNode(int line, String name) {
        super("NameExpr", line);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String asString() {
        return name;
    }

    @Override
    public List<ASTNode> getChildren() {
        return List.of();
    }

    @Override
    public void print(String indent) {
        System.out.println(header(indent) + " " + name);
    }
}
