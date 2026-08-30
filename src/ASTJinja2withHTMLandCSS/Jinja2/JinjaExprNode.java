package ASTJinja2withHTMLandCSS.Jinja2;

import ASTJinja2withHTMLandCSS.ASTNode;
import java.util.ArrayList;
import java.util.List;

public abstract class JinjaExprNode extends ASTNode {
    public JinjaExprNode(String nodeName, int line) {
        super(nodeName, line);
    }

    public abstract String asString();

    @Override
    protected String getNodeValue() {
        return asString();
    }
}
