package ASTJinja2withHTMLandCSS.Jinja2;

import ASTJinja2withHTMLandCSS.ASTNode;
import java.util.ArrayList;
import java.util.List;

public class NamedBlockNode extends ASTNode {
    private final String name;
    private final List<ASTNode> body = new ArrayList<>();

    public NamedBlockNode(int line, String name) {
        super("NamedBlock", line);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<ASTNode> getBody() {
        return body;
    }

    public void addContent(ASTNode node) {
        if (node != null) body.add(node);
    }

    @Override
    public List<ASTNode> getChildren() {
        return new ArrayList<>(body);
    }

    @Override
    protected String getNodeValue() {
        return "block " + name;
    }

    @Override
    public void print(String indent) {
        System.out.println(header(indent) + " block " + name);
        for (var c : body) c.print(indent + "  ");
    }
}
