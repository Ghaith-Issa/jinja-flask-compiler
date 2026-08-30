package ASTJinja2withHTMLandCSS;

import ASTJinja2withHTMLandCSS.CSS.*;
import ASTJinja2withHTMLandCSS.CSS.Atoms.*;
import ASTJinja2withHTMLandCSS.CSS.Selectors.*;
import ASTJinja2withHTMLandCSS.Jinja2.*;
import SymbolsTable.SymbolsTable;
import antlr.grammar.Jinja2withHTMLandCSS.gen.Jinja2withHTMLandCSSParser;
import antlr.grammar.Jinja2withHTMLandCSS.gen.Jinja2withHTMLandCSSParserBaseVisitor;
import org.antlr.v4.runtime.misc.Interval;

import java.util.*;

public class BaseVisitor extends Jinja2withHTMLandCSSParserBaseVisitor<ASTNode> {
    private final SymbolsTable htmlST = SymbolsTable.getHtmlInstance();
    public final List<String> semanticErrors = new ArrayList<>();

    public BaseVisitor() {
    }

    @Override
    public ASTNode visit(org.antlr.v4.runtime.tree.ParseTree tree) {
        ASTNode node = super.visit(tree);
        if (node != null
                && tree instanceof org.antlr.v4.runtime.ParserRuleContext ctx
                && ctx.start != null && ctx.stop != null) {
            node.setSpan(ctx.start.getStartIndex(), ctx.stop.getStopIndex());
        }
        return node;
    }

    private static String originalText(org.antlr.v4.runtime.ParserRuleContext ctx) {
        if (ctx.start == null || ctx.stop == null) return ctx.getText();
        Interval span = Interval.of(ctx.start.getStartIndex(), ctx.stop.getStopIndex());
        return ctx.start.getInputStream().getText(span);
    }

    // ================================================================
    //                        Entry Points
    // ================================================================

    @Override
    public ASTNode visitHtmlEntry(Jinja2withHTMLandCSSParser.HtmlEntryContext ctx) {
        ASTNode root = visit(ctx.htmlProg());
        return new ProgramNode(ctx.start.getLine(), root);
    }

    @Override
    public ASTNode visitCssEntry(Jinja2withHTMLandCSSParser.CssEntryContext ctx) {
        ASTNode root = visit(ctx.cssProg());
        return new ProgramNode(ctx.start.getLine(), root);
    }

    // ================================================================
    //                        HTML Document
    // ================================================================

    @Override
    public ASTNode visitHtmlProg(Jinja2withHTMLandCSSParser.HtmlProgContext ctx) {
        DocumentNode doc = new DocumentNode(ctx.start.getLine());
        if (ctx.doctype() != null) {
            doc.setDoctype((DoctypeNode) visit(ctx.doctype()));
        }
        for (var c : ctx.content()) {
            ASTNode elem = visit(c);
            if (elem != null) {
                doc.addElement(elem);
            }
        }
        return doc;
    }

    @Override
    public ASTNode visitDoctype(Jinja2withHTMLandCSSParser.DoctypeContext ctx) {
        return new DoctypeNode(ctx.start.getLine());
    }

    @Override
    public ASTNode visitContent(Jinja2withHTMLandCSSParser.ContentContext ctx) {
        if (ctx.htmlElement() != null) return visit(ctx.htmlElement());
        if (ctx.jinjaExpression() != null) return visit(ctx.jinjaExpression());
        if (ctx.jinjaBlock() != null) return visit(ctx.jinjaBlock());
        if (ctx.jinjaSetStmt() != null) return visit(ctx.jinjaSetStmt());
        if (ctx.textNode() != null) return visit(ctx.textNode());
        return null;
    }

    // ================================================================
    //                        HTML Elements
    // ================================================================

