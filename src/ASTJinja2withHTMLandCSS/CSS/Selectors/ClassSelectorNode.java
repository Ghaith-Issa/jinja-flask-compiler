package ASTJinja2withHTMLandCSS.CSS.Selectors;

import ASTJinja2withHTMLandCSS.ASTNode;
import ASTJinja2withHTMLandCSS.CSS.CSSSelectorNode;

import java.util.ArrayList;
import java.util.List;
public class ClassSelectorNode extends CSSSelectorNode {

    private final CSSNameNode className;

    public ClassSelectorNode(int line, CSSNameNode className) {
        super("ClassSelector", line);
        this.className = className;
    }
    @Override
    public List<ASTNode> getChildren() {
        List<ASTNode> children = new ArrayList<>();
        if (className != null) children.add(className);
        return children;
    }

    @Override
    protected String getNodeValue() {
        return ".";
    }

    @Override
    public void print(String indent) {
        System.out.println(header(indent));
        System.out.println(indent + "  .");
        className.print(indent + "    ");
    }
}
