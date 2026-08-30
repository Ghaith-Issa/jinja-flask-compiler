package ASTJinja2withHTMLandCSS.Jinja2;

import ASTJinja2withHTMLandCSS.ASTNode;
import java.util.List;

public class SetNode extends ASTNode {
    private final String varName;
    private final JinjaExprNode value;

    public SetNode(int line, String varName, JinjaExprNode value) {
        super("Set", line);
        this.varName = varName;
        this.value = value;
    }

    public String getVarName() {
        return varName;
    }

    public JinjaExprNode getValue() {
        return value;
    }

    @Override
    public List<ASTNode> getChildren() {
        return value != null ? List.of(value) : List.of();
    }

    @Override
    protected String getNodeValue() {
        return "set " + varName + " = " + (value != null ? value.asString() : "");
    }

    @Override
    public void print(String indent) {
        System.out.println(header(indent) + " set " + varName + " = " + (value != null ? value.asString() : ""));
    }
}
