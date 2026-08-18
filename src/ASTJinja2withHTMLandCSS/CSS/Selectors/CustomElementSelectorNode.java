package ASTJinja2withHTMLandCSS.CSS.Selectors;

import ASTJinja2withHTMLandCSS.ASTNode;
import ASTJinja2withHTMLandCSS.CSS.CSSSelectorNode;

import java.util.List;
public class CustomElementSelectorNode extends CSSSelectorNode {

    private final String name;

    public CustomElementSelectorNode(int line, String name) {
        super("CustomElementSelector", line);
        this.name = name;
    }
    @Override
    public List<ASTNode> getChildren() {
        return List.of();
    }
    @Override
    protected String getNodeValue() {
        return "<" + name + ">";
    }
    @Override
    public void print(String indent) {
        System.out.println(header(indent) + " <" + name + ">");
    }
}
