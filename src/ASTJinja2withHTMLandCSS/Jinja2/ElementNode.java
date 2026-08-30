package ASTJinja2withHTMLandCSS.Jinja2;

import ASTJinja2withHTMLandCSS.ASTNode;
import java.util.ArrayList;
import java.util.List;

public class ElementNode extends ASTNode {
    private final String tagName;
    private String endTagName;
    private final boolean selfClosing;
    private final List<AttributeNode> attributes = new ArrayList<>();
    private final List<ASTNode> content = new ArrayList<>();

    public ElementNode(int line, String tagName, boolean selfClosing) {
        super("Element", line);
        this.tagName = tagName;
        this.selfClosing = selfClosing;
    }

    public ElementNode(int line, String tagName, String endTagName) {
        super("Element", line);
        this.tagName = tagName;
        this.endTagName = endTagName;
        this.selfClosing = false;
    }

    public String getTagName() {
        return tagName;
    }

    public String getEndTagName() {
        return endTagName;
    }

    public void setEndTagName(String endTagName) {
        this.endTagName = endTagName;
    }

    public boolean isSelfClosing() {
        return selfClosing;
    }

    public List<AttributeNode> getAttributes() {
        return attributes;
    }

    public void addAttribute(AttributeNode attr) {
        if (attr != null) {
            attributes.add(attr);
        }
    }

    public boolean hasAttribute(String attrName) {
        if (attrName == null) return false;
        for (AttributeNode attr : attributes) {
            if (attrName.equalsIgnoreCase(attr.getName())) return true;
        }
        return false;
    }

    public String getAttributeValue(String attrName) {
        if (attrName == null) return null;
        for (AttributeNode attr : attributes) {
            if (attrName.equalsIgnoreCase(attr.getName())) return attr.getValue();
        }
        return null;
    }

    public AttributeNode getAttribute(String attrName) {
        if (attrName == null) return null;
        for (AttributeNode attr : attributes) {
            if (attrName.equalsIgnoreCase(attr.getName())) return attr;
        }
        return null;
    }

    public List<ASTNode> getContent() {
        return content;
    }

    public void addContent(ASTNode child) {
        if (child != null) {
            content.add(child);
        }
    }

    @Override
    public List<ASTNode> getChildren() {
        List<ASTNode> children = new ArrayList<>();
        children.addAll(attributes);
        children.addAll(content);
        return children;
    }

    @Override
    protected String getNodeValue() {
        return "<" + tagName + (selfClosing ? " />" : ">");
    }

    @Override
    public void print(String indent) {
        System.out.println(header(indent) + " <" + tagName + (selfClosing ? " />" : ">"));
        for (var a : attributes) a.print(indent + "  ");
        for (var c : content) c.print(indent + "  ");
    }
}
