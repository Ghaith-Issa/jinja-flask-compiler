package ASTJinja2withHTMLandCSS.CSS;

import ASTJinja2withHTMLandCSS.ASTNode;
import ASTJinja2withHTMLandCSS.CSS.Selectors.SelectorListNode;
import java.util.ArrayList;
import java.util.List;

public class CSSRuleNode extends ASTNode {
    private final SelectorListNode selectors;
    private final List<CSSDeclarationNode> declarations = new ArrayList<>();

    public CSSRuleNode(int line, SelectorListNode selectors) {
        super("CSSRule", line);
        this.selectors = selectors;
    }

    public SelectorListNode getSelectors() {
        return selectors;
    }

    public List<CSSDeclarationNode> getDeclarations() {
        return declarations;
    }

    public void addDeclaration(CSSDeclarationNode d) {
        if (d != null) {
            declarations.add(d);
        }
    }

    @Override
    public List<ASTNode> getChildren() {
        List<ASTNode> children = new ArrayList<>();
        if (selectors != null) {
            children.add(selectors);
        }
        children.addAll(declarations);
        return children;
    }

    @Override
    public void print(String indent) {
        System.out.println(header(indent));
        if (selectors != null) selectors.print(indent + "  ");
        for (var d : declarations) d.print(indent + "  ");
    }
}
