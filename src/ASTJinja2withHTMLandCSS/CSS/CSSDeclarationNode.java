package ASTJinja2withHTMLandCSS.CSS;
import ASTJinja2withHTMLandCSS.ASTNode;

import java.util.ArrayList;
import java.util.List;
public class CSSDeclarationNode extends ASTNode {

    private final CSSPropertyNameNode property;
    private final CSSValueNode value;

    public CSSDeclarationNode(int line, CSSPropertyNameNode property, CSSValueNode value) {
        super("CSSDeclaration", line);
        this.property = property;
        this.value = value;
    }
    @Override
    public List<ASTNode> getChildren() {
        List<ASTNode> children = new ArrayList<>();
        if (property != null) children.add(property);
        if (value != null) children.add(value);
        return children;
    }

    @Override
    public void print(String indent) {
        System.out.println(header(indent));
        property.print(indent + "  ");
        value.print(indent + "  ");
    }
}
