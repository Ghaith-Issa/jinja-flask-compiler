package ASTJinja2withHTMLandCSS.CSS;
import ASTJinja2withHTMLandCSS.ASTNode;

import java.util.List;
public class PseudoClassNode extends ASTNode {

    private final String name;

    public PseudoClassNode(int line, String name) {
        super("PseudoClass", line);
        this.name = name;
    } @Override
    public List<ASTNode> getChildren() {
        return List.of();
    }
    @Override
    protected String getNodeValue() {
        return ":" + name;
    }

    @Override
    public void print(String indent) {
        System.out.println(header(indent) + " :" + name);
    }
}