    @Override
    public ASTNode visitOpenCloseTag(Jinja2withHTMLandCSSParser.OpenCloseTagContext ctx) {
        String startTag = ctx.tagName(0).getText();
        String endTag = ctx.tagName(1).getText();

        if (!startTag.equalsIgnoreCase(endTag)) {
            semanticErrors.add("Tag mismatch line: " + ctx.start.getLine()
                    + " Header: <" + startTag + "> footer: </" + endTag + ">");
        }

        ElementNode elem = new ElementNode(ctx.start.getLine(), startTag, endTag);
        for (var attrCtx : ctx.attribute()) {
            AttributeNode attr = (AttributeNode) visit(attrCtx);
            if (attr != null) {
                elem.addAttribute(attr);
                registerAttributes(attr, attrCtx.start.getLine());
            }
        }
        for (var c : ctx.content()) {
            ASTNode child = visit(c);
            if (child != null) {
                elem.addContent(child);
            }
        }
        return elem;
    }

    @Override
    public ASTNode visitSelfClosingTag(Jinja2withHTMLandCSSParser.SelfClosingTagContext ctx) {
        String tagName = ctx.tagName().getText();
        ElementNode elem = new ElementNode(ctx.start.getLine(), tagName, true);
        for (var attrCtx : ctx.attribute()) {
            AttributeNode attr = (AttributeNode) visit(attrCtx);
            if (attr != null) {
                elem.addAttribute(attr);
                registerAttributes(attr, attrCtx.start.getLine());
            }
        }
        return elem;
    }

    @Override
    public ASTNode visitVoidElement(Jinja2withHTMLandCSSParser.VoidElementContext ctx) {
        String tagName = ctx.VOID_TAG_NAME().getText();
        ElementNode elem = new ElementNode(ctx.start.getLine(), tagName, true);
        for (var attrCtx : ctx.attribute()) {
            AttributeNode attr = (AttributeNode) visit(attrCtx);
            if (attr != null) {
                elem.addAttribute(attr);
                registerAttributes(attr, attrCtx.start.getLine());
            }
        }
        return elem;
    }

    // ================================================================
    //                        Attributes
    // ================================================================

    @Override
    public ASTNode visitFullAttribute(Jinja2withHTMLandCSSParser.FullAttributeContext ctx) {
        String name = ctx.tagName().getText();
        AttributeNode attr = new AttributeNode(ctx.start.getLine(), name);
        if (ctx.attrValue() != null) {
            collectAttrValueParts(ctx.attrValue(), attr);
        }
        return attr;
    }

    @Override
    public ASTNode visitBooleanAttribute(Jinja2withHTMLandCSSParser.BooleanAttributeContext ctx) {
        return new AttributeNode(ctx.start.getLine(), ctx.tagName().getText());
    }

    private void collectAttrValueParts(Jinja2withHTMLandCSSParser.AttrValueContext ctx, AttributeNode attr) {
        if (ctx instanceof Jinja2withHTMLandCSSParser.DqAttrValueContext dq) {
            for (var part : dq.attrValuePart()) {
                if (part instanceof Jinja2withHTMLandCSSParser.AttrLiteralContext lit) {
                    attr.addValuePart(new AttrTextNode(lit.start.getLine(), lit.getText()));
                } else if (part instanceof Jinja2withHTMLandCSSParser.AttrLBraceContext lbrace) {
                    attr.addValuePart(new AttrTextNode(lbrace.start.getLine(), "{"));
                } else if (part instanceof Jinja2withHTMLandCSSParser.AttrJinjaExprContext expr) {
                    attr.addValuePart(visit(expr.jinjaExpression()));
                }
            }
        } else if (ctx instanceof Jinja2withHTMLandCSSParser.SqAttrValueContext sq) {
            for (var part : sq.sqAttrValuePart()) {
                if (part instanceof Jinja2withHTMLandCSSParser.SqAttrLiteralContext lit) {
                    attr.addValuePart(new AttrTextNode(lit.start.getLine(), lit.getText()));
                } else if (part instanceof Jinja2withHTMLandCSSParser.SqAttrLBraceContext lbrace) {
                    attr.addValuePart(new AttrTextNode(lbrace.start.getLine(), "{"));
                } else if (part instanceof Jinja2withHTMLandCSSParser.SqAttrJinjaExprContext expr) {
                    attr.addValuePart(visit(expr.jinjaExpression()));
                }
            }
        } else if (ctx instanceof Jinja2withHTMLandCSSParser.UnquotedAttrValueContext unq) {
            attr.addValuePart(new AttrTextNode(unq.start.getLine(), unq.tagName().getText()));
        }
    }

