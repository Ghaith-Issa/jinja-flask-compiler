package ASTJinja2withHTMLandCSS.Jinja2;
import ASTJinja2withHTMLandCSS.ASTNode;
import java.util.*;

public class MemberAccessNode extends ASTNode {
    private final List<String> chain = new ArrayList<>();

    public MemberAccessNode(int line) {
        super("MemberAccess", line);
    }

    public void addPart(String part) { chain.add(part); }
    @Override
    public List<ASTNode> getChildren() {
        return List.of();
    }
    @Override
    protected String getNodeValue() {
        return String.join(".", chain);
    }

    @Override
    public void print(String indent) {
        System.out.println(header(indent) + " " + String.join(".", chain));
    }

    public String asString() {
        return String.join(".", chain);
    }

}

