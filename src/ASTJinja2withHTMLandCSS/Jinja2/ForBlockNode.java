package ASTJinja2withHTMLandCSS.Jinja2;

import ASTJinja2withHTMLandCSS.ASTNode;
import java.util.ArrayList;
import java.util.List;

public class ForBlockNode extends ASTNode {
    private final String iterator;
    private final JinjaExprNode collectionExpr;
    private final String collectionString;
    private final List<ASTNode> content = new ArrayList<>();

    public ForBlockNode(int line, String iterator, JinjaExprNode collectionExpr) {
        super("ForBlock", line);
        this.iterator = iterator;
        this.collectionExpr = collectionExpr;
        this.collectionString = collectionExpr != null ? collectionExpr.asString() : "";
    }

    public ForBlockNode(int line, String iterator, String collectionString) {
        super("ForBlock", line);
        this.iterator = iterator;
        this.collectionExpr = new NameExprNode(line, collectionString);
        this.collectionString = collectionString;
    }

    public String getIterator() {
        return iterator;
    }

    public JinjaExprNode getCollectionExpr() {
        return collectionExpr;
    }

    public String getCollection() {
        return collectionString;
    }

    public void addContent(ASTNode node) {
        if (node != null) {
            content.add(node);
        }
    }

    public List<ASTNode> getContent() {
        return content;
    }

    @Override
    public List<ASTNode> getChildren() {
        return new ArrayList<>(content);
    }

    @Override
    protected String getNodeValue() {
        return " for " + iterator + " in " + collectionString;
    }

    @Override
    public void print(String indent) {
        System.out.println(header(indent) + " for " + iterator + " in " + collectionString);
        for (var c : content) c.print(indent + "  ");
    }
}
