package ASTJinja2withHTMLandCSS.Jinja2;

import ASTJinja2withHTMLandCSS.ASTNode;
import java.util.ArrayList;
import java.util.List;

public class FilterExprNode extends JinjaExprNode {
    private final JinjaExprNode target;
    private final String filterName;
    private final List<JinjaExprNode> args = new ArrayList<>();

    public FilterExprNode(int line, JinjaExprNode target, String filterName, List<JinjaExprNode> args) {
        super("FilterExpr", line);
        this.target = target;
        this.filterName = filterName;
        if (args != null) {
            this.args.addAll(args);
        }
    }

    public JinjaExprNode getTarget() {
        return target;
    }

    public String getFilterName() {
        return filterName;
    }

    public List<JinjaExprNode> getArgs() {
        return args;
    }

    @Override
    public String asString() {
        StringBuilder sb = new StringBuilder();
        sb.append(target != null ? target.asString() : "").append("|").append(filterName);
        if (!args.isEmpty()) {
            sb.append("(");
            for (int i = 0; i < args.size(); i++) {
                if (i > 0) sb.append(", ");
                sb.append(args.get(i).asString());
            }
            sb.append(")");
        }
        return sb.toString();
    }

    @Override
    public List<ASTNode> getChildren() {
        List<ASTNode> children = new ArrayList<>();
        if (target != null) children.add(target);
        children.addAll(args);
        return children;
    }

    @Override
    public void print(String indent) {
        System.out.println(header(indent) + " | " + filterName);
        if (target != null) target.print(indent + "  ");
        for (var a : args) a.print(indent + "  ");
    }
}
