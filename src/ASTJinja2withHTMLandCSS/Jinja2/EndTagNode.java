package ASTJinja2withHTMLandCSS.Jinja2;
import ASTJinja2withHTMLandCSS.*;

import java.util.List;

public class EndTagNode extends ASTNode {
    private final TagNameNode tagName;

    public EndTagNode(int line, TagNameNode tagName) {
        super("EndTag", line);
        this.tagName = tagName;
    } @Override
    public List<ASTNode> getChildren() {
        return List.of();
    }
    @Override
    protected String getNodeValue() {
        return "</"+tagName.getName()+">";
    }

    @Override
    public void print(String indent) {
        String tagClass = tagName.getClass().getSimpleName();
        System.out.println(header(indent) + " </" + tagName.getName() + ">  [" + tagClass + "]");
    }

}

