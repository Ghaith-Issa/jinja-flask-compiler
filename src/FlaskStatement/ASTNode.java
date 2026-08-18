package FlaskStatement;

import SymbolsTable.Scope;

import java.util.List;

public abstract class ASTNode {
    public final int line;

    /**
     * Scope this node was written in, stamped by the AST builder.
     * The semantic analyzer needs it to resolve a name the way Python would at that
     * exact point; without it the analyzer would have to re-derive the scope tree
     * and keep its own counters in sync with the builder's.
     */
    private Scope scope;

    protected ASTNode(int line) {
        this.line = line;
    }

    public Scope getScope()           { return scope; }
    public void setScope(Scope scope) { this.scope = scope; }

    public abstract List<ASTNode> getChildren();
}
