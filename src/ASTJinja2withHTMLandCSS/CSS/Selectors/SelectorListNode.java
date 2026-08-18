package ASTJinja2withHTMLandCSS.CSS.Selectors;

import ASTJinja2withHTMLandCSS.ASTNode;

import java.util.ArrayList;
import java.util.List;

public class SelectorListNode extends ASTNode {

    private final List<SelectorChainNode> selectors = new ArrayList<>();

    public SelectorListNode(int line) {
        super("SelectorList", line);
    }

    public void addSelector(SelectorChainNode s) {
        selectors.add(s);
    }
    @Override
    public List<ASTNode> getChildren() {
        return new ArrayList<>(selectors);
    }

    @Override
    public void print(String indent) {
        System.out.println(header(indent));
        for (var s : selectors) s.print(indent + "  ");
    }
}
