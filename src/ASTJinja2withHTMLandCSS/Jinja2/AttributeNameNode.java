package ASTJinja2withHTMLandCSS.Jinja2;

import ASTJinja2withHTMLandCSS.ASTNode;

import java.util.List;

public class AttributeNameNode extends ASTNode {
    private final String name;

    public AttributeNameNode(int line, String name) {
        super("AttributeName", line);
        this.name = name;
    }

    public String getName() { return name; }

    @Override
    public List<ASTNode> getChildren() {
        return List.of();
    }
    @Override
    protected String getNodeValue() {
        return name;
    }
    @Override
    public void print(String indent) {
        String cls = getClass().getSimpleName();
        System.out.println(indent + cls + "(" + name + ") [line " + lineNumber + "]");
    }

}
