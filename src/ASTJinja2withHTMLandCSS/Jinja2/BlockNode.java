package ASTJinja2withHTMLandCSS.Jinja2;

public class BlockNode extends ForBlockNode {
    public BlockNode(int line, String iterator, String collection) {
        super(line, iterator, collection);
    }

    public BlockNode(int line, String iterator, JinjaExprNode collectionExpr) {
        super(line, iterator, collectionExpr);
    }
}
