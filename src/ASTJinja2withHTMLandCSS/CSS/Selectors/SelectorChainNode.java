package ASTJinja2withHTMLandCSS.CSS.Selectors;

import ASTJinja2withHTMLandCSS.ASTNode;
import ASTJinja2withHTMLandCSS.CSS.*;

import java.util.ArrayList;
import java.util.List;

public class SelectorChainNode extends CSSSelectorNode {
    private final List<CSSSelectorNode> parts = new ArrayList<>();
    private PseudoClassNode pseudo;

    public SelectorChainNode(int line) {
        super("SelectorChain", line);
    }

    public void addPart(CSSSelectorNode s) {
        parts.add(s);
    }

    public void setPseudo(PseudoClassNode p) {
        this.pseudo = p;
    }
    @Override
    public List<ASTNode> getChildren() {
        List<ASTNode> children = new ArrayList<>(parts);
        if (pseudo != null) {
            children.add(pseudo);
        }
        return children;
    }
    @Override
    public void print(String indent) {
        System.out.println(header(indent));
        for (var p : parts) p.print(indent + "  ");
        if (pseudo != null) pseudo.print(indent + "  ");
    }
}