    private void registerAttributes(AttributeNode attrNode, int line) {
        String attrName = attrNode.getName().toLowerCase().trim();
        String attrValue = attrNode.getValue();

        if (attrValue != null) {
            if (attrName.equals("id")) {
                if (htmlST.getHtmlSymbol(attrValue) != null) {
                    semanticErrors.add("Line " + line + ": Duplicate ID '" + attrValue + "' detected.");
                } else {
                    Map<String, Object> details = new LinkedHashMap<>();
                    details.put("type", "id");
                    details.put("line", line);
                    htmlST.addHtmlSymbol(attrValue, details);
                }
            } else if (attrName.equals("class")) {
                String[] classes = attrValue.split("\\s+");
                for (String className : classes) {
                    if (!className.isEmpty()) {
                        Map<String, Object> details = new LinkedHashMap<>();
                        details.put("type", "class");
                        details.put("line", line);
                        htmlST.addHtmlSymbol(className, details);
                    }
                }
            }
        }
    }

    // ================================================================
    //                     Jinja Expressions {{ ... }}
    // ================================================================

    @Override
    public ASTNode visitJinjaExpression(Jinja2withHTMLandCSSParser.JinjaExpressionContext ctx) {
        JinjaExprNode expr = (JinjaExprNode) visit(ctx.jinjaExpr());
        return new JinjaExpressionNode(ctx.start.getLine(), expr);
    }

    @Override
    public ASTNode visitNameExpr(Jinja2withHTMLandCSSParser.NameExprContext ctx) {
        return new NameExprNode(ctx.start.getLine(), ctx.JINJA_ID().getText());
    }

    @Override
    public ASTNode visitMemberExpr(Jinja2withHTMLandCSSParser.MemberExprContext ctx) {
        JinjaExprNode left = (JinjaExprNode) visit(ctx.jinjaExpr());
        String id = ctx.JINJA_ID().getText();

        if (left instanceof MemberAccessNode m) {
            m.addPart(id);
            return m;
        } else if (left instanceof NameExprNode n) {
            MemberAccessNode m = new MemberAccessNode(ctx.start.getLine());
            m.addPart(n.getName());
            m.addPart(id);
            return m;
        } else {
            MemberAccessNode m = new MemberAccessNode(ctx.start.getLine());
            m.addPart(left != null ? left.asString() : "");
            m.addPart(id);
            return m;
        }
    }

    @Override
    public ASTNode visitStringLiteral(Jinja2withHTMLandCSSParser.StringLiteralContext ctx) {
        String text = ctx.JINJA_STRING().getText();
        String val = text.length() >= 2 ? text.substring(1, text.length() - 1) : text;
        return new LiteralNode(ctx.start.getLine(), val, text);
    }

    @Override
    public ASTNode visitNumberLiteral(Jinja2withHTMLandCSSParser.NumberLiteralContext ctx) {
        String text = ctx.JINJA_NUMBER().getText();
        Object val = text.contains(".") ? Double.parseDouble(text) : Long.parseLong(text);
        return new LiteralNode(ctx.start.getLine(), val, text);
    }

    @Override
    public ASTNode visitBoolLiteral(Jinja2withHTMLandCSSParser.BoolLiteralContext ctx) {
        String text = ctx.getText();
        return new LiteralNode(ctx.start.getLine(), Boolean.parseBoolean(text.toLowerCase()), text);
    }

    @Override
    public ASTNode visitNoneLiteral(Jinja2withHTMLandCSSParser.NoneLiteralContext ctx) {
        return new LiteralNode(ctx.start.getLine(), null, "none");
    }

    @Override
    public ASTNode visitFilterExpr(Jinja2withHTMLandCSSParser.FilterExprContext ctx) {
        JinjaExprNode target = (JinjaExprNode) visit(ctx.jinjaExpr());
        String filterName = ctx.JINJA_ID().getText();
        List<JinjaExprNode> args = new ArrayList<>();
        if (ctx.jinjaArgList() != null) {
            for (var argCtx : ctx.jinjaArgList().jinjaArg()) {
                args.add((JinjaExprNode) visit(argCtx.jinjaExpr()));
            }
        }
        return new FilterExprNode(ctx.start.getLine(), target, filterName, args);
    }

