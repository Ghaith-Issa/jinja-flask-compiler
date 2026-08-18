package codegen;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * What a {@code render_template(...)} call evaluates to: the template to render and
 * the concrete values to render it with. This is the "Context Data" of the pipeline
 * — the point where the Python side hands over to the Jinja side.
 */
public class RenderRequest {

    private final String templateName;
    private final Map<String, Object> context;

    public RenderRequest(String templateName, Map<String, Object> context) {
        this.templateName = templateName;
        this.context = new LinkedHashMap<>(context);
    }

    public String getTemplateName() { return templateName; }
    public Map<String, Object> getContext() { return context; }

    @Override
    public String toString() {
        return "render " + templateName + " with " + context.keySet();
    }
}
