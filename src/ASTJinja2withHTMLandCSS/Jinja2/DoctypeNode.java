package ASTJinja2withHTMLandCSS.Jinja2;
import ASTJinja2withHTMLandCSS.*;

import java.util.List;

public class DoctypeNode extends ASTNode {
    public DoctypeNode(int line) {
        super("Doctype", line);
    }
    @Override
    public List<ASTNode> getChildren() {
        return List.of();
    }

    @Override
    protected String getNodeValue() {
        return "<!DOCTYPE html>";
    }

    @Override
    public void print(String indent) {
        System.out.println(header(indent) + " <!DOCTYPE html>");
    }

}

