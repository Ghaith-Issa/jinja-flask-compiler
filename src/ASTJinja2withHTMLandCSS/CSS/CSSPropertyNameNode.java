package ASTJinja2withHTMLandCSS.CSS;

import ASTJinja2withHTMLandCSS.ASTNode;

import java.util.List;

public class CSSPropertyNameNode extends ASTNode {
    private final String name;

    public CSSPropertyNameNode(int line, String name) {
        super("CSSProperty", line);
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
        String cls = getClass().getSimpleName();
        System.out.println(indent + cls + "(" + name + ") [line " + lineNumber + "]");
    }
}
