package ASTJinja2withHTMLandCSS.Jinja2;

import ASTJinja2withHTMLandCSS.ASTNode;
import java.util.ArrayList;
import java.util.List;

public class JinjaExpressionNode extends ASTNode {
    private final JinjaExprNode expr;

    public JinjaExpressionNode(int line, JinjaExprNode expr) {
        super("JinjaExpression", line);
        this.expr = expr;
    }

    public JinjaExprNode getExpr() {
        return expr;
    }

    @Override
    public List<ASTNode> getChildren() {
        return (expr != null) ? List.of(expr) : List.of();
    }

    @Override
    protected String getNodeValue() {
        return expr != null ? expr.asString() : "";
    }

    @Override
    public void print(String indent) {
        System.out.println(header(indent) + " {{ " + (expr != null ? expr.asString() : "") + " }}");
        if (expr != null) expr.print(indent + "  ");
    }
}
