package ASTJinja2withHTMLandCSS;

import SymbolsTable.SymbolsTable;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Standalone entry point for the Jinja2/HTML/CSS front end only.
 * The parsing loop lives in {@link Jinja2Runner}; this class just seeds a
 * stub template context and delegates, so there is a single implementation
 * to maintain.
 */
public class Test {

    public static void main(String[] args) {
        // Temporary stand-in for the real render_template() context.
        // Phase 1 replaces this with RouteCollector output.
        Map<String, Object> sent = new LinkedHashMap<>();
        sent.put("products", "all the product");
        sent.put("product", "like 1");
        SymbolsTable.getHtmlInstance().addHtmlSymbol("data_sent", sent);

        Jinja2Runner.runDefaultSuite(true);
    }
}
