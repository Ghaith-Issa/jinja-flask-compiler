package semantic;

import FlaskStatement.*;
import util.TemplateNames;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Finds every {@code render_template(...)} call in the Flask program and records
 * which template it feeds and with what.
 * <p>
 * This is what makes MISSING_FLASK_VARIABLE checkable: without it the template side
 * has to guess at the whole program's variables, and a template referencing a name
 * that some unrelated route happens to define would pass.
 */
public class RouteCollector {

    private static final String RENDER = "render_template";

    private final List<TemplateBinding> bindings = new ArrayList<>();

    public List<TemplateBinding> collect(Program program) {
        bindings.clear();
        if (program == null) return bindings;

        for (Statement statement : program.statements) {
            if (statement instanceof FunctionDef function) {
                collectFromFunction(function);
            }
        }
        return bindings;
    }

    public List<TemplateBinding> getBindings() {
        return bindings;
    }

    /** All bindings that feed the given template file. */
    public List<TemplateBinding> bindingsFor(String templateName) {
        List<TemplateBinding> matches = new ArrayList<>();
        for (TemplateBinding binding : bindings) {
            // index.jinja and index.html name the same template.
            if (TemplateNames.sameTemplate(binding.getTemplateName(), templateName)) {
                matches.add(binding);
            }
        }
        return matches;
    }

    // ============================================================

    private void collectFromFunction(FunctionDef function) {
        String route = routeOf(function);
        for (ASTNode node : function.getBody()) {
            collectFromNode(node, function.getName(), route);
        }
    }

    private void collectFromNode(ASTNode node, String functionName, String route) {
        if (node == null) return;

        if (node instanceof FunctionCall call && RENDER.equals(TypeSystem.calleeName(call))) {
            String template = templateNameOf(call);
            if (template != null) {
                bindings.add(new TemplateBinding(
                        template, contextOf(call), functionName, route, call.line));
            }
        }

        for (ASTNode child : node.getChildren()) {
            collectFromNode(child, functionName, route);
        }
    }

    /** First positional argument of render_template, e.g. "index.html". */
    private String templateNameOf(FunctionCall call) {
        if (call.args.isEmpty()) return null;
        if (call.args.get(0) instanceof Literal literal && literal.value instanceof String name) {
            return name;
        }
        return null;
    }

    /**
     * Keyword arguments become the template context. A bare positional dict is not
     * supported by the miniFlask grammar, so keywords are the only source.
     */
    private Map<String, Expression> contextOf(FunctionCall call) {
        return new LinkedHashMap<>(call.kwargs);
    }

    /** Reads the path out of {@code @app.route("/...")}, or null when absent. */
    private String routeOf(FunctionDef function) {
        if (function.getDecorators() == null) return null;
        for (Decorator decorator : function.getDecorators()) {
            if (!(decorator.expr instanceof FunctionCall call)) continue;
            if (!(call.called instanceof Attribute attribute)) continue;
            if (!"route".equals(attribute.attribute)) continue;
            if (call.args.isEmpty()) continue;
            if (call.args.get(0) instanceof Literal literal && literal.value instanceof String path) {
                return path;
            }
        }
        return null;
    }
}
