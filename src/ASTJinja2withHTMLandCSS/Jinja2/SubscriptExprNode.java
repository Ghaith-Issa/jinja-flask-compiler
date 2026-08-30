package ASTJinja2withHTMLandCSS.Jinja2;

import ASTJinja2withHTMLandCSS.ASTNode;
import java.util.ArrayList;
import java.util.List;

public class SubscriptExprNode extends JinjaExprNode {
    private final JinjaExprNode target;
    private final JinjaExprNode index;

    public SubscriptExprNode(int line, JinjaExprNode target, JinjaExprNode index) {
        super("SubscriptExpr", line);
        this.target = target;
        this.index = index;
    }

    public JinjaExprNode getTarget() {
        return target;
    }

    public JinjaExprNode getIndex() {
        return index;
    }

    @Override
    public String asString() {
        return (target != null ? target.asString() : "") + "[" + (index != null ? index.asString() : "") + "]";
    }

    @Override
    public List<ASTNode> getChildren() {
        List<ASTNode> children = new ArrayList<>();
        if (target != null) children.add(target);
        if (index != null) children.add(index);
        return children;
    }

    @Override
    public void print(String indent) {
        System.out.println(header(indent) + " []");
        if (target != null) target.print(indent + "  ");
        if (index != null) index.print(indent + "  ");
    }
}
