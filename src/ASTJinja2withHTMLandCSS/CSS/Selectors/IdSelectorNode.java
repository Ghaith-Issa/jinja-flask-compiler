package ASTJinja2withHTMLandCSS.CSS.Selectors;

import ASTJinja2withHTMLandCSS.ASTNode;
import ASTJinja2withHTMLandCSS.CSS.CSSSelectorNode;

import java.util.List;

public class IdSelectorNode extends CSSSelectorNode {

    private final String id;

    public IdSelectorNode(int line, String id) {
        super("IdSelector", line);
        this.id = id;
    }
    @Override
    public List<ASTNode> getChildren() {
        return List.of();
    }
    @Override
    protected String getNodeValue() {
        return " #" + id;
    }

    @Override
    public void print(String indent) {
        System.out.println(header(indent) + " #" + id);
    }
}
