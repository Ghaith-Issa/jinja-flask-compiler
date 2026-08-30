package ASTJinja2withHTMLandCSS.Jinja2;

import ASTJinja2withHTMLandCSS.ASTNode;
import java.util.ArrayList;
import java.util.List;

public class IfBlockNode extends ASTNode {
    private final JinjaExprNode condition;
    private final List<ASTNode> thenBody = new ArrayList<>();
    private final List<ASTNode> elseBody = new ArrayList<>();

    public IfBlockNode(int line, JinjaExprNode condition) {
        super("IfBlock", line);
        this.condition = condition;
    }

    public JinjaExprNode getCondition() {
        return condition;
    }

    public List<ASTNode> getThenBody() {
        return thenBody;
    }

    public List<ASTNode> getElseBody() {
        return elseBody;
    }

    public void addThen(ASTNode node) {
        if (node != null) thenBody.add(node);
    }

    public void addElse(ASTNode node) {
        if (node != null) elseBody.add(node);
    }

    @Override
    public List<ASTNode> getChildren() {
        List<ASTNode> children = new ArrayList<>();
        if (condition != null) children.add(condition);
        children.addAll(thenBody);
        children.addAll(elseBody);
        return children;
    }

    @Override
    protected String getNodeValue() {
        return " if " + (condition != null ? condition.asString() : "");
    }

    @Override
    public void print(String indent) {
        System.out.println(header(indent) + " if " + (condition != null ? condition.asString() : ""));
        for (var c : thenBody) c.print(indent + "  ");
        if (!elseBody.isEmpty()) {
            System.out.println(indent + "  else");
            for (var c : elseBody) c.print(indent + "    ");
        }
    }
}
