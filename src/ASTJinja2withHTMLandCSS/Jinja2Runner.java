package ASTJinja2withHTMLandCSS;

import SymbolsTable.SymbolsTable;
import util.Sources;
import util.SyntaxErrorCollector;
import antlr.grammar.Jinja2withHTMLandCSS.gen.Jinja2withHTMLandCSSLexer;
import antlr.grammar.Jinja2withHTMLandCSS.gen.Jinja2withHTMLandCSSParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.ArrayList;
import java.util.List;


public class Jinja2Runner {

    /** A parsed template together with whatever went wrong while parsing it. */
    public record TemplateParse(ASTNode ast, List<SyntaxErrorCollector.SyntaxError> errors) {
        public boolean ok() { return ast != null; }
    }

    public static void runDefaultSuite(Boolean detail) {
        try {
            SymbolsTable symbolsTable = SymbolsTable.getHtmlInstance();
//            Map<String, Object> inner = new LinkedHashMap<>();
//            inner.addHtmlSymbol("products", "all the product");
//            inner.addHtmlSymbol("product", "like 1");
//            symbolsTable.addHtmlSymbol("data_sent", inner);


            String[] files = {
                    "Testing Project/FlaskTestingApp/templates/add_product.html",
                    "Testing Project/FlaskTestingApp/templates/index.html",
                    "Testing Project/FlaskTestingApp/templates/product.html",
                    "Testing Project/FlaskTestingApp/static/style.css"
            };

            List<String> allErrors = new ArrayList<>();

            for (String file : files) {
                System.out.println("\n--- Processing: " + file + " ---");
                allErrors.addAll(executeFileParser(file,detail));
            }


            if (!allErrors.isEmpty()) {
                System.err.println("\n=== SEMANTIC ERRORS ===");
                allErrors.forEach(System.err::println);
            }

            System.out.println("\n=== Jinja2/HTML/CSS SYMBOL TABLE ===\n");
            symbolsTable.printjinja2Symbols();

        } catch (Exception e) {
            System.err.println("Fatal error during execution: " + e.getMessage());
        }
    }

    private static List<String> executeFileParser(String filePath,Boolean detail) throws Exception {
        CharStream cs = readSource(filePath);
        Jinja2withHTMLandCSSLexer lexer = new Jinja2withHTMLandCSSLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        Jinja2withHTMLandCSSParser parser = new Jinja2withHTMLandCSSParser(tokens);

        parser.removeErrorListeners();
        SyntaxErrorCollector collector = new SyntaxErrorCollector(fileNameOf(filePath));
        parser.addErrorListener(collector);

        ParseTree tree = parser.prog();

        if (collector.hasErrors()) {
            collector.getErrors().forEach(e -> System.err.println(e));
        } else {
            BaseVisitor builder = new BaseVisitor();
            ASTNode root = builder.visit(tree);
            attachSource(root, filePath, cs);

            root.print("",true,0,detail);
            if (!builder.semanticErrors.isEmpty()) {
                builder.semanticErrors.add(0, "ERRORS for the file: " + filePath);
            }
            return builder.semanticErrors;
        }
        return new ArrayList<>();
    }
    /**
     * Parses one template and hands back its errors alongside the tree.
     * Returning them beats a "last errors" static: the caller cannot forget to read
     * it, and two parses can never overwrite one another's results.
     */
    public static TemplateParse parseTemplate(String filePath) throws Exception {
        CharStream cs = readSource(filePath);
        Jinja2withHTMLandCSSLexer lexer = new Jinja2withHTMLandCSSLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        Jinja2withHTMLandCSSParser parser = new Jinja2withHTMLandCSSParser(tokens);

        parser.removeErrorListeners();
        SyntaxErrorCollector collector = new SyntaxErrorCollector(fileNameOf(filePath));
        parser.addErrorListener(collector);

        ParseTree tree = parser.prog();

        if (collector.hasErrors()) {
            return new TemplateParse(null, collector.getErrors());
        }

        BaseVisitor builder = new BaseVisitor();
        ASTNode root = builder.visit(tree);
        attachSource(root, filePath, cs);
        return new TemplateParse(root, List.of());
    }

    /** Convenience wrapper for callers that only want the tree. */
    public static ASTNode parseFile(String filePath) throws Exception {
        return parseTemplate(filePath).ast();
    }

    private static String fileNameOf(String path) {
        int slash = Math.max(path.lastIndexOf('/'), path.lastIndexOf(92));
        return (slash >= 0) ? path.substring(slash + 1) : path;
    }

    /** Reads a template, dropping any byte order mark the lexer has no rule for. */
    private static CharStream readSource(String filePath) throws java.io.IOException {
        String text = Sources.read(java.nio.file.Paths.get(filePath));
        return org.antlr.v4.runtime.CharStreams.fromString(text, filePath);
    }

    /** Hands the raw file text to the tree so the generator can read source spans. */
    private static void attachSource(ASTNode root, String filePath, CharStream cs) {
        if (root instanceof ProgramNode program) {
            program.setSource(filePath, cs.getText(Interval.of(0, cs.size() - 1)));
        }
    }


}
