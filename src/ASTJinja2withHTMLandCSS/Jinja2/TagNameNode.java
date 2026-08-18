package ASTJinja2withHTMLandCSS.Jinja2;
import ASTJinja2withHTMLandCSS.ASTNode;

import java.util.List;
public class TagNameNode extends ASTNode {
    private final String name;

    public TagNameNode(int line, String name) {
        super("TagName", line);
        this.name = name;
    }

    public String getName() { return name; }

    @Override
    public List<ASTNode> getChildren() {
        return List.of();
    }
    @Override
    public void print(String indent) {
        String cls = getClass().getSimpleName();
        System.out.println(indent + cls + "(" + name + ") [line " + lineNumber + "]");
    }

}

