package ASTJinja2withHTMLandCSS;

import java.util.List;

public class ProgramNode extends ASTNode {
    private final ASTNode root;

    /** Raw source of the file this tree came from; used by the generator. */
    private String sourceText;
    private String sourcePath;

    public ProgramNode(int line, ASTNode root) {
        super("Program", line);
        this.root = root;
    }

    public ASTNode getRoot() { return root; }

    public String getSourceText() { return sourceText; }
    public String getSourcePath() { return sourcePath; }

    public void setSource(String path, String text) {
        this.sourcePath = path;
        this.sourceText = text;
    }
    @Override
    public List<ASTNode> getChildren() {
        return (root != null) ? List.of(root) : List.of();
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + nodeName);
        if (root != null) root.print(indent + "  ");
    }
}

