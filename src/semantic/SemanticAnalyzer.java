package semantic;

import ASTJinja2withHTMLandCSS.Jinja2.*;
import FlaskStatement.*;
import SymbolsTable.Builtins;
import SymbolsTable.Scope;
import SymbolsTable.Symbol;
import SymbolsTable.SymbolsTable;
import SymbolsTable.Types;
import util.TemplateNames;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Reports the five semantic error kinds in {@link ErrorType}.
 * <p>
 * Every check resolves names through the scope the AST builder stamped on each node,
 * so a name is judged from where it was actually written rather than against one flat
 * table of everything the program ever declared.
 */
public class SemanticAnalyzer {

    /** Names Flask provides that are never declared in user code. */
    private static final Set<String> FLASK_BUILTINS = Builtins.ALL;

    /** Names Jinja resolves itself, so a template may use them uncontextualised. */
    private static final Set<String> JINJA_GLOBALS = Builtins.JINJA_GLOBALS;

    /** Calls miniFlask allows. Anything else is a TYPE_ERROR. */
    private static final Set<String> ALLOWED_CALLS = Builtins.FUNCTIONS;

    /** A {{ ... }} interpolation fallback inside raw strings. */
    private static final Pattern INTERPOLATION = Pattern.compile("\\{\\{(.+?)}}");

    /** The leading identifier chain of a Jinja expression, e.g. p.image -> p */
    private static final Pattern LEADING_NAME = Pattern.compile("\\s*([A-Za-z_][A-Za-z0-9_]*)");

    private final SymbolsTable symbolsTable;
    private final TypeSystem types = new TypeSystem();
    private final List<SemanticError> errors = new ArrayList<>();
    private final RouteCollector routes = new RouteCollector();

    private String currentFile = "app.py";

    public SemanticAnalyzer(SymbolsTable symbolsTable) {
        this.symbolsTable = symbolsTable;
    }

