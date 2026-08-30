// Generated from src/antlr/grammar/Jinja2withHTMLandCSS/Jinja2withHTMLandCSSParser.g4 by ANTLR 4.13.2
package antlr.grammar.Jinja2withHTMLandCSS.gen;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Jinja2withHTMLandCSSParser}.
 */
public interface Jinja2withHTMLandCSSParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code htmlEntry}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterHtmlEntry(Jinja2withHTMLandCSSParser.HtmlEntryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code htmlEntry}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitHtmlEntry(Jinja2withHTMLandCSSParser.HtmlEntryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cssEntry}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterCssEntry(Jinja2withHTMLandCSSParser.CssEntryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cssEntry}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitCssEntry(Jinja2withHTMLandCSSParser.CssEntryContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2withHTMLandCSSParser#htmlProg}.
	 * @param ctx the parse tree
	 */
	void enterHtmlProg(Jinja2withHTMLandCSSParser.HtmlProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2withHTMLandCSSParser#htmlProg}.
	 * @param ctx the parse tree
	 */
	void exitHtmlProg(Jinja2withHTMLandCSSParser.HtmlProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2withHTMLandCSSParser#doctype}.
	 * @param ctx the parse tree
	 */
	void enterDoctype(Jinja2withHTMLandCSSParser.DoctypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2withHTMLandCSSParser#doctype}.
	 * @param ctx the parse tree
	 */
	void exitDoctype(Jinja2withHTMLandCSSParser.DoctypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2withHTMLandCSSParser#content}.
	 * @param ctx the parse tree
	 */
	void enterContent(Jinja2withHTMLandCSSParser.ContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2withHTMLandCSSParser#content}.
	 * @param ctx the parse tree
	 */
	void exitContent(Jinja2withHTMLandCSSParser.ContentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code voidElement}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void enterVoidElement(Jinja2withHTMLandCSSParser.VoidElementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code voidElement}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void exitVoidElement(Jinja2withHTMLandCSSParser.VoidElementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code selfClosingTag}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void enterSelfClosingTag(Jinja2withHTMLandCSSParser.SelfClosingTagContext ctx);
	/**
	 * Exit a parse tree produced by the {@code selfClosingTag}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void exitSelfClosingTag(Jinja2withHTMLandCSSParser.SelfClosingTagContext ctx);
	/**
	 * Enter a parse tree produced by the {@code openCloseTag}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void enterOpenCloseTag(Jinja2withHTMLandCSSParser.OpenCloseTagContext ctx);
	/**
	 * Exit a parse tree produced by the {@code openCloseTag}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void exitOpenCloseTag(Jinja2withHTMLandCSSParser.OpenCloseTagContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2withHTMLandCSSParser#tagName}.
	 * @param ctx the parse tree
	 */
	void enterTagName(Jinja2withHTMLandCSSParser.TagNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2withHTMLandCSSParser#tagName}.
	 * @param ctx the parse tree
	 */
	void exitTagName(Jinja2withHTMLandCSSParser.TagNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fullAttribute}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterFullAttribute(Jinja2withHTMLandCSSParser.FullAttributeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fullAttribute}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitFullAttribute(Jinja2withHTMLandCSSParser.FullAttributeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code booleanAttribute}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterBooleanAttribute(Jinja2withHTMLandCSSParser.BooleanAttributeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code booleanAttribute}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitBooleanAttribute(Jinja2withHTMLandCSSParser.BooleanAttributeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dqAttrValue}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#attrValue}.
	 * @param ctx the parse tree
	 */
	void enterDqAttrValue(Jinja2withHTMLandCSSParser.DqAttrValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dqAttrValue}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#attrValue}.
	 * @param ctx the parse tree
	 */
	void exitDqAttrValue(Jinja2withHTMLandCSSParser.DqAttrValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sqAttrValue}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#attrValue}.
	 * @param ctx the parse tree
	 */
	void enterSqAttrValue(Jinja2withHTMLandCSSParser.SqAttrValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sqAttrValue}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#attrValue}.
	 * @param ctx the parse tree
	 */
	void exitSqAttrValue(Jinja2withHTMLandCSSParser.SqAttrValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unquotedAttrValue}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#attrValue}.
	 * @param ctx the parse tree
	 */
	void enterUnquotedAttrValue(Jinja2withHTMLandCSSParser.UnquotedAttrValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unquotedAttrValue}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#attrValue}.
	 * @param ctx the parse tree
	 */
	void exitUnquotedAttrValue(Jinja2withHTMLandCSSParser.UnquotedAttrValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code attrLiteral}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#attrValuePart}.
	 * @param ctx the parse tree
	 */
	void enterAttrLiteral(Jinja2withHTMLandCSSParser.AttrLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code attrLiteral}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#attrValuePart}.
	 * @param ctx the parse tree
	 */
	void exitAttrLiteral(Jinja2withHTMLandCSSParser.AttrLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code attrLBrace}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#attrValuePart}.
	 * @param ctx the parse tree
	 */
	void enterAttrLBrace(Jinja2withHTMLandCSSParser.AttrLBraceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code attrLBrace}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#attrValuePart}.
	 * @param ctx the parse tree
	 */
	void exitAttrLBrace(Jinja2withHTMLandCSSParser.AttrLBraceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code attrJinjaExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#attrValuePart}.
	 * @param ctx the parse tree
	 */
	void enterAttrJinjaExpr(Jinja2withHTMLandCSSParser.AttrJinjaExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code attrJinjaExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#attrValuePart}.
	 * @param ctx the parse tree
	 */
	void exitAttrJinjaExpr(Jinja2withHTMLandCSSParser.AttrJinjaExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sqAttrLiteral}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#sqAttrValuePart}.
	 * @param ctx the parse tree
	 */
	void enterSqAttrLiteral(Jinja2withHTMLandCSSParser.SqAttrLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sqAttrLiteral}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#sqAttrValuePart}.
	 * @param ctx the parse tree
	 */
	void exitSqAttrLiteral(Jinja2withHTMLandCSSParser.SqAttrLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sqAttrLBrace}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#sqAttrValuePart}.
	 * @param ctx the parse tree
	 */
	void enterSqAttrLBrace(Jinja2withHTMLandCSSParser.SqAttrLBraceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sqAttrLBrace}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#sqAttrValuePart}.
	 * @param ctx the parse tree
	 */
	void exitSqAttrLBrace(Jinja2withHTMLandCSSParser.SqAttrLBraceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sqAttrJinjaExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#sqAttrValuePart}.
	 * @param ctx the parse tree
	 */
	void enterSqAttrJinjaExpr(Jinja2withHTMLandCSSParser.SqAttrJinjaExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sqAttrJinjaExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#sqAttrValuePart}.
	 * @param ctx the parse tree
	 */
	void exitSqAttrJinjaExpr(Jinja2withHTMLandCSSParser.SqAttrJinjaExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2withHTMLandCSSParser#exprOpen}.
	 * @param ctx the parse tree
	 */
	void enterExprOpen(Jinja2withHTMLandCSSParser.ExprOpenContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2withHTMLandCSSParser#exprOpen}.
	 * @param ctx the parse tree
	 */
	void exitExprOpen(Jinja2withHTMLandCSSParser.ExprOpenContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2withHTMLandCSSParser#jinjaExpression}.
	 * @param ctx the parse tree
	 */
	void enterJinjaExpression(Jinja2withHTMLandCSSParser.JinjaExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2withHTMLandCSSParser#jinjaExpression}.
	 * @param ctx the parse tree
	 */
	void exitJinjaExpression(Jinja2withHTMLandCSSParser.JinjaExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code noneLiteral}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#jinjaExpr}.
	 * @param ctx the parse tree
	 */
	void enterNoneLiteral(Jinja2withHTMLandCSSParser.NoneLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code noneLiteral}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#jinjaExpr}.
	 * @param ctx the parse tree
	 */
	void exitNoneLiteral(Jinja2withHTMLandCSSParser.NoneLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subscriptExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#jinjaExpr}.
	 * @param ctx the parse tree
	 */
	void enterSubscriptExpr(Jinja2withHTMLandCSSParser.SubscriptExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subscriptExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#jinjaExpr}.
	 * @param ctx the parse tree
	 */
	void exitSubscriptExpr(Jinja2withHTMLandCSSParser.SubscriptExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#jinjaExpr}.
	 * @param ctx the parse tree
	 */
	void enterInExpr(Jinja2withHTMLandCSSParser.InExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#jinjaExpr}.
	 * @param ctx the parse tree
	 */
	void exitInExpr(Jinja2withHTMLandCSSParser.InExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code memberExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#jinjaExpr}.
	 * @param ctx the parse tree
	 */
	void enterMemberExpr(Jinja2withHTMLandCSSParser.MemberExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code memberExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#jinjaExpr}.
	 * @param ctx the parse tree
	 */
	void exitMemberExpr(Jinja2withHTMLandCSSParser.MemberExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#jinjaExpr}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(Jinja2withHTMLandCSSParser.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#jinjaExpr}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(Jinja2withHTMLandCSSParser.OrExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code filterExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#jinjaExpr}.
	 * @param ctx the parse tree
	 */
	void enterFilterExpr(Jinja2withHTMLandCSSParser.FilterExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code filterExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#jinjaExpr}.
	 * @param ctx the parse tree
	 */
	void exitFilterExpr(Jinja2withHTMLandCSSParser.FilterExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolLiteral}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#jinjaExpr}.
	 * @param ctx the parse tree
	 */
	void enterBoolLiteral(Jinja2withHTMLandCSSParser.BoolLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolLiteral}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#jinjaExpr}.
	 * @param ctx the parse tree
	 */
	void exitBoolLiteral(Jinja2withHTMLandCSSParser.BoolLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#jinjaExpr}.
	 * @param ctx the parse tree
	 */
	void enterMultExpr(Jinja2withHTMLandCSSParser.MultExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#jinjaExpr}.
	 * @param ctx the parse tree
	 */
	void exitMultExpr(Jinja2withHTMLandCSSParser.MultExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#jinjaExpr}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(Jinja2withHTMLandCSSParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#jinjaExpr}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(Jinja2withHTMLandCSSParser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nameExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#jinjaExpr}.
	 * @param ctx the parse tree
	 */
	void enterNameExpr(Jinja2withHTMLandCSSParser.NameExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nameExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#jinjaExpr}.
	 * @param ctx the parse tree
	 */
	void exitNameExpr(Jinja2withHTMLandCSSParser.NameExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#jinjaExpr}.
	 * @param ctx the parse tree
	 */
	void enterNotExpr(Jinja2withHTMLandCSSParser.NotExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#jinjaExpr}.
	 * @param ctx the parse tree
	 */
	void exitNotExpr(Jinja2withHTMLandCSSParser.NotExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringLiteral}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#jinjaExpr}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(Jinja2withHTMLandCSSParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringLiteral}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#jinjaExpr}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(Jinja2withHTMLandCSSParser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#jinjaExpr}.
	 * @param ctx the parse tree
	 */
	void enterAddExpr(Jinja2withHTMLandCSSParser.AddExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#jinjaExpr}.
	 * @param ctx the parse tree
	 */
	void exitAddExpr(Jinja2withHTMLandCSSParser.AddExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code testExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#jinjaExpr}.
	 * @param ctx the parse tree
	 */
	void enterTestExpr(Jinja2withHTMLandCSSParser.TestExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code testExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#jinjaExpr}.
	 * @param ctx the parse tree
	 */
	void exitTestExpr(Jinja2withHTMLandCSSParser.TestExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code callExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#jinjaExpr}.
	 * @param ctx the parse tree
	 */
	void enterCallExpr(Jinja2withHTMLandCSSParser.CallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code callExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#jinjaExpr}.
	 * @param ctx the parse tree
	 */
	void exitCallExpr(Jinja2withHTMLandCSSParser.CallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberLiteral}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#jinjaExpr}.
	 * @param ctx the parse tree
	 */
	void enterNumberLiteral(Jinja2withHTMLandCSSParser.NumberLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberLiteral}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#jinjaExpr}.
	 * @param ctx the parse tree
	 */
	void exitNumberLiteral(Jinja2withHTMLandCSSParser.NumberLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compareExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#jinjaExpr}.
	 * @param ctx the parse tree
	 */
	void enterCompareExpr(Jinja2withHTMLandCSSParser.CompareExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compareExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#jinjaExpr}.
	 * @param ctx the parse tree
	 */
	void exitCompareExpr(Jinja2withHTMLandCSSParser.CompareExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#jinjaExpr}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(Jinja2withHTMLandCSSParser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#jinjaExpr}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(Jinja2withHTMLandCSSParser.AndExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2withHTMLandCSSParser#jinjaArgList}.
	 * @param ctx the parse tree
	 */
	void enterJinjaArgList(Jinja2withHTMLandCSSParser.JinjaArgListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2withHTMLandCSSParser#jinjaArgList}.
	 * @param ctx the parse tree
	 */
	void exitJinjaArgList(Jinja2withHTMLandCSSParser.JinjaArgListContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2withHTMLandCSSParser#jinjaArg}.
	 * @param ctx the parse tree
	 */
	void enterJinjaArg(Jinja2withHTMLandCSSParser.JinjaArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2withHTMLandCSSParser#jinjaArg}.
	 * @param ctx the parse tree
	 */
	void exitJinjaArg(Jinja2withHTMLandCSSParser.JinjaArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2withHTMLandCSSParser#stmtOpen}.
	 * @param ctx the parse tree
	 */
	void enterStmtOpen(Jinja2withHTMLandCSSParser.StmtOpenContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2withHTMLandCSSParser#stmtOpen}.
	 * @param ctx the parse tree
	 */
	void exitStmtOpen(Jinja2withHTMLandCSSParser.StmtOpenContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2withHTMLandCSSParser#jinjaBlock}.
	 * @param ctx the parse tree
	 */
	void enterJinjaBlock(Jinja2withHTMLandCSSParser.JinjaBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2withHTMLandCSSParser#jinjaBlock}.
	 * @param ctx the parse tree
	 */
	void exitJinjaBlock(Jinja2withHTMLandCSSParser.JinjaBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2withHTMLandCSSParser#forBlock}.
	 * @param ctx the parse tree
	 */
	void enterForBlock(Jinja2withHTMLandCSSParser.ForBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2withHTMLandCSSParser#forBlock}.
	 * @param ctx the parse tree
	 */
	void exitForBlock(Jinja2withHTMLandCSSParser.ForBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2withHTMLandCSSParser#jinjaForOpen}.
	 * @param ctx the parse tree
	 */
	void enterJinjaForOpen(Jinja2withHTMLandCSSParser.JinjaForOpenContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2withHTMLandCSSParser#jinjaForOpen}.
	 * @param ctx the parse tree
	 */
	void exitJinjaForOpen(Jinja2withHTMLandCSSParser.JinjaForOpenContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2withHTMLandCSSParser#jinjaForClose}.
	 * @param ctx the parse tree
	 */
	void enterJinjaForClose(Jinja2withHTMLandCSSParser.JinjaForCloseContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2withHTMLandCSSParser#jinjaForClose}.
	 * @param ctx the parse tree
	 */
	void exitJinjaForClose(Jinja2withHTMLandCSSParser.JinjaForCloseContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2withHTMLandCSSParser#ifBlock}.
	 * @param ctx the parse tree
	 */
	void enterIfBlock(Jinja2withHTMLandCSSParser.IfBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2withHTMLandCSSParser#ifBlock}.
	 * @param ctx the parse tree
	 */
	void exitIfBlock(Jinja2withHTMLandCSSParser.IfBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2withHTMLandCSSParser#jinjaIfOpen}.
	 * @param ctx the parse tree
	 */
	void enterJinjaIfOpen(Jinja2withHTMLandCSSParser.JinjaIfOpenContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2withHTMLandCSSParser#jinjaIfOpen}.
	 * @param ctx the parse tree
	 */
	void exitJinjaIfOpen(Jinja2withHTMLandCSSParser.JinjaIfOpenContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2withHTMLandCSSParser#jinjaElse}.
	 * @param ctx the parse tree
	 */
	void enterJinjaElse(Jinja2withHTMLandCSSParser.JinjaElseContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2withHTMLandCSSParser#jinjaElse}.
	 * @param ctx the parse tree
	 */
	void exitJinjaElse(Jinja2withHTMLandCSSParser.JinjaElseContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2withHTMLandCSSParser#jinjaEndIf}.
	 * @param ctx the parse tree
	 */
	void enterJinjaEndIf(Jinja2withHTMLandCSSParser.JinjaEndIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2withHTMLandCSSParser#jinjaEndIf}.
	 * @param ctx the parse tree
	 */
	void exitJinjaEndIf(Jinja2withHTMLandCSSParser.JinjaEndIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2withHTMLandCSSParser#namedBlock}.
	 * @param ctx the parse tree
	 */
	void enterNamedBlock(Jinja2withHTMLandCSSParser.NamedBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2withHTMLandCSSParser#namedBlock}.
	 * @param ctx the parse tree
	 */
	void exitNamedBlock(Jinja2withHTMLandCSSParser.NamedBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2withHTMLandCSSParser#jinjaBlockOpen}.
	 * @param ctx the parse tree
	 */
	void enterJinjaBlockOpen(Jinja2withHTMLandCSSParser.JinjaBlockOpenContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2withHTMLandCSSParser#jinjaBlockOpen}.
	 * @param ctx the parse tree
	 */
	void exitJinjaBlockOpen(Jinja2withHTMLandCSSParser.JinjaBlockOpenContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2withHTMLandCSSParser#jinjaBlockClose}.
	 * @param ctx the parse tree
	 */
	void enterJinjaBlockClose(Jinja2withHTMLandCSSParser.JinjaBlockCloseContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2withHTMLandCSSParser#jinjaBlockClose}.
	 * @param ctx the parse tree
	 */
	void exitJinjaBlockClose(Jinja2withHTMLandCSSParser.JinjaBlockCloseContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2withHTMLandCSSParser#jinjaSetStmt}.
	 * @param ctx the parse tree
	 */
	void enterJinjaSetStmt(Jinja2withHTMLandCSSParser.JinjaSetStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2withHTMLandCSSParser#jinjaSetStmt}.
	 * @param ctx the parse tree
	 */
	void exitJinjaSetStmt(Jinja2withHTMLandCSSParser.JinjaSetStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stmtTestExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#stmtExpr}.
	 * @param ctx the parse tree
	 */
	void enterStmtTestExpr(Jinja2withHTMLandCSSParser.StmtTestExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stmtTestExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#stmtExpr}.
	 * @param ctx the parse tree
	 */
	void exitStmtTestExpr(Jinja2withHTMLandCSSParser.StmtTestExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stmtNotExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#stmtExpr}.
	 * @param ctx the parse tree
	 */
	void enterStmtNotExpr(Jinja2withHTMLandCSSParser.StmtNotExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stmtNotExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#stmtExpr}.
	 * @param ctx the parse tree
	 */
	void exitStmtNotExpr(Jinja2withHTMLandCSSParser.StmtNotExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stmtCallExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#stmtExpr}.
	 * @param ctx the parse tree
	 */
	void enterStmtCallExpr(Jinja2withHTMLandCSSParser.StmtCallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stmtCallExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#stmtExpr}.
	 * @param ctx the parse tree
	 */
	void exitStmtCallExpr(Jinja2withHTMLandCSSParser.StmtCallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stmtAddExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#stmtExpr}.
	 * @param ctx the parse tree
	 */
	void enterStmtAddExpr(Jinja2withHTMLandCSSParser.StmtAddExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stmtAddExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#stmtExpr}.
	 * @param ctx the parse tree
	 */
	void exitStmtAddExpr(Jinja2withHTMLandCSSParser.StmtAddExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stmtMemberExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#stmtExpr}.
	 * @param ctx the parse tree
	 */
	void enterStmtMemberExpr(Jinja2withHTMLandCSSParser.StmtMemberExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stmtMemberExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#stmtExpr}.
	 * @param ctx the parse tree
	 */
	void exitStmtMemberExpr(Jinja2withHTMLandCSSParser.StmtMemberExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stmtOrExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#stmtExpr}.
	 * @param ctx the parse tree
	 */
	void enterStmtOrExpr(Jinja2withHTMLandCSSParser.StmtOrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stmtOrExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#stmtExpr}.
	 * @param ctx the parse tree
	 */
	void exitStmtOrExpr(Jinja2withHTMLandCSSParser.StmtOrExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stmtStringLiteral}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#stmtExpr}.
	 * @param ctx the parse tree
	 */
	void enterStmtStringLiteral(Jinja2withHTMLandCSSParser.StmtStringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stmtStringLiteral}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#stmtExpr}.
	 * @param ctx the parse tree
	 */
	void exitStmtStringLiteral(Jinja2withHTMLandCSSParser.StmtStringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stmtFilterExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#stmtExpr}.
	 * @param ctx the parse tree
	 */
	void enterStmtFilterExpr(Jinja2withHTMLandCSSParser.StmtFilterExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stmtFilterExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#stmtExpr}.
	 * @param ctx the parse tree
	 */
	void exitStmtFilterExpr(Jinja2withHTMLandCSSParser.StmtFilterExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stmtSubscriptExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#stmtExpr}.
	 * @param ctx the parse tree
	 */
	void enterStmtSubscriptExpr(Jinja2withHTMLandCSSParser.StmtSubscriptExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stmtSubscriptExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#stmtExpr}.
	 * @param ctx the parse tree
	 */
	void exitStmtSubscriptExpr(Jinja2withHTMLandCSSParser.StmtSubscriptExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stmtParenExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#stmtExpr}.
	 * @param ctx the parse tree
	 */
	void enterStmtParenExpr(Jinja2withHTMLandCSSParser.StmtParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stmtParenExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#stmtExpr}.
	 * @param ctx the parse tree
	 */
	void exitStmtParenExpr(Jinja2withHTMLandCSSParser.StmtParenExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stmtNumberLiteral}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#stmtExpr}.
	 * @param ctx the parse tree
	 */
	void enterStmtNumberLiteral(Jinja2withHTMLandCSSParser.StmtNumberLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stmtNumberLiteral}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#stmtExpr}.
	 * @param ctx the parse tree
	 */
	void exitStmtNumberLiteral(Jinja2withHTMLandCSSParser.StmtNumberLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stmtMultExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#stmtExpr}.
	 * @param ctx the parse tree
	 */
	void enterStmtMultExpr(Jinja2withHTMLandCSSParser.StmtMultExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stmtMultExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#stmtExpr}.
	 * @param ctx the parse tree
	 */
	void exitStmtMultExpr(Jinja2withHTMLandCSSParser.StmtMultExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stmtCompareExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#stmtExpr}.
	 * @param ctx the parse tree
	 */
	void enterStmtCompareExpr(Jinja2withHTMLandCSSParser.StmtCompareExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stmtCompareExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#stmtExpr}.
	 * @param ctx the parse tree
	 */
	void exitStmtCompareExpr(Jinja2withHTMLandCSSParser.StmtCompareExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stmtNameExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#stmtExpr}.
	 * @param ctx the parse tree
	 */
	void enterStmtNameExpr(Jinja2withHTMLandCSSParser.StmtNameExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stmtNameExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#stmtExpr}.
	 * @param ctx the parse tree
	 */
	void exitStmtNameExpr(Jinja2withHTMLandCSSParser.StmtNameExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stmtInExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#stmtExpr}.
	 * @param ctx the parse tree
	 */
	void enterStmtInExpr(Jinja2withHTMLandCSSParser.StmtInExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stmtInExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#stmtExpr}.
	 * @param ctx the parse tree
	 */
	void exitStmtInExpr(Jinja2withHTMLandCSSParser.StmtInExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stmtBoolLiteral}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#stmtExpr}.
	 * @param ctx the parse tree
	 */
	void enterStmtBoolLiteral(Jinja2withHTMLandCSSParser.StmtBoolLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stmtBoolLiteral}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#stmtExpr}.
	 * @param ctx the parse tree
	 */
	void exitStmtBoolLiteral(Jinja2withHTMLandCSSParser.StmtBoolLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stmtNoneLiteral}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#stmtExpr}.
	 * @param ctx the parse tree
	 */
	void enterStmtNoneLiteral(Jinja2withHTMLandCSSParser.StmtNoneLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stmtNoneLiteral}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#stmtExpr}.
	 * @param ctx the parse tree
	 */
	void exitStmtNoneLiteral(Jinja2withHTMLandCSSParser.StmtNoneLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stmtAndExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#stmtExpr}.
	 * @param ctx the parse tree
	 */
	void enterStmtAndExpr(Jinja2withHTMLandCSSParser.StmtAndExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stmtAndExpr}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#stmtExpr}.
	 * @param ctx the parse tree
	 */
	void exitStmtAndExpr(Jinja2withHTMLandCSSParser.StmtAndExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2withHTMLandCSSParser#stmtArgList}.
	 * @param ctx the parse tree
	 */
	void enterStmtArgList(Jinja2withHTMLandCSSParser.StmtArgListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2withHTMLandCSSParser#stmtArgList}.
	 * @param ctx the parse tree
	 */
	void exitStmtArgList(Jinja2withHTMLandCSSParser.StmtArgListContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2withHTMLandCSSParser#stmtArg}.
	 * @param ctx the parse tree
	 */
	void enterStmtArg(Jinja2withHTMLandCSSParser.StmtArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2withHTMLandCSSParser#stmtArg}.
	 * @param ctx the parse tree
	 */
	void exitStmtArg(Jinja2withHTMLandCSSParser.StmtArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2withHTMLandCSSParser#textNode}.
	 * @param ctx the parse tree
	 */
	void enterTextNode(Jinja2withHTMLandCSSParser.TextNodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2withHTMLandCSSParser#textNode}.
	 * @param ctx the parse tree
	 */
	void exitTextNode(Jinja2withHTMLandCSSParser.TextNodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2withHTMLandCSSParser#cssProg}.
	 * @param ctx the parse tree
	 */
	void enterCssProg(Jinja2withHTMLandCSSParser.CssProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2withHTMLandCSSParser#cssProg}.
	 * @param ctx the parse tree
	 */
	void exitCssProg(Jinja2withHTMLandCSSParser.CssProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2withHTMLandCSSParser#cssRule}.
	 * @param ctx the parse tree
	 */
	void enterCssRule(Jinja2withHTMLandCSSParser.CssRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2withHTMLandCSSParser#cssRule}.
	 * @param ctx the parse tree
	 */
	void exitCssRule(Jinja2withHTMLandCSSParser.CssRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2withHTMLandCSSParser#cssSelectorList}.
	 * @param ctx the parse tree
	 */
	void enterCssSelectorList(Jinja2withHTMLandCSSParser.CssSelectorListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2withHTMLandCSSParser#cssSelectorList}.
	 * @param ctx the parse tree
	 */
	void exitCssSelectorList(Jinja2withHTMLandCSSParser.CssSelectorListContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2withHTMLandCSSParser#cssSelector}.
	 * @param ctx the parse tree
	 */
	void enterCssSelector(Jinja2withHTMLandCSSParser.CssSelectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2withHTMLandCSSParser#cssSelector}.
	 * @param ctx the parse tree
	 */
	void exitCssSelector(Jinja2withHTMLandCSSParser.CssSelectorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cssElementSelector}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssSimpleSelector}.
	 * @param ctx the parse tree
	 */
	void enterCssElementSelector(Jinja2withHTMLandCSSParser.CssElementSelectorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cssElementSelector}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssSimpleSelector}.
	 * @param ctx the parse tree
	 */
	void exitCssElementSelector(Jinja2withHTMLandCSSParser.CssElementSelectorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cssClassSelector}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssSimpleSelector}.
	 * @param ctx the parse tree
	 */
	void enterCssClassSelector(Jinja2withHTMLandCSSParser.CssClassSelectorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cssClassSelector}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssSimpleSelector}.
	 * @param ctx the parse tree
	 */
	void exitCssClassSelector(Jinja2withHTMLandCSSParser.CssClassSelectorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cssIdSelector}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssSimpleSelector}.
	 * @param ctx the parse tree
	 */
	void enterCssIdSelector(Jinja2withHTMLandCSSParser.CssIdSelectorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cssIdSelector}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssSimpleSelector}.
	 * @param ctx the parse tree
	 */
	void exitCssIdSelector(Jinja2withHTMLandCSSParser.CssIdSelectorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cssUniversalSelector}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssSimpleSelector}.
	 * @param ctx the parse tree
	 */
	void enterCssUniversalSelector(Jinja2withHTMLandCSSParser.CssUniversalSelectorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cssUniversalSelector}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssSimpleSelector}.
	 * @param ctx the parse tree
	 */
	void exitCssUniversalSelector(Jinja2withHTMLandCSSParser.CssUniversalSelectorContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2withHTMLandCSSParser#cssDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterCssDeclaration(Jinja2withHTMLandCSSParser.CssDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2withHTMLandCSSParser#cssDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitCssDeclaration(Jinja2withHTMLandCSSParser.CssDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2withHTMLandCSSParser#cssValueList}.
	 * @param ctx the parse tree
	 */
	void enterCssValueList(Jinja2withHTMLandCSSParser.CssValueListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2withHTMLandCSSParser#cssValueList}.
	 * @param ctx the parse tree
	 */
	void exitCssValueList(Jinja2withHTMLandCSSParser.CssValueListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cssNumberWithUnit}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssValue}.
	 * @param ctx the parse tree
	 */
	void enterCssNumberWithUnit(Jinja2withHTMLandCSSParser.CssNumberWithUnitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cssNumberWithUnit}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssValue}.
	 * @param ctx the parse tree
	 */
	void exitCssNumberWithUnit(Jinja2withHTMLandCSSParser.CssNumberWithUnitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cssPercentage}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssValue}.
	 * @param ctx the parse tree
	 */
	void enterCssPercentage(Jinja2withHTMLandCSSParser.CssPercentageContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cssPercentage}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssValue}.
	 * @param ctx the parse tree
	 */
	void exitCssPercentage(Jinja2withHTMLandCSSParser.CssPercentageContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cssColor}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssValue}.
	 * @param ctx the parse tree
	 */
	void enterCssColor(Jinja2withHTMLandCSSParser.CssColorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cssColor}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssValue}.
	 * @param ctx the parse tree
	 */
	void exitCssColor(Jinja2withHTMLandCSSParser.CssColorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cssIdent}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssValue}.
	 * @param ctx the parse tree
	 */
	void enterCssIdent(Jinja2withHTMLandCSSParser.CssIdentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cssIdent}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssValue}.
	 * @param ctx the parse tree
	 */
	void exitCssIdent(Jinja2withHTMLandCSSParser.CssIdentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cssString}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssValue}.
	 * @param ctx the parse tree
	 */
	void enterCssString(Jinja2withHTMLandCSSParser.CssStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cssString}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssValue}.
	 * @param ctx the parse tree
	 */
	void exitCssString(Jinja2withHTMLandCSSParser.CssStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cssFunctionCall}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssValue}.
	 * @param ctx the parse tree
	 */
	void enterCssFunctionCall(Jinja2withHTMLandCSSParser.CssFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cssFunctionCall}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssValue}.
	 * @param ctx the parse tree
	 */
	void exitCssFunctionCall(Jinja2withHTMLandCSSParser.CssFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cssComma}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssValue}.
	 * @param ctx the parse tree
	 */
	void enterCssComma(Jinja2withHTMLandCSSParser.CssCommaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cssComma}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssValue}.
	 * @param ctx the parse tree
	 */
	void exitCssComma(Jinja2withHTMLandCSSParser.CssCommaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cssSlash}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssValue}.
	 * @param ctx the parse tree
	 */
	void enterCssSlash(Jinja2withHTMLandCSSParser.CssSlashContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cssSlash}
	 * labeled alternative in {@link Jinja2withHTMLandCSSParser#cssValue}.
	 * @param ctx the parse tree
	 */
	void exitCssSlash(Jinja2withHTMLandCSSParser.CssSlashContext ctx);
}