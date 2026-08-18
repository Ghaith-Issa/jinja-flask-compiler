package SymbolsTable;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Symbol storage for the compiler.
 * <p>
 * The Flask side is a real {@link Scope} tree: entries carry a type, a kind and the
 * scope they were declared in, and resolution walks the parent chain. Previously
 * there were two unrelated maps here — a scoped one written by the AST builder and a
 * flat one read by the semantic analyzer — so the analyzer could never see what the
 * builder had recorded, and {@code Main} had to hand-declare variables to silence
 * false errors.
 * <p>
 * The Jinja/HTML side still uses the original flat map; it is rebuilt from the
 * render_template() bindings in phase 1.
 */
public class SymbolsTable {

    private static SymbolsTable flaskInstance;
    private static SymbolsTable htmlInstance;

    // ---------- Flask side: scope tree ----------
    private Scope globalScope = new Scope("main", null);
    private Scope currentScope = globalScope;

    // ---------- Jinja/HTML side: flat map (unchanged) ----------
    private final Map<String, Map<String, Object>> htmlSymbols = new LinkedHashMap<>();

    private SymbolsTable() {}

    public static SymbolsTable getFlaskInstance() {
        if (flaskInstance == null) flaskInstance = new SymbolsTable();
        return flaskInstance;
    }

    public static SymbolsTable getHtmlInstance() {
        if (htmlInstance == null) htmlInstance = new SymbolsTable();
        return htmlInstance;
    }

    // ============================================================
    //                      Scope navigation
    // ============================================================

    public Scope getGlobalScope()  { return globalScope; }
    public Scope getCurrentScope() { return currentScope; }

    /** Opens a nested scope and makes it current. */
    public Scope enterScope(String name) {
        currentScope = new Scope(name, currentScope);
        return currentScope;
    }

    /** Closes the current scope. No-op at the root. */
    public void exitScope() {
        if (currentScope.getParent() != null) currentScope = currentScope.getParent();
    }

    // ============================================================
    //                      Define / resolve
    // ============================================================

    public Symbol define(String name, Symbol.Kind kind, String type, int line) {
        Symbol symbol = new Symbol(name, kind, type, line, currentScope);
        currentScope.define(symbol);
        return symbol;
    }

    public void define(Symbol symbol) {
        symbol.getScope().define(symbol);
    }

    /** Resolves from the current scope upwards. */
    public Symbol resolve(String name) {
        return currentScope.resolve(name);
    }

    /** Resolves from an explicit scope upwards — what the semantic analyzer uses. */
    public Symbol resolveFrom(Scope scope, String name) {
        return (scope != null) ? scope.resolve(name) : globalScope.resolve(name);
    }

    /** Finds a name anywhere in the tree, in scope or not. */
    public Symbol findAnywhere(String name) {
        return globalScope.findAnywhere(name);
    }

    public boolean exists(String name) {
        return resolve(name) != null;
    }

    public String getType(String name) {
        Symbol symbol = resolve(name);
        return (symbol != null) ? symbol.getType() : null;
    }

    /** Clears the Flask tree; the file watcher calls this before recompiling. */
    public void clearFlaskST() {
        globalScope = new Scope("main", null);
        currentScope = globalScope;
    }

    // ============================================================
    //                    Jinja / HTML side
    // ============================================================

    public void addHtmlSymbol(String key, Map<String, Object> value) {
        htmlSymbols.put(key, value);
    }

    public Map<String, Object> getHtmlSymbol(String key) {
        return htmlSymbols.get(key);
    }

    public void removehtmlkey(String key) {
        htmlSymbols.remove(key);
    }

    public void clearHtmlST() {
        htmlSymbols.clear();
    }

    // ============================================================
    //                         Printing
    // ============================================================

    public void printFlaskSymbols() {
        if (globalScope.getSymbols().isEmpty() && globalScope.getChildren().isEmpty()) {
            System.out.println("(empty)");
            return;
        }
        printScope(globalScope);
    }

    private void printScope(Scope scope) {
        for (Symbol symbol : scope.getSymbols()) {
            System.out.println(symbol.qualifiedName() + " {");
            System.out.printf("  %-15s : %s%n", "kind", symbol.getKind());
            System.out.printf("  %-15s : %s%n", "type", symbol.getType());
            System.out.printf("  %-15s : %s%n", "scope", scope.qualifiedName());
            System.out.printf("  %-15s : %s%n", "line", symbol.getLine());
            if (symbol.getKind() == Symbol.Kind.FUNCTION) {
                System.out.printf("  %-15s : %s%n", "parameters", symbol.getParameters());
                if (symbol.getRoute() != null) {
                    System.out.printf("  %-15s : %s%n", "route", symbol.getRoute());
                }
            } else if (symbol.getValue() != null) {
                System.out.printf("  %-15s : %s%n", "value", symbol.getValue());
            }
            System.out.println("}\n");
        }
        for (Scope child : scope.getChildren()) printScope(child);
    }

    public void printjinja2Symbols() {
        if (htmlSymbols.isEmpty()) {
            System.out.println("(empty)");
            return;
        }
        for (Map.Entry<String, Map<String, Object>> outer : htmlSymbols.entrySet()) {
            if (Objects.equals(outer.getKey(), "data_sent")) continue;
            System.out.println(outer.getKey() + " {");
            for (Map.Entry<String, Object> inner : outer.getValue().entrySet()) {
                System.out.printf("  %-3s : %s%n", inner.getKey(), inner.getValue());
            }
            System.out.println("}\n");
        }
    }
}
