package codegen;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Runtime scope chain used while executing the Flask program.
 * <p>
 * Deliberately separate from SymbolsTable: the announcement rules the symbol table
 * out of the generation phase, and the two hold different things anyway — the symbol
 * table maps names to types, this maps names to values.
 */
public class Environment {

    private final Environment parent;
    private final Map<String, Object> values = new LinkedHashMap<>();

    public Environment() {
        this(null);
    }

    public Environment(Environment parent) {
        this.parent = parent;
    }

    public Environment child() {
        return new Environment(this);
    }

    public void define(String name, Object value) {
        values.put(name, value);
    }

    public boolean has(String name) {
        for (Environment env = this; env != null; env = env.parent) {
            if (env.values.containsKey(name)) return true;
        }
        return false;
    }

    public Object get(String name) {
        for (Environment env = this; env != null; env = env.parent) {
            if (env.values.containsKey(name)) return env.values.get(name);
        }
        throw new EvaluationException("name '" + name + "' is not defined at run time");
    }

    /** Assigns to the nearest existing binding, or creates one here. */
    public void assign(String name, Object value) {
        for (Environment env = this; env != null; env = env.parent) {
            if (env.values.containsKey(name)) {
                env.values.put(name, value);
                return;
            }
        }
        values.put(name, value);
    }

    public Map<String, Object> ownValues() {
        return values;
    }
}
