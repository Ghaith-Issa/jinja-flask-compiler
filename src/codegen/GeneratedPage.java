package codegen;

import java.util.LinkedHashMap;
import java.util.Map;

/** One page the generator will write: which template, which data, which output file. */
public class GeneratedPage {

    private final String outputFileName;
    private final String templateName;
    private final Map<String, Object> context;
    private final String route;
    private final String endpoint;

    /** Value substituted into the route parameter, or null for a static route. */
    private final Object routeValue;

    public GeneratedPage(String outputFileName,
                         String templateName,
                         Map<String, Object> context,
                         String route,
                         String endpoint,
                         Object routeValue) {
        this.outputFileName = outputFileName;
        this.templateName = templateName;
        this.context = new LinkedHashMap<>(context);
        this.route = route;
        this.endpoint = endpoint;
        this.routeValue = routeValue;
    }

    public String getOutputFileName()        { return outputFileName; }
    public String getTemplateName()          { return templateName; }
    public Map<String, Object> getContext()  { return context; }
    public String getRoute()                 { return route; }
    public String getEndpoint()              { return endpoint; }
    public Object getRouteValue()            { return routeValue; }

    /**
     * The concrete URL this page answers: {@code /product/<int:product_id>} with the
     * value 2 becomes {@code /product/2}. Template links are written against these,
     * so they are what the generator has to rewrite to file names.
     */
    public String concreteUrl() {
        if (route == null) return null;
        if (routeValue == null) return route;
        return route.replaceAll("<(?:\\w+:)?\\w+>", Values.display(routeValue));
    }

    @Override
    public String toString() {
        return outputFileName + "  <-  " + templateName
                + "  " + context.keySet()
                + (route != null ? "  [" + route + "]" : "");
    }
}
