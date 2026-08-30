// Generated from src/antlr/grammar/Jinja2withHTMLandCSS/Jinja2withHTMLandCSSParser.g4 by ANTLR 4.13.2
package antlr.grammar.Jinja2withHTMLandCSS.gen;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Jinja2withHTMLandCSSParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Jinja2withHTMLandCSSParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code htmlEntry}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlEntry(Jinja2withHTMLandCSSParser.HtmlEntryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cssEntry}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssEntry(Jinja2withHTMLandCSSParser.CssEntryContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2withHTMLandCSSParser#htmlProg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlProg(Jinja2withHTMLandCSSParser.HtmlProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2withHTMLandCSSParser#doctype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoctype(Jinja2withHTMLandCSSParser.DoctypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2withHTMLandCSSParser#content}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContent(Jinja2withHTMLandCSSParser.ContentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code voidElement}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#htmlElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVoidElement(Jinja2withHTMLandCSSParser.VoidElementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code selfClosingTag}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#htmlElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelfClosingTag(Jinja2withHTMLandCSSParser.SelfClosingTagContext ctx);
	/**
	 * Visit a parse tree produced by the {@code openCloseTag}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#htmlElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpenCloseTag(Jinja2withHTMLandCSSParser.OpenCloseTagContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2withHTMLandCSSParser#tagName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagName(Jinja2withHTMLandCSSParser.TagNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fullAttribute}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFullAttribute(Jinja2withHTMLandCSSParser.FullAttributeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code booleanAttribute}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanAttribute(Jinja2withHTMLandCSSParser.BooleanAttributeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dqAttrValue}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#attrValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDqAttrValue(Jinja2withHTMLandCSSParser.DqAttrValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sqAttrValue}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#attrValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSqAttrValue(Jinja2withHTMLandCSSParser.SqAttrValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unquotedAttrValue}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#attrValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnquotedAttrValue(Jinja2withHTMLandCSSParser.UnquotedAttrValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code attrLiteral}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#attrValuePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrLiteral(Jinja2withHTMLandCSSParser.AttrLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code attrLBrace}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#attrValuePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrLBrace(Jinja2withHTMLandCSSParser.AttrLBraceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code attrJinjaExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#attrValuePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrJinjaExpr(Jinja2withHTMLandCSSParser.AttrJinjaExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sqAttrLiteral}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#sqAttrValuePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSqAttrLiteral(Jinja2withHTMLandCSSParser.SqAttrLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sqAttrLBrace}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#sqAttrValuePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSqAttrLBrace(Jinja2withHTMLandCSSParser.SqAttrLBraceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sqAttrJinjaExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#sqAttrValuePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSqAttrJinjaExpr(Jinja2withHTMLandCSSParser.SqAttrJinjaExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2withHTMLandCSSParser#exprOpen}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprOpen(Jinja2withHTMLandCSSParser.ExprOpenContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2withHTMLandCSSParser#jinjaExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaExpression(Jinja2withHTMLandCSSParser.JinjaExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code noneLiteral}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#jinjaExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoneLiteral(Jinja2withHTMLandCSSParser.NoneLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subscriptExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#jinjaExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubscriptExpr(Jinja2withHTMLandCSSParser.SubscriptExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#jinjaExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInExpr(Jinja2withHTMLandCSSParser.InExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code memberExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#jinjaExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberExpr(Jinja2withHTMLandCSSParser.MemberExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#jinjaExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpr(Jinja2withHTMLandCSSParser.OrExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code filterExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#jinjaExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilterExpr(Jinja2withHTMLandCSSParser.FilterExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolLiteral}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#jinjaExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolLiteral(Jinja2withHTMLandCSSParser.BoolLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#jinjaExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultExpr(Jinja2withHTMLandCSSParser.MultExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#jinjaExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(Jinja2withHTMLandCSSParser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nameExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#jinjaExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNameExpr(Jinja2withHTMLandCSSParser.NameExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#jinjaExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpr(Jinja2withHTMLandCSSParser.NotExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringLiteral}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#jinjaExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(Jinja2withHTMLandCSSParser.StringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#jinjaExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExpr(Jinja2withHTMLandCSSParser.AddExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code testExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#jinjaExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTestExpr(Jinja2withHTMLandCSSParser.TestExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code callExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#jinjaExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallExpr(Jinja2withHTMLandCSSParser.CallExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberLiteral}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#jinjaExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberLiteral(Jinja2withHTMLandCSSParser.NumberLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compareExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#jinjaExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompareExpr(Jinja2withHTMLandCSSParser.CompareExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#jinjaExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpr(Jinja2withHTMLandCSSParser.AndExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2withHTMLandCSSParser#jinjaArgList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaArgList(Jinja2withHTMLandCSSParser.JinjaArgListContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2withHTMLandCSSParser#jinjaArg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaArg(Jinja2withHTMLandCSSParser.JinjaArgContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2withHTMLandCSSParser#stmtOpen}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtOpen(Jinja2withHTMLandCSSParser.StmtOpenContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2withHTMLandCSSParser#jinjaBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaBlock(Jinja2withHTMLandCSSParser.JinjaBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2withHTMLandCSSParser#forBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForBlock(Jinja2withHTMLandCSSParser.ForBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2withHTMLandCSSParser#jinjaForOpen}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaForOpen(Jinja2withHTMLandCSSParser.JinjaForOpenContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2withHTMLandCSSParser#jinjaForClose}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaForClose(Jinja2withHTMLandCSSParser.JinjaForCloseContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2withHTMLandCSSParser#ifBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfBlock(Jinja2withHTMLandCSSParser.IfBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2withHTMLandCSSParser#jinjaIfOpen}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaIfOpen(Jinja2withHTMLandCSSParser.JinjaIfOpenContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2withHTMLandCSSParser#jinjaElse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaElse(Jinja2withHTMLandCSSParser.JinjaElseContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2withHTMLandCSSParser#jinjaEndIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaEndIf(Jinja2withHTMLandCSSParser.JinjaEndIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2withHTMLandCSSParser#namedBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamedBlock(Jinja2withHTMLandCSSParser.NamedBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2withHTMLandCSSParser#jinjaBlockOpen}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaBlockOpen(Jinja2withHTMLandCSSParser.JinjaBlockOpenContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2withHTMLandCSSParser#jinjaBlockClose}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaBlockClose(Jinja2withHTMLandCSSParser.JinjaBlockCloseContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2withHTMLandCSSParser#jinjaSetStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaSetStmt(Jinja2withHTMLandCSSParser.JinjaSetStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stmtTestExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#stmtExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtTestExpr(Jinja2withHTMLandCSSParser.StmtTestExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stmtNotExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#stmtExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtNotExpr(Jinja2withHTMLandCSSParser.StmtNotExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stmtCallExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#stmtExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtCallExpr(Jinja2withHTMLandCSSParser.StmtCallExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stmtAddExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#stmtExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtAddExpr(Jinja2withHTMLandCSSParser.StmtAddExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stmtMemberExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#stmtExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtMemberExpr(Jinja2withHTMLandCSSParser.StmtMemberExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stmtOrExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#stmtExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtOrExpr(Jinja2withHTMLandCSSParser.StmtOrExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stmtStringLiteral}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#stmtExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtStringLiteral(Jinja2withHTMLandCSSParser.StmtStringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stmtFilterExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#stmtExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtFilterExpr(Jinja2withHTMLandCSSParser.StmtFilterExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stmtSubscriptExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#stmtExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtSubscriptExpr(Jinja2withHTMLandCSSParser.StmtSubscriptExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stmtParenExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#stmtExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtParenExpr(Jinja2withHTMLandCSSParser.StmtParenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stmtNumberLiteral}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#stmtExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtNumberLiteral(Jinja2withHTMLandCSSParser.StmtNumberLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stmtMultExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#stmtExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtMultExpr(Jinja2withHTMLandCSSParser.StmtMultExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stmtCompareExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#stmtExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtCompareExpr(Jinja2withHTMLandCSSParser.StmtCompareExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stmtNameExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#stmtExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtNameExpr(Jinja2withHTMLandCSSParser.StmtNameExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stmtInExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#stmtExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtInExpr(Jinja2withHTMLandCSSParser.StmtInExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stmtBoolLiteral}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#stmtExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtBoolLiteral(Jinja2withHTMLandCSSParser.StmtBoolLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stmtNoneLiteral}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#stmtExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtNoneLiteral(Jinja2withHTMLandCSSParser.StmtNoneLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stmtAndExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#stmtExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtAndExpr(Jinja2withHTMLandCSSParser.StmtAndExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2withHTMLandCSSParser#stmtArgList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtArgList(Jinja2withHTMLandCSSParser.StmtArgListContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2withHTMLandCSSParser#stmtArg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtArg(Jinja2withHTMLandCSSParser.StmtArgContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2withHTMLandCSSParser#textNode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextNode(Jinja2withHTMLandCSSParser.TextNodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2withHTMLandCSSParser#cssProg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssProg(Jinja2withHTMLandCSSParser.CssProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2withHTMLandCSSParser#cssRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssRule(Jinja2withHTMLandCSSParser.CssRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2withHTMLandCSSParser#cssSelectorList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssSelectorList(Jinja2withHTMLandCSSParser.CssSelectorListContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2withHTMLandCSSParser#cssSelector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssSelector(Jinja2withHTMLandCSSParser.CssSelectorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cssElementSelector}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssSimpleSelector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssElementSelector(Jinja2withHTMLandCSSParser.CssElementSelectorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cssClassSelector}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssSimpleSelector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssClassSelector(Jinja2withHTMLandCSSParser.CssClassSelectorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cssIdSelector}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssSimpleSelector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssIdSelector(Jinja2withHTMLandCSSParser.CssIdSelectorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cssUniversalSelector}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssSimpleSelector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssUniversalSelector(Jinja2withHTMLandCSSParser.CssUniversalSelectorContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2withHTMLandCSSParser#cssDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssDeclaration(Jinja2withHTMLandCSSParser.CssDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2withHTMLandCSSParser#cssValueList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssValueList(Jinja2withHTMLandCSSParser.CssValueListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cssNumberWithUnit}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssNumberWithUnit(Jinja2withHTMLandCSSParser.CssNumberWithUnitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cssPercentage}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssPercentage(Jinja2withHTMLandCSSParser.CssPercentageContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cssColor}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssColor(Jinja2withHTMLandCSSParser.CssColorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cssIdent}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssIdent(Jinja2withHTMLandCSSParser.CssIdentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cssString}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssString(Jinja2withHTMLandCSSParser.CssStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cssFunctionCall}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssFunctionCall(Jinja2withHTMLandCSSParser.CssFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cssComma}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssComma(Jinja2withHTMLandCSSParser.CssCommaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cssSlash}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssSlash(Jinja2withHTMLandCSSParser.CssSlashContext ctx);
}