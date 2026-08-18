package antlr.grammar.flask;

import FlaskStatement.Program;
import FlaskStatement.Statement;

import java.util.ArrayList;
import java.util.List;

public class AntlrToProgram extends FlaskExprParserBaseVisitor<Program> {

    private final AntlrToExpression expressionVisitor = new AntlrToExpression();

    /** Diagnostics collected while building the tree, instead of thrown. */
    public List<String> getBuildErrors() {
        return expressionVisitor.getBuildErrors();
    }

    @Override
    public Program visitProgram(FlaskExprParser.ProgramContext ctx) {
        List<Statement> statements = new ArrayList<>();

        ASTStatementsBuilderVisitor statementVisitor =
                new ASTStatementsBuilderVisitor(expressionVisitor);
        for (var stmtCtx : ctx.statement()) {
            statements.add(statementVisitor.visit(stmtCtx));
        }

        return new Program(statements);
    }
}
