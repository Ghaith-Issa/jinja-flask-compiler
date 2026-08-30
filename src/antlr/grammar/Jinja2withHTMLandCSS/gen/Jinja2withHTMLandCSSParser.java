// Generated from D:/compiler/jinja-flask-compiler/src/antlr/grammar/Jinja2withHTMLandCSS/Jinja2withHTMLandCSSParser.g4 by ANTLR 4.13.2
package antlr.grammar.Jinja2withHTMLandCSS.gen;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class Jinja2withHTMLandCSSParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		HTML_COMMENT=1, JINJA_COMMENT=2, JINJA_EXPR_OPEN=3, JINJA_STMT_OPEN=4, 
		OPEN_TAG_SLASH=5, OPEN_TAG=6, LBRACE=7, TEXT=8, TAG_WS=9, TAG_EQUALS=10, 
		TAG_BANG=11, SLASH_CLOSE=12, CLOSE_TAG=13, TAG_DQ_OPEN=14, TAG_SQ_OPEN=15, 
		VOID_TAG_NAME=16, TAG_NAME=17, ATTR_JINJA_EXPR_OPEN=18, ATTR_JINJA_STMT_OPEN=19, 
		DQ_CLOSE=20, ATTR_LBRACE=21, ATTR_TEXT=22, SQ_JINJA_EXPR_OPEN=23, SQ_JINJA_STMT_OPEN=24, 
		SQ_CLOSE=25, SQ_ATTR_LBRACE=26, SQ_ATTR_TEXT=27, JINJA_EXPR_CLOSE=28, 
		JINJA_WS=29, JINJA_DOT=30, JINJA_PIPE=31, JINJA_COMMA=32, JINJA_COLON=33, 
		JINJA_LPAREN=34, JINJA_RPAREN=35, JINJA_LBRACKET=36, JINJA_RBRACKET=37, 
		JINJA_EQ=38, JINJA_NE=39, JINJA_LE=40, JINJA_GE=41, JINJA_LT=42, JINJA_GT=43, 
		JINJA_ASSIGN=44, JINJA_PLUS=45, JINJA_MINUS=46, JINJA_STAR=47, JINJA_SLASH=48, 
		JINJA_PERCENT=49, JINJA_TRUE=50, JINJA_FALSE=51, JINJA_NONE=52, JINJA_NOT=53, 
		JINJA_AND=54, JINJA_OR=55, JINJA_IS=56, JINJA_IN=57, JINJA_STRING=58, 
		JINJA_NUMBER=59, JINJA_ID=60, JINJA_STMT_CLOSE=61, STMT_WS=62, KW_FOR=63, 
		KW_ENDFOR=64, KW_IF=65, KW_ELSE=66, KW_ENDIF=67, KW_SET=68, KW_BLOCK=69, 
		KW_ENDBLOCK=70, KW_IN=71, KW_NOT=72, KW_AND=73, KW_OR=74, KW_IS=75, STMT_TRUE=76, 
		STMT_FALSE=77, STMT_NONE=78, STMT_DOT=79, STMT_PIPE=80, STMT_COMMA=81, 
		STMT_COLON=82, STMT_LPAREN=83, STMT_RPAREN=84, STMT_LBRACKET=85, STMT_RBRACKET=86, 
		STMT_EQ=87, STMT_NE=88, STMT_LE=89, STMT_GE=90, STMT_LT=91, STMT_GT=92, 
		STMT_ASSIGN=93, STMT_PLUS=94, STMT_MINUS=95, STMT_STAR=96, STMT_SLASH=97, 
		STMT_PERCENT=98, STMT_STRING=99, STMT_NUMBER=100, STMT_ID=101, CSS_COMMENT=102, 
		CSS_WS=103, CSS_IMPORTANT=104, CSS_LCURLY=105, CSS_RCURLY=106, CSS_COLON=107, 
		CSS_SEMICOLON=108, CSS_COMMA=109, CSS_DOT=110, CSS_HASH=111, CSS_LPAREN=112, 
		CSS_RPAREN=113, CSS_STAR=114, CSS_GT=115, CSS_PLUS=116, CSS_TILDE=117, 
		CSS_PERCENT=118, CSS_SLASH=119, CSS_HEX_COLOR=120, CSS_STRING=121, CSS_NUMBER=122, 
		CSS_IDENT=123;
	public static final int
		RULE_prog = 0, RULE_htmlProg = 1, RULE_doctype = 2, RULE_content = 3, 
		RULE_htmlElement = 4, RULE_tagName = 5, RULE_attribute = 6, RULE_attrValue = 7, 
		RULE_attrValuePart = 8, RULE_sqAttrValuePart = 9, RULE_jinjaExpression = 10, 
		RULE_jinjaExpr = 11, RULE_jinjaArgList = 12, RULE_jinjaArg = 13, RULE_jinjaBlock = 14, 
		RULE_forBlock = 15, RULE_jinjaForOpen = 16, RULE_jinjaForClose = 17, RULE_ifBlock = 18, 
		RULE_jinjaIfOpen = 19, RULE_jinjaElse = 20, RULE_jinjaEndIf = 21, RULE_namedBlock = 22, 
		RULE_jinjaBlockOpen = 23, RULE_jinjaBlockClose = 24, RULE_jinjaSetStmt = 25, 
		RULE_stmtExpr = 26, RULE_stmtArgList = 27, RULE_stmtArg = 28, RULE_textNode = 29, 
		RULE_cssProg = 30, RULE_cssRule = 31, RULE_cssSelectorList = 32, RULE_cssSelector = 33, 
		RULE_cssSimpleSelector = 34, RULE_cssDeclaration = 35, RULE_cssValueList = 36, 
		RULE_cssValue = 37;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "htmlProg", "doctype", "content", "htmlElement", "tagName", "attribute", 
			"attrValue", "attrValuePart", "sqAttrValuePart", "jinjaExpression", "jinjaExpr", 
			"jinjaArgList", "jinjaArg", "jinjaBlock", "forBlock", "jinjaForOpen", 
			"jinjaForClose", "ifBlock", "jinjaIfOpen", "jinjaElse", "jinjaEndIf", 
			"namedBlock", "jinjaBlockOpen", "jinjaBlockClose", "jinjaSetStmt", "stmtExpr", 
			"stmtArgList", "stmtArg", "textNode", "cssProg", "cssRule", "cssSelectorList", 
			"cssSelector", "cssSimpleSelector", "cssDeclaration", "cssValueList", 
			"cssValue"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, "'</'", null, null, null, null, null, "'!'", 
			"'/>'", null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "'}}'", null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "'%}'", null, "'for'", "'endfor'", "'if'", "'else'", "'endif'", 
			"'set'", "'block'", "'endblock'", null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "'}'", null, "';'", null, null, "'#'", 
			null, null, null, null, null, "'~'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "HTML_COMMENT", "JINJA_COMMENT", "JINJA_EXPR_OPEN", "JINJA_STMT_OPEN", 
			"OPEN_TAG_SLASH", "OPEN_TAG", "LBRACE", "TEXT", "TAG_WS", "TAG_EQUALS", 
			"TAG_BANG", "SLASH_CLOSE", "CLOSE_TAG", "TAG_DQ_OPEN", "TAG_SQ_OPEN", 
			"VOID_TAG_NAME", "TAG_NAME", "ATTR_JINJA_EXPR_OPEN", "ATTR_JINJA_STMT_OPEN", 
			"DQ_CLOSE", "ATTR_LBRACE", "ATTR_TEXT", "SQ_JINJA_EXPR_OPEN", "SQ_JINJA_STMT_OPEN", 
			"SQ_CLOSE", "SQ_ATTR_LBRACE", "SQ_ATTR_TEXT", "JINJA_EXPR_CLOSE", "JINJA_WS", 
			"JINJA_DOT", "JINJA_PIPE", "JINJA_COMMA", "JINJA_COLON", "JINJA_LPAREN", 
			"JINJA_RPAREN", "JINJA_LBRACKET", "JINJA_RBRACKET", "JINJA_EQ", "JINJA_NE", 
			"JINJA_LE", "JINJA_GE", "JINJA_LT", "JINJA_GT", "JINJA_ASSIGN", "JINJA_PLUS", 
			"JINJA_MINUS", "JINJA_STAR", "JINJA_SLASH", "JINJA_PERCENT", "JINJA_TRUE", 
			"JINJA_FALSE", "JINJA_NONE", "JINJA_NOT", "JINJA_AND", "JINJA_OR", "JINJA_IS", 
			"JINJA_IN", "JINJA_STRING", "JINJA_NUMBER", "JINJA_ID", "JINJA_STMT_CLOSE", 
			"STMT_WS", "KW_FOR", "KW_ENDFOR", "KW_IF", "KW_ELSE", "KW_ENDIF", "KW_SET", 
			"KW_BLOCK", "KW_ENDBLOCK", "KW_IN", "KW_NOT", "KW_AND", "KW_OR", "KW_IS", 
			"STMT_TRUE", "STMT_FALSE", "STMT_NONE", "STMT_DOT", "STMT_PIPE", "STMT_COMMA", 
			"STMT_COLON", "STMT_LPAREN", "STMT_RPAREN", "STMT_LBRACKET", "STMT_RBRACKET", 
			"STMT_EQ", "STMT_NE", "STMT_LE", "STMT_GE", "STMT_LT", "STMT_GT", "STMT_ASSIGN", 
			"STMT_PLUS", "STMT_MINUS", "STMT_STAR", "STMT_SLASH", "STMT_PERCENT", 
			"STMT_STRING", "STMT_NUMBER", "STMT_ID", "CSS_COMMENT", "CSS_WS", "CSS_IMPORTANT", 
			"CSS_LCURLY", "CSS_RCURLY", "CSS_COLON", "CSS_SEMICOLON", "CSS_COMMA", 
			"CSS_DOT", "CSS_HASH", "CSS_LPAREN", "CSS_RPAREN", "CSS_STAR", "CSS_GT", 
			"CSS_PLUS", "CSS_TILDE", "CSS_PERCENT", "CSS_SLASH", "CSS_HEX_COLOR", 
			"CSS_STRING", "CSS_NUMBER", "CSS_IDENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Jinja2withHTMLandCSSParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public Jinja2withHTMLandCSSParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	 
		public ProgContext() { }
		public void copyFrom(ProgContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssEntryContext extends ProgContext {
		public CssProgContext cssProg() {
			return getRuleContext(CssProgContext.class,0);
		}
		public CssEntryContext(ProgContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterCssEntry(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitCssEntry(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitCssEntry(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class HtmlEntryContext extends ProgContext {
		public HtmlProgContext htmlProg() {
			return getRuleContext(HtmlProgContext.class,0);
		}
		public HtmlEntryContext(ProgContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterHtmlEntry(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitHtmlEntry(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitHtmlEntry(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			setState(78);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new HtmlEntryContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				htmlProg();
				}
				break;
			case 2:
				_localctx = new CssEntryContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(77);
				cssProg();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlProgContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(Jinja2withHTMLandCSSParser.EOF, 0); }
		public DoctypeContext doctype() {
			return getRuleContext(DoctypeContext.class,0);
		}
		public List<ContentContext> content() {
			return getRuleContexts(ContentContext.class);
		}
		public ContentContext content(int i) {
			return getRuleContext(ContentContext.class,i);
		}
		public HtmlProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlProg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterHtmlProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitHtmlProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitHtmlProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlProgContext htmlProg() throws RecognitionException {
		HtmlProgContext _localctx = new HtmlProgContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_htmlProg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(80);
				doctype();
				}
				break;
			}
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8651224L) != 0)) {
				{
				{
				setState(83);
				content();
				}
				}
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(89);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DoctypeContext extends ParserRuleContext {
		public TerminalNode OPEN_TAG() { return getToken(Jinja2withHTMLandCSSParser.OPEN_TAG, 0); }
		public TerminalNode TAG_BANG() { return getToken(Jinja2withHTMLandCSSParser.TAG_BANG, 0); }
		public List<TagNameContext> tagName() {
			return getRuleContexts(TagNameContext.class);
		}
		public TagNameContext tagName(int i) {
			return getRuleContext(TagNameContext.class,i);
		}
		public TerminalNode CLOSE_TAG() { return getToken(Jinja2withHTMLandCSSParser.CLOSE_TAG, 0); }
		public DoctypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doctype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterDoctype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitDoctype(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitDoctype(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoctypeContext doctype() throws RecognitionException {
		DoctypeContext _localctx = new DoctypeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_doctype);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(OPEN_TAG);
			setState(92);
			match(TAG_BANG);
			setState(93);
			tagName();
			setState(94);
			tagName();
			setState(95);
			match(CLOSE_TAG);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ContentContext extends ParserRuleContext {
		public HtmlElementContext htmlElement() {
			return getRuleContext(HtmlElementContext.class,0);
		}
		public JinjaExpressionContext jinjaExpression() {
			return getRuleContext(JinjaExpressionContext.class,0);
		}
		public JinjaBlockContext jinjaBlock() {
			return getRuleContext(JinjaBlockContext.class,0);
		}
		public JinjaSetStmtContext jinjaSetStmt() {
			return getRuleContext(JinjaSetStmtContext.class,0);
		}
		public TextNodeContext textNode() {
			return getRuleContext(TextNodeContext.class,0);
		}
		public ContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_content; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitContent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContentContext content() throws RecognitionException {
		ContentContext _localctx = new ContentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_content);
		try {
			setState(102);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(97);
				htmlElement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(98);
				jinjaExpression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(99);
				jinjaBlock();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(100);
				jinjaSetStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(101);
				textNode();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlElementContext extends ParserRuleContext {
		public HtmlElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlElement; }
	 
		public HtmlElementContext() { }
		public void copyFrom(HtmlElementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SelfClosingTagContext extends HtmlElementContext {
		public TerminalNode OPEN_TAG() { return getToken(Jinja2withHTMLandCSSParser.OPEN_TAG, 0); }
		public TagNameContext tagName() {
			return getRuleContext(TagNameContext.class,0);
		}
		public TerminalNode SLASH_CLOSE() { return getToken(Jinja2withHTMLandCSSParser.SLASH_CLOSE, 0); }
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public SelfClosingTagContext(HtmlElementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterSelfClosingTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitSelfClosingTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitSelfClosingTag(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VoidElementContext extends HtmlElementContext {
		public TerminalNode OPEN_TAG() { return getToken(Jinja2withHTMLandCSSParser.OPEN_TAG, 0); }
		public TerminalNode VOID_TAG_NAME() { return getToken(Jinja2withHTMLandCSSParser.VOID_TAG_NAME, 0); }
		public TerminalNode SLASH_CLOSE() { return getToken(Jinja2withHTMLandCSSParser.SLASH_CLOSE, 0); }
		public TerminalNode CLOSE_TAG() { return getToken(Jinja2withHTMLandCSSParser.CLOSE_TAG, 0); }
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public VoidElementContext(HtmlElementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterVoidElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitVoidElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitVoidElement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OpenCloseTagContext extends HtmlElementContext {
		public TerminalNode OPEN_TAG() { return getToken(Jinja2withHTMLandCSSParser.OPEN_TAG, 0); }
		public List<TagNameContext> tagName() {
			return getRuleContexts(TagNameContext.class);
		}
		public TagNameContext tagName(int i) {
			return getRuleContext(TagNameContext.class,i);
		}
		public List<TerminalNode> CLOSE_TAG() { return getTokens(Jinja2withHTMLandCSSParser.CLOSE_TAG); }
		public TerminalNode CLOSE_TAG(int i) {
			return getToken(Jinja2withHTMLandCSSParser.CLOSE_TAG, i);
		}
		public TerminalNode OPEN_TAG_SLASH() { return getToken(Jinja2withHTMLandCSSParser.OPEN_TAG_SLASH, 0); }
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public List<ContentContext> content() {
			return getRuleContexts(ContentContext.class);
		}
		public ContentContext content(int i) {
			return getRuleContext(ContentContext.class,i);
		}
		public OpenCloseTagContext(HtmlElementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterOpenCloseTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitOpenCloseTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitOpenCloseTag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlElementContext htmlElement() throws RecognitionException {
		HtmlElementContext _localctx = new HtmlElementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_htmlElement);
		int _la;
		try {
			setState(142);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new VoidElementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(104);
				match(OPEN_TAG);
				setState(105);
				match(VOID_TAG_NAME);
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==VOID_TAG_NAME || _la==TAG_NAME) {
					{
					{
					setState(106);
					attribute();
					}
					}
					setState(111);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(112);
				_la = _input.LA(1);
				if ( !(_la==SLASH_CLOSE || _la==CLOSE_TAG) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 2:
				_localctx = new SelfClosingTagContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(113);
				match(OPEN_TAG);
				setState(114);
				tagName();
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==VOID_TAG_NAME || _la==TAG_NAME) {
					{
					{
					setState(115);
					attribute();
					}
					}
					setState(120);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(121);
				match(SLASH_CLOSE);
				}
				break;
			case 3:
				_localctx = new OpenCloseTagContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(123);
				match(OPEN_TAG);
				setState(124);
				tagName();
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==VOID_TAG_NAME || _la==TAG_NAME) {
					{
					{
					setState(125);
					attribute();
					}
					}
					setState(130);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(131);
				match(CLOSE_TAG);
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8651224L) != 0)) {
					{
					{
					setState(132);
					content();
					}
					}
					setState(137);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(138);
				match(OPEN_TAG_SLASH);
				setState(139);
				tagName();
				setState(140);
				match(CLOSE_TAG);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TagNameContext extends ParserRuleContext {
		public TerminalNode TAG_NAME() { return getToken(Jinja2withHTMLandCSSParser.TAG_NAME, 0); }
		public TerminalNode VOID_TAG_NAME() { return getToken(Jinja2withHTMLandCSSParser.VOID_TAG_NAME, 0); }
		public TagNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tagName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterTagName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitTagName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitTagName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TagNameContext tagName() throws RecognitionException {
		TagNameContext _localctx = new TagNameContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_tagName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			_la = _input.LA(1);
			if ( !(_la==VOID_TAG_NAME || _la==TAG_NAME) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AttributeContext extends ParserRuleContext {
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
	 
		public AttributeContext() { }
		public void copyFrom(AttributeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BooleanAttributeContext extends AttributeContext {
		public TagNameContext tagName() {
			return getRuleContext(TagNameContext.class,0);
		}
		public BooleanAttributeContext(AttributeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterBooleanAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitBooleanAttribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitBooleanAttribute(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FullAttributeContext extends AttributeContext {
		public TagNameContext tagName() {
			return getRuleContext(TagNameContext.class,0);
		}
		public TerminalNode TAG_EQUALS() { return getToken(Jinja2withHTMLandCSSParser.TAG_EQUALS, 0); }
		public AttrValueContext attrValue() {
			return getRuleContext(AttrValueContext.class,0);
		}
		public FullAttributeContext(AttributeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterFullAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitFullAttribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitFullAttribute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_attribute);
		try {
			setState(151);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				_localctx = new FullAttributeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(146);
				tagName();
				setState(147);
				match(TAG_EQUALS);
				setState(148);
				attrValue();
				}
				break;
			case 2:
				_localctx = new BooleanAttributeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(150);
				tagName();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AttrValueContext extends ParserRuleContext {
		public AttrValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attrValue; }
	 
		public AttrValueContext() { }
		public void copyFrom(AttrValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnquotedAttrValueContext extends AttrValueContext {
		public TagNameContext tagName() {
			return getRuleContext(TagNameContext.class,0);
		}
		public UnquotedAttrValueContext(AttrValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterUnquotedAttrValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitUnquotedAttrValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitUnquotedAttrValue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SqAttrValueContext extends AttrValueContext {
		public TerminalNode TAG_SQ_OPEN() { return getToken(Jinja2withHTMLandCSSParser.TAG_SQ_OPEN, 0); }
		public TerminalNode SQ_CLOSE() { return getToken(Jinja2withHTMLandCSSParser.SQ_CLOSE, 0); }
		public List<SqAttrValuePartContext> sqAttrValuePart() {
			return getRuleContexts(SqAttrValuePartContext.class);
		}
		public SqAttrValuePartContext sqAttrValuePart(int i) {
			return getRuleContext(SqAttrValuePartContext.class,i);
		}
		public SqAttrValueContext(AttrValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterSqAttrValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitSqAttrValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitSqAttrValue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DqAttrValueContext extends AttrValueContext {
		public TerminalNode TAG_DQ_OPEN() { return getToken(Jinja2withHTMLandCSSParser.TAG_DQ_OPEN, 0); }
		public TerminalNode DQ_CLOSE() { return getToken(Jinja2withHTMLandCSSParser.DQ_CLOSE, 0); }
		public List<AttrValuePartContext> attrValuePart() {
			return getRuleContexts(AttrValuePartContext.class);
		}
		public AttrValuePartContext attrValuePart(int i) {
			return getRuleContext(AttrValuePartContext.class,i);
		}
		public DqAttrValueContext(AttrValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterDqAttrValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitDqAttrValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitDqAttrValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttrValueContext attrValue() throws RecognitionException {
		AttrValueContext _localctx = new AttrValueContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_attrValue);
		int _la;
		try {
			setState(170);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TAG_DQ_OPEN:
				_localctx = new DqAttrValueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(153);
				match(TAG_DQ_OPEN);
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 14942216L) != 0)) {
					{
					{
					setState(154);
					attrValuePart();
					}
					}
					setState(159);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(160);
				match(DQ_CLOSE);
				}
				break;
			case TAG_SQ_OPEN:
				_localctx = new SqAttrValueContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(161);
				match(TAG_SQ_OPEN);
				setState(165);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 209977352L) != 0)) {
					{
					{
					setState(162);
					sqAttrValuePart();
					}
					}
					setState(167);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(168);
				match(SQ_CLOSE);
				}
				break;
			case VOID_TAG_NAME:
			case TAG_NAME:
				_localctx = new UnquotedAttrValueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(169);
				tagName();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AttrValuePartContext extends ParserRuleContext {
		public AttrValuePartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attrValuePart; }
	 
		public AttrValuePartContext() { }
		public void copyFrom(AttrValuePartContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AttrLiteralContext extends AttrValuePartContext {
		public TerminalNode ATTR_TEXT() { return getToken(Jinja2withHTMLandCSSParser.ATTR_TEXT, 0); }
		public AttrLiteralContext(AttrValuePartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterAttrLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitAttrLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitAttrLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AttrLBraceContext extends AttrValuePartContext {
		public TerminalNode ATTR_LBRACE() { return getToken(Jinja2withHTMLandCSSParser.ATTR_LBRACE, 0); }
		public AttrLBraceContext(AttrValuePartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterAttrLBrace(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitAttrLBrace(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitAttrLBrace(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AttrJinjaExprContext extends AttrValuePartContext {
		public JinjaExpressionContext jinjaExpression() {
			return getRuleContext(JinjaExpressionContext.class,0);
		}
		public AttrJinjaExprContext(AttrValuePartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterAttrJinjaExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitAttrJinjaExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitAttrJinjaExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttrValuePartContext attrValuePart() throws RecognitionException {
		AttrValuePartContext _localctx = new AttrValuePartContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_attrValuePart);
		try {
			setState(175);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ATTR_TEXT:
				_localctx = new AttrLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(172);
				match(ATTR_TEXT);
				}
				break;
			case ATTR_LBRACE:
				_localctx = new AttrLBraceContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(173);
				match(ATTR_LBRACE);
				}
				break;
			case JINJA_EXPR_OPEN:
			case ATTR_JINJA_EXPR_OPEN:
			case SQ_JINJA_EXPR_OPEN:
				_localctx = new AttrJinjaExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(174);
				jinjaExpression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SqAttrValuePartContext extends ParserRuleContext {
		public SqAttrValuePartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sqAttrValuePart; }
	 
		public SqAttrValuePartContext() { }
		public void copyFrom(SqAttrValuePartContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SqAttrJinjaExprContext extends SqAttrValuePartContext {
		public JinjaExpressionContext jinjaExpression() {
			return getRuleContext(JinjaExpressionContext.class,0);
		}
		public SqAttrJinjaExprContext(SqAttrValuePartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterSqAttrJinjaExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitSqAttrJinjaExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitSqAttrJinjaExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SqAttrLBraceContext extends SqAttrValuePartContext {
		public TerminalNode SQ_ATTR_LBRACE() { return getToken(Jinja2withHTMLandCSSParser.SQ_ATTR_LBRACE, 0); }
		public SqAttrLBraceContext(SqAttrValuePartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterSqAttrLBrace(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitSqAttrLBrace(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitSqAttrLBrace(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SqAttrLiteralContext extends SqAttrValuePartContext {
		public TerminalNode SQ_ATTR_TEXT() { return getToken(Jinja2withHTMLandCSSParser.SQ_ATTR_TEXT, 0); }
		public SqAttrLiteralContext(SqAttrValuePartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterSqAttrLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitSqAttrLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitSqAttrLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SqAttrValuePartContext sqAttrValuePart() throws RecognitionException {
		SqAttrValuePartContext _localctx = new SqAttrValuePartContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_sqAttrValuePart);
		try {
			setState(180);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SQ_ATTR_TEXT:
				_localctx = new SqAttrLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(177);
				match(SQ_ATTR_TEXT);
				}
				break;
			case SQ_ATTR_LBRACE:
				_localctx = new SqAttrLBraceContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(178);
				match(SQ_ATTR_LBRACE);
				}
				break;
			case JINJA_EXPR_OPEN:
			case ATTR_JINJA_EXPR_OPEN:
			case SQ_JINJA_EXPR_OPEN:
				_localctx = new SqAttrJinjaExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(179);
				jinjaExpression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaExpressionContext extends ParserRuleContext {
		public TerminalNode JINJA_EXPR_OPEN() { return getToken(Jinja2withHTMLandCSSParser.JINJA_EXPR_OPEN, 0); }
		public JinjaExprContext jinjaExpr() {
			return getRuleContext(JinjaExprContext.class,0);
		}
		public TerminalNode JINJA_EXPR_CLOSE() { return getToken(Jinja2withHTMLandCSSParser.JINJA_EXPR_CLOSE, 0); }
		public TerminalNode ATTR_JINJA_EXPR_OPEN() { return getToken(Jinja2withHTMLandCSSParser.ATTR_JINJA_EXPR_OPEN, 0); }
		public TerminalNode SQ_JINJA_EXPR_OPEN() { return getToken(Jinja2withHTMLandCSSParser.SQ_JINJA_EXPR_OPEN, 0); }
		public JinjaExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterJinjaExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitJinjaExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitJinjaExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaExpressionContext jinjaExpression() throws RecognitionException {
		JinjaExpressionContext _localctx = new JinjaExpressionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_jinjaExpression);
		try {
			setState(194);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case JINJA_EXPR_OPEN:
				enterOuterAlt(_localctx, 1);
				{
				setState(182);
				match(JINJA_EXPR_OPEN);
				setState(183);
				jinjaExpr(0);
				setState(184);
				match(JINJA_EXPR_CLOSE);
				}
				break;
			case ATTR_JINJA_EXPR_OPEN:
				enterOuterAlt(_localctx, 2);
				{
				setState(186);
				match(ATTR_JINJA_EXPR_OPEN);
				setState(187);
				jinjaExpr(0);
				setState(188);
				match(JINJA_EXPR_CLOSE);
				}
				break;
			case SQ_JINJA_EXPR_OPEN:
				enterOuterAlt(_localctx, 3);
				{
				setState(190);
				match(SQ_JINJA_EXPR_OPEN);
				setState(191);
				jinjaExpr(0);
				setState(192);
				match(JINJA_EXPR_CLOSE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaExprContext extends ParserRuleContext {
		public JinjaExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaExpr; }
	 
		public JinjaExprContext() { }
		public void copyFrom(JinjaExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NoneLiteralContext extends JinjaExprContext {
		public TerminalNode JINJA_NONE() { return getToken(Jinja2withHTMLandCSSParser.JINJA_NONE, 0); }
		public NoneLiteralContext(JinjaExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterNoneLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitNoneLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitNoneLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SubscriptExprContext extends JinjaExprContext {
		public List<JinjaExprContext> jinjaExpr() {
			return getRuleContexts(JinjaExprContext.class);
		}
		public JinjaExprContext jinjaExpr(int i) {
			return getRuleContext(JinjaExprContext.class,i);
		}
		public TerminalNode JINJA_LBRACKET() { return getToken(Jinja2withHTMLandCSSParser.JINJA_LBRACKET, 0); }
		public TerminalNode JINJA_RBRACKET() { return getToken(Jinja2withHTMLandCSSParser.JINJA_RBRACKET, 0); }
		public SubscriptExprContext(JinjaExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterSubscriptExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitSubscriptExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitSubscriptExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InExprContext extends JinjaExprContext {
		public List<JinjaExprContext> jinjaExpr() {
			return getRuleContexts(JinjaExprContext.class);
		}
		public JinjaExprContext jinjaExpr(int i) {
			return getRuleContext(JinjaExprContext.class,i);
		}
		public TerminalNode JINJA_IN() { return getToken(Jinja2withHTMLandCSSParser.JINJA_IN, 0); }
		public InExprContext(JinjaExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterInExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitInExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitInExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MemberExprContext extends JinjaExprContext {
		public JinjaExprContext jinjaExpr() {
			return getRuleContext(JinjaExprContext.class,0);
		}
		public TerminalNode JINJA_DOT() { return getToken(Jinja2withHTMLandCSSParser.JINJA_DOT, 0); }
		public TerminalNode JINJA_ID() { return getToken(Jinja2withHTMLandCSSParser.JINJA_ID, 0); }
		public MemberExprContext(JinjaExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterMemberExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitMemberExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitMemberExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrExprContext extends JinjaExprContext {
		public List<JinjaExprContext> jinjaExpr() {
			return getRuleContexts(JinjaExprContext.class);
		}
		public JinjaExprContext jinjaExpr(int i) {
			return getRuleContext(JinjaExprContext.class,i);
		}
		public TerminalNode JINJA_OR() { return getToken(Jinja2withHTMLandCSSParser.JINJA_OR, 0); }
		public OrExprContext(JinjaExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterOrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitOrExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitOrExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FilterExprContext extends JinjaExprContext {
		public JinjaExprContext jinjaExpr() {
			return getRuleContext(JinjaExprContext.class,0);
		}
		public TerminalNode JINJA_PIPE() { return getToken(Jinja2withHTMLandCSSParser.JINJA_PIPE, 0); }
		public TerminalNode JINJA_ID() { return getToken(Jinja2withHTMLandCSSParser.JINJA_ID, 0); }
		public TerminalNode JINJA_LPAREN() { return getToken(Jinja2withHTMLandCSSParser.JINJA_LPAREN, 0); }
		public TerminalNode JINJA_RPAREN() { return getToken(Jinja2withHTMLandCSSParser.JINJA_RPAREN, 0); }
		public JinjaArgListContext jinjaArgList() {
			return getRuleContext(JinjaArgListContext.class,0);
		}
		public FilterExprContext(JinjaExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterFilterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitFilterExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitFilterExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BoolLiteralContext extends JinjaExprContext {
		public TerminalNode JINJA_TRUE() { return getToken(Jinja2withHTMLandCSSParser.JINJA_TRUE, 0); }
		public TerminalNode JINJA_FALSE() { return getToken(Jinja2withHTMLandCSSParser.JINJA_FALSE, 0); }
		public BoolLiteralContext(JinjaExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterBoolLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitBoolLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitBoolLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultExprContext extends JinjaExprContext {
		public List<JinjaExprContext> jinjaExpr() {
			return getRuleContexts(JinjaExprContext.class);
		}
		public JinjaExprContext jinjaExpr(int i) {
			return getRuleContext(JinjaExprContext.class,i);
		}
		public TerminalNode JINJA_STAR() { return getToken(Jinja2withHTMLandCSSParser.JINJA_STAR, 0); }
		public TerminalNode JINJA_SLASH() { return getToken(Jinja2withHTMLandCSSParser.JINJA_SLASH, 0); }
		public TerminalNode JINJA_PERCENT() { return getToken(Jinja2withHTMLandCSSParser.JINJA_PERCENT, 0); }
		public MultExprContext(JinjaExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterMultExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitMultExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitMultExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenExprContext extends JinjaExprContext {
		public TerminalNode JINJA_LPAREN() { return getToken(Jinja2withHTMLandCSSParser.JINJA_LPAREN, 0); }
		public JinjaExprContext jinjaExpr() {
			return getRuleContext(JinjaExprContext.class,0);
		}
		public TerminalNode JINJA_RPAREN() { return getToken(Jinja2withHTMLandCSSParser.JINJA_RPAREN, 0); }
		public ParenExprContext(JinjaExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterParenExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitParenExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitParenExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NameExprContext extends JinjaExprContext {
		public TerminalNode JINJA_ID() { return getToken(Jinja2withHTMLandCSSParser.JINJA_ID, 0); }
		public NameExprContext(JinjaExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterNameExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitNameExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitNameExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotExprContext extends JinjaExprContext {
		public TerminalNode JINJA_NOT() { return getToken(Jinja2withHTMLandCSSParser.JINJA_NOT, 0); }
		public JinjaExprContext jinjaExpr() {
			return getRuleContext(JinjaExprContext.class,0);
		}
		public NotExprContext(JinjaExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterNotExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitNotExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitNotExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringLiteralContext extends JinjaExprContext {
		public TerminalNode JINJA_STRING() { return getToken(Jinja2withHTMLandCSSParser.JINJA_STRING, 0); }
		public StringLiteralContext(JinjaExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitStringLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddExprContext extends JinjaExprContext {
		public List<JinjaExprContext> jinjaExpr() {
			return getRuleContexts(JinjaExprContext.class);
		}
		public JinjaExprContext jinjaExpr(int i) {
			return getRuleContext(JinjaExprContext.class,i);
		}
		public TerminalNode JINJA_PLUS() { return getToken(Jinja2withHTMLandCSSParser.JINJA_PLUS, 0); }
		public TerminalNode JINJA_MINUS() { return getToken(Jinja2withHTMLandCSSParser.JINJA_MINUS, 0); }
		public AddExprContext(JinjaExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterAddExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitAddExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitAddExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TestExprContext extends JinjaExprContext {
		public JinjaExprContext jinjaExpr() {
			return getRuleContext(JinjaExprContext.class,0);
		}
		public TerminalNode JINJA_IS() { return getToken(Jinja2withHTMLandCSSParser.JINJA_IS, 0); }
		public TerminalNode JINJA_ID() { return getToken(Jinja2withHTMLandCSSParser.JINJA_ID, 0); }
		public TestExprContext(JinjaExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterTestExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitTestExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitTestExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CallExprContext extends JinjaExprContext {
		public TerminalNode JINJA_ID() { return getToken(Jinja2withHTMLandCSSParser.JINJA_ID, 0); }
		public TerminalNode JINJA_LPAREN() { return getToken(Jinja2withHTMLandCSSParser.JINJA_LPAREN, 0); }
		public TerminalNode JINJA_RPAREN() { return getToken(Jinja2withHTMLandCSSParser.JINJA_RPAREN, 0); }
		public JinjaArgListContext jinjaArgList() {
			return getRuleContext(JinjaArgListContext.class,0);
		}
		public CallExprContext(JinjaExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterCallExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitCallExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitCallExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumberLiteralContext extends JinjaExprContext {
		public TerminalNode JINJA_NUMBER() { return getToken(Jinja2withHTMLandCSSParser.JINJA_NUMBER, 0); }
		public NumberLiteralContext(JinjaExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterNumberLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitNumberLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitNumberLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CompareExprContext extends JinjaExprContext {
		public List<JinjaExprContext> jinjaExpr() {
			return getRuleContexts(JinjaExprContext.class);
		}
		public JinjaExprContext jinjaExpr(int i) {
			return getRuleContext(JinjaExprContext.class,i);
		}
		public TerminalNode JINJA_EQ() { return getToken(Jinja2withHTMLandCSSParser.JINJA_EQ, 0); }
		public TerminalNode JINJA_NE() { return getToken(Jinja2withHTMLandCSSParser.JINJA_NE, 0); }
		public TerminalNode JINJA_LT() { return getToken(Jinja2withHTMLandCSSParser.JINJA_LT, 0); }
		public TerminalNode JINJA_GT() { return getToken(Jinja2withHTMLandCSSParser.JINJA_GT, 0); }
		public TerminalNode JINJA_LE() { return getToken(Jinja2withHTMLandCSSParser.JINJA_LE, 0); }
		public TerminalNode JINJA_GE() { return getToken(Jinja2withHTMLandCSSParser.JINJA_GE, 0); }
		public CompareExprContext(JinjaExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterCompareExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitCompareExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitCompareExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndExprContext extends JinjaExprContext {
		public List<JinjaExprContext> jinjaExpr() {
			return getRuleContexts(JinjaExprContext.class);
		}
		public JinjaExprContext jinjaExpr(int i) {
			return getRuleContext(JinjaExprContext.class,i);
		}
		public TerminalNode JINJA_AND() { return getToken(Jinja2withHTMLandCSSParser.JINJA_AND, 0); }
		public AndExprContext(JinjaExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterAndExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitAndExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitAndExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaExprContext jinjaExpr() throws RecognitionException {
		return jinjaExpr(0);
	}

	private JinjaExprContext jinjaExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		JinjaExprContext _localctx = new JinjaExprContext(_ctx, _parentState);
		JinjaExprContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_jinjaExpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(197);
				match(JINJA_NOT);
				setState(198);
				jinjaExpr(10);
				}
				break;
			case 2:
				{
				_localctx = new CallExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(199);
				match(JINJA_ID);
				setState(200);
				match(JINJA_LPAREN);
				setState(202);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2034501148844490752L) != 0)) {
					{
					setState(201);
					jinjaArgList();
					}
				}

				setState(204);
				match(JINJA_RPAREN);
				}
				break;
			case 3:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(205);
				match(JINJA_LPAREN);
				setState(206);
				jinjaExpr(0);
				setState(207);
				match(JINJA_RPAREN);
				}
				break;
			case 4:
				{
				_localctx = new NameExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(209);
				match(JINJA_ID);
				}
				break;
			case 5:
				{
				_localctx = new StringLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(210);
				match(JINJA_STRING);
				}
				break;
			case 6:
				{
				_localctx = new NumberLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(211);
				match(JINJA_NUMBER);
				}
				break;
			case 7:
				{
				_localctx = new BoolLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(212);
				_la = _input.LA(1);
				if ( !(_la==JINJA_TRUE || _la==JINJA_FALSE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 8:
				{
				_localctx = new NoneLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(213);
				match(JINJA_NONE);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(257);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(255);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						_localctx = new MultExprContext(new JinjaExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_jinjaExpr);
						setState(216);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(217);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 985162418487296L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(218);
						jinjaExpr(16);
						}
						break;
					case 2:
						{
						_localctx = new AddExprContext(new JinjaExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_jinjaExpr);
						setState(219);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(220);
						_la = _input.LA(1);
						if ( !(_la==JINJA_PLUS || _la==JINJA_MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(221);
						jinjaExpr(15);
						}
						break;
					case 3:
						{
						_localctx = new CompareExprContext(new JinjaExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_jinjaExpr);
						setState(222);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(223);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 17317308137472L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(224);
						jinjaExpr(14);
						}
						break;
					case 4:
						{
						_localctx = new InExprContext(new JinjaExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_jinjaExpr);
						setState(225);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(226);
						match(JINJA_IN);
						setState(227);
						jinjaExpr(12);
						}
						break;
					case 5:
						{
						_localctx = new AndExprContext(new JinjaExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_jinjaExpr);
						setState(228);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(229);
						match(JINJA_AND);
						setState(230);
						jinjaExpr(10);
						}
						break;
					case 6:
						{
						_localctx = new OrExprContext(new JinjaExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_jinjaExpr);
						setState(231);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(232);
						match(JINJA_OR);
						setState(233);
						jinjaExpr(9);
						}
						break;
					case 7:
						{
						_localctx = new FilterExprContext(new JinjaExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_jinjaExpr);
						setState(234);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(235);
						match(JINJA_PIPE);
						setState(236);
						match(JINJA_ID);
						setState(242);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
						case 1:
							{
							setState(237);
							match(JINJA_LPAREN);
							setState(239);
							_errHandler.sync(this);
							_la = _input.LA(1);
							if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2034501148844490752L) != 0)) {
								{
								setState(238);
								jinjaArgList();
								}
							}

							setState(241);
							match(JINJA_RPAREN);
							}
							break;
						}
						}
						break;
					case 8:
						{
						_localctx = new MemberExprContext(new JinjaExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_jinjaExpr);
						setState(244);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(245);
						match(JINJA_DOT);
						setState(246);
						match(JINJA_ID);
						}
						break;
					case 9:
						{
						_localctx = new SubscriptExprContext(new JinjaExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_jinjaExpr);
						setState(247);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(248);
						match(JINJA_LBRACKET);
						setState(249);
						jinjaExpr(0);
						setState(250);
						match(JINJA_RBRACKET);
						}
						break;
					case 10:
						{
						_localctx = new TestExprContext(new JinjaExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_jinjaExpr);
						setState(252);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(253);
						match(JINJA_IS);
						setState(254);
						match(JINJA_ID);
						}
						break;
					}
					} 
				}
				setState(259);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaArgListContext extends ParserRuleContext {
		public List<JinjaArgContext> jinjaArg() {
			return getRuleContexts(JinjaArgContext.class);
		}
		public JinjaArgContext jinjaArg(int i) {
			return getRuleContext(JinjaArgContext.class,i);
		}
		public List<TerminalNode> JINJA_COMMA() { return getTokens(Jinja2withHTMLandCSSParser.JINJA_COMMA); }
		public TerminalNode JINJA_COMMA(int i) {
			return getToken(Jinja2withHTMLandCSSParser.JINJA_COMMA, i);
		}
		public JinjaArgListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaArgList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterJinjaArgList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitJinjaArgList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitJinjaArgList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaArgListContext jinjaArgList() throws RecognitionException {
		JinjaArgListContext _localctx = new JinjaArgListContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_jinjaArgList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			jinjaArg();
			setState(265);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==JINJA_COMMA) {
				{
				{
				setState(261);
				match(JINJA_COMMA);
				setState(262);
				jinjaArg();
				}
				}
				setState(267);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaArgContext extends ParserRuleContext {
		public JinjaExprContext jinjaExpr() {
			return getRuleContext(JinjaExprContext.class,0);
		}
		public TerminalNode JINJA_ID() { return getToken(Jinja2withHTMLandCSSParser.JINJA_ID, 0); }
		public TerminalNode JINJA_ASSIGN() { return getToken(Jinja2withHTMLandCSSParser.JINJA_ASSIGN, 0); }
		public JinjaArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaArg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterJinjaArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitJinjaArg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitJinjaArg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaArgContext jinjaArg() throws RecognitionException {
		JinjaArgContext _localctx = new JinjaArgContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_jinjaArg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(268);
				match(JINJA_ID);
				setState(269);
				match(JINJA_ASSIGN);
				}
				break;
			}
			setState(272);
			jinjaExpr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaBlockContext extends ParserRuleContext {
		public ForBlockContext forBlock() {
			return getRuleContext(ForBlockContext.class,0);
		}
		public IfBlockContext ifBlock() {
			return getRuleContext(IfBlockContext.class,0);
		}
		public NamedBlockContext namedBlock() {
			return getRuleContext(NamedBlockContext.class,0);
		}
		public JinjaBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterJinjaBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitJinjaBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitJinjaBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaBlockContext jinjaBlock() throws RecognitionException {
		JinjaBlockContext _localctx = new JinjaBlockContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_jinjaBlock);
		try {
			setState(277);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(274);
				forBlock();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(275);
				ifBlock();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(276);
				namedBlock();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForBlockContext extends ParserRuleContext {
		public JinjaForOpenContext jinjaForOpen() {
			return getRuleContext(JinjaForOpenContext.class,0);
		}
		public JinjaForCloseContext jinjaForClose() {
			return getRuleContext(JinjaForCloseContext.class,0);
		}
		public List<ContentContext> content() {
			return getRuleContexts(ContentContext.class);
		}
		public ContentContext content(int i) {
			return getRuleContext(ContentContext.class,i);
		}
		public ForBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterForBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitForBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitForBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForBlockContext forBlock() throws RecognitionException {
		ForBlockContext _localctx = new ForBlockContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_forBlock);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			jinjaForOpen();
			setState(283);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(280);
					content();
					}
					} 
				}
				setState(285);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			}
			setState(286);
			jinjaForClose();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaForOpenContext extends ParserRuleContext {
		public TerminalNode JINJA_STMT_OPEN() { return getToken(Jinja2withHTMLandCSSParser.JINJA_STMT_OPEN, 0); }
		public TerminalNode KW_FOR() { return getToken(Jinja2withHTMLandCSSParser.KW_FOR, 0); }
		public TerminalNode STMT_ID() { return getToken(Jinja2withHTMLandCSSParser.STMT_ID, 0); }
		public TerminalNode KW_IN() { return getToken(Jinja2withHTMLandCSSParser.KW_IN, 0); }
		public StmtExprContext stmtExpr() {
			return getRuleContext(StmtExprContext.class,0);
		}
		public TerminalNode JINJA_STMT_CLOSE() { return getToken(Jinja2withHTMLandCSSParser.JINJA_STMT_CLOSE, 0); }
		public JinjaForOpenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaForOpen; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterJinjaForOpen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitJinjaForOpen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitJinjaForOpen(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaForOpenContext jinjaForOpen() throws RecognitionException {
		JinjaForOpenContext _localctx = new JinjaForOpenContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_jinjaForOpen);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			match(JINJA_STMT_OPEN);
			setState(289);
			match(KW_FOR);
			setState(290);
			match(STMT_ID);
			setState(291);
			match(KW_IN);
			setState(292);
			stmtExpr(0);
			setState(293);
			match(JINJA_STMT_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaForCloseContext extends ParserRuleContext {
		public TerminalNode JINJA_STMT_OPEN() { return getToken(Jinja2withHTMLandCSSParser.JINJA_STMT_OPEN, 0); }
		public TerminalNode KW_ENDFOR() { return getToken(Jinja2withHTMLandCSSParser.KW_ENDFOR, 0); }
		public TerminalNode JINJA_STMT_CLOSE() { return getToken(Jinja2withHTMLandCSSParser.JINJA_STMT_CLOSE, 0); }
		public JinjaForCloseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaForClose; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterJinjaForClose(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitJinjaForClose(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitJinjaForClose(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaForCloseContext jinjaForClose() throws RecognitionException {
		JinjaForCloseContext _localctx = new JinjaForCloseContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_jinjaForClose);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(295);
			match(JINJA_STMT_OPEN);
			setState(296);
			match(KW_ENDFOR);
			setState(297);
			match(JINJA_STMT_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfBlockContext extends ParserRuleContext {
		public JinjaIfOpenContext jinjaIfOpen() {
			return getRuleContext(JinjaIfOpenContext.class,0);
		}
		public JinjaEndIfContext jinjaEndIf() {
			return getRuleContext(JinjaEndIfContext.class,0);
		}
		public List<ContentContext> content() {
			return getRuleContexts(ContentContext.class);
		}
		public ContentContext content(int i) {
			return getRuleContext(ContentContext.class,i);
		}
		public JinjaElseContext jinjaElse() {
			return getRuleContext(JinjaElseContext.class,0);
		}
		public IfBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterIfBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitIfBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitIfBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfBlockContext ifBlock() throws RecognitionException {
		IfBlockContext _localctx = new IfBlockContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_ifBlock);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
			jinjaIfOpen();
			setState(303);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(300);
					content();
					}
					} 
				}
				setState(305);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			}
			setState(313);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(306);
				jinjaElse();
				setState(310);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(307);
						content();
						}
						} 
					}
					setState(312);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
				}
				}
				break;
			}
			setState(315);
			jinjaEndIf();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaIfOpenContext extends ParserRuleContext {
		public TerminalNode JINJA_STMT_OPEN() { return getToken(Jinja2withHTMLandCSSParser.JINJA_STMT_OPEN, 0); }
		public TerminalNode KW_IF() { return getToken(Jinja2withHTMLandCSSParser.KW_IF, 0); }
		public StmtExprContext stmtExpr() {
			return getRuleContext(StmtExprContext.class,0);
		}
		public TerminalNode JINJA_STMT_CLOSE() { return getToken(Jinja2withHTMLandCSSParser.JINJA_STMT_CLOSE, 0); }
		public JinjaIfOpenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaIfOpen; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterJinjaIfOpen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitJinjaIfOpen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitJinjaIfOpen(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaIfOpenContext jinjaIfOpen() throws RecognitionException {
		JinjaIfOpenContext _localctx = new JinjaIfOpenContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_jinjaIfOpen);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(317);
			match(JINJA_STMT_OPEN);
			setState(318);
			match(KW_IF);
			setState(319);
			stmtExpr(0);
			setState(320);
			match(JINJA_STMT_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaElseContext extends ParserRuleContext {
		public TerminalNode JINJA_STMT_OPEN() { return getToken(Jinja2withHTMLandCSSParser.JINJA_STMT_OPEN, 0); }
		public TerminalNode KW_ELSE() { return getToken(Jinja2withHTMLandCSSParser.KW_ELSE, 0); }
		public TerminalNode JINJA_STMT_CLOSE() { return getToken(Jinja2withHTMLandCSSParser.JINJA_STMT_CLOSE, 0); }
		public JinjaElseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaElse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterJinjaElse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitJinjaElse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitJinjaElse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaElseContext jinjaElse() throws RecognitionException {
		JinjaElseContext _localctx = new JinjaElseContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_jinjaElse);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(322);
			match(JINJA_STMT_OPEN);
			setState(323);
			match(KW_ELSE);
			setState(324);
			match(JINJA_STMT_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaEndIfContext extends ParserRuleContext {
		public TerminalNode JINJA_STMT_OPEN() { return getToken(Jinja2withHTMLandCSSParser.JINJA_STMT_OPEN, 0); }
		public TerminalNode KW_ENDIF() { return getToken(Jinja2withHTMLandCSSParser.KW_ENDIF, 0); }
		public TerminalNode JINJA_STMT_CLOSE() { return getToken(Jinja2withHTMLandCSSParser.JINJA_STMT_CLOSE, 0); }
		public JinjaEndIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaEndIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterJinjaEndIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitJinjaEndIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitJinjaEndIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaEndIfContext jinjaEndIf() throws RecognitionException {
		JinjaEndIfContext _localctx = new JinjaEndIfContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_jinjaEndIf);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
			match(JINJA_STMT_OPEN);
			setState(327);
			match(KW_ENDIF);
			setState(328);
			match(JINJA_STMT_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NamedBlockContext extends ParserRuleContext {
		public JinjaBlockOpenContext jinjaBlockOpen() {
			return getRuleContext(JinjaBlockOpenContext.class,0);
		}
		public JinjaBlockCloseContext jinjaBlockClose() {
			return getRuleContext(JinjaBlockCloseContext.class,0);
		}
		public List<ContentContext> content() {
			return getRuleContexts(ContentContext.class);
		}
		public ContentContext content(int i) {
			return getRuleContext(ContentContext.class,i);
		}
		public NamedBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namedBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterNamedBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitNamedBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitNamedBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NamedBlockContext namedBlock() throws RecognitionException {
		NamedBlockContext _localctx = new NamedBlockContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_namedBlock);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(330);
			jinjaBlockOpen();
			setState(334);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(331);
					content();
					}
					} 
				}
				setState(336);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			}
			setState(337);
			jinjaBlockClose();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaBlockOpenContext extends ParserRuleContext {
		public TerminalNode JINJA_STMT_OPEN() { return getToken(Jinja2withHTMLandCSSParser.JINJA_STMT_OPEN, 0); }
		public TerminalNode KW_BLOCK() { return getToken(Jinja2withHTMLandCSSParser.KW_BLOCK, 0); }
		public TerminalNode STMT_ID() { return getToken(Jinja2withHTMLandCSSParser.STMT_ID, 0); }
		public TerminalNode JINJA_STMT_CLOSE() { return getToken(Jinja2withHTMLandCSSParser.JINJA_STMT_CLOSE, 0); }
		public JinjaBlockOpenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaBlockOpen; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterJinjaBlockOpen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitJinjaBlockOpen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitJinjaBlockOpen(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaBlockOpenContext jinjaBlockOpen() throws RecognitionException {
		JinjaBlockOpenContext _localctx = new JinjaBlockOpenContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_jinjaBlockOpen);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
			match(JINJA_STMT_OPEN);
			setState(340);
			match(KW_BLOCK);
			setState(341);
			match(STMT_ID);
			setState(342);
			match(JINJA_STMT_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaBlockCloseContext extends ParserRuleContext {
		public TerminalNode JINJA_STMT_OPEN() { return getToken(Jinja2withHTMLandCSSParser.JINJA_STMT_OPEN, 0); }
		public TerminalNode KW_ENDBLOCK() { return getToken(Jinja2withHTMLandCSSParser.KW_ENDBLOCK, 0); }
		public TerminalNode JINJA_STMT_CLOSE() { return getToken(Jinja2withHTMLandCSSParser.JINJA_STMT_CLOSE, 0); }
		public JinjaBlockCloseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaBlockClose; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterJinjaBlockClose(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitJinjaBlockClose(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitJinjaBlockClose(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaBlockCloseContext jinjaBlockClose() throws RecognitionException {
		JinjaBlockCloseContext _localctx = new JinjaBlockCloseContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_jinjaBlockClose);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(344);
			match(JINJA_STMT_OPEN);
			setState(345);
			match(KW_ENDBLOCK);
			setState(346);
			match(JINJA_STMT_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaSetStmtContext extends ParserRuleContext {
		public TerminalNode JINJA_STMT_OPEN() { return getToken(Jinja2withHTMLandCSSParser.JINJA_STMT_OPEN, 0); }
		public TerminalNode KW_SET() { return getToken(Jinja2withHTMLandCSSParser.KW_SET, 0); }
		public TerminalNode STMT_ID() { return getToken(Jinja2withHTMLandCSSParser.STMT_ID, 0); }
		public TerminalNode STMT_ASSIGN() { return getToken(Jinja2withHTMLandCSSParser.STMT_ASSIGN, 0); }
		public StmtExprContext stmtExpr() {
			return getRuleContext(StmtExprContext.class,0);
		}
		public TerminalNode JINJA_STMT_CLOSE() { return getToken(Jinja2withHTMLandCSSParser.JINJA_STMT_CLOSE, 0); }
		public JinjaSetStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaSetStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterJinjaSetStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitJinjaSetStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitJinjaSetStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaSetStmtContext jinjaSetStmt() throws RecognitionException {
		JinjaSetStmtContext _localctx = new JinjaSetStmtContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_jinjaSetStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(348);
			match(JINJA_STMT_OPEN);
			setState(349);
			match(KW_SET);
			setState(350);
			match(STMT_ID);
			setState(351);
			match(STMT_ASSIGN);
			setState(352);
			stmtExpr(0);
			setState(353);
			match(JINJA_STMT_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StmtExprContext extends ParserRuleContext {
		public StmtExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmtExpr; }
	 
		public StmtExprContext() { }
		public void copyFrom(StmtExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StmtTestExprContext extends StmtExprContext {
		public StmtExprContext stmtExpr() {
			return getRuleContext(StmtExprContext.class,0);
		}
		public TerminalNode KW_IS() { return getToken(Jinja2withHTMLandCSSParser.KW_IS, 0); }
		public TerminalNode STMT_ID() { return getToken(Jinja2withHTMLandCSSParser.STMT_ID, 0); }
		public StmtTestExprContext(StmtExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterStmtTestExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitStmtTestExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitStmtTestExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StmtNotExprContext extends StmtExprContext {
		public TerminalNode KW_NOT() { return getToken(Jinja2withHTMLandCSSParser.KW_NOT, 0); }
		public StmtExprContext stmtExpr() {
			return getRuleContext(StmtExprContext.class,0);
		}
		public StmtNotExprContext(StmtExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterStmtNotExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitStmtNotExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitStmtNotExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StmtCallExprContext extends StmtExprContext {
		public TerminalNode STMT_ID() { return getToken(Jinja2withHTMLandCSSParser.STMT_ID, 0); }
		public TerminalNode STMT_LPAREN() { return getToken(Jinja2withHTMLandCSSParser.STMT_LPAREN, 0); }
		public TerminalNode STMT_RPAREN() { return getToken(Jinja2withHTMLandCSSParser.STMT_RPAREN, 0); }
		public StmtArgListContext stmtArgList() {
			return getRuleContext(StmtArgListContext.class,0);
		}
		public StmtCallExprContext(StmtExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterStmtCallExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitStmtCallExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitStmtCallExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StmtAddExprContext extends StmtExprContext {
		public List<StmtExprContext> stmtExpr() {
			return getRuleContexts(StmtExprContext.class);
		}
		public StmtExprContext stmtExpr(int i) {
			return getRuleContext(StmtExprContext.class,i);
		}
		public TerminalNode STMT_PLUS() { return getToken(Jinja2withHTMLandCSSParser.STMT_PLUS, 0); }
		public TerminalNode STMT_MINUS() { return getToken(Jinja2withHTMLandCSSParser.STMT_MINUS, 0); }
		public StmtAddExprContext(StmtExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterStmtAddExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitStmtAddExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitStmtAddExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StmtMemberExprContext extends StmtExprContext {
		public StmtExprContext stmtExpr() {
			return getRuleContext(StmtExprContext.class,0);
		}
		public TerminalNode STMT_DOT() { return getToken(Jinja2withHTMLandCSSParser.STMT_DOT, 0); }
		public TerminalNode STMT_ID() { return getToken(Jinja2withHTMLandCSSParser.STMT_ID, 0); }
		public StmtMemberExprContext(StmtExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterStmtMemberExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitStmtMemberExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitStmtMemberExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StmtOrExprContext extends StmtExprContext {
		public List<StmtExprContext> stmtExpr() {
			return getRuleContexts(StmtExprContext.class);
		}
		public StmtExprContext stmtExpr(int i) {
			return getRuleContext(StmtExprContext.class,i);
		}
		public TerminalNode KW_OR() { return getToken(Jinja2withHTMLandCSSParser.KW_OR, 0); }
		public StmtOrExprContext(StmtExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterStmtOrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitStmtOrExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitStmtOrExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StmtStringLiteralContext extends StmtExprContext {
		public TerminalNode STMT_STRING() { return getToken(Jinja2withHTMLandCSSParser.STMT_STRING, 0); }
		public StmtStringLiteralContext(StmtExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterStmtStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitStmtStringLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitStmtStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StmtFilterExprContext extends StmtExprContext {
		public StmtExprContext stmtExpr() {
			return getRuleContext(StmtExprContext.class,0);
		}
		public TerminalNode STMT_PIPE() { return getToken(Jinja2withHTMLandCSSParser.STMT_PIPE, 0); }
		public TerminalNode STMT_ID() { return getToken(Jinja2withHTMLandCSSParser.STMT_ID, 0); }
		public TerminalNode STMT_LPAREN() { return getToken(Jinja2withHTMLandCSSParser.STMT_LPAREN, 0); }
		public TerminalNode STMT_RPAREN() { return getToken(Jinja2withHTMLandCSSParser.STMT_RPAREN, 0); }
		public StmtArgListContext stmtArgList() {
			return getRuleContext(StmtArgListContext.class,0);
		}
		public StmtFilterExprContext(StmtExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterStmtFilterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitStmtFilterExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitStmtFilterExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StmtSubscriptExprContext extends StmtExprContext {
		public List<StmtExprContext> stmtExpr() {
			return getRuleContexts(StmtExprContext.class);
		}
		public StmtExprContext stmtExpr(int i) {
			return getRuleContext(StmtExprContext.class,i);
		}
		public TerminalNode STMT_LBRACKET() { return getToken(Jinja2withHTMLandCSSParser.STMT_LBRACKET, 0); }
		public TerminalNode STMT_RBRACKET() { return getToken(Jinja2withHTMLandCSSParser.STMT_RBRACKET, 0); }
		public StmtSubscriptExprContext(StmtExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterStmtSubscriptExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitStmtSubscriptExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitStmtSubscriptExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StmtParenExprContext extends StmtExprContext {
		public TerminalNode STMT_LPAREN() { return getToken(Jinja2withHTMLandCSSParser.STMT_LPAREN, 0); }
		public StmtExprContext stmtExpr() {
			return getRuleContext(StmtExprContext.class,0);
		}
		public TerminalNode STMT_RPAREN() { return getToken(Jinja2withHTMLandCSSParser.STMT_RPAREN, 0); }
		public StmtParenExprContext(StmtExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterStmtParenExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitStmtParenExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitStmtParenExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StmtNumberLiteralContext extends StmtExprContext {
		public TerminalNode STMT_NUMBER() { return getToken(Jinja2withHTMLandCSSParser.STMT_NUMBER, 0); }
		public StmtNumberLiteralContext(StmtExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterStmtNumberLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitStmtNumberLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitStmtNumberLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StmtMultExprContext extends StmtExprContext {
		public List<StmtExprContext> stmtExpr() {
			return getRuleContexts(StmtExprContext.class);
		}
		public StmtExprContext stmtExpr(int i) {
			return getRuleContext(StmtExprContext.class,i);
		}
		public TerminalNode STMT_STAR() { return getToken(Jinja2withHTMLandCSSParser.STMT_STAR, 0); }
		public TerminalNode STMT_SLASH() { return getToken(Jinja2withHTMLandCSSParser.STMT_SLASH, 0); }
		public TerminalNode STMT_PERCENT() { return getToken(Jinja2withHTMLandCSSParser.STMT_PERCENT, 0); }
		public StmtMultExprContext(StmtExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterStmtMultExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitStmtMultExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitStmtMultExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StmtCompareExprContext extends StmtExprContext {
		public List<StmtExprContext> stmtExpr() {
			return getRuleContexts(StmtExprContext.class);
		}
		public StmtExprContext stmtExpr(int i) {
			return getRuleContext(StmtExprContext.class,i);
		}
		public TerminalNode STMT_EQ() { return getToken(Jinja2withHTMLandCSSParser.STMT_EQ, 0); }
		public TerminalNode STMT_NE() { return getToken(Jinja2withHTMLandCSSParser.STMT_NE, 0); }
		public TerminalNode STMT_LT() { return getToken(Jinja2withHTMLandCSSParser.STMT_LT, 0); }
		public TerminalNode STMT_GT() { return getToken(Jinja2withHTMLandCSSParser.STMT_GT, 0); }
		public TerminalNode STMT_LE() { return getToken(Jinja2withHTMLandCSSParser.STMT_LE, 0); }
		public TerminalNode STMT_GE() { return getToken(Jinja2withHTMLandCSSParser.STMT_GE, 0); }
		public StmtCompareExprContext(StmtExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterStmtCompareExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitStmtCompareExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitStmtCompareExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StmtNameExprContext extends StmtExprContext {
		public TerminalNode STMT_ID() { return getToken(Jinja2withHTMLandCSSParser.STMT_ID, 0); }
		public StmtNameExprContext(StmtExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterStmtNameExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitStmtNameExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitStmtNameExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StmtInExprContext extends StmtExprContext {
		public List<StmtExprContext> stmtExpr() {
			return getRuleContexts(StmtExprContext.class);
		}
		public StmtExprContext stmtExpr(int i) {
			return getRuleContext(StmtExprContext.class,i);
		}
		public TerminalNode KW_IN() { return getToken(Jinja2withHTMLandCSSParser.KW_IN, 0); }
		public StmtInExprContext(StmtExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterStmtInExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitStmtInExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitStmtInExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StmtBoolLiteralContext extends StmtExprContext {
		public TerminalNode STMT_TRUE() { return getToken(Jinja2withHTMLandCSSParser.STMT_TRUE, 0); }
		public TerminalNode STMT_FALSE() { return getToken(Jinja2withHTMLandCSSParser.STMT_FALSE, 0); }
		public StmtBoolLiteralContext(StmtExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterStmtBoolLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitStmtBoolLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitStmtBoolLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StmtNoneLiteralContext extends StmtExprContext {
		public TerminalNode STMT_NONE() { return getToken(Jinja2withHTMLandCSSParser.STMT_NONE, 0); }
		public StmtNoneLiteralContext(StmtExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterStmtNoneLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitStmtNoneLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitStmtNoneLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StmtAndExprContext extends StmtExprContext {
		public List<StmtExprContext> stmtExpr() {
			return getRuleContexts(StmtExprContext.class);
		}
		public StmtExprContext stmtExpr(int i) {
			return getRuleContext(StmtExprContext.class,i);
		}
		public TerminalNode KW_AND() { return getToken(Jinja2withHTMLandCSSParser.KW_AND, 0); }
		public StmtAndExprContext(StmtExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterStmtAndExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitStmtAndExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitStmtAndExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtExprContext stmtExpr() throws RecognitionException {
		return stmtExpr(0);
	}

	private StmtExprContext stmtExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StmtExprContext _localctx = new StmtExprContext(_ctx, _parentState);
		StmtExprContext _prevctx = _localctx;
		int _startState = 52;
		enterRecursionRule(_localctx, 52, RULE_stmtExpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(373);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				_localctx = new StmtNotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(356);
				match(KW_NOT);
				setState(357);
				stmtExpr(10);
				}
				break;
			case 2:
				{
				_localctx = new StmtCallExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(358);
				match(STMT_ID);
				setState(359);
				match(STMT_LPAREN);
				setState(361);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & 939526257L) != 0)) {
					{
					setState(360);
					stmtArgList();
					}
				}

				setState(363);
				match(STMT_RPAREN);
				}
				break;
			case 3:
				{
				_localctx = new StmtParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(364);
				match(STMT_LPAREN);
				setState(365);
				stmtExpr(0);
				setState(366);
				match(STMT_RPAREN);
				}
				break;
			case 4:
				{
				_localctx = new StmtNameExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(368);
				match(STMT_ID);
				}
				break;
			case 5:
				{
				_localctx = new StmtStringLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(369);
				match(STMT_STRING);
				}
				break;
			case 6:
				{
				_localctx = new StmtNumberLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(370);
				match(STMT_NUMBER);
				}
				break;
			case 7:
				{
				_localctx = new StmtBoolLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(371);
				_la = _input.LA(1);
				if ( !(_la==STMT_TRUE || _la==STMT_FALSE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 8:
				{
				_localctx = new StmtNoneLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(372);
				match(STMT_NONE);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(416);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(414);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
					case 1:
						{
						_localctx = new StmtMultExprContext(new StmtExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_stmtExpr);
						setState(375);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(376);
						_la = _input.LA(1);
						if ( !(((((_la - 96)) & ~0x3f) == 0 && ((1L << (_la - 96)) & 7L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(377);
						stmtExpr(16);
						}
						break;
					case 2:
						{
						_localctx = new StmtAddExprContext(new StmtExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_stmtExpr);
						setState(378);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(379);
						_la = _input.LA(1);
						if ( !(_la==STMT_PLUS || _la==STMT_MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(380);
						stmtExpr(15);
						}
						break;
					case 3:
						{
						_localctx = new StmtCompareExprContext(new StmtExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_stmtExpr);
						setState(381);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(382);
						_la = _input.LA(1);
						if ( !(((((_la - 87)) & ~0x3f) == 0 && ((1L << (_la - 87)) & 63L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(383);
						stmtExpr(14);
						}
						break;
					case 4:
						{
						_localctx = new StmtInExprContext(new StmtExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_stmtExpr);
						setState(384);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(385);
						match(KW_IN);
						setState(386);
						stmtExpr(12);
						}
						break;
					case 5:
						{
						_localctx = new StmtAndExprContext(new StmtExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_stmtExpr);
						setState(387);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(388);
						match(KW_AND);
						setState(389);
						stmtExpr(10);
						}
						break;
					case 6:
						{
						_localctx = new StmtOrExprContext(new StmtExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_stmtExpr);
						setState(390);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(391);
						match(KW_OR);
						setState(392);
						stmtExpr(9);
						}
						break;
					case 7:
						{
						_localctx = new StmtFilterExprContext(new StmtExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_stmtExpr);
						setState(393);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(394);
						match(STMT_PIPE);
						setState(395);
						match(STMT_ID);
						setState(401);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
						case 1:
							{
							setState(396);
							match(STMT_LPAREN);
							setState(398);
							_errHandler.sync(this);
							_la = _input.LA(1);
							if (((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & 939526257L) != 0)) {
								{
								setState(397);
								stmtArgList();
								}
							}

							setState(400);
							match(STMT_RPAREN);
							}
							break;
						}
						}
						break;
					case 8:
						{
						_localctx = new StmtMemberExprContext(new StmtExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_stmtExpr);
						setState(403);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(404);
						match(STMT_DOT);
						setState(405);
						match(STMT_ID);
						}
						break;
					case 9:
						{
						_localctx = new StmtSubscriptExprContext(new StmtExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_stmtExpr);
						setState(406);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(407);
						match(STMT_LBRACKET);
						setState(408);
						stmtExpr(0);
						setState(409);
						match(STMT_RBRACKET);
						}
						break;
					case 10:
						{
						_localctx = new StmtTestExprContext(new StmtExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_stmtExpr);
						setState(411);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(412);
						match(KW_IS);
						setState(413);
						match(STMT_ID);
						}
						break;
					}
					} 
				}
				setState(418);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StmtArgListContext extends ParserRuleContext {
		public List<StmtArgContext> stmtArg() {
			return getRuleContexts(StmtArgContext.class);
		}
		public StmtArgContext stmtArg(int i) {
			return getRuleContext(StmtArgContext.class,i);
		}
		public List<TerminalNode> STMT_COMMA() { return getTokens(Jinja2withHTMLandCSSParser.STMT_COMMA); }
		public TerminalNode STMT_COMMA(int i) {
			return getToken(Jinja2withHTMLandCSSParser.STMT_COMMA, i);
		}
		public StmtArgListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmtArgList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterStmtArgList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitStmtArgList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitStmtArgList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtArgListContext stmtArgList() throws RecognitionException {
		StmtArgListContext _localctx = new StmtArgListContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_stmtArgList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(419);
			stmtArg();
			setState(424);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==STMT_COMMA) {
				{
				{
				setState(420);
				match(STMT_COMMA);
				setState(421);
				stmtArg();
				}
				}
				setState(426);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StmtArgContext extends ParserRuleContext {
		public StmtExprContext stmtExpr() {
			return getRuleContext(StmtExprContext.class,0);
		}
		public TerminalNode STMT_ID() { return getToken(Jinja2withHTMLandCSSParser.STMT_ID, 0); }
		public TerminalNode STMT_ASSIGN() { return getToken(Jinja2withHTMLandCSSParser.STMT_ASSIGN, 0); }
		public StmtArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmtArg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterStmtArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitStmtArg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitStmtArg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtArgContext stmtArg() throws RecognitionException {
		StmtArgContext _localctx = new StmtArgContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_stmtArg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(429);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				{
				setState(427);
				match(STMT_ID);
				setState(428);
				match(STMT_ASSIGN);
				}
				break;
			}
			setState(431);
			stmtExpr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TextNodeContext extends ParserRuleContext {
		public List<TerminalNode> TEXT() { return getTokens(Jinja2withHTMLandCSSParser.TEXT); }
		public TerminalNode TEXT(int i) {
			return getToken(Jinja2withHTMLandCSSParser.TEXT, i);
		}
		public List<TerminalNode> LBRACE() { return getTokens(Jinja2withHTMLandCSSParser.LBRACE); }
		public TerminalNode LBRACE(int i) {
			return getToken(Jinja2withHTMLandCSSParser.LBRACE, i);
		}
		public TextNodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_textNode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterTextNode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitTextNode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitTextNode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TextNodeContext textNode() throws RecognitionException {
		TextNodeContext _localctx = new TextNodeContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_textNode);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(434); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(433);
					_la = _input.LA(1);
					if ( !(_la==LBRACE || _la==TEXT) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(436); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssProgContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(Jinja2withHTMLandCSSParser.EOF, 0); }
		public List<CssRuleContext> cssRule() {
			return getRuleContexts(CssRuleContext.class);
		}
		public CssRuleContext cssRule(int i) {
			return getRuleContext(CssRuleContext.class,i);
		}
		public CssProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssProg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterCssProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitCssProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitCssProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssProgContext cssProg() throws RecognitionException {
		CssProgContext _localctx = new CssProgContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_cssProg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(441);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 110)) & ~0x3f) == 0 && ((1L << (_la - 110)) & 8211L) != 0)) {
				{
				{
				setState(438);
				cssRule();
				}
				}
				setState(443);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(444);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssRuleContext extends ParserRuleContext {
		public CssSelectorListContext cssSelectorList() {
			return getRuleContext(CssSelectorListContext.class,0);
		}
		public TerminalNode CSS_LCURLY() { return getToken(Jinja2withHTMLandCSSParser.CSS_LCURLY, 0); }
		public TerminalNode CSS_RCURLY() { return getToken(Jinja2withHTMLandCSSParser.CSS_RCURLY, 0); }
		public List<CssDeclarationContext> cssDeclaration() {
			return getRuleContexts(CssDeclarationContext.class);
		}
		public CssDeclarationContext cssDeclaration(int i) {
			return getRuleContext(CssDeclarationContext.class,i);
		}
		public CssRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterCssRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitCssRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitCssRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssRuleContext cssRule() throws RecognitionException {
		CssRuleContext _localctx = new CssRuleContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_cssRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(446);
			cssSelectorList();
			setState(447);
			match(CSS_LCURLY);
			setState(451);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CSS_IDENT) {
				{
				{
				setState(448);
				cssDeclaration();
				}
				}
				setState(453);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(454);
			match(CSS_RCURLY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssSelectorListContext extends ParserRuleContext {
		public List<CssSelectorContext> cssSelector() {
			return getRuleContexts(CssSelectorContext.class);
		}
		public CssSelectorContext cssSelector(int i) {
			return getRuleContext(CssSelectorContext.class,i);
		}
		public List<TerminalNode> CSS_COMMA() { return getTokens(Jinja2withHTMLandCSSParser.CSS_COMMA); }
		public TerminalNode CSS_COMMA(int i) {
			return getToken(Jinja2withHTMLandCSSParser.CSS_COMMA, i);
		}
		public CssSelectorListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssSelectorList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterCssSelectorList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitCssSelectorList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitCssSelectorList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssSelectorListContext cssSelectorList() throws RecognitionException {
		CssSelectorListContext _localctx = new CssSelectorListContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_cssSelectorList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(456);
			cssSelector();
			setState(461);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CSS_COMMA) {
				{
				{
				setState(457);
				match(CSS_COMMA);
				setState(458);
				cssSelector();
				}
				}
				setState(463);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssSelectorContext extends ParserRuleContext {
		public List<CssSimpleSelectorContext> cssSimpleSelector() {
			return getRuleContexts(CssSimpleSelectorContext.class);
		}
		public CssSimpleSelectorContext cssSimpleSelector(int i) {
			return getRuleContext(CssSimpleSelectorContext.class,i);
		}
		public List<TerminalNode> CSS_COLON() { return getTokens(Jinja2withHTMLandCSSParser.CSS_COLON); }
		public TerminalNode CSS_COLON(int i) {
			return getToken(Jinja2withHTMLandCSSParser.CSS_COLON, i);
		}
		public TerminalNode CSS_IDENT() { return getToken(Jinja2withHTMLandCSSParser.CSS_IDENT, 0); }
		public List<TerminalNode> CSS_GT() { return getTokens(Jinja2withHTMLandCSSParser.CSS_GT); }
		public TerminalNode CSS_GT(int i) {
			return getToken(Jinja2withHTMLandCSSParser.CSS_GT, i);
		}
		public List<TerminalNode> CSS_PLUS() { return getTokens(Jinja2withHTMLandCSSParser.CSS_PLUS); }
		public TerminalNode CSS_PLUS(int i) {
			return getToken(Jinja2withHTMLandCSSParser.CSS_PLUS, i);
		}
		public List<TerminalNode> CSS_TILDE() { return getTokens(Jinja2withHTMLandCSSParser.CSS_TILDE); }
		public TerminalNode CSS_TILDE(int i) {
			return getToken(Jinja2withHTMLandCSSParser.CSS_TILDE, i);
		}
		public CssSelectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssSelector; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterCssSelector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitCssSelector(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitCssSelector(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssSelectorContext cssSelector() throws RecognitionException {
		CssSelectorContext _localctx = new CssSelectorContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_cssSelector);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(464);
			cssSimpleSelector();
			setState(471);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 110)) & ~0x3f) == 0 && ((1L << (_la - 110)) & 8435L) != 0)) {
				{
				{
				setState(466);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 115)) & ~0x3f) == 0 && ((1L << (_la - 115)) & 7L) != 0)) {
					{
					setState(465);
					_la = _input.LA(1);
					if ( !(((((_la - 115)) & ~0x3f) == 0 && ((1L << (_la - 115)) & 7L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(468);
				cssSimpleSelector();
				}
				}
				setState(473);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(479);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CSS_COLON) {
				{
				setState(474);
				match(CSS_COLON);
				setState(476);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CSS_COLON) {
					{
					setState(475);
					match(CSS_COLON);
					}
				}

				setState(478);
				match(CSS_IDENT);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssSimpleSelectorContext extends ParserRuleContext {
		public CssSimpleSelectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssSimpleSelector; }
	 
		public CssSimpleSelectorContext() { }
		public void copyFrom(CssSimpleSelectorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssUniversalSelectorContext extends CssSimpleSelectorContext {
		public TerminalNode CSS_STAR() { return getToken(Jinja2withHTMLandCSSParser.CSS_STAR, 0); }
		public CssUniversalSelectorContext(CssSimpleSelectorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterCssUniversalSelector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitCssUniversalSelector(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitCssUniversalSelector(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssElementSelectorContext extends CssSimpleSelectorContext {
		public TerminalNode CSS_IDENT() { return getToken(Jinja2withHTMLandCSSParser.CSS_IDENT, 0); }
		public CssElementSelectorContext(CssSimpleSelectorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterCssElementSelector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitCssElementSelector(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitCssElementSelector(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssClassSelectorContext extends CssSimpleSelectorContext {
		public TerminalNode CSS_DOT() { return getToken(Jinja2withHTMLandCSSParser.CSS_DOT, 0); }
		public TerminalNode CSS_IDENT() { return getToken(Jinja2withHTMLandCSSParser.CSS_IDENT, 0); }
		public CssClassSelectorContext(CssSimpleSelectorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterCssClassSelector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitCssClassSelector(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitCssClassSelector(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssIdSelectorContext extends CssSimpleSelectorContext {
		public TerminalNode CSS_HASH() { return getToken(Jinja2withHTMLandCSSParser.CSS_HASH, 0); }
		public TerminalNode CSS_IDENT() { return getToken(Jinja2withHTMLandCSSParser.CSS_IDENT, 0); }
		public CssIdSelectorContext(CssSimpleSelectorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterCssIdSelector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitCssIdSelector(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitCssIdSelector(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssSimpleSelectorContext cssSimpleSelector() throws RecognitionException {
		CssSimpleSelectorContext _localctx = new CssSimpleSelectorContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_cssSimpleSelector);
		try {
			setState(487);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CSS_IDENT:
				_localctx = new CssElementSelectorContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(481);
				match(CSS_IDENT);
				}
				break;
			case CSS_DOT:
				_localctx = new CssClassSelectorContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(482);
				match(CSS_DOT);
				setState(483);
				match(CSS_IDENT);
				}
				break;
			case CSS_HASH:
				_localctx = new CssIdSelectorContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(484);
				match(CSS_HASH);
				setState(485);
				match(CSS_IDENT);
				}
				break;
			case CSS_STAR:
				_localctx = new CssUniversalSelectorContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(486);
				match(CSS_STAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssDeclarationContext extends ParserRuleContext {
		public TerminalNode CSS_IDENT() { return getToken(Jinja2withHTMLandCSSParser.CSS_IDENT, 0); }
		public TerminalNode CSS_COLON() { return getToken(Jinja2withHTMLandCSSParser.CSS_COLON, 0); }
		public CssValueListContext cssValueList() {
			return getRuleContext(CssValueListContext.class,0);
		}
		public TerminalNode CSS_IMPORTANT() { return getToken(Jinja2withHTMLandCSSParser.CSS_IMPORTANT, 0); }
		public TerminalNode CSS_SEMICOLON() { return getToken(Jinja2withHTMLandCSSParser.CSS_SEMICOLON, 0); }
		public CssDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterCssDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitCssDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitCssDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssDeclarationContext cssDeclaration() throws RecognitionException {
		CssDeclarationContext _localctx = new CssDeclarationContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_cssDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(489);
			match(CSS_IDENT);
			setState(490);
			match(CSS_COLON);
			setState(491);
			cssValueList();
			setState(493);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CSS_IMPORTANT) {
				{
				setState(492);
				match(CSS_IMPORTANT);
				}
			}

			setState(496);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CSS_SEMICOLON) {
				{
				setState(495);
				match(CSS_SEMICOLON);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssValueListContext extends ParserRuleContext {
		public List<CssValueContext> cssValue() {
			return getRuleContexts(CssValueContext.class);
		}
		public CssValueContext cssValue(int i) {
			return getRuleContext(CssValueContext.class,i);
		}
		public CssValueListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssValueList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterCssValueList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitCssValueList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitCssValueList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssValueListContext cssValueList() throws RecognitionException {
		CssValueListContext _localctx = new CssValueListContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_cssValueList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(499); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(498);
					cssValue();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(501); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssValueContext extends ParserRuleContext {
		public CssValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssValue; }
	 
		public CssValueContext() { }
		public void copyFrom(CssValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssStringContext extends CssValueContext {
		public TerminalNode CSS_STRING() { return getToken(Jinja2withHTMLandCSSParser.CSS_STRING, 0); }
		public CssStringContext(CssValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterCssString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitCssString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitCssString(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssCommaContext extends CssValueContext {
		public TerminalNode CSS_COMMA() { return getToken(Jinja2withHTMLandCSSParser.CSS_COMMA, 0); }
		public CssCommaContext(CssValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterCssComma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitCssComma(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitCssComma(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssColorContext extends CssValueContext {
		public TerminalNode CSS_HEX_COLOR() { return getToken(Jinja2withHTMLandCSSParser.CSS_HEX_COLOR, 0); }
		public CssColorContext(CssValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterCssColor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitCssColor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitCssColor(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssSlashContext extends CssValueContext {
		public TerminalNode CSS_SLASH() { return getToken(Jinja2withHTMLandCSSParser.CSS_SLASH, 0); }
		public CssSlashContext(CssValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterCssSlash(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitCssSlash(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitCssSlash(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssPercentageContext extends CssValueContext {
		public TerminalNode CSS_NUMBER() { return getToken(Jinja2withHTMLandCSSParser.CSS_NUMBER, 0); }
		public TerminalNode CSS_PERCENT() { return getToken(Jinja2withHTMLandCSSParser.CSS_PERCENT, 0); }
		public CssPercentageContext(CssValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterCssPercentage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitCssPercentage(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitCssPercentage(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssIdentContext extends CssValueContext {
		public TerminalNode CSS_IDENT() { return getToken(Jinja2withHTMLandCSSParser.CSS_IDENT, 0); }
		public CssIdentContext(CssValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterCssIdent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitCssIdent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitCssIdent(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssFunctionCallContext extends CssValueContext {
		public TerminalNode CSS_IDENT() { return getToken(Jinja2withHTMLandCSSParser.CSS_IDENT, 0); }
		public TerminalNode CSS_LPAREN() { return getToken(Jinja2withHTMLandCSSParser.CSS_LPAREN, 0); }
		public CssValueListContext cssValueList() {
			return getRuleContext(CssValueListContext.class,0);
		}
		public TerminalNode CSS_RPAREN() { return getToken(Jinja2withHTMLandCSSParser.CSS_RPAREN, 0); }
		public CssFunctionCallContext(CssValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterCssFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitCssFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitCssFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssNumberWithUnitContext extends CssValueContext {
		public TerminalNode CSS_NUMBER() { return getToken(Jinja2withHTMLandCSSParser.CSS_NUMBER, 0); }
		public TerminalNode CSS_IDENT() { return getToken(Jinja2withHTMLandCSSParser.CSS_IDENT, 0); }
		public CssNumberWithUnitContext(CssValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).enterCssNumberWithUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Jinja2withHTMLandCSSParserListener ) ((Jinja2withHTMLandCSSParserListener)listener).exitCssNumberWithUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitCssNumberWithUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssValueContext cssValue() throws RecognitionException {
		CssValueContext _localctx = new CssValueContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_cssValue);
		try {
			setState(519);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				_localctx = new CssNumberWithUnitContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(503);
				match(CSS_NUMBER);
				setState(505);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
				case 1:
					{
					setState(504);
					match(CSS_IDENT);
					}
					break;
				}
				}
				break;
			case 2:
				_localctx = new CssPercentageContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(507);
				match(CSS_NUMBER);
				setState(508);
				match(CSS_PERCENT);
				}
				break;
			case 3:
				_localctx = new CssColorContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(509);
				match(CSS_HEX_COLOR);
				}
				break;
			case 4:
				_localctx = new CssIdentContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(510);
				match(CSS_IDENT);
				}
				break;
			case 5:
				_localctx = new CssStringContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(511);
				match(CSS_STRING);
				}
				break;
			case 6:
				_localctx = new CssFunctionCallContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(512);
				match(CSS_IDENT);
				setState(513);
				match(CSS_LPAREN);
				setState(514);
				cssValueList();
				setState(515);
				match(CSS_RPAREN);
				}
				break;
			case 7:
				_localctx = new CssCommaContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(517);
				match(CSS_COMMA);
				}
				break;
			case 8:
				_localctx = new CssSlashContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(518);
				match(CSS_SLASH);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 11:
			return jinjaExpr_sempred((JinjaExprContext)_localctx, predIndex);
		case 26:
			return stmtExpr_sempred((StmtExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean jinjaExpr_sempred(JinjaExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 15);
		case 1:
			return precpred(_ctx, 14);
		case 2:
			return precpred(_ctx, 13);
		case 3:
			return precpred(_ctx, 11);
		case 4:
			return precpred(_ctx, 9);
		case 5:
			return precpred(_ctx, 8);
		case 6:
			return precpred(_ctx, 18);
		case 7:
			return precpred(_ctx, 17);
		case 8:
			return precpred(_ctx, 16);
		case 9:
			return precpred(_ctx, 12);
		}
		return true;
	}
	private boolean stmtExpr_sempred(StmtExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 10:
			return precpred(_ctx, 15);
		case 11:
			return precpred(_ctx, 14);
		case 12:
			return precpred(_ctx, 13);
		case 13:
			return precpred(_ctx, 11);
		case 14:
			return precpred(_ctx, 9);
		case 15:
			return precpred(_ctx, 8);
		case 16:
			return precpred(_ctx, 18);
		case 17:
			return precpred(_ctx, 17);
		case 18:
			return precpred(_ctx, 16);
		case 19:
			return precpred(_ctx, 12);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001{\u020a\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0001\u0000\u0001\u0000\u0003\u0000"+
		"O\b\u0000\u0001\u0001\u0003\u0001R\b\u0001\u0001\u0001\u0005\u0001U\b"+
		"\u0001\n\u0001\f\u0001X\t\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003g\b\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0005\u0004l\b\u0004\n\u0004\f\u0004o\t"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004u\b"+
		"\u0004\n\u0004\f\u0004x\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0005\u0004\u007f\b\u0004\n\u0004\f\u0004\u0082\t\u0004"+
		"\u0001\u0004\u0001\u0004\u0005\u0004\u0086\b\u0004\n\u0004\f\u0004\u0089"+
		"\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u008f"+
		"\b\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0003\u0006\u0098\b\u0006\u0001\u0007\u0001\u0007\u0005"+
		"\u0007\u009c\b\u0007\n\u0007\f\u0007\u009f\t\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0005\u0007\u00a4\b\u0007\n\u0007\f\u0007\u00a7\t\u0007\u0001"+
		"\u0007\u0001\u0007\u0003\u0007\u00ab\b\u0007\u0001\b\u0001\b\u0001\b\u0003"+
		"\b\u00b0\b\b\u0001\t\u0001\t\u0001\t\u0003\t\u00b5\b\t\u0001\n\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0003\n\u00c3\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00cb\b\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00d7\b\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00f0\b\u000b\u0001"+
		"\u000b\u0003\u000b\u00f3\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0005\u000b\u0100\b\u000b\n\u000b\f\u000b\u0103\t\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0005\f\u0108\b\f\n\f\f\f\u010b\t\f\u0001\r\u0001"+
		"\r\u0003\r\u010f\b\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0003\u000e\u0116\b\u000e\u0001\u000f\u0001\u000f\u0005\u000f\u011a\b"+
		"\u000f\n\u000f\f\u000f\u011d\t\u000f\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012"+
		"\u0005\u0012\u012e\b\u0012\n\u0012\f\u0012\u0131\t\u0012\u0001\u0012\u0001"+
		"\u0012\u0005\u0012\u0135\b\u0012\n\u0012\f\u0012\u0138\t\u0012\u0003\u0012"+
		"\u013a\b\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016"+
		"\u0005\u0016\u014d\b\u0016\n\u0016\f\u0016\u0150\t\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0003\u001a\u016a"+
		"\b\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0003\u001a\u0176"+
		"\b\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0003"+
		"\u001a\u018f\b\u001a\u0001\u001a\u0003\u001a\u0192\b\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0005\u001a\u019f\b\u001a"+
		"\n\u001a\f\u001a\u01a2\t\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0005"+
		"\u001b\u01a7\b\u001b\n\u001b\f\u001b\u01aa\t\u001b\u0001\u001c\u0001\u001c"+
		"\u0003\u001c\u01ae\b\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0004\u001d"+
		"\u01b3\b\u001d\u000b\u001d\f\u001d\u01b4\u0001\u001e\u0005\u001e\u01b8"+
		"\b\u001e\n\u001e\f\u001e\u01bb\t\u001e\u0001\u001e\u0001\u001e\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0005\u001f\u01c2\b\u001f\n\u001f\f\u001f\u01c5"+
		"\t\u001f\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001 \u0005 \u01cc\b "+
		"\n \f \u01cf\t \u0001!\u0001!\u0003!\u01d3\b!\u0001!\u0005!\u01d6\b!\n"+
		"!\f!\u01d9\t!\u0001!\u0001!\u0003!\u01dd\b!\u0001!\u0003!\u01e0\b!\u0001"+
		"\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0003\"\u01e8\b\"\u0001#\u0001"+
		"#\u0001#\u0001#\u0003#\u01ee\b#\u0001#\u0003#\u01f1\b#\u0001$\u0004$\u01f4"+
		"\b$\u000b$\f$\u01f5\u0001%\u0001%\u0003%\u01fa\b%\u0001%\u0001%\u0001"+
		"%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0003"+
		"%\u0208\b%\u0001%\u0000\u0002\u00164&\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDF"+
		"HJ\u0000\f\u0001\u0000\f\r\u0001\u0000\u0010\u0011\u0001\u000023\u0001"+
		"\u0000/1\u0001\u0000-.\u0001\u0000&+\u0001\u0000LM\u0001\u0000`b\u0001"+
		"\u0000^_\u0001\u0000W\\\u0001\u0000\u0007\b\u0001\u0000su\u0244\u0000"+
		"N\u0001\u0000\u0000\u0000\u0002Q\u0001\u0000\u0000\u0000\u0004[\u0001"+
		"\u0000\u0000\u0000\u0006f\u0001\u0000\u0000\u0000\b\u008e\u0001\u0000"+
		"\u0000\u0000\n\u0090\u0001\u0000\u0000\u0000\f\u0097\u0001\u0000\u0000"+
		"\u0000\u000e\u00aa\u0001\u0000\u0000\u0000\u0010\u00af\u0001\u0000\u0000"+
		"\u0000\u0012\u00b4\u0001\u0000\u0000\u0000\u0014\u00c2\u0001\u0000\u0000"+
		"\u0000\u0016\u00d6\u0001\u0000\u0000\u0000\u0018\u0104\u0001\u0000\u0000"+
		"\u0000\u001a\u010e\u0001\u0000\u0000\u0000\u001c\u0115\u0001\u0000\u0000"+
		"\u0000\u001e\u0117\u0001\u0000\u0000\u0000 \u0120\u0001\u0000\u0000\u0000"+
		"\"\u0127\u0001\u0000\u0000\u0000$\u012b\u0001\u0000\u0000\u0000&\u013d"+
		"\u0001\u0000\u0000\u0000(\u0142\u0001\u0000\u0000\u0000*\u0146\u0001\u0000"+
		"\u0000\u0000,\u014a\u0001\u0000\u0000\u0000.\u0153\u0001\u0000\u0000\u0000"+
		"0\u0158\u0001\u0000\u0000\u00002\u015c\u0001\u0000\u0000\u00004\u0175"+
		"\u0001\u0000\u0000\u00006\u01a3\u0001\u0000\u0000\u00008\u01ad\u0001\u0000"+
		"\u0000\u0000:\u01b2\u0001\u0000\u0000\u0000<\u01b9\u0001\u0000\u0000\u0000"+
		">\u01be\u0001\u0000\u0000\u0000@\u01c8\u0001\u0000\u0000\u0000B\u01d0"+
		"\u0001\u0000\u0000\u0000D\u01e7\u0001\u0000\u0000\u0000F\u01e9\u0001\u0000"+
		"\u0000\u0000H\u01f3\u0001\u0000\u0000\u0000J\u0207\u0001\u0000\u0000\u0000"+
		"LO\u0003\u0002\u0001\u0000MO\u0003<\u001e\u0000NL\u0001\u0000\u0000\u0000"+
		"NM\u0001\u0000\u0000\u0000O\u0001\u0001\u0000\u0000\u0000PR\u0003\u0004"+
		"\u0002\u0000QP\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000RV\u0001"+
		"\u0000\u0000\u0000SU\u0003\u0006\u0003\u0000TS\u0001\u0000\u0000\u0000"+
		"UX\u0001\u0000\u0000\u0000VT\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000"+
		"\u0000WY\u0001\u0000\u0000\u0000XV\u0001\u0000\u0000\u0000YZ\u0005\u0000"+
		"\u0000\u0001Z\u0003\u0001\u0000\u0000\u0000[\\\u0005\u0006\u0000\u0000"+
		"\\]\u0005\u000b\u0000\u0000]^\u0003\n\u0005\u0000^_\u0003\n\u0005\u0000"+
		"_`\u0005\r\u0000\u0000`\u0005\u0001\u0000\u0000\u0000ag\u0003\b\u0004"+
		"\u0000bg\u0003\u0014\n\u0000cg\u0003\u001c\u000e\u0000dg\u00032\u0019"+
		"\u0000eg\u0003:\u001d\u0000fa\u0001\u0000\u0000\u0000fb\u0001\u0000\u0000"+
		"\u0000fc\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000fe\u0001\u0000"+
		"\u0000\u0000g\u0007\u0001\u0000\u0000\u0000hi\u0005\u0006\u0000\u0000"+
		"im\u0005\u0010\u0000\u0000jl\u0003\f\u0006\u0000kj\u0001\u0000\u0000\u0000"+
		"lo\u0001\u0000\u0000\u0000mk\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000"+
		"\u0000np\u0001\u0000\u0000\u0000om\u0001\u0000\u0000\u0000p\u008f\u0007"+
		"\u0000\u0000\u0000qr\u0005\u0006\u0000\u0000rv\u0003\n\u0005\u0000su\u0003"+
		"\f\u0006\u0000ts\u0001\u0000\u0000\u0000ux\u0001\u0000\u0000\u0000vt\u0001"+
		"\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000wy\u0001\u0000\u0000\u0000"+
		"xv\u0001\u0000\u0000\u0000yz\u0005\f\u0000\u0000z\u008f\u0001\u0000\u0000"+
		"\u0000{|\u0005\u0006\u0000\u0000|\u0080\u0003\n\u0005\u0000}\u007f\u0003"+
		"\f\u0006\u0000~}\u0001\u0000\u0000\u0000\u007f\u0082\u0001\u0000\u0000"+
		"\u0000\u0080~\u0001\u0000\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000"+
		"\u0081\u0083\u0001\u0000\u0000\u0000\u0082\u0080\u0001\u0000\u0000\u0000"+
		"\u0083\u0087\u0005\r\u0000\u0000\u0084\u0086\u0003\u0006\u0003\u0000\u0085"+
		"\u0084\u0001\u0000\u0000\u0000\u0086\u0089\u0001\u0000\u0000\u0000\u0087"+
		"\u0085\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000\u0000\u0088"+
		"\u008a\u0001\u0000\u0000\u0000\u0089\u0087\u0001\u0000\u0000\u0000\u008a"+
		"\u008b\u0005\u0005\u0000\u0000\u008b\u008c\u0003\n\u0005\u0000\u008c\u008d"+
		"\u0005\r\u0000\u0000\u008d\u008f\u0001\u0000\u0000\u0000\u008eh\u0001"+
		"\u0000\u0000\u0000\u008eq\u0001\u0000\u0000\u0000\u008e{\u0001\u0000\u0000"+
		"\u0000\u008f\t\u0001\u0000\u0000\u0000\u0090\u0091\u0007\u0001\u0000\u0000"+
		"\u0091\u000b\u0001\u0000\u0000\u0000\u0092\u0093\u0003\n\u0005\u0000\u0093"+
		"\u0094\u0005\n\u0000\u0000\u0094\u0095\u0003\u000e\u0007\u0000\u0095\u0098"+
		"\u0001\u0000\u0000\u0000\u0096\u0098\u0003\n\u0005\u0000\u0097\u0092\u0001"+
		"\u0000\u0000\u0000\u0097\u0096\u0001\u0000\u0000\u0000\u0098\r\u0001\u0000"+
		"\u0000\u0000\u0099\u009d\u0005\u000e\u0000\u0000\u009a\u009c\u0003\u0010"+
		"\b\u0000\u009b\u009a\u0001\u0000\u0000\u0000\u009c\u009f\u0001\u0000\u0000"+
		"\u0000\u009d\u009b\u0001\u0000\u0000\u0000\u009d\u009e\u0001\u0000\u0000"+
		"\u0000\u009e\u00a0\u0001\u0000\u0000\u0000\u009f\u009d\u0001\u0000\u0000"+
		"\u0000\u00a0\u00ab\u0005\u0014\u0000\u0000\u00a1\u00a5\u0005\u000f\u0000"+
		"\u0000\u00a2\u00a4\u0003\u0012\t\u0000\u00a3\u00a2\u0001\u0000\u0000\u0000"+
		"\u00a4\u00a7\u0001\u0000\u0000\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000"+
		"\u00a5\u00a6\u0001\u0000\u0000\u0000\u00a6\u00a8\u0001\u0000\u0000\u0000"+
		"\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a8\u00ab\u0005\u0019\u0000\u0000"+
		"\u00a9\u00ab\u0003\n\u0005\u0000\u00aa\u0099\u0001\u0000\u0000\u0000\u00aa"+
		"\u00a1\u0001\u0000\u0000\u0000\u00aa\u00a9\u0001\u0000\u0000\u0000\u00ab"+
		"\u000f\u0001\u0000\u0000\u0000\u00ac\u00b0\u0005\u0016\u0000\u0000\u00ad"+
		"\u00b0\u0005\u0015\u0000\u0000\u00ae\u00b0\u0003\u0014\n\u0000\u00af\u00ac"+
		"\u0001\u0000\u0000\u0000\u00af\u00ad\u0001\u0000\u0000\u0000\u00af\u00ae"+
		"\u0001\u0000\u0000\u0000\u00b0\u0011\u0001\u0000\u0000\u0000\u00b1\u00b5"+
		"\u0005\u001b\u0000\u0000\u00b2\u00b5\u0005\u001a\u0000\u0000\u00b3\u00b5"+
		"\u0003\u0014\n\u0000\u00b4\u00b1\u0001\u0000\u0000\u0000\u00b4\u00b2\u0001"+
		"\u0000\u0000\u0000\u00b4\u00b3\u0001\u0000\u0000\u0000\u00b5\u0013\u0001"+
		"\u0000\u0000\u0000\u00b6\u00b7\u0005\u0003\u0000\u0000\u00b7\u00b8\u0003"+
		"\u0016\u000b\u0000\u00b8\u00b9\u0005\u001c\u0000\u0000\u00b9\u00c3\u0001"+
		"\u0000\u0000\u0000\u00ba\u00bb\u0005\u0012\u0000\u0000\u00bb\u00bc\u0003"+
		"\u0016\u000b\u0000\u00bc\u00bd\u0005\u001c\u0000\u0000\u00bd\u00c3\u0001"+
		"\u0000\u0000\u0000\u00be\u00bf\u0005\u0017\u0000\u0000\u00bf\u00c0\u0003"+
		"\u0016\u000b\u0000\u00c0\u00c1\u0005\u001c\u0000\u0000\u00c1\u00c3\u0001"+
		"\u0000\u0000\u0000\u00c2\u00b6\u0001\u0000\u0000\u0000\u00c2\u00ba\u0001"+
		"\u0000\u0000\u0000\u00c2\u00be\u0001\u0000\u0000\u0000\u00c3\u0015\u0001"+
		"\u0000\u0000\u0000\u00c4\u00c5\u0006\u000b\uffff\uffff\u0000\u00c5\u00c6"+
		"\u00055\u0000\u0000\u00c6\u00d7\u0003\u0016\u000b\n\u00c7\u00c8\u0005"+
		"<\u0000\u0000\u00c8\u00ca\u0005\"\u0000\u0000\u00c9\u00cb\u0003\u0018"+
		"\f\u0000\u00ca\u00c9\u0001\u0000\u0000\u0000\u00ca\u00cb\u0001\u0000\u0000"+
		"\u0000\u00cb\u00cc\u0001\u0000\u0000\u0000\u00cc\u00d7\u0005#\u0000\u0000"+
		"\u00cd\u00ce\u0005\"\u0000\u0000\u00ce\u00cf\u0003\u0016\u000b\u0000\u00cf"+
		"\u00d0\u0005#\u0000\u0000\u00d0\u00d7\u0001\u0000\u0000\u0000\u00d1\u00d7"+
		"\u0005<\u0000\u0000\u00d2\u00d7\u0005:\u0000\u0000\u00d3\u00d7\u0005;"+
		"\u0000\u0000\u00d4\u00d7\u0007\u0002\u0000\u0000\u00d5\u00d7\u00054\u0000"+
		"\u0000\u00d6\u00c4\u0001\u0000\u0000\u0000\u00d6\u00c7\u0001\u0000\u0000"+
		"\u0000\u00d6\u00cd\u0001\u0000\u0000\u0000\u00d6\u00d1\u0001\u0000\u0000"+
		"\u0000\u00d6\u00d2\u0001\u0000\u0000\u0000\u00d6\u00d3\u0001\u0000\u0000"+
		"\u0000\u00d6\u00d4\u0001\u0000\u0000\u0000\u00d6\u00d5\u0001\u0000\u0000"+
		"\u0000\u00d7\u0101\u0001\u0000\u0000\u0000\u00d8\u00d9\n\u000f\u0000\u0000"+
		"\u00d9\u00da\u0007\u0003\u0000\u0000\u00da\u0100\u0003\u0016\u000b\u0010"+
		"\u00db\u00dc\n\u000e\u0000\u0000\u00dc\u00dd\u0007\u0004\u0000\u0000\u00dd"+
		"\u0100\u0003\u0016\u000b\u000f\u00de\u00df\n\r\u0000\u0000\u00df\u00e0"+
		"\u0007\u0005\u0000\u0000\u00e0\u0100\u0003\u0016\u000b\u000e\u00e1\u00e2"+
		"\n\u000b\u0000\u0000\u00e2\u00e3\u00059\u0000\u0000\u00e3\u0100\u0003"+
		"\u0016\u000b\f\u00e4\u00e5\n\t\u0000\u0000\u00e5\u00e6\u00056\u0000\u0000"+
		"\u00e6\u0100\u0003\u0016\u000b\n\u00e7\u00e8\n\b\u0000\u0000\u00e8\u00e9"+
		"\u00057\u0000\u0000\u00e9\u0100\u0003\u0016\u000b\t\u00ea\u00eb\n\u0012"+
		"\u0000\u0000\u00eb\u00ec\u0005\u001f\u0000\u0000\u00ec\u00f2\u0005<\u0000"+
		"\u0000\u00ed\u00ef\u0005\"\u0000\u0000\u00ee\u00f0\u0003\u0018\f\u0000"+
		"\u00ef\u00ee\u0001\u0000\u0000\u0000\u00ef\u00f0\u0001\u0000\u0000\u0000"+
		"\u00f0\u00f1\u0001\u0000\u0000\u0000\u00f1\u00f3\u0005#\u0000\u0000\u00f2"+
		"\u00ed\u0001\u0000\u0000\u0000\u00f2\u00f3\u0001\u0000\u0000\u0000\u00f3"+
		"\u0100\u0001\u0000\u0000\u0000\u00f4\u00f5\n\u0011\u0000\u0000\u00f5\u00f6"+
		"\u0005\u001e\u0000\u0000\u00f6\u0100\u0005<\u0000\u0000\u00f7\u00f8\n"+
		"\u0010\u0000\u0000\u00f8\u00f9\u0005$\u0000\u0000\u00f9\u00fa\u0003\u0016"+
		"\u000b\u0000\u00fa\u00fb\u0005%\u0000\u0000\u00fb\u0100\u0001\u0000\u0000"+
		"\u0000\u00fc\u00fd\n\f\u0000\u0000\u00fd\u00fe\u00058\u0000\u0000\u00fe"+
		"\u0100\u0005<\u0000\u0000\u00ff\u00d8\u0001\u0000\u0000\u0000\u00ff\u00db"+
		"\u0001\u0000\u0000\u0000\u00ff\u00de\u0001\u0000\u0000\u0000\u00ff\u00e1"+
		"\u0001\u0000\u0000\u0000\u00ff\u00e4\u0001\u0000\u0000\u0000\u00ff\u00e7"+
		"\u0001\u0000\u0000\u0000\u00ff\u00ea\u0001\u0000\u0000\u0000\u00ff\u00f4"+
		"\u0001\u0000\u0000\u0000\u00ff\u00f7\u0001\u0000\u0000\u0000\u00ff\u00fc"+
		"\u0001\u0000\u0000\u0000\u0100\u0103\u0001\u0000\u0000\u0000\u0101\u00ff"+
		"\u0001\u0000\u0000\u0000\u0101\u0102\u0001\u0000\u0000\u0000\u0102\u0017"+
		"\u0001\u0000\u0000\u0000\u0103\u0101\u0001\u0000\u0000\u0000\u0104\u0109"+
		"\u0003\u001a\r\u0000\u0105\u0106\u0005 \u0000\u0000\u0106\u0108\u0003"+
		"\u001a\r\u0000\u0107\u0105\u0001\u0000\u0000\u0000\u0108\u010b\u0001\u0000"+
		"\u0000\u0000\u0109\u0107\u0001\u0000\u0000\u0000\u0109\u010a\u0001\u0000"+
		"\u0000\u0000\u010a\u0019\u0001\u0000\u0000\u0000\u010b\u0109\u0001\u0000"+
		"\u0000\u0000\u010c\u010d\u0005<\u0000\u0000\u010d\u010f\u0005,\u0000\u0000"+
		"\u010e\u010c\u0001\u0000\u0000\u0000\u010e\u010f\u0001\u0000\u0000\u0000"+
		"\u010f\u0110\u0001\u0000\u0000\u0000\u0110\u0111\u0003\u0016\u000b\u0000"+
		"\u0111\u001b\u0001\u0000\u0000\u0000\u0112\u0116\u0003\u001e\u000f\u0000"+
		"\u0113\u0116\u0003$\u0012\u0000\u0114\u0116\u0003,\u0016\u0000\u0115\u0112"+
		"\u0001\u0000\u0000\u0000\u0115\u0113\u0001\u0000\u0000\u0000\u0115\u0114"+
		"\u0001\u0000\u0000\u0000\u0116\u001d\u0001\u0000\u0000\u0000\u0117\u011b"+
		"\u0003 \u0010\u0000\u0118\u011a\u0003\u0006\u0003\u0000\u0119\u0118\u0001"+
		"\u0000\u0000\u0000\u011a\u011d\u0001\u0000\u0000\u0000\u011b\u0119\u0001"+
		"\u0000\u0000\u0000\u011b\u011c\u0001\u0000\u0000\u0000\u011c\u011e\u0001"+
		"\u0000\u0000\u0000\u011d\u011b\u0001\u0000\u0000\u0000\u011e\u011f\u0003"+
		"\"\u0011\u0000\u011f\u001f\u0001\u0000\u0000\u0000\u0120\u0121\u0005\u0004"+
		"\u0000\u0000\u0121\u0122\u0005?\u0000\u0000\u0122\u0123\u0005e\u0000\u0000"+
		"\u0123\u0124\u0005G\u0000\u0000\u0124\u0125\u00034\u001a\u0000\u0125\u0126"+
		"\u0005=\u0000\u0000\u0126!\u0001\u0000\u0000\u0000\u0127\u0128\u0005\u0004"+
		"\u0000\u0000\u0128\u0129\u0005@\u0000\u0000\u0129\u012a\u0005=\u0000\u0000"+
		"\u012a#\u0001\u0000\u0000\u0000\u012b\u012f\u0003&\u0013\u0000\u012c\u012e"+
		"\u0003\u0006\u0003\u0000\u012d\u012c\u0001\u0000\u0000\u0000\u012e\u0131"+
		"\u0001\u0000\u0000\u0000\u012f\u012d\u0001\u0000\u0000\u0000\u012f\u0130"+
		"\u0001\u0000\u0000\u0000\u0130\u0139\u0001\u0000\u0000\u0000\u0131\u012f"+
		"\u0001\u0000\u0000\u0000\u0132\u0136\u0003(\u0014\u0000\u0133\u0135\u0003"+
		"\u0006\u0003\u0000\u0134\u0133\u0001\u0000\u0000\u0000\u0135\u0138\u0001"+
		"\u0000\u0000\u0000\u0136\u0134\u0001\u0000\u0000\u0000\u0136\u0137\u0001"+
		"\u0000\u0000\u0000\u0137\u013a\u0001\u0000\u0000\u0000\u0138\u0136\u0001"+
		"\u0000\u0000\u0000\u0139\u0132\u0001\u0000\u0000\u0000\u0139\u013a\u0001"+
		"\u0000\u0000\u0000\u013a\u013b\u0001\u0000\u0000\u0000\u013b\u013c\u0003"+
		"*\u0015\u0000\u013c%\u0001\u0000\u0000\u0000\u013d\u013e\u0005\u0004\u0000"+
		"\u0000\u013e\u013f\u0005A\u0000\u0000\u013f\u0140\u00034\u001a\u0000\u0140"+
		"\u0141\u0005=\u0000\u0000\u0141\'\u0001\u0000\u0000\u0000\u0142\u0143"+
		"\u0005\u0004\u0000\u0000\u0143\u0144\u0005B\u0000\u0000\u0144\u0145\u0005"+
		"=\u0000\u0000\u0145)\u0001\u0000\u0000\u0000\u0146\u0147\u0005\u0004\u0000"+
		"\u0000\u0147\u0148\u0005C\u0000\u0000\u0148\u0149\u0005=\u0000\u0000\u0149"+
		"+\u0001\u0000\u0000\u0000\u014a\u014e\u0003.\u0017\u0000\u014b\u014d\u0003"+
		"\u0006\u0003\u0000\u014c\u014b\u0001\u0000\u0000\u0000\u014d\u0150\u0001"+
		"\u0000\u0000\u0000\u014e\u014c\u0001\u0000\u0000\u0000\u014e\u014f\u0001"+
		"\u0000\u0000\u0000\u014f\u0151\u0001\u0000\u0000\u0000\u0150\u014e\u0001"+
		"\u0000\u0000\u0000\u0151\u0152\u00030\u0018\u0000\u0152-\u0001\u0000\u0000"+
		"\u0000\u0153\u0154\u0005\u0004\u0000\u0000\u0154\u0155\u0005E\u0000\u0000"+
		"\u0155\u0156\u0005e\u0000\u0000\u0156\u0157\u0005=\u0000\u0000\u0157/"+
		"\u0001\u0000\u0000\u0000\u0158\u0159\u0005\u0004\u0000\u0000\u0159\u015a"+
		"\u0005F\u0000\u0000\u015a\u015b\u0005=\u0000\u0000\u015b1\u0001\u0000"+
		"\u0000\u0000\u015c\u015d\u0005\u0004\u0000\u0000\u015d\u015e\u0005D\u0000"+
		"\u0000\u015e\u015f\u0005e\u0000\u0000\u015f\u0160\u0005]\u0000\u0000\u0160"+
		"\u0161\u00034\u001a\u0000\u0161\u0162\u0005=\u0000\u0000\u01623\u0001"+
		"\u0000\u0000\u0000\u0163\u0164\u0006\u001a\uffff\uffff\u0000\u0164\u0165"+
		"\u0005H\u0000\u0000\u0165\u0176\u00034\u001a\n\u0166\u0167\u0005e\u0000"+
		"\u0000\u0167\u0169\u0005S\u0000\u0000\u0168\u016a\u00036\u001b\u0000\u0169"+
		"\u0168\u0001\u0000\u0000\u0000\u0169\u016a\u0001\u0000\u0000\u0000\u016a"+
		"\u016b\u0001\u0000\u0000\u0000\u016b\u0176\u0005T\u0000\u0000\u016c\u016d"+
		"\u0005S\u0000\u0000\u016d\u016e\u00034\u001a\u0000\u016e\u016f\u0005T"+
		"\u0000\u0000\u016f\u0176\u0001\u0000\u0000\u0000\u0170\u0176\u0005e\u0000"+
		"\u0000\u0171\u0176\u0005c\u0000\u0000\u0172\u0176\u0005d\u0000\u0000\u0173"+
		"\u0176\u0007\u0006\u0000\u0000\u0174\u0176\u0005N\u0000\u0000\u0175\u0163"+
		"\u0001\u0000\u0000\u0000\u0175\u0166\u0001\u0000\u0000\u0000\u0175\u016c"+
		"\u0001\u0000\u0000\u0000\u0175\u0170\u0001\u0000\u0000\u0000\u0175\u0171"+
		"\u0001\u0000\u0000\u0000\u0175\u0172\u0001\u0000\u0000\u0000\u0175\u0173"+
		"\u0001\u0000\u0000\u0000\u0175\u0174\u0001\u0000\u0000\u0000\u0176\u01a0"+
		"\u0001\u0000\u0000\u0000\u0177\u0178\n\u000f\u0000\u0000\u0178\u0179\u0007"+
		"\u0007\u0000\u0000\u0179\u019f\u00034\u001a\u0010\u017a\u017b\n\u000e"+
		"\u0000\u0000\u017b\u017c\u0007\b\u0000\u0000\u017c\u019f\u00034\u001a"+
		"\u000f\u017d\u017e\n\r\u0000\u0000\u017e\u017f\u0007\t\u0000\u0000\u017f"+
		"\u019f\u00034\u001a\u000e\u0180\u0181\n\u000b\u0000\u0000\u0181\u0182"+
		"\u0005G\u0000\u0000\u0182\u019f\u00034\u001a\f\u0183\u0184\n\t\u0000\u0000"+
		"\u0184\u0185\u0005I\u0000\u0000\u0185\u019f\u00034\u001a\n\u0186\u0187"+
		"\n\b\u0000\u0000\u0187\u0188\u0005J\u0000\u0000\u0188\u019f\u00034\u001a"+
		"\t\u0189\u018a\n\u0012\u0000\u0000\u018a\u018b\u0005P\u0000\u0000\u018b"+
		"\u0191\u0005e\u0000\u0000\u018c\u018e\u0005S\u0000\u0000\u018d\u018f\u0003"+
		"6\u001b\u0000\u018e\u018d\u0001\u0000\u0000\u0000\u018e\u018f\u0001\u0000"+
		"\u0000\u0000\u018f\u0190\u0001\u0000\u0000\u0000\u0190\u0192\u0005T\u0000"+
		"\u0000\u0191\u018c\u0001\u0000\u0000\u0000\u0191\u0192\u0001\u0000\u0000"+
		"\u0000\u0192\u019f\u0001\u0000\u0000\u0000\u0193\u0194\n\u0011\u0000\u0000"+
		"\u0194\u0195\u0005O\u0000\u0000\u0195\u019f\u0005e\u0000\u0000\u0196\u0197"+
		"\n\u0010\u0000\u0000\u0197\u0198\u0005U\u0000\u0000\u0198\u0199\u0003"+
		"4\u001a\u0000\u0199\u019a\u0005V\u0000\u0000\u019a\u019f\u0001\u0000\u0000"+
		"\u0000\u019b\u019c\n\f\u0000\u0000\u019c\u019d\u0005K\u0000\u0000\u019d"+
		"\u019f\u0005e\u0000\u0000\u019e\u0177\u0001\u0000\u0000\u0000\u019e\u017a"+
		"\u0001\u0000\u0000\u0000\u019e\u017d\u0001\u0000\u0000\u0000\u019e\u0180"+
		"\u0001\u0000\u0000\u0000\u019e\u0183\u0001\u0000\u0000\u0000\u019e\u0186"+
		"\u0001\u0000\u0000\u0000\u019e\u0189\u0001\u0000\u0000\u0000\u019e\u0193"+
		"\u0001\u0000\u0000\u0000\u019e\u0196\u0001\u0000\u0000\u0000\u019e\u019b"+
		"\u0001\u0000\u0000\u0000\u019f\u01a2\u0001\u0000\u0000\u0000\u01a0\u019e"+
		"\u0001\u0000\u0000\u0000\u01a0\u01a1\u0001\u0000\u0000\u0000\u01a15\u0001"+
		"\u0000\u0000\u0000\u01a2\u01a0\u0001\u0000\u0000\u0000\u01a3\u01a8\u0003"+
		"8\u001c\u0000\u01a4\u01a5\u0005Q\u0000\u0000\u01a5\u01a7\u00038\u001c"+
		"\u0000\u01a6\u01a4\u0001\u0000\u0000\u0000\u01a7\u01aa\u0001\u0000\u0000"+
		"\u0000\u01a8\u01a6\u0001\u0000\u0000\u0000\u01a8\u01a9\u0001\u0000\u0000"+
		"\u0000\u01a97\u0001\u0000\u0000\u0000\u01aa\u01a8\u0001\u0000\u0000\u0000"+
		"\u01ab\u01ac\u0005e\u0000\u0000\u01ac\u01ae\u0005]\u0000\u0000\u01ad\u01ab"+
		"\u0001\u0000\u0000\u0000\u01ad\u01ae\u0001\u0000\u0000\u0000\u01ae\u01af"+
		"\u0001\u0000\u0000\u0000\u01af\u01b0\u00034\u001a\u0000\u01b09\u0001\u0000"+
		"\u0000\u0000\u01b1\u01b3\u0007\n\u0000\u0000\u01b2\u01b1\u0001\u0000\u0000"+
		"\u0000\u01b3\u01b4\u0001\u0000\u0000\u0000\u01b4\u01b2\u0001\u0000\u0000"+
		"\u0000\u01b4\u01b5\u0001\u0000\u0000\u0000\u01b5;\u0001\u0000\u0000\u0000"+
		"\u01b6\u01b8\u0003>\u001f\u0000\u01b7\u01b6\u0001\u0000\u0000\u0000\u01b8"+
		"\u01bb\u0001\u0000\u0000\u0000\u01b9\u01b7\u0001\u0000\u0000\u0000\u01b9"+
		"\u01ba\u0001\u0000\u0000\u0000\u01ba\u01bc\u0001\u0000\u0000\u0000\u01bb"+
		"\u01b9\u0001\u0000\u0000\u0000\u01bc\u01bd\u0005\u0000\u0000\u0001\u01bd"+
		"=\u0001\u0000\u0000\u0000\u01be\u01bf\u0003@ \u0000\u01bf\u01c3\u0005"+
		"i\u0000\u0000\u01c0\u01c2\u0003F#\u0000\u01c1\u01c0\u0001\u0000\u0000"+
		"\u0000\u01c2\u01c5\u0001\u0000\u0000\u0000\u01c3\u01c1\u0001\u0000\u0000"+
		"\u0000\u01c3\u01c4\u0001\u0000\u0000\u0000\u01c4\u01c6\u0001\u0000\u0000"+
		"\u0000\u01c5\u01c3\u0001\u0000\u0000\u0000\u01c6\u01c7\u0005j\u0000\u0000"+
		"\u01c7?\u0001\u0000\u0000\u0000\u01c8\u01cd\u0003B!\u0000\u01c9\u01ca"+
		"\u0005m\u0000\u0000\u01ca\u01cc\u0003B!\u0000\u01cb\u01c9\u0001\u0000"+
		"\u0000\u0000\u01cc\u01cf\u0001\u0000\u0000\u0000\u01cd\u01cb\u0001\u0000"+
		"\u0000\u0000\u01cd\u01ce\u0001\u0000\u0000\u0000\u01ceA\u0001\u0000\u0000"+
		"\u0000\u01cf\u01cd\u0001\u0000\u0000\u0000\u01d0\u01d7\u0003D\"\u0000"+
		"\u01d1\u01d3\u0007\u000b\u0000\u0000\u01d2\u01d1\u0001\u0000\u0000\u0000"+
		"\u01d2\u01d3\u0001\u0000\u0000\u0000\u01d3\u01d4\u0001\u0000\u0000\u0000"+
		"\u01d4\u01d6\u0003D\"\u0000\u01d5\u01d2\u0001\u0000\u0000\u0000\u01d6"+
		"\u01d9\u0001\u0000\u0000\u0000\u01d7\u01d5\u0001\u0000\u0000\u0000\u01d7"+
		"\u01d8\u0001\u0000\u0000\u0000\u01d8\u01df\u0001\u0000\u0000\u0000\u01d9"+
		"\u01d7\u0001\u0000\u0000\u0000\u01da\u01dc\u0005k\u0000\u0000\u01db\u01dd"+
		"\u0005k\u0000\u0000\u01dc\u01db\u0001\u0000\u0000\u0000\u01dc\u01dd\u0001"+
		"\u0000\u0000\u0000\u01dd\u01de\u0001\u0000\u0000\u0000\u01de\u01e0\u0005"+
		"{\u0000\u0000\u01df\u01da\u0001\u0000\u0000\u0000\u01df\u01e0\u0001\u0000"+
		"\u0000\u0000\u01e0C\u0001\u0000\u0000\u0000\u01e1\u01e8\u0005{\u0000\u0000"+
		"\u01e2\u01e3\u0005n\u0000\u0000\u01e3\u01e8\u0005{\u0000\u0000\u01e4\u01e5"+
		"\u0005o\u0000\u0000\u01e5\u01e8\u0005{\u0000\u0000\u01e6\u01e8\u0005r"+
		"\u0000\u0000\u01e7\u01e1\u0001\u0000\u0000\u0000\u01e7\u01e2\u0001\u0000"+
		"\u0000\u0000\u01e7\u01e4\u0001\u0000\u0000\u0000\u01e7\u01e6\u0001\u0000"+
		"\u0000\u0000\u01e8E\u0001\u0000\u0000\u0000\u01e9\u01ea\u0005{\u0000\u0000"+
		"\u01ea\u01eb\u0005k\u0000\u0000\u01eb\u01ed\u0003H$\u0000\u01ec\u01ee"+
		"\u0005h\u0000\u0000\u01ed\u01ec\u0001\u0000\u0000\u0000\u01ed\u01ee\u0001"+
		"\u0000\u0000\u0000\u01ee\u01f0\u0001\u0000\u0000\u0000\u01ef\u01f1\u0005"+
		"l\u0000\u0000\u01f0\u01ef\u0001\u0000\u0000\u0000\u01f0\u01f1\u0001\u0000"+
		"\u0000\u0000\u01f1G\u0001\u0000\u0000\u0000\u01f2\u01f4\u0003J%\u0000"+
		"\u01f3\u01f2\u0001\u0000\u0000\u0000\u01f4\u01f5\u0001\u0000\u0000\u0000"+
		"\u01f5\u01f3\u0001\u0000\u0000\u0000\u01f5\u01f6\u0001\u0000\u0000\u0000"+
		"\u01f6I\u0001\u0000\u0000\u0000\u01f7\u01f9\u0005z\u0000\u0000\u01f8\u01fa"+
		"\u0005{\u0000\u0000\u01f9\u01f8\u0001\u0000\u0000\u0000\u01f9\u01fa\u0001"+
		"\u0000\u0000\u0000\u01fa\u0208\u0001\u0000\u0000\u0000\u01fb\u01fc\u0005"+
		"z\u0000\u0000\u01fc\u0208\u0005v\u0000\u0000\u01fd\u0208\u0005x\u0000"+
		"\u0000\u01fe\u0208\u0005{\u0000\u0000\u01ff\u0208\u0005y\u0000\u0000\u0200"+
		"\u0201\u0005{\u0000\u0000\u0201\u0202\u0005p\u0000\u0000\u0202\u0203\u0003"+
		"H$\u0000\u0203\u0204\u0005q\u0000\u0000\u0204\u0208\u0001\u0000\u0000"+
		"\u0000\u0205\u0208\u0005m\u0000\u0000\u0206\u0208\u0005w\u0000\u0000\u0207"+
		"\u01f7\u0001\u0000\u0000\u0000\u0207\u01fb\u0001\u0000\u0000\u0000\u0207"+
		"\u01fd\u0001\u0000\u0000\u0000\u0207\u01fe\u0001\u0000\u0000\u0000\u0207"+
		"\u01ff\u0001\u0000\u0000\u0000\u0207\u0200\u0001\u0000\u0000\u0000\u0207"+
		"\u0205\u0001\u0000\u0000\u0000\u0207\u0206\u0001\u0000\u0000\u0000\u0208"+
		"K\u0001\u0000\u0000\u00004NQVfmv\u0080\u0087\u008e\u0097\u009d\u00a5\u00aa"+
		"\u00af\u00b4\u00c2\u00ca\u00d6\u00ef\u00f2\u00ff\u0101\u0109\u010e\u0115"+
		"\u011b\u012f\u0136\u0139\u014e\u0169\u0175\u018e\u0191\u019e\u01a0\u01a8"+
		"\u01ad\u01b4\u01b9\u01c3\u01cd\u01d2\u01d7\u01dc\u01df\u01e7\u01ed\u01f0"+
		"\u01f5\u01f9\u0207";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}