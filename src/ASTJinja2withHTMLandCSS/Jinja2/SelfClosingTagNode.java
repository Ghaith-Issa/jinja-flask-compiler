package ASTJinja2withHTMLandCSS.Jinja2;
import ASTJinja2withHTMLandCSS.ASTNode;

import java.util.*;

public class SelfClosingTagNode extends HTMLElementNode {
    private final VoidTagNameNode tagName;
    private final List<AttributeNode> attributes = new ArrayList<>();

    public SelfClosingTagNode(int line, VoidTagNameNode tagName) {
        super("SelfClosingTag", line);
        this.tagName = tagName;
    }
    @Override
    public List<ASTNode> getChildren() {
        List<ASTNode> children= new ArrayList<>();
        if (tagName != null)children.add(tagName);
        children.addAll( attributes);
        return children;
    }

    @Override
    protected String getNodeValue() {
        return " <" + tagName.getName() + " />";
    }

    public void addAttribute(AttributeNode a) { attributes.add(a); }

    @Override
    public void print(String indent) {
        String tagClass = tagName.getClass().getSimpleName();
        System.out.println(header(indent) + " <" + tagName.getName() + " />  [" + tagClass + "]");
        for (var a : attributes) a.print(indent + "  ");
    }

}

