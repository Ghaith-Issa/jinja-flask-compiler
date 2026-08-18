package ASTJinja2withHTMLandCSS.Jinja2;

import ASTJinja2withHTMLandCSS.ASTNode;

import java.util.List;

public class JinjaStatementNode extends ASTNode {
    private String content;

    public JinjaStatementNode(int line, String content) {
        super("JinjaStatement",line);
        this.content = content;
    }

    public String getContent() { return content; }

    @Override
    public List<ASTNode> getChildren() {
        return List.of();
    }
    @Override
    protected String getNodeValue() {
        return content;
    }
    @Override
    public void print(String indent) {
        System.out.println(header(indent) + content);
    }
}