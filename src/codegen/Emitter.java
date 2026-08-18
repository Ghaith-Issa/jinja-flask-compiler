package codegen;

import ASTJinja2withHTMLandCSS.ASTNode;

import java.util.Map;

/**
 * Renders a parsed template against a context.
 * <p>
 * Kept as an interface so the back end is the only thing that changes if the target
 * language does: everything up to the context is shared.
 */
public interface Emitter {

    /**
     * @param root    the template's parsed tree, with its source attached
     * @param context concrete values produced by the Python side
     * @return the rendered page
     */
    String emit(ASTNode root, Map<String, Object> context);
}
