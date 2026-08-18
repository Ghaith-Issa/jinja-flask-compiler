package SymbolsTable;

import java.util.ArrayList;
import java.util.List;

/**
 * One named entity discovered while building the Python AST.
 * <p>
 * Replaces the old {@code Map<String,Object>} entries, which carried no type and
 * no link to the scope they belonged to, so the semantic analyzer could not use them.
 */
public class Symbol {

    public enum Kind {
        VARIABLE,   // x = ...
        PARAMETER,  // def f(x)
        FUNCTION,   // def f()
        LOOP_VAR,   // for x in ...
        IMPORT,     // from flask import x
        ROUTE       // @app.route("/...")
    }

    private final String name;
    private final Kind kind;
    private final int line;
    private final Scope scope;

    /** One of the names in {@link Types}. Never null. */
    private String type = Types.UNKNOWN;

    /** The AST expression this was bound to, kept for reporting. */
    private Object value;

    /** Declared parameter names; only meaningful for {@link Kind#FUNCTION}. */
    private List<String> parameters = new ArrayList<>();

    /** Route path for {@link Kind#FUNCTION} symbols reached through @app.route. */
    private String route;

    public Symbol(String name, Kind kind, String type, int line, Scope scope) {
        this.name = name;
        this.kind = kind;
        this.line = line;
        this.scope = scope;
        if (type != null) this.type = type;
    }

    public String getName()          { return name; }
    public Kind getKind()            { return kind; }
    public int getLine()             { return line; }
    public Scope getScope()          { return scope; }
    public String getType()          { return type; }
    public Object getValue()         { return value; }
    public List<String> getParameters() { return parameters; }
    public String getRoute()         { return route; }

    public void setType(String type)   { if (type != null) this.type = type; }
    public void setValue(Object value) { this.value = value; }
    public void setParameters(List<String> parameters) {
        this.parameters = (parameters != null) ? parameters : new ArrayList<>();
    }
    public void setRoute(String route) { this.route = route; }

    /** Fully qualified name, e.g. {@code main.add_product.if2.max_id}. */
    public String qualifiedName() {
        return scope.qualifiedName() + "." + name;
    }

    @Override
    public String toString() {
        return qualifiedName() + " : " + type + " (" + kind + ", line " + line + ")";
    }
}
