package ASTJinja2withHTMLandCSS.Jinja2;
import ASTJinja2withHTMLandCSS.ASTNode;

import java.util.ArrayList;
import java.util.List;

public class ExpressionNode extends ASTNode {
    private final MemberAccessNode member;

    public ExpressionNode(int line, MemberAccessNode member) {
        super("Expression", line);
        this.member = member;
    }
    @Override
    public List<ASTNode> getChildren() {
        List<ASTNode> children= new ArrayList<>();
        if (member != null) children.add(member);
        return children;
    }

    @Override
    public void print(String indent) {
        System.out.println(header(indent));
        member.print(indent + "  ");
    }

}
