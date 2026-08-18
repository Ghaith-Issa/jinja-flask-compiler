package antlr.grammar.flask;

import FlaskStatement.*;
import SymbolsTable.Builtins;
import SymbolsTable.Symbol;
import SymbolsTable.SymbolsTable;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;

public class AntlrToExpression extends FlaskExprParserBaseVisitor<Expression> {
    SymbolsTable symbolsTable = SymbolsTable.getFlaskInstance();
    ArrayList<String> builtInFunctions = new ArrayList<>();
    ArrayList<String> SendDataFunctions = new ArrayList<>();

    /**
     * Problems found while building the tree. These used to be thrown, which stopped
     * the compiler at the first bad name and hid every later error; they are collected
     * now so the run always reaches the semantic phase and reports everything at once.
     */
    private final List<String> buildErrors = new ArrayList<>();

    public List<String> getBuildErrors() { return buildErrors; }
    public AntlrToExpression(){
        builtInFunctions.addAll(Builtins.FUNCTIONS);
        SendDataFunctions.add("render_template");
    }

    @Override
    public Expression visitVar(FlaskExprParser.VarContext ctx) {
        return new Name(ctx.getStart().getLine(),ctx.NAME().getText());
    }

    @Override
    public Expression visitNumber(FlaskExprParser.NumberContext ctx) {
        String text = ctx.NUMBER().getText();
        return new Literal(ctx.getStart().getLine(),parseNumber(text));
    }

    @Override
    public Expression visitString(FlaskExprParser.StringContext ctx) {
        return new Literal(ctx.getStart().getLine(), unquote(ctx.STRING().getText()));
    }

    /**
     * Turns a STRING token into its actual value: drops the surrounding quotes and
     * resolves escape sequences. Keeping the quotes in the AST made every literal
     * double-quoted downstream ("\"id\"") and would break the evaluator, which uses
     * these values as real dict keys.
     */
    static String unquote(String raw) {
        if (raw == null || raw.length() < 2) return raw;
        char first = raw.charAt(0);
        char last = raw.charAt(raw.length() - 1);
        if ((first != '"' && first != '\'') || first != last) return raw;

        String body = raw.substring(1, raw.length() - 1);
        StringBuilder out = new StringBuilder(body.length());
        for (int i = 0; i < body.length(); i++) {
            char c = body.charAt(i);
            if (c != '\\' || i + 1 >= body.length()) {
                out.append(c);
                continue;
            }
            char next = body.charAt(++i);
            switch (next) {
                case 'n'  -> out.append('\n');
                case 't'  -> out.append('\t');
                case 'r'  -> out.append('\r');
                case '"'  -> out.append('"');
                case '\'' -> out.append('\'');
                case '\\' -> out.append('\\');
                default   -> out.append('\\').append(next);
            }
        }
        return out.toString();
    }

    @Override
    public Expression visitTrueLit(FlaskExprParser.TrueLitContext ctx) {
        return Literal.trueLiteral(ctx.start.getLine());
    }

    @Override
    public Expression visitFalseLit(FlaskExprParser.FalseLitContext ctx) {
        return Literal.falseLiteral(ctx.start.getLine());
    }

    @Override
    public Expression visitNoneLit(FlaskExprParser.NoneLitContext ctx) {
        return Literal.noneLiteral(ctx.start.getLine());
    }



    @Override public Expression visitParens(FlaskExprParser.ParensContext ctx) { return visit(ctx.expr()); }


    @Override
    public Expression visitList(FlaskExprParser.ListContext ctx) {
        if (ctx.expr() == null || ctx.expr().isEmpty()) {
            return new ListExpr(ctx.getStart().getLine(),List.of());
        }
        List<Expression> elements = ctx.expr().stream()
                .map(this::visit)
                .toList();
        return new ListExpr(ctx.getStart().getLine(),elements);
    }

    @Override
    public Expression visitDict(FlaskExprParser.DictContext ctx) {
        if (ctx.STRING() == null || ctx.STRING().isEmpty()) {
            return new DictExpr(ctx.getStart().getLine(),Map.of());
        }

        Map<String, Expression> map = new LinkedHashMap<>();
        for (int i = 0; i < ctx.STRING().size(); i++) {
            String key = unquote(ctx.STRING(i).getText());
            Expression value = visit(ctx.expr(i));
            map.put(key, value);
        }
        return new DictExpr(ctx.getStart().getLine(),map);
    }
    @Override public Expression visitAttribute(FlaskExprParser.AttributeContext ctx) {
        Expression obj = visit(ctx.expr());
        requireParenthesesIfBinOp(obj, ctx, "attribute access");
        return new Attribute(ctx.getStart().getLine(),obj, ctx.NAME().getText());
    }

    @Override public Expression visitSubscript(FlaskExprParser.SubscriptContext ctx) {
        Expression target = visit(ctx.expr(0));
        requireParenthesesIfBinOp(target, ctx, "subscript");
        Expression index = visit(ctx.expr(1));
        return new Subscript(ctx.getStart().getLine(),target, index);
    }

    @Override
    public Expression visitMultiplication(FlaskExprParser.MultiplicationContext ctx) {
        Expression left  = visit(ctx.expr(0));
        Expression right = visit(ctx.expr(1));
        // Undeclared names are reported by SemanticAnalyzer for every expression,
        // so there is nothing operator-specific to check here.
        return binOp(ctx.getStart().getLine(),left, right, "*");
    }

