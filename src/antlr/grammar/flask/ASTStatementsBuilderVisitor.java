package antlr.grammar.flask;

import FlaskStatement.*;
import SymbolsTable.Scope;
import SymbolsTable.Symbol;
import SymbolsTable.SymbolsTable;
import SymbolsTable.Types;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Builds the Python AST and, along the way, the scope tree.
 * <p>
 * Two things changed from the earlier version: scopes are real {@link Scope}
 * objects opened and closed as the walk descends (no static stack of dotted
 * strings), and every declaration is recorded — including function parameters and
 * loop variables, which were previously skipped and had to be hand-declared in
 * {@code Main} to stop the analyzer reporting them as undefined.
 */
public class ASTStatementsBuilderVisitor extends FlaskExprParserBaseVisitor<Statement> {

    /** Matches the converter in a route segment, e.g. {@code <int:product_id>}. */
    private static final Pattern ROUTE_PARAM = Pattern.compile("<(?:(\\w+):)?(\\w+)>");

    private final AntlrToExpression expressionVisitor;
    private final SymbolsTable sym = SymbolsTable.getFlaskInstance();

    private int forCounter = 0;
    private int ifCounter = 0;

    /** Route paths seen on decorators, waiting to be attached to the next function. */
    private final List<String> pendingRoutes = new ArrayList<>();

    public ASTStatementsBuilderVisitor() {
        this(new AntlrToExpression());
    }

    public ASTStatementsBuilderVisitor(AntlrToExpression expressionVisitor) {
        this.expressionVisitor = expressionVisitor;
    }

    // ============================================================
    //                        Statements
    // ============================================================

    @Override
    public Statement visitImportstatement(FlaskExprParser.ImportstatementContext ctx) {
        List<String> packageParts = new ArrayList<>();
        for (int i = 0; i < ctx.packageName().NAME().size(); i++) {
            packageParts.add(ctx.packageName().NAME(i).getText());
        }

        List<String> importedNames = new ArrayList<>();
        for (int i = 0; i < ctx.importList().NAME().size(); i++) {
            String imported = ctx.importList().NAME(i).getText();
            importedNames.add(imported);
            sym.define(imported, Symbol.Kind.IMPORT, Types.FUNCTION, ctx.getStart().getLine());
        }

        return stamp(new ImportStatement(ctx.getStart().getLine(), packageParts, importedNames));
    }

    @Override
    public Statement visitGlobalStmt(FlaskExprParser.GlobalStmtContext ctx) {
        List<String> names = new ArrayList<>();
        if (ctx.globalstatement() != null && ctx.globalstatement().NAME() != null) {
            for (var nameToken : ctx.globalstatement().NAME()) {
                names.add(nameToken.getText());
            }
        }
        return stamp(new GlobalStatement(ctx.getStart().getLine(), names));
    }


    @Override
    public Statement visitAssignment(FlaskExprParser.AssignmentContext ctx) {
        Expression left = expr(ctx.expr(0));
        Expression right = expr(ctx.expr(1));

        // Only a bare name introduces a new binding; products[0] = x assigns into
        // an existing object and declares nothing.
        if (left instanceof Name name) {
            Symbol existing = sym.getCurrentScope().resolveLocal(name.id);
            Symbol symbol = (existing != null)
                    ? existing
                    : sym.define(name.id, Symbol.Kind.VARIABLE, Types.UNKNOWN, ctx.getStart().getLine());
            symbol.setType(literalTypeOf(right));
            symbol.setValue(right);
        }

        return stamp(new Assignment(ctx.getStart().getLine(), left, right));
    }

    @Override
    public Statement visitReturnStmt(FlaskExprParser.ReturnStmtContext ctx) {
        Expression expression = (ctx.expr() != null) ? expr(ctx.expr()) : null;
        return stamp(new ReturnStatement(ctx.getStart().getLine(), expression));
    }

    @Override
    public Statement visitExprStmt(FlaskExprParser.ExprStmtContext ctx) {
        return stamp(new ExpressionStatement(ctx.getStart().getLine(), expr(ctx.expr())));
    }

    @Override
    public Statement visitBreak(FlaskExprParser.BreakContext ctx) {
        return stamp(new BreakStatement(ctx.getStart().getLine()));
    }

    @Override
    public Statement visitContinue(FlaskExprParser.ContinueContext ctx) {
        return stamp(new ContinueStatement(ctx.getStart().getLine()));
    }

    @Override
    public Statement visitFunctionDefstatementment(FlaskExprParser.FunctionDefstatementmentContext ctx) {
        List<Decorator> decorators = new ArrayList<>();
        pendingRoutes.clear();
        for (var decCtx : ctx.decorator()) {
            decorators.add(visitDecorator(decCtx));
        }

        FunctionDef func = (FunctionDef) visitFunctionDef(ctx.functionDef());

        return stamp(new FunctionDef(ctx.getStart().getLine(),
                func.getName(),
                func.getParameters(),
                func.getBody(),
                decorators));
    }

