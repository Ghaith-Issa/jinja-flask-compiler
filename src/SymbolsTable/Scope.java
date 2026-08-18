package SymbolsTable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * A lexical scope and its children, forming the tree the semantic analyzer walks.
 * <p>
 * Name resolution follows the parent chain, which is what makes SCOPE_ERROR
 * distinguishable from UNDEFINED_VARIABLE: a name that resolves nowhere is
 * undefined, whereas a name that exists in some other branch of the tree but not
 * on the path to the root is a scope violation.
 */
public final class Scope {

    private final String name;
    private final Scope parent;
    private final Map<String, Symbol> symbols = new LinkedHashMap<>();
    private final List<Scope> children = new ArrayList<>();

    /** Scope is not designed for subclassing; the constructor links it to its parent. */
    public Scope(String name, Scope parent) {
        this.name = name;
        this.parent = parent;
        if (parent != null) parent.children.add(this);
    }

    public String getName()            { return name; }
    public Scope getParent()           { return parent; }
    public List<Scope> getChildren()   { return children; }
    public Collection<Symbol> getSymbols() { return symbols.values(); }

    public void define(Symbol symbol) {
        symbols.put(symbol.getName(), symbol);
    }

    /** Looks in this scope only. */
    public Symbol resolveLocal(String name) {
        return symbols.get(name);
    }

    /** Looks in this scope, then walks up to the root. */
    public Symbol resolve(String name) {
        for (Scope s = this; s != null; s = s.parent) {
            Symbol found = s.symbols.get(name);
            if (found != null) return found;
        }
        return null;
    }

    /**
     * Searches this scope and everything below it. Used to tell an out-of-scope
     * name apart from one that was never declared at all.
     */
    public Symbol findAnywhere(String name) {
        Symbol local = symbols.get(name);
        if (local != null) return local;
        for (Scope child : children) {
            Symbol found = child.findAnywhere(name);
            if (found != null) return found;
        }
        return null;
    }

    /** Root of the tree this scope belongs to. */
    public Scope root() {
        Scope s = this;
        while (s.parent != null) s = s.parent;
        return s;
    }

    /** Dotted path from the root, e.g. {@code main.add_product.if2}. */
    public String qualifiedName() {
        return (parent == null) ? name : parent.qualifiedName() + "." + name;
    }

    public int depth() {
        return (parent == null) ? 0 : parent.depth() + 1;
    }

    @Override
    public String toString() {
        return qualifiedName();
    }
}