    public List<SemanticError> getErrors() {
        return Collections.unmodifiableList(errors);
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    public RouteCollector getRoutes() {
        return routes;
    }

    // ============================================================
    //                     Python (Flask) side
    // ============================================================

    public void analyzePythonProgram(Program program) {
        analyzePythonProgram(program, "app.py");
    }

    public void analyzePythonProgram(Program program, String fileName) {
        this.currentFile = fileName;
        routes.collect(program);
        visitPython(program);
    }

    private void visitPython(ASTNode node) {
        if (node == null) return;

        if (node instanceof Assignment assignment)      checkAssignment(assignment);
        else if (node instanceof BinaryOperation binary) checkBinaryOperation(binary);
        else if (node instanceof Subscript subscript)    checkSubscript(subscript);
        else if (node instanceof FunctionCall call)      checkFunctionCall(call);
        else if (node instanceof ForStatement loop)      checkForStatement(loop);
        else if (node instanceof Name name)              checkName(name);

        for (ASTNode child : node.getChildren()) visitPython(child);
    }

    /** UNDEFINED_VARIABLE vs SCOPE_ERROR. */
    private void checkName(Name node) {
        String id = node.id;
        if (FLASK_BUILTINS.contains(id)) return;

        Scope scope = node.getScope();
        if (symbolsTable.resolveFrom(scope, id) != null) return;

        // Declared somewhere, just not on the path from here to the root.
        Symbol elsewhere = symbolsTable.findAnywhere(id);
        if (elsewhere != null) {
            report(ErrorType.SCOPE_ERROR, node.line,
                    "Variable '" + id + "' is not visible from "
                            + describe(scope) + "; it is declared in "
                            + elsewhere.getScope().qualifiedName()
                            + " at line " + elsewhere.getLine(),
                    "move the declaration to an enclosing scope, or assign it before the block");
            return;
        }

        report(ErrorType.UNDEFINED_VARIABLE, node.line,
                "Variable '" + id + "' is used before it is defined");
    }

    /** TYPE_MISMATCH on operands the operator cannot combine. */
    private void checkBinaryOperation(BinaryOperation node) {
        Scope scope = node.getScope();
        String left = types.infer(node.left, scope);
        String right = types.infer(node.right, scope);

        if (types.accepts(node.op, left, right)) return;

        report(ErrorType.TYPE_MISMATCH, node.line,
                "Operator '" + node.op.symbol + "' cannot combine "
                        + left + " and " + right
                        + " (" + node.left + " " + node.op.symbol + " " + node.right + ")");
    }

    /** TYPE_ERROR when indexing something that is not indexable. */
    private void checkSubscript(Subscript node) {
        Scope scope = node.getScope();
        String targetType = types.infer(node.value, scope);

        if (!types.allowsSubscript(targetType)) {
            report(ErrorType.TYPE_ERROR, node.line,
                    "Cannot index a value of type " + targetType
                            + " ('" + node.value + "' is not subscriptable)");
            return;
        }

        // A dict indexed by a key it does not contain.
        Expression target = types.boundExpression(node.value, scope);
        if (target instanceof DictExpr dict
                && node.index instanceof Literal literal
                && literal.value instanceof String key
                && !dict.pairs.containsKey(key)) {
            report(ErrorType.TYPE_ERROR, node.line,
                    "Key '" + key + "' is not present in '" + node.value + "'",
                    "available keys: " + dict.pairs.keySet());
        }
    }

    /** TYPE_ERROR for calls miniFlask does not support. */
    private void checkFunctionCall(FunctionCall node) {
        String name = TypeSystem.calleeName(node);
        if (name.isEmpty() || ALLOWED_CALLS.contains(name)) return;

        Symbol symbol = symbolsTable.resolveFrom(node.getScope(), name);
        if (symbol == null) return;   // reported as undefined by checkName

        if (symbol.getKind() != Symbol.Kind.FUNCTION && symbol.getKind() != Symbol.Kind.IMPORT) {
            report(ErrorType.TYPE_ERROR, node.line,
                    "'" + name + "' is a " + symbol.getType() + ", not a function, and cannot be called");
            return;
        }

        if (symbol.getKind() == Symbol.Kind.FUNCTION) {
            int expected = symbol.getParameters().size();
            int actual = node.args.size();
            if (actual != expected) {
                report(ErrorType.TYPE_ERROR, node.line,
                    "'" + name + "' takes " + expected + " argument(s) but got " + actual);
            }
        }
    }

    /** TYPE_ERROR when the thing after {@code in} cannot be iterated. */
    private void checkForStatement(ForStatement node) {
        Scope scope = node.getScope();
        String iterableType = types.infer(node.getIterableExpression(), scope);

        if (!Types.isUnknown(iterableType) && !Types.isIterable(iterableType)) {
            report(ErrorType.TYPE_ERROR, node.line,
                    "Cannot iterate over " + iterableType
                            + " ('" + node.getIterableExpression() + "' is not iterable)");
        }
    }

    private void checkAssignment(Assignment node) {
        Expression left = node.getLeft();
        if (!(left instanceof Name) && !(left instanceof Subscript) && !(left instanceof Attribute)) {
            report(ErrorType.TYPE_ERROR, node.line,
                    "Left side of assignment is not assignable: " + left);
            return;
        }

        // The AST builder can only read a type off a literal. Now that full inference
        // is available, fill in what it left as unknown — the walk is in source order,
        // so a refined type is in place before any later use of the name.
        if (left instanceof Name name) {
            Symbol symbol = symbolsTable.resolveFrom(node.getScope(), name.id);
            if (symbol != null && Types.isUnknown(symbol.getType())) {
                symbol.setType(types.infer(node.getRight(), node.getScope()));
            }
        }
    }

    // ============================================================
    //                     Jinja template side
    // ============================================================

    /**
     * Checks one template against the context every route hands it.
     * A name is accepted when any route rendering this template provides it, since
     * the template only has to work for the routes that actually use it.
     */
    public void analyzeTemplate(String templateName, ASTJinja2withHTMLandCSS.ASTNode root) {
        if (root == null) return;
        this.currentFile = templateName;

        List<TemplateBinding> bindings = routes.bindingsFor(templateName);
        Set<String> provided = new LinkedHashSet<>();
        for (TemplateBinding binding : bindings) provided.addAll(binding.getContext().keySet());

        if (bindings.isEmpty()) {
            report(ErrorType.MISSING_FLASK_VARIABLE, 1,
                    "Template '" + templateName + "' is never rendered by any route",
                    "add render_template(\"" + templateName + "\", ...) to a view function");
        }

        visitTemplate(root, provided, new HashSet<>());
    }

    /**
     * Flags a route that renders a template file which is not there. The orphan case
     * (a template no route renders) is checked in analyzeTemplate; this is its mirror,
     * and without it a typo in a template name produces a page that never appears.
     */
    public void checkTemplateFiles(Set<String> availableTemplates) {
        this.currentFile = "app.py";
        for (TemplateBinding binding : routes.getBindings()) {
            boolean present = availableTemplates.stream()
                    .anyMatch(file -> TemplateNames.sameTemplate(file, binding.getTemplateName()));
            if (present) continue;
            report(ErrorType.MISSING_FLASK_VARIABLE, binding.getLine(),
                    "Route '" + binding.getFunctionName() + "()' renders '"
                            + binding.getTemplateName() + "' but no such template exists",
                    availableTemplates.isEmpty()
                            ? "the templates folder is empty or missing"
                            : "available templates: " + availableTemplates);
        }
    }

    private void visitTemplate(ASTJinja2withHTMLandCSS.ASTNode node,
                               Set<String> provided,
                               Set<String> localVars) {
        if (node == null) return;

        if (node instanceof ForBlockNode block) {
            visitForBlockNode(block, provided, localVars);
            return;
        }

        if (node instanceof IfBlockNode ifBlock) {
            checkJinjaExpr(ifBlock.getCondition(), ifBlock.getLineNumber(), provided, localVars,
                    "tested by {% if " + (ifBlock.getCondition() != null ? ifBlock.getCondition().asString() : "") + " %}");
            for (ASTJinja2withHTMLandCSS.ASTNode child : ifBlock.getThenBody()) {
                visitTemplate(child, provided, localVars);
            }
            for (ASTJinja2withHTMLandCSS.ASTNode child : ifBlock.getElseBody()) {
                visitTemplate(child, provided, localVars);
            }
            return;
        }

        if (node instanceof SetNode setNode) {
            localVars.add(setNode.getVarName());
            checkJinjaExpr(setNode.getValue(), setNode.getLineNumber(), provided, localVars,
                    "assigned in {% set " + setNode.getVarName() + " = ... %}");
            return;
        }

        if (node instanceof JinjaExpressionNode expression) {
            checkJinjaExpr(expression.getExpr(), expression.getLineNumber(), provided, localVars,
                    "used as {{ " + (expression.getExpr() != null ? expression.getExpr().asString() : "") + " }}");
            return;
        }

        if (node instanceof ElementNode elem) {
            if (elem.getTagName().equalsIgnoreCase("img") && !elem.hasAttribute("src")) {
                report(ErrorType.TYPE_ERROR, elem.getLineNumber(), "Missing 'src' for <img> tag.");
            }
            if (elem.getTagName().equalsIgnoreCase("a") && !elem.hasAttribute("href")) {
                report(ErrorType.TYPE_ERROR, elem.getLineNumber(), "Missing 'href' for <a> tag.");
            }
        }

        for (ASTJinja2withHTMLandCSS.ASTNode child : node.getChildren()) {
            visitTemplate(child, provided, localVars);
        }
    }

    private void visitForBlockNode(ForBlockNode block, Set<String> provided, Set<String> localVars) {
        String collection = block.getCollection();
        String iterator = block.getIterator();

        if (collection != null) {
            // A chain such as group.items is satisfied by its root being in the context.
            requireProvided(rootOf(collection), block.getLineNumber(), provided, localVars,
                    "iterated by {% for " + iterator + " in " + collection + " %}");
        }

        Set<String> inner = new HashSet<>(localVars);
        if (iterator != null) inner.add(iterator);
        for (ASTJinja2withHTMLandCSS.ASTNode child : block.getContent()) {
            visitTemplate(child, provided, inner);
        }
    }

    private void checkJinjaExpr(JinjaExprNode expr, int defaultLine,
                                Set<String> provided, Set<String> localVars,
                                String usage) {
        if (expr == null) return;
        int line = expr.getLineNumber() > 0 ? expr.getLineNumber() : defaultLine;

        if (expr instanceof NameExprNode nameNode) {
            requireProvided(nameNode.getName(), line, provided, localVars, usage);
        } else if (expr instanceof MemberAccessNode member) {
            requireProvided(member.getRoot(), line, provided, localVars, usage);
        } else if (expr instanceof FilterExprNode filter) {
            checkJinjaExpr(filter.getTarget(), line, provided, localVars, usage);
            for (JinjaExprNode arg : filter.getArgs()) {
                checkJinjaExpr(arg, line, provided, localVars, usage);
            }
        } else if (expr instanceof BinaryExprNode binary) {
            checkJinjaExpr(binary.getLeft(), line, provided, localVars, usage);
            checkJinjaExpr(binary.getRight(), line, provided, localVars, usage);
        } else if (expr instanceof UnaryExprNode unary) {
            checkJinjaExpr(unary.getOperand(), line, provided, localVars, usage);
        } else if (expr instanceof CallExprNode call) {
            for (CallExprNode.Arg arg : call.getArgs()) {
                checkJinjaExpr(arg.expr(), line, provided, localVars, usage);
            }
        } else if (expr instanceof SubscriptExprNode subscript) {
            checkJinjaExpr(subscript.getTarget(), line, provided, localVars, usage);
            checkJinjaExpr(subscript.getIndex(), line, provided, localVars, usage);
        }
    }

    private void requireProvided(String name, int line,
                                 Set<String> provided, Set<String> localVars,
                                 String usage) {
        if (name == null || name.isEmpty()) return;
        if (localVars.contains(name)) return;
        if (JINJA_GLOBALS.contains(name)) return;
        if (provided.contains(name)) return;

        String hint = provided.isEmpty()
                ? "no route passes any variable to this template"
                : "this template receives: " + provided;

        report(ErrorType.MISSING_FLASK_VARIABLE, line,
                "Variable '" + name + "' is " + usage
                        + " but Flask never passes it to this template",
                hint);
    }

    // ============================================================
    //                          Helpers
    // ============================================================

    /** Leading identifier of a Jinja expression: "p.image" and "p['x']" both give "p". */
    private String rootOf(String expression) {
        if (expression == null) return null;
        Matcher matcher = LEADING_NAME.matcher(expression);
        return matcher.lookingAt() ? matcher.group(1) : null;
    }

    private String describe(Scope scope) {
        return (scope != null) ? "scope " + scope.qualifiedName() : "this scope";
    }

    private void report(ErrorType type, int line, String message) {
        errors.add(new SemanticError(type, currentFile, line, message));
    }

    private void report(ErrorType type, int line, String message, String hint) {
        errors.add(new SemanticError(type, currentFile, line, message, hint));
    }

    // ============================================================
    //                          Reporting
    // ============================================================

    public void printErrors() {
        if (errors.isEmpty()) {
            System.out.println("Semantic Analysis: No errors found.");
            return;
        }

        List<SemanticError> sorted = new ArrayList<>(errors);
        Collections.sort(sorted);

        System.out.println("Semantic Analysis: " + errors.size() + " error(s) found.\n");
        for (SemanticError error : sorted) System.out.println(error);

        System.out.println();
        for (ErrorType type : ErrorType.values()) {
            long count = errors.stream().filter(e -> e.getType() == type).count();
            // Locale.ROOT: the default locale here renders %d with Arabic-Indic digits.
            if (count > 0) System.out.printf(Locale.ROOT, "  %-24s %d%n", type.label(), count);
        }
    }
}