    @Override
    public Statement visitFunctionDef(FlaskExprParser.FunctionDefContext ctx) {
        int line = ctx.getStart().getLine();
        String name = ctx.NAME(0).getText();

        List<String> parameters = new ArrayList<>();
        for (int i = 1; i < ctx.NAME().size(); i++) {
            parameters.add(ctx.NAME(i).getText());
        }

        // The function itself belongs to the enclosing scope.
        Symbol funcSymbol = sym.define(name, Symbol.Kind.FUNCTION, Types.FUNCTION, line);
        funcSymbol.setParameters(parameters);
        String route = pendingRoutes.isEmpty() ? null : pendingRoutes.get(0);
        funcSymbol.setRoute(route);
        pendingRoutes.clear();

        sym.enterScope(name);
        // Parameters live in the function's own scope. Their type comes from the
        // route converter when there is one: <int:product_id> gives a number.
        for (String parameter : parameters) {
            sym.define(parameter, Symbol.Kind.PARAMETER, routeParamType(route, parameter), line);
        }

        List<Statement> body = new ArrayList<>();
        for (var stmtCtx : ctx.statement()) {
            body.add(visit(stmtCtx));
        }
        sym.exitScope();

        return stamp(new FunctionDef(line, name, parameters, body, null));
    }

    @Override
    public Statement visitIfstatement(FlaskExprParser.IfstatementContext ctx) {
        int line = ctx.getStart().getLine();
        Expression condition = expr(ctx.expr());

        sym.enterScope("if" + (++ifCounter));
        List<Statement> ifBody = new ArrayList<>();
        for (var stmtCtx : ctx.statement()) {
            ifBody.add(visit(stmtCtx));
        }
        sym.exitScope();

        return stamp(new IfStatement(line, condition, ifBody, new ArrayList<>()));
    }

    @Override
    public Statement visitForstatement(FlaskExprParser.ForstatementContext ctx) {
        int line = ctx.getStart().getLine();
        String iterator = ctx.NAME().getText();
        // The iterable is evaluated in the enclosing scope, before the loop opens.
        Expression iterable = expr(ctx.expr());

        sym.enterScope("for" + (++forCounter));
        Symbol loopVar = sym.define(iterator, Symbol.Kind.LOOP_VAR, elementTypeOf(iterable), line);
        loopVar.setValue(iterable);

        List<Statement> body = new ArrayList<>();
        for (var stmtCtx : ctx.statement()) {
            body.add(visit(stmtCtx));
        }
        sym.exitScope();

        return stamp(new ForStatement(line, iterable, iterator, body));
    }

    @Override
    public Decorator visitDecorator(FlaskExprParser.DecoratorContext ctx) {
        Expression expression = expr(ctx.expr());
        String route = routePathOf(expression);
        if (route != null) pendingRoutes.add(route);
        return stamp(new Decorator(ctx.getStart().getLine(), expression));
    }

    // ============================================================
    //                         Helpers
    // ============================================================

    /** Visits an expression and stamps the current scope over its whole subtree. */
    private Expression expr(FlaskExprParser.ExprContext ctx) {
        Expression expression = expressionVisitor.visit(ctx);
        stampTree(expression, sym.getCurrentScope());
        return expression;
    }

    /** Stamps a freshly built statement; its children already carry their own scope. */
    private <T extends ASTNode> T stamp(T node) {
        if (node != null && node.getScope() == null) node.setScope(sym.getCurrentScope());
        return node;
    }

    private void stampTree(ASTNode node, Scope scope) {
        if (node == null) return;
        node.setScope(scope);
        for (ASTNode child : node.getChildren()) stampTree(child, scope);
    }

    /** Type of an expression as far as it can be told from its literal shape. */
    private String literalTypeOf(Expression expression) {
        if (expression instanceof Literal literal) {
            if (literal.isString()) return Types.STRING;
            if (literal.isNumber()) return Types.NUMBER;
            if (literal.isTrue() || literal.isFalse()) return Types.BOOL;
            if (literal.isNone()) return Types.NONE;
        }
        if (expression instanceof ListExpr) return Types.LIST;
        if (expression instanceof DictExpr) return Types.DICT;
        if (expression instanceof Name name) {
            Symbol referenced = sym.resolve(name.id);
            return (referenced != null) ? referenced.getType() : Types.UNKNOWN;
        }
        return Types.UNKNOWN;
    }

    /** Type of the values produced by iterating this expression. */
    private String elementTypeOf(Expression iterable) {
        if (iterable instanceof ListExpr list) {
            return list.getChildren().isEmpty()
                    ? Types.UNKNOWN
                    : literalTypeOf((Expression) list.getChildren().get(0));
        }
        if (iterable instanceof Name name) {
            Symbol symbol = sym.resolve(name.id);
            if (symbol != null && symbol.getValue() instanceof Expression bound) {
                return elementTypeOf(bound);
            }
        }
        return Types.UNKNOWN;
    }

    /** Pulls "/product/&lt;int:product_id&gt;" out of {@code @app.route("...")}. */
    private String routePathOf(Expression decorator) {
        if (!(decorator instanceof FunctionCall call)) return null;
        if (!(call.called instanceof Attribute attribute)) return null;
        if (!"route".equals(attribute.attribute)) return null;
        if (call.args.isEmpty()) return null;
        if (call.args.get(0) instanceof Literal literal && literal.isString()) {
            return String.valueOf(literal.value);
        }
        return null;
    }

    /** Maps a route converter onto a miniFlask type: {@code <int:x>} gives number. */
    private String routeParamType(String route, String parameter) {
        if (route == null) return Types.UNKNOWN;
        Matcher matcher = ROUTE_PARAM.matcher(route);
        while (matcher.find()) {
            if (!parameter.equals(matcher.group(2))) continue;
            String converter = matcher.group(1);
            if (converter == null) return Types.STRING;
            return switch (converter) {
                case "int", "float" -> Types.NUMBER;
                case "string", "path" -> Types.STRING;
                default -> Types.UNKNOWN;
            };
        }
        return Types.UNKNOWN;
    }
}
