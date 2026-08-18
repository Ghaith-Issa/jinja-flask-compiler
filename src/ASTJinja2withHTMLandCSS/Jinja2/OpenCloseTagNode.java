package ASTJinja2withHTMLandCSS.Jinja2;
import ASTJinja2withHTMLandCSS.ASTNode;
import java.util.*;

public class OpenCloseTagNode extends HTMLElementNode {
    private final StartTagNode start;
    private EndTagNode end;
    private final List<ASTNode> content = new ArrayList<>();

    public OpenCloseTagNode(int line, StartTagNode start) {
        super("OpenCloseTag", line);
        this.start = start;
    }

    public void addContent(ASTNode e) { content.add(e); }
    public void setEndTag(EndTagNode e) { this.end = e; }
    @Override
    public List<ASTNode> getChildren() {
        List<ASTNode> children = new ArrayList<>();
        if (start != null)children.add(start);
        children.addAll(content);
        if (end != null)children.add(end);
        return children;
    }
    @Override
    public void print(String indent) {
        System.out.println(header(indent));
        start.print(indent + "  ");
        for (var c : content) c.print(indent + "  ");
        if (end != null) end.print(indent + "  ");
    }

}

