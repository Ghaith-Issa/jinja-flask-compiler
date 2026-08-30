package ASTJinja2withHTMLandCSS.Jinja2;

import ASTJinja2withHTMLandCSS.ASTNode;
import java.util.ArrayList;
import java.util.List;

public class UnaryExprNode extends JinjaExprNode {
    private final String op;
    private final JinjaExprNode operand;

    public UnaryExprNode(int line, String op, JinjaExprNode operand) {
        super("UnaryExpr", line);
        this.op = op;
        this.operand = operand;
    }

    public String getOp() {
        return op;
    }

    public JinjaExprNode getOperand() {
        return operand;
    }

    @Override
    public String asString() {
        return op + " " + (operand != null ? operand.asString() : "");
    }

    @Override
    public List<ASTNode> getChildren() {
        return operand != null ? List.of(operand) : List.of();
    }

    @Override
    public void print(String indent) {
        System.out.println(header(indent) + " " + op);
        if (operand != null) operand.print(indent + "  ");
    }
}