    @Override
    public ASTNode visitAddExpr(Jinja2withHTMLandCSSParser.AddExprContext ctx) {
        JinjaExprNode left = (JinjaExprNode) visit(ctx.jinjaExpr(0));
        JinjaExprNode right = (JinjaExprNode) visit(ctx.jinjaExpr(1));
        String op = ctx.JINJA_PLUS() != null ? "+" : "-";
        return new BinaryExprNode(ctx.start.getLine(), left, op, right);
    }

    @Override
    public ASTNode visitMultExpr(Jinja2withHTMLandCSSParser.MultExprContext ctx) {
        JinjaExprNode left = (JinjaExprNode) visit(ctx.jinjaExpr(0));
        JinjaExprNode right = (JinjaExprNode) visit(ctx.jinjaExpr(1));
        String op = ctx.getChild(1).getText();
        return new BinaryExprNode(ctx.start.getLine(), left, op, right);
    }

    @Override
    public ASTNode visitCompareExpr(Jinja2withHTMLandCSSParser.CompareExprContext ctx) {
        JinjaExprNode left = (JinjaExprNode) visit(ctx.jinjaExpr(0));
        JinjaExprNode right = (JinjaExprNode) visit(ctx.jinjaExpr(1));
        String op = ctx.getChild(1).getText();
        return new BinaryExprNode(ctx.start.getLine(), left, op, right);
    }

    @Override
    public ASTNode visitAndExpr(Jinja2withHTMLandCSSParser.AndExprContext ctx) {
        JinjaExprNode left = (JinjaExprNode) visit(ctx.jinjaExpr(0));
        JinjaExprNode right = (JinjaExprNode) visit(ctx.jinjaExpr(1));
        return new BinaryExprNode(ctx.start.getLine(), left, "and", right);
    }

    @Override
    public ASTNode visitOrExpr(Jinja2withHTMLandCSSParser.OrExprContext ctx) {
        JinjaExprNode left = (JinjaExprNode) visit(ctx.jinjaExpr(0));
        JinjaExprNode right = (JinjaExprNode) visit(ctx.jinjaExpr(1));
        return new BinaryExprNode(ctx.start.getLine(), left, "or", right);
    }

    @Override
    public ASTNode visitInExpr(Jinja2withHTMLandCSSParser.InExprContext ctx) {
        JinjaExprNode left = (JinjaExprNode) visit(ctx.jinjaExpr(0));
        JinjaExprNode right = (JinjaExprNode) visit(ctx.jinjaExpr(1));
        return new BinaryExprNode(ctx.start.getLine(), left, "in", right);
    }

    @Override
    public ASTNode visitTestExpr(Jinja2withHTMLandCSSParser.TestExprContext ctx) {
        JinjaExprNode left = (JinjaExprNode) visit(ctx.jinjaExpr());
        return new BinaryExprNode(ctx.start.getLine(), left, "is",
                new NameExprNode(ctx.start.getLine(), ctx.JINJA_ID().getText()));
    }

    @Override
    public ASTNode visitNotExpr(Jinja2withHTMLandCSSParser.NotExprContext ctx) {
        JinjaExprNode operand = (JinjaExprNode) visit(ctx.jinjaExpr());
        return new UnaryExprNode(ctx.start.getLine(), "not", operand);
    }

    @Override
    public ASTNode visitCallExpr(Jinja2withHTMLandCSSParser.CallExprContext ctx) {
        String callee = ctx.JINJA_ID().getText();
        List<CallExprNode.Arg> args = new ArrayList<>();
        if (ctx.jinjaArgList() != null) {
            for (var argCtx : ctx.jinjaArgList().jinjaArg()) {
                String kwName = argCtx.JINJA_ID() != null ? argCtx.JINJA_ID().getText() : null;
                JinjaExprNode val = (JinjaExprNode) visit(argCtx.jinjaExpr());
                args.add(new CallExprNode.Arg(kwName, val));
            }
        }
        return new CallExprNode(ctx.start.getLine(), callee, args);
    }

