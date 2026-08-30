package ASTJinja2withHTMLandCSS.CSS;

import ASTJinja2withHTMLandCSS.ASTNode;
import java.util.ArrayList;
import java.util.List;

public class CSSProgNode extends ASTNode {
    private final List<CSSRuleNode> rules = new ArrayList<>();

    public CSSProgNode(int line) {
        super("CSSProg", line);
    }

    public void addRule(CSSRuleNode rule) {
        if (rule != null) {
            rules.add(rule);
        }
    }

    public List<CSSRuleNode> getRules() {
        return rules;
    }

    @Override
    public List<ASTNode> getChildren() {
        return new ArrayList<>(rules);
    }

    @Override
    public void print(String indent) {
        System.out.println(header(indent));
        for (var r : rules) r.print(indent + "  ");
    }
}
