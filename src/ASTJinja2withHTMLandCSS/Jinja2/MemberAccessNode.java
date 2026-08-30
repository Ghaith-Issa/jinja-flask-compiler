package ASTJinja2withHTMLandCSS.Jinja2;

import ASTJinja2withHTMLandCSS.ASTNode;
import java.util.ArrayList;
import java.util.List;

public class MemberAccessNode extends JinjaExprNode {
    private final List<String> chain = new ArrayList<>();

    public MemberAccessNode(int line) {
        super("MemberAccess", line);
    }

    public MemberAccessNode(int line, List<String> chain) {
        super("MemberAccess", line);
        this.chain.addAll(chain);
    }

    public void addPart(String part) {
        chain.add(part);
    }

    public List<String> getChain() {
        return chain;
    }

    public String getRoot() {
        return chain.isEmpty() ? "" : chain.get(0);
    }

    @Override
    public List<ASTNode> getChildren() {
        return List.of();
    }

    @Override
    protected String getNodeValue() {
        return asString();
    }

    @Override
    public String asString() {
        return String.join(".", chain);
    }

    @Override
    public void print(String indent) {
        System.out.println(header(indent) + " " + asString());
    }
}