    @Override
    public ASTNode visitSubscriptExpr(Jinja2withHTMLandCSSParser.SubscriptExprContext ctx) {
        JinjaExprNode target = (JinjaExprNode) visit(ctx.jinjaExpr(0));
        JinjaExprNode index = (JinjaExprNode) visit(ctx.jinjaExpr(1));
        return new SubscriptExprNode(ctx.start.getLine(), target, index);
    }

    @Override
    public ASTNode visitParenExpr(Jinja2withHTMLandCSSParser.ParenExprContext ctx) {
        return visit(ctx.jinjaExpr());
    }

    // ================================================================
    //                 Statement Expressions (inside {% %})
    // ================================================================

    @Override
    public ASTNode visitStmtNameExpr(Jinja2withHTMLandCSSParser.StmtNameExprContext ctx) {
        return new NameExprNode(ctx.start.getLine(), ctx.STMT_ID().getText());
    }

    @Override
    public ASTNode visitStmtMemberExpr(Jinja2withHTMLandCSSParser.StmtMemberExprContext ctx) {
        JinjaExprNode left = (JinjaExprNode) visit(ctx.stmtExpr());
        String id = ctx.STMT_ID().getText();

        if (left instanceof MemberAccessNode m) {
            m.addPart(id);
            return m;
        } else if (left instanceof NameExprNode n) {
            MemberAccessNode m = new MemberAccessNode(ctx.start.getLine());
            m.addPart(n.getName());
            m.addPart(id);
            return m;
        } else {
            MemberAccessNode m = new MemberAccessNode(ctx.start.getLine());
            m.addPart(left != null ? left.asString() : "");
            m.addPart(id);
            return m;
        }
    }

    @Override
    public ASTNode visitStmtStringLiteral(Jinja2withHTMLandCSSParser.StmtStringLiteralContext ctx) {
        String text = ctx.STMT_STRING().getText();
        String val = text.length() >= 2 ? text.substring(1, text.length() - 1) : text;
        return new LiteralNode(ctx.start.getLine(), val, text);
    }

    @Override
    public ASTNode visitStmtNumberLiteral(Jinja2withHTMLandCSSParser.StmtNumberLiteralContext ctx) {
        String text = ctx.STMT_NUMBER().getText();
        Object val = text.contains(".") ? Double.parseDouble(text) : Long.parseLong(text);
        return new LiteralNode(ctx.start.getLine(), val, text);
    }

    @Override
    public ASTNode visitStmtBoolLiteral(Jinja2withHTMLandCSSParser.StmtBoolLiteralContext ctx) {
        String text = ctx.getText();
        return new LiteralNode(ctx.start.getLine(), Boolean.parseBoolean(text.toLowerCase()), text);
    }

    @Override
    public ASTNode visitStmtNoneLiteral(Jinja2withHTMLandCSSParser.StmtNoneLiteralContext ctx) {
        return new LiteralNode(ctx.start.getLine(), null, "none");
    }

    @Override
    public ASTNode visitStmtFilterExpr(Jinja2withHTMLandCSSParser.StmtFilterExprContext ctx) {
        JinjaExprNode target = (JinjaExprNode) visit(ctx.stmtExpr());
        String filterName = ctx.STMT_ID().getText();
        List<JinjaExprNode> args = new ArrayList<>();
        if (ctx.stmtArgList() != null) {
            for (var argCtx : ctx.stmtArgList().stmtArg()) {
                args.add((JinjaExprNode) visit(argCtx.stmtExpr()));
            }
        }
        return new FilterExprNode(ctx.start.getLine(), target, filterName, args);
    }

    @Override
    public ASTNode visitStmtAddExpr(Jinja2withHTMLandCSSParser.StmtAddExprContext ctx) {
        JinjaExprNode left = (JinjaExprNode) visit(ctx.stmtExpr(0));
        JinjaExprNode right = (JinjaExprNode) visit(ctx.stmtExpr(1));
        String op = ctx.STMT_PLUS() != null ? "+" : "-";
        return new BinaryExprNode(ctx.start.getLine(), left, op, right);
    }

