package ASTJinja2withHTMLandCSS.Jinja2;

import ASTJinja2withHTMLandCSS.ASTNode;
import java.util.ArrayList;
import java.util.List;

public class DocumentNode extends ASTNode {
    private DoctypeNode doctype;
    private final List<ASTNode> elements = new ArrayList<>();

    public DocumentNode(int line) {
        super("Document", line);
    }

    public void setDoctype(DoctypeNode d) {
        this.doctype = d;
    }

    public DoctypeNode getDoctype() {
        return doctype;
    }

    public void addElement(ASTNode e) {
        if (e != null) {
            elements.add(e);
        }
    }

    public List<ASTNode> getElements() {
        return elements;
    }

    @Override
    public List<ASTNode> getChildren() {
        List<ASTNode> children = new ArrayList<>();
        if (this.doctype != null) children.add(doctype);
        children.addAll(elements);
        return children;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + nodeName);
        if (doctype != null) doctype.print(indent + "  ");
        for (var e : elements) e.print(indent + "  ");
    }
}
