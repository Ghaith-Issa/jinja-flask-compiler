package ASTJinja2withHTMLandCSS.Jinja2;
import ASTJinja2withHTMLandCSS.ASTNode;
import java.util.*;

public class BlockNode extends ASTNode {
    private final String iterator;
    private final String collection;
    private final List<ASTNode> content = new ArrayList<>();

    public BlockNode(int line, String iterator, String collection) {
        super("ForBlock", line);
        this.iterator = iterator;
        this.collection = collection;
    }
    @Override
    public List<ASTNode> getChildren() {
        return new ArrayList<>(content);
    }

    @Override
    protected String getNodeValue() {
        return " for " + iterator + " in " + collection;
    }

    public void addContent(ASTNode node) { content.add(node); }

    /** Loop variable bound inside the block, e.g. the {@code p} of {% for p in products %}. */
    public String getIterator() { return iterator; }

    /** Expression being iterated, e.g. the {@code products} of {% for p in products %}. */
    public String getCollection() { return collection; }

    @Override
    public void print(String indent) {
        System.out.println(header(indent) + " for " + iterator + " in " + collection);
        for (var c : content) c.print(indent + "  ");
    }

}

