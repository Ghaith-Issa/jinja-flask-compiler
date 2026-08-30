package ASTJinja2withHTMLandCSS.CSS.Selectors;

import ASTJinja2withHTMLandCSS.ASTNode;
import ASTJinja2withHTMLandCSS.CSS.CSSSelectorNode;

import java.util.List;

public class ClassSelectorNode extends CSSSelectorNode {
    private final String className;

    public ClassSelectorNode(int line, String className) {
        super("ClassSelector", line);
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    @Override
    public List<ASTNode> getChildren() {
        return List.of();
    }

    @Override
    protected String getNodeValue() {
        return "." + className;
    }

    @Override
    public void print(String indent) {
        System.out.println(header(indent) + " ." + className);
    }
}