    @Override
    public Expression visitDivision(FlaskExprParser.DivisionContext ctx) {
        Expression left  = visit(ctx.expr(0));
        Expression right = visit(ctx.expr(1));
        return binOp(ctx.getStart().getLine(),left, right, "/");
    }

    @Override
    public Expression visitAddition(FlaskExprParser.AdditionContext ctx) {
        Expression left  = visit(ctx.expr(0));
        Expression right = visit(ctx.expr(1));
        return binOp(ctx.getStart().getLine(),left, right, "+");
    }

    @Override
    public Expression visitSubtraction(FlaskExprParser.SubtractionContext ctx) {
        Expression left  = visit(ctx.expr(0));
        Expression right = visit(ctx.expr(1));
        return binOp(ctx.getStart().getLine(),left, right, "-");
    }

    @Override
    public Expression visitComparison(FlaskExprParser.ComparisonContext ctx) {
        Expression left  = visit(ctx.expr(0));
        Expression right = visit(ctx.expr(1));
        String opText = ctx.getChild(1).getText();  // >, <, >=, ==, etc.
        return binOp(ctx.getStart().getLine(),left, right, opText);
    }



    @Override
    public Expression visitFunctionCall(FlaskExprParser.FunctionCallContext ctx) {
        Expression called = visit(ctx.expr(0));
        String functionName = called.toString();
        if (called instanceof Attribute){
            functionName = ((Attribute) called).attribute;
        }

        Symbol declared = symbolsTable.resolve(functionName);
        boolean isDeclaredFunction = declared != null
                && (declared.getKind() == Symbol.Kind.FUNCTION || declared.getKind() == Symbol.Kind.IMPORT);
        if (!isDeclaredFunction && !builtInFunctions.contains(functionName)) {
            buildErrors.add("line " + ctx.getStart().getLine()
                    + ": function '" + functionName + "' has not been declared");
        }



        requireParenthesesIfBinOp(called, ctx, "function call");

        List<Expression> args = new ArrayList<>();
        Map<String, Expression> kwargs = new LinkedHashMap<>();



        int i = 2; // position after LPAREN
        int childCount = ctx.getChildCount();

        while (i < childCount - 1) { // stop before RPAREN
            ParseTree child = ctx.getChild(i);

            if (child.getText().equals(",")) {
                i++;
                continue;
            }

            // Case 1: Keyword argument → NAME = expr
            if (child instanceof TerminalNode nameNode
                    && nameNode.getSymbol().getType() == FlaskExprParser.NAME
                    && ctx.getChild(i + 1).getText().equals("=")
                    && ctx.getChild(i + 2) instanceof FlaskExprParser.ExprContext valueCtx) {

                String kwName = nameNode.getText();
                Expression value = visit(valueCtx);
                kwargs.put(kwName, value);

                i += 3; // skip NAME, =, expr
            }
            // Case 2: Positional argument → expr
            else if (child instanceof FlaskExprParser.ExprContext exprCtx) {
                args.add(visit(exprCtx));
                i++;
            }
            else {
                // Unexpected token — skip to avoid infinite loop
                i++;
            }
        }

        //handiling data sent to html:
        if (SendDataFunctions.contains(functionName)) {
            SymbolsTable htmlST = SymbolsTable.getHtmlInstance();
            Map<String,Object> sentVars = new LinkedHashMap<>();

            for (Map.Entry<String, Expression> entry : kwargs.entrySet()) {
                String varName = entry.getKey();
                Expression value = entry.getValue();
                // The value may be a literal or an expression with no symbol of its
                // own; fall back to the expression itself instead of throwing.
                Symbol symbol = symbolsTable.resolve(value.toString());
                Object data = (symbol != null && symbol.getValue() != null) ? symbol.getValue() : value;
                sentVars.put(varName, data);
            }
            Map<String,Object> mapVars = htmlST.getHtmlSymbol("data_sent");
            if (mapVars!=null){
                mapVars.putAll(sentVars);
            }else{
                htmlST.addHtmlSymbol("data_sent",sentVars);
            }


        }

        return new FunctionCall(ctx.getStart().getLine(),called, args, kwargs);
    }

    private static Object parseNumber(String text) {
        text = text.toLowerCase();
        if (text.startsWith("0x")) return Long.parseLong(text.substring(2), 16);
        if (text.startsWith("0b")) return Long.parseLong(text.substring(2), 2);
        if (text.startsWith("0o")) return Long.parseLong(text.substring(2), 8);

        if (text.contains(".") || text.contains("e") || text.contains("j")) {
            return Double.parseDouble(text);
        }

        try {
            return Integer.parseInt(text);
        } catch (Exception e) {
            try {
                return Long.parseLong(text);
            } catch (Exception e2) {
                return new java.math.BigInteger(text);
            }
        }
    }


    private void requireParenthesesIfBinOp(Expression expr, ParserRuleContext ctx, String operation) {
        if (ctx.getChild(0) instanceof FlaskExprParser.ParensContext) {
            return;
        }

        // Check the AST node
        if (expr instanceof BinaryOperation) {
            String source = ctx.getText();
            String leftText = ctx.getChild(0).getText();
            String hint = "(" + leftText + ")" + source.substring(leftText.length());

            buildErrors.add("SyntaxError: " + operation
                    + " requires parentheses after a binary expression: " + source
                    + "  (did you mean " + hint + " ?)");
        }
    }

    private Expression binOp(int line, Expression left, Expression right, String opToken) {
        BinaryOperation.Operator op =
                BinaryOperation.Operator.fromToken(opToken);
        return new BinaryOperation(line, left, op, right);
    }

}


