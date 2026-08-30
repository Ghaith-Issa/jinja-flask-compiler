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

    public CSSDeclarationNode(int line, String propertyName, CSSValueNode value) {
        super("CSSDeclaration", line);
        this.property = new CSSPropertyNameNode(line, propertyName);
        this.value = value;
    }

    public CSSPropertyNameNode getPropertyNode() {
        return property;
    }

    public String getProperty() {
        return property != null ? property.getName() : "";
    }

    public CSSValueNode getValue() {
        return value;
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
        if (property != null) property.print(indent + "  ");
        if (value != null) value.print(indent + "  ");
    }
}
