package ASTJinja2withHTMLandCSS.Jinja2;

import ASTJinja2withHTMLandCSS.ASTNode;
import java.util.ArrayList;
import java.util.List;

public class CallExprNode extends JinjaExprNode {
    public record Arg(String name, JinjaExprNode expr) {}

    private final String callee;
    private final List<Arg> args = new ArrayList<>();

    public CallExprNode(int line, String callee, List<Arg> args) {
        super("CallExpr", line);
        this.callee = callee;
        if (args != null) {
            this.args.addAll(args);
        }
    }

    public String getCallee() {
        return callee;
    }

    public List<Arg> getArgs() {
        return args;
    }

    @Override
    public String asString() {
        StringBuilder sb = new StringBuilder();
        sb.append(callee).append("(");
        for (int i = 0; i < args.size(); i++) {
            if (i > 0) sb.append(", ");
            Arg arg = args.get(i);
            if (arg.name() != null) {
                sb.append(arg.name()).append("=");
            }
            sb.append(arg.expr() != null ? arg.expr().asString() : "");
        }
        sb.append(")");
        return sb.toString();
    }

    @Override
    public List<ASTNode> getChildren() {
        List<ASTNode> children = new ArrayList<>();
        for (Arg arg : args) {
            if (arg.expr() != null) {
                children.add(arg.expr());
            }
        }
        return children;
    }

    @Override
    public void print(String indent) {
        System.out.println(header(indent) + " " + asString());
    }
}