    @Override
    public ASTNode visitStmtMultExpr(Jinja2withHTMLandCSSParser.StmtMultExprContext ctx) {
        JinjaExprNode left = (JinjaExprNode) visit(ctx.stmtExpr(0));
        JinjaExprNode right = (JinjaExprNode) visit(ctx.stmtExpr(1));
        String op = ctx.getChild(1).getText();
        return new BinaryExprNode(ctx.start.getLine(), left, op, right);
    }

    @Override
    public ASTNode visitStmtCompareExpr(Jinja2withHTMLandCSSParser.StmtCompareExprContext ctx) {
        JinjaExprNode left = (JinjaExprNode) visit(ctx.stmtExpr(0));
        JinjaExprNode right = (JinjaExprNode) visit(ctx.stmtExpr(1));
        String op = ctx.getChild(1).getText();
        return new BinaryExprNode(ctx.start.getLine(), left, op, right);
    }

    @Override
    public ASTNode visitStmtAndExpr(Jinja2withHTMLandCSSParser.StmtAndExprContext ctx) {
        JinjaExprNode left = (JinjaExprNode) visit(ctx.stmtExpr(0));
        JinjaExprNode right = (JinjaExprNode) visit(ctx.stmtExpr(1));
        return new BinaryExprNode(ctx.start.getLine(), left, "and", right);
    }

    @Override
    public ASTNode visitStmtOrExpr(Jinja2withHTMLandCSSParser.StmtOrExprContext ctx) {
        JinjaExprNode left = (JinjaExprNode) visit(ctx.stmtExpr(0));
        JinjaExprNode right = (JinjaExprNode) visit(ctx.stmtExpr(1));
        return new BinaryExprNode(ctx.start.getLine(), left, "or", right);
    }

    @Override
    public ASTNode visitStmtInExpr(Jinja2withHTMLandCSSParser.StmtInExprContext ctx) {
        JinjaExprNode left = (JinjaExprNode) visit(ctx.stmtExpr(0));
        JinjaExprNode right = (JinjaExprNode) visit(ctx.stmtExpr(1));
        return new BinaryExprNode(ctx.start.getLine(), left, "in", right);
    }

    @Override
    public ASTNode visitStmtTestExpr(Jinja2withHTMLandCSSParser.StmtTestExprContext ctx) {
        JinjaExprNode left = (JinjaExprNode) visit(ctx.stmtExpr());
        return new BinaryExprNode(ctx.start.getLine(), left, "is",
                new NameExprNode(ctx.start.getLine(), ctx.STMT_ID().getText()));
    }

    @Override
    public ASTNode visitStmtNotExpr(Jinja2withHTMLandCSSParser.StmtNotExprContext ctx) {
        JinjaExprNode operand = (JinjaExprNode) visit(ctx.stmtExpr());
        return new UnaryExprNode(ctx.start.getLine(), "not", operand);
    }

    @Override
    public ASTNode visitStmtCallExpr(Jinja2withHTMLandCSSParser.StmtCallExprContext ctx) {
        String callee = ctx.STMT_ID().getText();
        List<CallExprNode.Arg> args = new ArrayList<>();
        if (ctx.stmtArgList() != null) {
            for (var argCtx : ctx.stmtArgList().stmtArg()) {
                String kwName = argCtx.STMT_ID() != null ? argCtx.STMT_ID().getText() : null;
                JinjaExprNode val = (JinjaExprNode) visit(argCtx.stmtExpr());
                args.add(new CallExprNode.Arg(kwName, val));
            }
        }
        return new CallExprNode(ctx.start.getLine(), callee, args);
    }

    @Override
    public ASTNode visitStmtSubscriptExpr(Jinja2withHTMLandCSSParser.StmtSubscriptExprContext ctx) {
        JinjaExprNode target = (JinjaExprNode) visit(ctx.stmtExpr(0));
        JinjaExprNode index = (JinjaExprNode) visit(ctx.stmtExpr(1));
        return new SubscriptExprNode(ctx.start.getLine(), target, index);
    }

    @Override
    public ASTNode visitStmtParenExpr(Jinja2withHTMLandCSSParser.StmtParenExprContext ctx) {
        return visit(ctx.stmtExpr());
    }

