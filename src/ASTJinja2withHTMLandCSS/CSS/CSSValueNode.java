package ASTJinja2withHTMLandCSS.CSS;

import ASTJinja2withHTMLandCSS.ASTNode;

import java.util.ArrayList;
import java.util.List;

public class CSSValueNode extends ASTNode {

    private final List<CSSValueAtomNode> atoms = new ArrayList<>();

    public CSSValueNode(int line) {
        super("CSSValue", line);
    }

    public void addAtom(CSSValueAtomNode a) {
        atoms.add(a);
    }

    @Override
    public List<ASTNode> getChildren() {
        return new ArrayList<>(atoms);
    }
    @Override
    public void print(String indent) {
        System.out.println(header(indent));
        for (var a : atoms) a.print(indent + "  ");
    }
}
