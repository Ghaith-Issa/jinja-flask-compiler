package semantic;

import FlaskStatement.Expression;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * One {@code render_template(...)} call: which template it renders and which
 * variables it hands over. This is the contract the template side is checked
 * against, and the context the generator later fills in.
 */
public class TemplateBinding {

    private final String templateName;
    private final Map<String, Expression> context;
    private final String functionName;
    private final String route;
    private final int line;

    public TemplateBinding(String templateName,
                           Map<String, Expression> context,
                           String functionName,
                           String route,
                           int line) {
        this.templateName = templateName;
        this.context = new LinkedHashMap<>(context);
        this.functionName = functionName;
        this.route = route;
        this.line = line;
    }

    public String getTemplateName()          { return templateName; }
    public Map<String, Expression> getContext() { return context; }
    public String getFunctionName()          { return functionName; }
    public String getRoute()                 { return route; }
    public int getLine()                     { return line; }

    @Override
    public String toString() {
        return templateName + " <- " + functionName + "() " + context.keySet()
                + (route != null ? " [" + route + "]" : "");
    }
}
