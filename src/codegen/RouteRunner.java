package codegen;

import FlaskStatement.Attribute;
import FlaskStatement.Decorator;
import FlaskStatement.FunctionCall;
import FlaskStatement.FunctionDef;
import FlaskStatement.Literal;
import FlaskStatement.Program;
import FlaskStatement.Statement;
import util.TemplateNames;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Calls every route and collects the pages to generate.
 * <p>
 * A route with no parameters gives one page. A route like
 * {@code /product/<int:product_id>} gives one page per matching record, because a
 * static site has no request to read the id from — the pages have to exist up front.
 */
public class RouteRunner {

    private static final Pattern ROUTE_PARAM = Pattern.compile("<(?:(\\w+):)?(\\w+)>");

    private final PythonEvaluator evaluator;
    private final List<GeneratedPage> pages = new ArrayList<>();
    private final List<String> log = new ArrayList<>();

    public RouteRunner(PythonEvaluator evaluator) {
        this.evaluator = evaluator;
    }

    public List<GeneratedPage> getPages() { return pages; }
    public List<String> getLog()          { return log; }

    // ============================================================

    public List<GeneratedPage> run(Program program) {
        pages.clear();

        List<FunctionDef> views = viewFunctions(program);
        for (FunctionDef view : views) {
            evaluator.registerRoute(view.getName(), routeOf(view));
        }
        for (FunctionDef view : views) {
            runView(view);
        }
        return pages;
    }

    private List<FunctionDef> viewFunctions(Program program) {
        List<FunctionDef> views = new ArrayList<>();
        for (Statement statement : program.statements) {
            if (statement instanceof FunctionDef function && routeOf(function) != null) {
                views.add(function);
            }
        }
        return views;
    }

    private void runView(FunctionDef view) {
        String route = routeOf(view);
        List<String> parameters = view.getParameters();

        if (parameters.isEmpty()) {
            renderOnce(view, route, List.of(), null);
            return;
        }

        // Only single-parameter routes are generated; anything wider would need a
        // cartesian product the source gives no basis for.
        if (parameters.size() > 1) {
            log.add("skipped " + view.getName() + "(): routes with "
                    + parameters.size() + " parameters are not generated");
            return;
        }

        String parameter = parameters.get(0);
        List<Object> candidates = parameterValues(parameter);
        if (candidates.isEmpty()) {
            log.add("skipped " + view.getName() + "(): found no values for '" + parameter + "'");
            return;
        }
        for (Object value : candidates) {
            renderOnce(view, route, List.of(value), value);
        }
    }

    private void renderOnce(FunctionDef view, String route, List<Object> args, Object suffix) {
        Object result;
        try {
            result = evaluator.callFunction(new PythonEvaluator.FunctionValue(view), args, view.line);
        } catch (EvaluationException e) {
            log.add("error running " + view.getName() + "(): " + e.getMessage());
            return;
        }

        if (result instanceof RenderRequest request) {
            pages.add(new GeneratedPage(
                    outputNameFor(request.getTemplateName(), suffix),
                    request.getTemplateName(),
                    request.getContext(),
                    route,
                    view.getName(),
                    suffix));
            return;
        }
        if (result instanceof PythonEvaluator.Redirect redirect) {
            log.add(view.getName() + "() redirects to " + redirect.location() + "; no page generated");
            return;
        }
        log.add(view.getName() + "() returned no template; no page generated");
    }

    /** {@code product.html} + id 2 becomes {@code product_2.html}. */
    private String outputNameFor(String templateName, Object suffix) {
        String base = TemplateNames.baseOf(templateName);
        if (suffix != null) base = base + "_" + Values.display(suffix);
        return base + ".html";
    }

    /**
     * Values a route parameter can take, read from the program's own data.
     * {@code product_id} looks for a global list of dicts carrying an {@code id} key,
     * which is how the miniFlask sample models its records.
     */
    private List<Object> parameterValues(String parameter) {
        for (String key : keyCandidates(parameter)) {
            for (Object global : evaluator.getGlobals().ownValues().values()) {
                if (!(global instanceof List<?> list) || list.isEmpty()) continue;

                List<Object> values = new ArrayList<>();
                for (Object item : list) {
                    if (item instanceof Map<?, ?> record && record.containsKey(key)) {
                        values.add(record.get(key));
                    }
                }
                if (values.size() == list.size()) return values;
            }
        }
        return List.of();
    }

    /** product_id -> ["product_id", "id"]; plain names stay as they are. */
    private List<String> keyCandidates(String parameter) {
        List<String> candidates = new ArrayList<>();
        candidates.add(parameter);
        int underscore = parameter.lastIndexOf('_');
        if (underscore >= 0 && underscore < parameter.length() - 1) {
            candidates.add(parameter.substring(underscore + 1));
        }
        return candidates;
    }

    /** Route path declared by {@code @app.route("...")}, or null. */
    public static String routeOf(FunctionDef function) {
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

    /** Parameter names declared in a route path, in order. */
    public static Map<String, String> routeParameters(String route) {
        Map<String, String> parameters = new LinkedHashMap<>();
        if (route == null) return parameters;
        Matcher matcher = ROUTE_PARAM.matcher(route);
        while (matcher.find()) {
            parameters.put(matcher.group(2), matcher.group(1) == null ? "string" : matcher.group(1));
        }
        return parameters;
    }
}