    // ================================================================
    //                     Jinja Block Constructs
    // ================================================================

    @Override
    public ASTNode visitForBlock(Jinja2withHTMLandCSSParser.ForBlockContext ctx) {
        String iterator = ctx.jinjaForOpen().STMT_ID().getText();
        JinjaExprNode collectionExpr = (JinjaExprNode) visit(ctx.jinjaForOpen().stmtExpr());

        ForBlockNode block = new ForBlockNode(ctx.start.getLine(), iterator, collectionExpr);
        for (var c : ctx.content()) {
            ASTNode child = visit(c);
            if (child != null) {
                block.addContent(child);
            }
        }
        return block;
    }

    @Override
    public ASTNode visitIfBlock(Jinja2withHTMLandCSSParser.IfBlockContext ctx) {
        JinjaExprNode cond = (JinjaExprNode) visit(ctx.jinjaIfOpen().stmtExpr());
        IfBlockNode ifNode = new IfBlockNode(ctx.start.getLine(), cond);

        boolean inElse = false;
        int elseStartIndex = ctx.jinjaElse() != null ? ctx.jinjaElse().start.getStartIndex() : Integer.MAX_VALUE;

        for (var c : ctx.content()) {
            if (c.start.getStartIndex() >= elseStartIndex) {
                inElse = true;
            }
            ASTNode child = visit(c);
            if (child != null) {
                if (inElse) {
                    ifNode.addElse(child);
                } else {
                    ifNode.addThen(child);
                }
            }
        }
        return ifNode;
    }

    @Override
    public ASTNode visitNamedBlock(Jinja2withHTMLandCSSParser.NamedBlockContext ctx) {
        String name = ctx.jinjaBlockOpen().STMT_ID().getText();
        NamedBlockNode block = new NamedBlockNode(ctx.start.getLine(), name);
        for (var c : ctx.content()) {
            ASTNode child = visit(c);
            if (child != null) {
                block.addContent(child);
            }
        }
        return block;
    }

    @Override
    public ASTNode visitJinjaSetStmt(Jinja2withHTMLandCSSParser.JinjaSetStmtContext ctx) {
        String varName = ctx.STMT_ID().getText();
        JinjaExprNode value = (JinjaExprNode) visit(ctx.stmtExpr());
        return new SetNode(ctx.start.getLine(), varName, value);
    }

    @Override
    public ASTNode visitTextNode(Jinja2withHTMLandCSSParser.TextNodeContext ctx) {
        String text = originalText(ctx);
        if (text == null || text.trim().isEmpty()) {
            return null;
        }
        return new TextNode(ctx.start.getLine(), text.trim());
    }

    // ================================================================
    //                              CSS
    // ================================================================

    @Override
    public ASTNode visitCssProg(Jinja2withHTMLandCSSParser.CssProgContext ctx) {
        CSSProgNode prog = new CSSProgNode(ctx.start.getLine());
        for (var r : ctx.cssRule()) {
            prog.addRule((CSSRuleNode) visit(r));
        }
        return prog;
    }

    @Override
    public ASTNode visitCssRule(Jinja2withHTMLandCSSParser.CssRuleContext ctx) {
        SelectorListNode selectors = (SelectorListNode) visit(ctx.cssSelectorList());
        CSSRuleNode rule = new CSSRuleNode(ctx.start.getLine(), selectors);
        for (var d : ctx.cssDeclaration()) {
            rule.addDeclaration((CSSDeclarationNode) visit(d));
        }
        return rule;
    }

    @Override
    public ASTNode visitCssSelectorList(Jinja2withHTMLandCSSParser.CssSelectorListContext ctx) {
        SelectorListNode list = new SelectorListNode(ctx.start.getLine());
        for (var s : ctx.cssSelector()) {
            list.addSelector((SelectorChainNode) visit(s));
        }
        return list;
    }

    @Override
    public ASTNode visitCssSelector(Jinja2withHTMLandCSSParser.CssSelectorContext ctx) {
        SelectorChainNode chain = new SelectorChainNode(ctx.start.getLine());
        for (var s : ctx.cssSimpleSelector()) {
            chain.addPart((CSSSelectorNode) visit(s));
        }
        if (ctx.CSS_IDENT() != null) {
            chain.setPseudo(new PseudoClassNode(ctx.start.getLine(), ctx.CSS_IDENT().getText()));
        }
        return chain;
    }

