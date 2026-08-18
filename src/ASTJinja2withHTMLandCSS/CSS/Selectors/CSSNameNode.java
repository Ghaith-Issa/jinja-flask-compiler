package ASTJinja2withHTMLandCSS.CSS.Selectors;
import ASTJinja2withHTMLandCSS.ASTNode;

import java.util.List;
public class CSSNameNode extends ASTNode {

    private final String name;

    public CSSNameNode(int line, String name) {
        super("CSSName", line);
        this.name = name;
    }
    @Override
    public List<ASTNode> getChildren() {
        return List.of();
    }
    @Override
    protected String getNodeValue() {
        return name;
    }

    public String getName() { return name; }

    @Override
    public void print(String indent) {
        System.out.println(indent + getClass().getSimpleName()
                + "(" + name + ") [line " + lineNumber + "]");
    }
}
