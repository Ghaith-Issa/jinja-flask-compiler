package ASTJinja2withHTMLandCSS.CSS.Selectors;
import ASTJinja2withHTMLandCSS.ASTNode;
import ASTJinja2withHTMLandCSS.CSS.CSSSelectorNode;

import java.util.ArrayList;
import java.util.List;
public class ElementSelectorNode extends CSSSelectorNode {

    private final CSSNameNode name;

    public ElementSelectorNode(int line, CSSNameNode name) {
        super("ElementSelector", line);
        this.name = name;
    }
    @Override
    public List<ASTNode> getChildren() {
        List<ASTNode> children = new ArrayList<>();
        if (name != null) children.add(name);
        return children;
    }
    @Override
    public void print(String indent) {
        System.out.println(header(indent));
        name.print(indent + "  ");
    }
}
