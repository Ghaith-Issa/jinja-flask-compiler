package ASTJinja2withHTMLandCSS;

import java.util.List;
public abstract class ASTNode {
    protected String nodeName;
    protected int lineNumber;

    /**
     * Character offsets of this node in the original source file.
     * The code generator needs them to restore the whitespace that sits
     * *between* sibling nodes, which no single node's own text contains.
     * -1 means "not stamped".
     */
    protected int startIndex = -1;
    protected int stopIndex = -1;

    public ASTNode(String nodeName, int lineNumber) {
        this.nodeName = nodeName;
        this.lineNumber = lineNumber;
    }

    public int getStartIndex() { return startIndex; }
    public int getStopIndex()  { return stopIndex; }
    public int getLineNumber() { return lineNumber; }
    public String getNodeName() { return nodeName; }

    public void setSpan(int start, int stop) {
        this.startIndex = start;
        this.stopIndex = stop;
    }

    protected String header(String indent) {
        return indent + " [line " + lineNumber + "] " + nodeName;
    }

    public abstract List<ASTNode> getChildren();
    public void print(String prefix, boolean isLast, int depth,Boolean detail) {
        if (depth > 0) {
            System.out.print(prefix);
            if (depth == 1) {
                System.out.print("└── ");
            } else {
                System.out.print(isLast ? "└── " : "├── ");
            }
        }
        String value = getNodeValue();
        String displayValue = (detail && value != null && !value.isEmpty()) ? ": " + value : "";

        System.out.println(this.getClass().getSimpleName() + displayValue + " (line " + lineNumber + ")");

        List<ASTNode> children = getChildren();
        for (int i = 0; i < children.size(); i++) {
            ASTNode child = children.get(i);
            if (child == null) continue;

            boolean lastChild = (i == children.size() - 1);

            String nextPrefix;
            if (depth == 0) {
                nextPrefix = "";
            } else if (depth == 1) {
                nextPrefix = prefix + "    ";
            } else {
                nextPrefix = prefix + (isLast ? "    " : "│   ");
            }

            child.print(nextPrefix, lastChild, depth + 1,detail);
        }
    }
    protected String getNodeValue() {
        return null;
    }

    /**
     * Public view of {@link #getNodeValue()}. Subclasses override the protected form,
     * so exposing it here avoids widening every override just to serialise the tree.
     */
    public final String nodeValue() {
        return getNodeValue();
    }

    public abstract void print(String indent);
}