    @Override
    public ASTNode visitCssElementSelector(Jinja2withHTMLandCSSParser.CssElementSelectorContext ctx) {
        return new ElementSelectorNode(ctx.start.getLine(), ctx.CSS_IDENT().getText());
    }

    @Override
    public ASTNode visitCssClassSelector(Jinja2withHTMLandCSSParser.CssClassSelectorContext ctx) {
        String name = ctx.CSS_IDENT().getText();
        if (htmlST.getHtmlSymbol(name) == null) {
            semanticErrors.add("Line " + ctx.start.getLine() + " Warning: CSS class ." + name + " is defined but never used in HTML.");
        }
        return new ClassSelectorNode(ctx.start.getLine(), name);
    }

    @Override
    public ASTNode visitCssIdSelector(Jinja2withHTMLandCSSParser.CssIdSelectorContext ctx) {
        String idName = ctx.CSS_IDENT().getText();
        if (htmlST.getHtmlSymbol(idName) == null) {
            semanticErrors.add("Line " + ctx.start.getLine() + " Warning: CSS ID #" + idName + " has no matching element in HTML.");
        }
        return new IdSelectorNode(ctx.start.getLine(), idName);
    }

    @Override
    public ASTNode visitCssDeclaration(Jinja2withHTMLandCSSParser.CssDeclarationContext ctx) {
        String propName = ctx.CSS_IDENT().getText();
        CSSValueNode value = (CSSValueNode) visit(ctx.cssValueList());
        return new CSSDeclarationNode(ctx.start.getLine(), propName, value);
    }

    @Override
    public ASTNode visitCssValueList(Jinja2withHTMLandCSSParser.CssValueListContext ctx) {
        CSSValueNode v = new CSSValueNode(ctx.start.getLine());
        for (var val : ctx.cssValue()) {
            ASTNode atom = visit(val);
            if (atom instanceof CSSValueAtomNode a) {
                v.addAtom(a);
            }
        }
        return v;
    }

    @Override
    public ASTNode visitCssNumberWithUnit(Jinja2withHTMLandCSSParser.CssNumberWithUnitContext ctx) {
        String num = ctx.CSS_NUMBER().getText();
        String unit = ctx.CSS_IDENT() != null ? ctx.CSS_IDENT().getText() : "";
        return new NumberAtomNode(ctx.start.getLine(), num + unit);
    }

    @Override
    public ASTNode visitCssPercentage(Jinja2withHTMLandCSSParser.CssPercentageContext ctx) {
        return new NumberAtomNode(ctx.start.getLine(), ctx.CSS_NUMBER().getText() + "%");
    }

    @Override
    public ASTNode visitCssColor(Jinja2withHTMLandCSSParser.CssColorContext ctx) {
        return new ColorAtomNode(ctx.start.getLine(), ctx.CSS_HEX_COLOR().getText());
    }

    @Override
    public ASTNode visitCssIdent(Jinja2withHTMLandCSSParser.CssIdentContext ctx) {
        return new IdentAtomNode(ctx.start.getLine(), ctx.CSS_IDENT().getText());
    }

    @Override
    public ASTNode visitCssString(Jinja2withHTMLandCSSParser.CssStringContext ctx) {
        return new IdentAtomNode(ctx.start.getLine(), ctx.CSS_STRING().getText());
    }

    @Override
    public ASTNode visitCssFunctionCall(Jinja2withHTMLandCSSParser.CssFunctionCallContext ctx) {
        return new IdentAtomNode(ctx.start.getLine(), ctx.getText());
    }

    @Override
    public ASTNode visitCssComma(Jinja2withHTMLandCSSParser.CssCommaContext ctx) {
        return new SymbolAtomNode(ctx.start.getLine(), ",");
    }

    @Override
    public ASTNode visitCssSlash(Jinja2withHTMLandCSSParser.CssSlashContext ctx) {
        return new SymbolAtomNode(ctx.start.getLine(), "/");
    }
}