package ASTJinja2withHTMLandCSS.Jinja2;

import ASTJinja2withHTMLandCSS.ASTNode;
import java.util.ArrayList;
import java.util.List;

public class BinaryExprNode extends JinjaExprNode {
    private final JinjaExprNode left;
    private final String op;
    private final JinjaExprNode right;

    public BinaryExprNode(int line, JinjaExprNode left, String op, JinjaExprNode right) {
        super("BinaryExpr", line);
        this.left = left;
        this.op = op;
        this.right = right;
    }

    public JinjaExprNode getLeft() {
        return left;
    }

    public String getOp() {
        return op;
    }

    public JinjaExprNode getRight() {
        return right;
    }

    @Override
    public String asString() {
        return (left != null ? left.asString() : "") + " " + op + " " + (right != null ? right.asString() : "");
    }

    @Override
    public List<ASTNode> getChildren() {
        List<ASTNode> children = new ArrayList<>();
        if (left != null) children.add(left);
        if (right != null) children.add(right);
        return children;
    }

    @Override
    public void print(String indent) {
        System.out.println(header(indent) + " " + op);
        if (left != null) left.print(indent + "  ");
        if (right != null) right.print(indent + "  ");
    }
}
