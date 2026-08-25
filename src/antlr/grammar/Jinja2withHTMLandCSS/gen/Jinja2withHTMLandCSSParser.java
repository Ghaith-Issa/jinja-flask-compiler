// Generated from src/antlr/grammar/Jinja2withHTMLandCSS/Jinja2withHTMLandCSSParser.g4 by ANTLR 4.13.2
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
		WS=1, JINJA_COMMENT=2, DOCTYPE_TAG=3, HTML_TAG=4, HEAD_TAG=5, BODY_TAG=6, 
		META_TAG=7, TITLE_TAG=8, LINK_TAG=9, DIV_TAG=10, A_TAG=11, P_TAG=12, H1_TAG=13, 
		H2_TAG=14, H3_TAG=15, H4_TAG=16, H5_TAG=17, H6_TAG=18, IMG_TAG=19, FORM_TAG=20, 
		INPUT_TAG=21, LABEL_TAG=22, BUTTON_TAG=23, TEXTAREA_TAG=24, SPAN_TAG=25, 
		UL_TAG=26, LI_TAG=27, CHARSET_ATT=28, STYLE_ATT=29, ALT_ATT=30, HREF_ATT=31, 
		SRC_ATT=32, REL_ATT=33, CLASS_ATT=34, METHOD_ATT=35, TYPE_ATT=36, NAME_ATT=37, 
		STEP_ATT=38, REQUIRED_ATT=39, ACTION_ATT=40, VALUE_ATT=41, FONT_FAMILY=42, 
		BACKGROUND=43, BACKGROUND_COLOR=44, COLOR_PROP=45, PADDING=46, PADDING_TOP=47, 
		PADDING_BOTTOM=48, MARGIN=49, MARGIN_TOP=50, MARGIN_BOTTOM=51, WIDTH=52, 
		HEIGHT=53, DISPLAY=54, GAP=55, FLEX_WRAP=56, JUSTIFY_CONTENT=57, TEXT_ALIGN=58, 
		FONT_SIZE=59, FONT_WEIGHT=60, BORDER=61, BORDER_RADIUS=62, BOX_SHADOW=63, 
		TEXT_DECORATION=64, CURSOR=65, TRANSFORM=66, FLEX_DIRECTION=67, PSEUDO_HOVER=68, 
		LCURLY=69, RCURLY=70, BLOCK_START=71, BLOCK_END=72, ASSIGN=73, NOT=74, 
		OPEN_TAG=75, OPEN_TAG_SLASH=76, CLOSE_TAG=77, SELF_CLOSD=78, COLON=79, 
		SEMICOLON=80, COMMA=81, LPAREN=82, RPAREN=83, DOT=84, HASH=85, PLUS=86, 
		MINUS=87, STAR=88, DIVISION=89, FOR=90, END_FOR=91, IN=92, STRING=93, 
		NUMBER=94, BOOL=95, CSS_UNIT=96, CSS_COLOR=97, IDDEFINER=98;
	public static final int
		RULE_prog = 0, RULE_jinja2Prog = 1, RULE_doctype = 2, RULE_htmlelement = 3, 
		RULE_startTag = 4, RULE_endTag = 5, RULE_tagName = 6, RULE_voidTagName = 7, 
		RULE_attribute = 8, RULE_attributeName = 9, RULE_attributeValue = 10, 
		RULE_elementContent = 11, RULE_statement = 12, RULE_expression = 13, RULE_memberAccess = 14, 
		RULE_block = 15, RULE_anyId = 16, RULE_cssProg = 17, RULE_cssRule = 18, 
		RULE_cssSelectorList = 19, RULE_cssSelector = 20, RULE_cssElementName = 21, 
		RULE_className = 22, RULE_simpleSelector = 23, RULE_pseudoClass = 24, 
		RULE_cssDeclaration = 25, RULE_cssProperty = 26, RULE_cssValue = 27, RULE_cssValueAtom = 28;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "jinja2Prog", "doctype", "htmlelement", "startTag", "endTag", 
			"tagName", "voidTagName", "attribute", "attributeName", "attributeValue", 
			"elementContent", "statement", "expression", "memberAccess", "block", 
			"anyId", "cssProg", "cssRule", "cssSelectorList", "cssSelector", "cssElementName", 
			"className", "simpleSelector", "pseudoClass", "cssDeclaration", "cssProperty", 
			"cssValue", "cssValueAtom"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'DOCTYPE'", "'html'", "'head'", "'body'", "'meta'", 
			"'title'", "'link'", "'div'", "'a'", "'p'", "'h1'", "'h2'", "'h3'", "'h4'", 
			"'h5'", "'h6'", "'img'", "'form'", "'input'", "'label'", "'button'", 
			"'textarea'", "'span'", "'ul'", "'li'", "'charset'", "'style'", "'alt'", 
			"'href'", "'src'", "'rel'", "'class'", "'method'", "'type'", "'name'", 
			"'step'", "'required'", "'action'", "'value'", "'font-family'", "'background'", 
			"'background-color'", "'color'", "'padding'", "'padding-top'", "'padding-bottom'", 
			"'margin'", "'margin-top'", "'margin-bottom'", "'width'", "'height'", 
			"'display'", "'gap'", "'flex-wrap'", "'justify-content'", "'text-align'", 
			"'font-size'", "'font-weight'", "'border'", "'border-radius'", "'box-shadow'", 
			"'text-decoration'", "'cursor'", "'transform'", "'flex-direction'", "'hover'", 
			"'{'", "'}'", "'{%'", "'%}'", "'='", "'!'", "'<'", "'</'", "'>'", "'/>'", 
			"':'", "';'", "','", "'('", "')'", "'.'", "'#'", "'+'", "'-'", "'*'", 
			"'/'", "'for'", "'endfor'", "'in'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS", "JINJA_COMMENT", "DOCTYPE_TAG", "HTML_TAG", "HEAD_TAG", "BODY_TAG", 
			"META_TAG", "TITLE_TAG", "LINK_TAG", "DIV_TAG", "A_TAG", "P_TAG", "H1_TAG", 
			"H2_TAG", "H3_TAG", "H4_TAG", "H5_TAG", "H6_TAG", "IMG_TAG", "FORM_TAG", 
			"INPUT_TAG", "LABEL_TAG", "BUTTON_TAG", "TEXTAREA_TAG", "SPAN_TAG", "UL_TAG", 
			"LI_TAG", "CHARSET_ATT", "STYLE_ATT", "ALT_ATT", "HREF_ATT", "SRC_ATT", 
			"REL_ATT", "CLASS_ATT", "METHOD_ATT", "TYPE_ATT", "NAME_ATT", "STEP_ATT", 
			"REQUIRED_ATT", "ACTION_ATT", "VALUE_ATT", "FONT_FAMILY", "BACKGROUND", 
			"BACKGROUND_COLOR", "COLOR_PROP", "PADDING", "PADDING_TOP", "PADDING_BOTTOM", 
			"MARGIN", "MARGIN_TOP", "MARGIN_BOTTOM", "WIDTH", "HEIGHT", "DISPLAY", 
			"GAP", "FLEX_WRAP", "JUSTIFY_CONTENT", "TEXT_ALIGN", "FONT_SIZE", "FONT_WEIGHT", 
			"BORDER", "BORDER_RADIUS", "BOX_SHADOW", "TEXT_DECORATION", "CURSOR", 
			"TRANSFORM", "FLEX_DIRECTION", "PSEUDO_HOVER", "LCURLY", "RCURLY", "BLOCK_START", 
			"BLOCK_END", "ASSIGN", "NOT", "OPEN_TAG", "OPEN_TAG_SLASH", "CLOSE_TAG", 
			"SELF_CLOSD", "COLON", "SEMICOLON", "COMMA", "LPAREN", "RPAREN", "DOT", 
			"HASH", "PLUS", "MINUS", "STAR", "DIVISION", "FOR", "END_FOR", "IN", 
			"STRING", "NUMBER", "BOOL", "CSS_UNIT", "CSS_COLOR", "IDDEFINER"
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
	public static class Jinja2Context extends ProgContext {
		public Jinja2ProgContext jinja2Prog() {
			return getRuleContext(Jinja2ProgContext.class,0);
		}
		public Jinja2Context(ProgContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitJinja2(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssContext extends ProgContext {
		public CssProgContext cssProg() {
			return getRuleContext(CssProgContext.class,0);
		}
		public CssContext(ProgContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitCss(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			setState(60);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new Jinja2Context(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				jinja2Prog();
				}
				break;
			case 2:
				_localctx = new CssContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
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
	public static class Jinja2ProgContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(Jinja2withHTMLandCSSParser.EOF, 0); }
		public DoctypeContext doctype() {
			return getRuleContext(DoctypeContext.class,0);
		}
		public List<ElementContentContext> elementContent() {
			return getRuleContexts(ElementContentContext.class);
		}
		public ElementContentContext elementContent(int i) {
			return getRuleContext(ElementContentContext.class,i);
		}
		public Jinja2ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinja2Prog; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitJinja2Prog(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Jinja2ProgContext jinja2Prog() throws RecognitionException {
		Jinja2ProgContext _localctx = new Jinja2ProgContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_jinja2Prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(62);
				doctype();
				}
				break;
			}
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4398045994992L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 616494149L) != 0)) {
				{
				{
				setState(65);
				elementContent();
				}
				}
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(71);
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
		public TerminalNode NOT() { return getToken(Jinja2withHTMLandCSSParser.NOT, 0); }
		public TerminalNode DOCTYPE_TAG() { return getToken(Jinja2withHTMLandCSSParser.DOCTYPE_TAG, 0); }
		public TerminalNode HTML_TAG() { return getToken(Jinja2withHTMLandCSSParser.HTML_TAG, 0); }
		public TerminalNode CLOSE_TAG() { return getToken(Jinja2withHTMLandCSSParser.CLOSE_TAG, 0); }
		public DoctypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doctype; }
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
			setState(73);
			match(OPEN_TAG);
			setState(74);
			match(NOT);
			setState(75);
			match(DOCTYPE_TAG);
			setState(76);
			match(HTML_TAG);
			setState(77);
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
	public static class HtmlelementContext extends ParserRuleContext {
		public HtmlelementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlelement; }
	 
		public HtmlelementContext() { }
		public void copyFrom(HtmlelementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SelfClosingTagContext extends HtmlelementContext {
		public TerminalNode OPEN_TAG() { return getToken(Jinja2withHTMLandCSSParser.OPEN_TAG, 0); }
		public VoidTagNameContext voidTagName() {
			return getRuleContext(VoidTagNameContext.class,0);
		}
		public TerminalNode SELF_CLOSD() { return getToken(Jinja2withHTMLandCSSParser.SELF_CLOSD, 0); }
		public TerminalNode CLOSE_TAG() { return getToken(Jinja2withHTMLandCSSParser.CLOSE_TAG, 0); }
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public SelfClosingTagContext(HtmlelementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitSelfClosingTag(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OpenCloseTagContext extends HtmlelementContext {
		public StartTagContext startTag() {
			return getRuleContext(StartTagContext.class,0);
		}
		public EndTagContext endTag() {
			return getRuleContext(EndTagContext.class,0);
		}
		public List<ElementContentContext> elementContent() {
			return getRuleContexts(ElementContentContext.class);
		}
		public ElementContentContext elementContent(int i) {
			return getRuleContext(ElementContentContext.class,i);
		}
		public OpenCloseTagContext(HtmlelementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitOpenCloseTag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlelementContext htmlelement() throws RecognitionException {
		HtmlelementContext _localctx = new HtmlelementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_htmlelement);
		int _la;
		try {
			setState(98);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new OpenCloseTagContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(79);
				startTag();
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4398045994992L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 616494149L) != 0)) {
					{
					{
					setState(80);
					elementContent();
					}
					}
					setState(85);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(86);
				endTag();
				}
				break;
			case 2:
				_localctx = new SelfClosingTagContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(88);
				match(OPEN_TAG);
				setState(89);
				voidTagName();
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4397778075648L) != 0)) {
					{
					{
					setState(90);
					attribute();
					}
					}
					setState(95);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(96);
				_la = _input.LA(1);
				if ( !(_la==CLOSE_TAG || _la==SELF_CLOSD) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
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
	public static class StartTagContext extends ParserRuleContext {
		public TerminalNode OPEN_TAG() { return getToken(Jinja2withHTMLandCSSParser.OPEN_TAG, 0); }
		public TagNameContext tagName() {
			return getRuleContext(TagNameContext.class,0);
		}
		public TerminalNode CLOSE_TAG() { return getToken(Jinja2withHTMLandCSSParser.CLOSE_TAG, 0); }
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public StartTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_startTag; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitStartTag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartTagContext startTag() throws RecognitionException {
		StartTagContext _localctx = new StartTagContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_startTag);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(OPEN_TAG);
			setState(101);
			tagName();
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4397778075648L) != 0)) {
				{
				{
				setState(102);
				attribute();
				}
				}
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(108);
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
	public static class EndTagContext extends ParserRuleContext {
		public TerminalNode OPEN_TAG_SLASH() { return getToken(Jinja2withHTMLandCSSParser.OPEN_TAG_SLASH, 0); }
		public TagNameContext tagName() {
			return getRuleContext(TagNameContext.class,0);
		}
		public TerminalNode CLOSE_TAG() { return getToken(Jinja2withHTMLandCSSParser.CLOSE_TAG, 0); }
		public EndTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_endTag; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitEndTag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EndTagContext endTag() throws RecognitionException {
		EndTagContext _localctx = new EndTagContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_endTag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(OPEN_TAG_SLASH);
			setState(111);
			tagName();
			setState(112);
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
	public static class TagNameContext extends ParserRuleContext {
		public TerminalNode HTML_TAG() { return getToken(Jinja2withHTMLandCSSParser.HTML_TAG, 0); }
		public TerminalNode HEAD_TAG() { return getToken(Jinja2withHTMLandCSSParser.HEAD_TAG, 0); }
		public TerminalNode BODY_TAG() { return getToken(Jinja2withHTMLandCSSParser.BODY_TAG, 0); }
		public TerminalNode TITLE_TAG() { return getToken(Jinja2withHTMLandCSSParser.TITLE_TAG, 0); }
		public TerminalNode DIV_TAG() { return getToken(Jinja2withHTMLandCSSParser.DIV_TAG, 0); }
		public TerminalNode A_TAG() { return getToken(Jinja2withHTMLandCSSParser.A_TAG, 0); }
		public TerminalNode P_TAG() { return getToken(Jinja2withHTMLandCSSParser.P_TAG, 0); }
		public TerminalNode H1_TAG() { return getToken(Jinja2withHTMLandCSSParser.H1_TAG, 0); }
		public TerminalNode H2_TAG() { return getToken(Jinja2withHTMLandCSSParser.H2_TAG, 0); }
		public TerminalNode H3_TAG() { return getToken(Jinja2withHTMLandCSSParser.H3_TAG, 0); }
		public TerminalNode H4_TAG() { return getToken(Jinja2withHTMLandCSSParser.H4_TAG, 0); }
		public TerminalNode H5_TAG() { return getToken(Jinja2withHTMLandCSSParser.H5_TAG, 0); }
		public TerminalNode H6_TAG() { return getToken(Jinja2withHTMLandCSSParser.H6_TAG, 0); }
		public TerminalNode FORM_TAG() { return getToken(Jinja2withHTMLandCSSParser.FORM_TAG, 0); }
		public TerminalNode LABEL_TAG() { return getToken(Jinja2withHTMLandCSSParser.LABEL_TAG, 0); }
		public TerminalNode BUTTON_TAG() { return getToken(Jinja2withHTMLandCSSParser.BUTTON_TAG, 0); }
		public TerminalNode TEXTAREA_TAG() { return getToken(Jinja2withHTMLandCSSParser.TEXTAREA_TAG, 0); }
		public TerminalNode SPAN_TAG() { return getToken(Jinja2withHTMLandCSSParser.SPAN_TAG, 0); }
		public TerminalNode UL_TAG() { return getToken(Jinja2withHTMLandCSSParser.UL_TAG, 0); }
		public TerminalNode LI_TAG() { return getToken(Jinja2withHTMLandCSSParser.LI_TAG, 0); }
		public TagNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tagName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitTagName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TagNameContext tagName() throws RecognitionException {
		TagNameContext _localctx = new TagNameContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_tagName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 265813360L) != 0)) ) {
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
	public static class VoidTagNameContext extends ParserRuleContext {
		public TerminalNode META_TAG() { return getToken(Jinja2withHTMLandCSSParser.META_TAG, 0); }
		public TerminalNode LINK_TAG() { return getToken(Jinja2withHTMLandCSSParser.LINK_TAG, 0); }
		public TerminalNode IMG_TAG() { return getToken(Jinja2withHTMLandCSSParser.IMG_TAG, 0); }
		public TerminalNode INPUT_TAG() { return getToken(Jinja2withHTMLandCSSParser.INPUT_TAG, 0); }
		public VoidTagNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_voidTagName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitVoidTagName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VoidTagNameContext voidTagName() throws RecognitionException {
		VoidTagNameContext _localctx = new VoidTagNameContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_voidTagName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2622080L) != 0)) ) {
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
	public static class BooleanAttrContext extends AttributeContext {
		public AttributeNameContext attributeName() {
			return getRuleContext(AttributeNameContext.class,0);
		}
		public BooleanAttrContext(AttributeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitBooleanAttr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FullAttrContext extends AttributeContext {
		public AttributeNameContext attributeName() {
			return getRuleContext(AttributeNameContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(Jinja2withHTMLandCSSParser.ASSIGN, 0); }
		public AttributeValueContext attributeValue() {
			return getRuleContext(AttributeValueContext.class,0);
		}
		public FullAttrContext(AttributeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitFullAttr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_attribute);
		try {
			setState(123);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new FullAttrContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(118);
				attributeName();
				setState(119);
				match(ASSIGN);
				setState(120);
				attributeValue();
				}
				break;
			case 2:
				_localctx = new BooleanAttrContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(122);
				attributeName();
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
	public static class AttributeNameContext extends ParserRuleContext {
		public TerminalNode CHARSET_ATT() { return getToken(Jinja2withHTMLandCSSParser.CHARSET_ATT, 0); }
		public TerminalNode ALT_ATT() { return getToken(Jinja2withHTMLandCSSParser.ALT_ATT, 0); }
		public TerminalNode HREF_ATT() { return getToken(Jinja2withHTMLandCSSParser.HREF_ATT, 0); }
		public TerminalNode SRC_ATT() { return getToken(Jinja2withHTMLandCSSParser.SRC_ATT, 0); }
		public TerminalNode REL_ATT() { return getToken(Jinja2withHTMLandCSSParser.REL_ATT, 0); }
		public TerminalNode CLASS_ATT() { return getToken(Jinja2withHTMLandCSSParser.CLASS_ATT, 0); }
		public TerminalNode METHOD_ATT() { return getToken(Jinja2withHTMLandCSSParser.METHOD_ATT, 0); }
		public TerminalNode TYPE_ATT() { return getToken(Jinja2withHTMLandCSSParser.TYPE_ATT, 0); }
		public TerminalNode NAME_ATT() { return getToken(Jinja2withHTMLandCSSParser.NAME_ATT, 0); }
		public TerminalNode STEP_ATT() { return getToken(Jinja2withHTMLandCSSParser.STEP_ATT, 0); }
		public TerminalNode REQUIRED_ATT() { return getToken(Jinja2withHTMLandCSSParser.REQUIRED_ATT, 0); }
		public TerminalNode STYLE_ATT() { return getToken(Jinja2withHTMLandCSSParser.STYLE_ATT, 0); }
		public TerminalNode ACTION_ATT() { return getToken(Jinja2withHTMLandCSSParser.ACTION_ATT, 0); }
		public TerminalNode VALUE_ATT() { return getToken(Jinja2withHTMLandCSSParser.VALUE_ATT, 0); }
		public AttributeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitAttributeName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeNameContext attributeName() throws RecognitionException {
		AttributeNameContext _localctx = new AttributeNameContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_attributeName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4397778075648L) != 0)) ) {
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
	public static class AttributeValueContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(Jinja2withHTMLandCSSParser.STRING, 0); }
		public AttributeValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeValue; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitAttributeValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeValueContext attributeValue() throws RecognitionException {
		AttributeValueContext _localctx = new AttributeValueContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_attributeValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			match(STRING);
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
	public static class ElementContentContext extends ParserRuleContext {
		public ElementContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementContent; }
	 
		public ElementContentContext() { }
		public void copyFrom(ElementContentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NestedElementContext extends ElementContentContext {
		public HtmlelementContext htmlelement() {
			return getRuleContext(HtmlelementContext.class,0);
		}
		public NestedElementContext(ElementContentContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitNestedElement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TextContentContext extends ElementContentContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TextContentContext(ElementContentContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitTextContent(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaExpressionContext extends ElementContentContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public JinjaExpressionContext(ElementContentContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitJinjaExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaBlockContext extends ElementContentContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public JinjaBlockContext(ElementContentContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitJinjaBlock(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaStatementContext extends ElementContentContext {
		public TerminalNode BLOCK_START() { return getToken(Jinja2withHTMLandCSSParser.BLOCK_START, 0); }
		public List<TerminalNode> IDDEFINER() { return getTokens(Jinja2withHTMLandCSSParser.IDDEFINER); }
		public TerminalNode IDDEFINER(int i) {
			return getToken(Jinja2withHTMLandCSSParser.IDDEFINER, i);
		}
		public TerminalNode BLOCK_END() { return getToken(Jinja2withHTMLandCSSParser.BLOCK_END, 0); }
		public List<TerminalNode> ASSIGN() { return getTokens(Jinja2withHTMLandCSSParser.ASSIGN); }
		public TerminalNode ASSIGN(int i) {
			return getToken(Jinja2withHTMLandCSSParser.ASSIGN, i);
		}
		public List<TerminalNode> STRING() { return getTokens(Jinja2withHTMLandCSSParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(Jinja2withHTMLandCSSParser.STRING, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(Jinja2withHTMLandCSSParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(Jinja2withHTMLandCSSParser.NUMBER, i);
		}
		public JinjaStatementContext(ElementContentContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitJinjaStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementContentContext elementContent() throws RecognitionException {
		ElementContentContext _localctx = new ElementContentContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_elementContent);
		int _la;
		try {
			setState(142);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				_localctx = new TextContentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(129);
				statement();
				}
				break;
			case 2:
				_localctx = new NestedElementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(130);
				htmlelement();
				}
				break;
			case 3:
				_localctx = new JinjaExpressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(131);
				expression();
				}
				break;
			case 4:
				_localctx = new JinjaBlockContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(132);
				block();
				}
				break;
			case 5:
				_localctx = new JinjaStatementContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(133);
				match(BLOCK_START);
				setState(134);
				match(IDDEFINER);
				setState(138);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & 36700161L) != 0)) {
					{
					{
					setState(135);
					_la = _input.LA(1);
					if ( !(((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & 36700161L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					setState(140);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(141);
				match(BLOCK_END);
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
	public static class StatementContext extends ParserRuleContext {
		public List<AnyIdContext> anyId() {
			return getRuleContexts(AnyIdContext.class);
		}
		public AnyIdContext anyId(int i) {
			return getRuleContext(AnyIdContext.class,i);
		}
		public List<TerminalNode> COLON() { return getTokens(Jinja2withHTMLandCSSParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(Jinja2withHTMLandCSSParser.COLON, i);
		}
		public List<TerminalNode> LPAREN() { return getTokens(Jinja2withHTMLandCSSParser.LPAREN); }
		public TerminalNode LPAREN(int i) {
			return getToken(Jinja2withHTMLandCSSParser.LPAREN, i);
		}
		public List<TerminalNode> RPAREN() { return getTokens(Jinja2withHTMLandCSSParser.RPAREN); }
		public TerminalNode RPAREN(int i) {
			return getToken(Jinja2withHTMLandCSSParser.RPAREN, i);
		}
		public List<TerminalNode> DOT() { return getTokens(Jinja2withHTMLandCSSParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(Jinja2withHTMLandCSSParser.DOT, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(Jinja2withHTMLandCSSParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Jinja2withHTMLandCSSParser.COMMA, i);
		}
		public List<TerminalNode> PLUS() { return getTokens(Jinja2withHTMLandCSSParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(Jinja2withHTMLandCSSParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(Jinja2withHTMLandCSSParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(Jinja2withHTMLandCSSParser.MINUS, i);
		}
		public List<TerminalNode> STAR() { return getTokens(Jinja2withHTMLandCSSParser.STAR); }
		public TerminalNode STAR(int i) {
			return getToken(Jinja2withHTMLandCSSParser.STAR, i);
		}
		public List<TerminalNode> DIVISION() { return getTokens(Jinja2withHTMLandCSSParser.DIVISION); }
		public TerminalNode DIVISION(int i) {
			return getToken(Jinja2withHTMLandCSSParser.DIVISION, i);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_statement);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(154); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(154);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case HTML_TAG:
					case HEAD_TAG:
					case BODY_TAG:
					case META_TAG:
					case TITLE_TAG:
					case LINK_TAG:
					case DIV_TAG:
					case A_TAG:
					case P_TAG:
					case IMG_TAG:
					case FORM_TAG:
					case INPUT_TAG:
					case LABEL_TAG:
					case BUTTON_TAG:
					case TEXTAREA_TAG:
					case SPAN_TAG:
					case UL_TAG:
					case LI_TAG:
					case CHARSET_ATT:
					case STYLE_ATT:
					case ALT_ATT:
					case HREF_ATT:
					case SRC_ATT:
					case REL_ATT:
					case CLASS_ATT:
					case METHOD_ATT:
					case TYPE_ATT:
					case NAME_ATT:
					case STEP_ATT:
					case REQUIRED_ATT:
					case ACTION_ATT:
					case VALUE_ATT:
					case FOR:
					case IN:
					case BOOL:
					case IDDEFINER:
						{
						setState(144);
						anyId();
						}
						break;
					case COLON:
						{
						setState(145);
						match(COLON);
						}
						break;
					case LPAREN:
						{
						setState(146);
						match(LPAREN);
						}
						break;
					case RPAREN:
						{
						setState(147);
						match(RPAREN);
						}
						break;
					case DOT:
						{
						setState(148);
						match(DOT);
						}
						break;
					case COMMA:
						{
						setState(149);
						match(COMMA);
						}
						break;
					case PLUS:
						{
						setState(150);
						match(PLUS);
						}
						break;
					case MINUS:
						{
						setState(151);
						match(MINUS);
						}
						break;
					case STAR:
						{
						setState(152);
						match(STAR);
						}
						break;
					case DIVISION:
						{
						setState(153);
						match(DIVISION);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(156); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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
	public static class ExpressionContext extends ParserRuleContext {
		public List<TerminalNode> LCURLY() { return getTokens(Jinja2withHTMLandCSSParser.LCURLY); }
		public TerminalNode LCURLY(int i) {
			return getToken(Jinja2withHTMLandCSSParser.LCURLY, i);
		}
		public MemberAccessContext memberAccess() {
			return getRuleContext(MemberAccessContext.class,0);
		}
		public List<TerminalNode> RCURLY() { return getTokens(Jinja2withHTMLandCSSParser.RCURLY); }
		public TerminalNode RCURLY(int i) {
			return getToken(Jinja2withHTMLandCSSParser.RCURLY, i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(LCURLY);
			setState(159);
			match(LCURLY);
			setState(160);
			memberAccess();
			setState(161);
			match(RCURLY);
			setState(162);
			match(RCURLY);
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
	public static class MemberAccessContext extends ParserRuleContext {
		public List<AnyIdContext> anyId() {
			return getRuleContexts(AnyIdContext.class);
		}
		public AnyIdContext anyId(int i) {
			return getRuleContext(AnyIdContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(Jinja2withHTMLandCSSParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(Jinja2withHTMLandCSSParser.DOT, i);
		}
		public MemberAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberAccess; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitMemberAccess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MemberAccessContext memberAccess() throws RecognitionException {
		MemberAccessContext _localctx = new MemberAccessContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_memberAccess);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			anyId();
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(165);
				match(DOT);
				setState(166);
				anyId();
				}
				}
				setState(171);
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
	public static class BlockContext extends ParserRuleContext {
		public List<TerminalNode> BLOCK_START() { return getTokens(Jinja2withHTMLandCSSParser.BLOCK_START); }
		public TerminalNode BLOCK_START(int i) {
			return getToken(Jinja2withHTMLandCSSParser.BLOCK_START, i);
		}
		public TerminalNode FOR() { return getToken(Jinja2withHTMLandCSSParser.FOR, 0); }
		public AnyIdContext anyId() {
			return getRuleContext(AnyIdContext.class,0);
		}
		public TerminalNode IN() { return getToken(Jinja2withHTMLandCSSParser.IN, 0); }
		public MemberAccessContext memberAccess() {
			return getRuleContext(MemberAccessContext.class,0);
		}
		public List<TerminalNode> BLOCK_END() { return getTokens(Jinja2withHTMLandCSSParser.BLOCK_END); }
		public TerminalNode BLOCK_END(int i) {
			return getToken(Jinja2withHTMLandCSSParser.BLOCK_END, i);
		}
		public TerminalNode END_FOR() { return getToken(Jinja2withHTMLandCSSParser.END_FOR, 0); }
		public List<ElementContentContext> elementContent() {
			return getRuleContexts(ElementContentContext.class);
		}
		public ElementContentContext elementContent(int i) {
			return getRuleContext(ElementContentContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_block);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(BLOCK_START);
			setState(173);
			match(FOR);
			setState(174);
			anyId();
			setState(175);
			match(IN);
			setState(176);
			memberAccess();
			setState(177);
			match(BLOCK_END);
			setState(181);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(178);
					elementContent();
					}
					} 
				}
				setState(183);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			setState(184);
			match(BLOCK_START);
			setState(185);
			match(END_FOR);
			setState(186);
			match(BLOCK_END);
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
	public static class AnyIdContext extends ParserRuleContext {
		public TerminalNode IDDEFINER() { return getToken(Jinja2withHTMLandCSSParser.IDDEFINER, 0); }
		public TerminalNode HTML_TAG() { return getToken(Jinja2withHTMLandCSSParser.HTML_TAG, 0); }
		public TerminalNode HEAD_TAG() { return getToken(Jinja2withHTMLandCSSParser.HEAD_TAG, 0); }
		public TerminalNode BODY_TAG() { return getToken(Jinja2withHTMLandCSSParser.BODY_TAG, 0); }
		public TerminalNode DIV_TAG() { return getToken(Jinja2withHTMLandCSSParser.DIV_TAG, 0); }
		public TerminalNode A_TAG() { return getToken(Jinja2withHTMLandCSSParser.A_TAG, 0); }
		public TerminalNode P_TAG() { return getToken(Jinja2withHTMLandCSSParser.P_TAG, 0); }
		public TerminalNode SPAN_TAG() { return getToken(Jinja2withHTMLandCSSParser.SPAN_TAG, 0); }
		public TerminalNode FORM_TAG() { return getToken(Jinja2withHTMLandCSSParser.FORM_TAG, 0); }
		public TerminalNode LABEL_TAG() { return getToken(Jinja2withHTMLandCSSParser.LABEL_TAG, 0); }
		public TerminalNode BUTTON_TAG() { return getToken(Jinja2withHTMLandCSSParser.BUTTON_TAG, 0); }
		public TerminalNode UL_TAG() { return getToken(Jinja2withHTMLandCSSParser.UL_TAG, 0); }
		public TerminalNode LI_TAG() { return getToken(Jinja2withHTMLandCSSParser.LI_TAG, 0); }
		public TerminalNode TITLE_TAG() { return getToken(Jinja2withHTMLandCSSParser.TITLE_TAG, 0); }
		public TerminalNode META_TAG() { return getToken(Jinja2withHTMLandCSSParser.META_TAG, 0); }
		public TerminalNode LINK_TAG() { return getToken(Jinja2withHTMLandCSSParser.LINK_TAG, 0); }
		public TerminalNode IMG_TAG() { return getToken(Jinja2withHTMLandCSSParser.IMG_TAG, 0); }
		public TerminalNode INPUT_TAG() { return getToken(Jinja2withHTMLandCSSParser.INPUT_TAG, 0); }
		public TerminalNode TEXTAREA_TAG() { return getToken(Jinja2withHTMLandCSSParser.TEXTAREA_TAG, 0); }
		public TerminalNode NAME_ATT() { return getToken(Jinja2withHTMLandCSSParser.NAME_ATT, 0); }
		public TerminalNode TYPE_ATT() { return getToken(Jinja2withHTMLandCSSParser.TYPE_ATT, 0); }
		public TerminalNode CLASS_ATT() { return getToken(Jinja2withHTMLandCSSParser.CLASS_ATT, 0); }
		public TerminalNode HREF_ATT() { return getToken(Jinja2withHTMLandCSSParser.HREF_ATT, 0); }
		public TerminalNode SRC_ATT() { return getToken(Jinja2withHTMLandCSSParser.SRC_ATT, 0); }
		public TerminalNode REL_ATT() { return getToken(Jinja2withHTMLandCSSParser.REL_ATT, 0); }
		public TerminalNode STYLE_ATT() { return getToken(Jinja2withHTMLandCSSParser.STYLE_ATT, 0); }
		public TerminalNode CHARSET_ATT() { return getToken(Jinja2withHTMLandCSSParser.CHARSET_ATT, 0); }
		public TerminalNode ALT_ATT() { return getToken(Jinja2withHTMLandCSSParser.ALT_ATT, 0); }
		public TerminalNode METHOD_ATT() { return getToken(Jinja2withHTMLandCSSParser.METHOD_ATT, 0); }
		public TerminalNode STEP_ATT() { return getToken(Jinja2withHTMLandCSSParser.STEP_ATT, 0); }
		public TerminalNode REQUIRED_ATT() { return getToken(Jinja2withHTMLandCSSParser.REQUIRED_ATT, 0); }
		public TerminalNode ACTION_ATT() { return getToken(Jinja2withHTMLandCSSParser.ACTION_ATT, 0); }
		public TerminalNode VALUE_ATT() { return getToken(Jinja2withHTMLandCSSParser.VALUE_ATT, 0); }
		public TerminalNode FOR() { return getToken(Jinja2withHTMLandCSSParser.FOR, 0); }
		public TerminalNode IN() { return getToken(Jinja2withHTMLandCSSParser.IN, 0); }
		public TerminalNode BOOL() { return getToken(Jinja2withHTMLandCSSParser.BOOL, 0); }
		public AnyIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anyId; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitAnyId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnyIdContext anyId() throws RecognitionException {
		AnyIdContext _localctx = new AnyIdContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_anyId);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4398045994992L) != 0) || ((((_la - 90)) & ~0x3f) == 0 && ((1L << (_la - 90)) & 293L) != 0)) ) {
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitCssProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssProgContext cssProg() throws RecognitionException {
		CssProgContext _localctx = new CssProgContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_cssProg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(190);
				cssRule();
				}
				}
				setState(193); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 268435440L) != 0) || ((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & 16387L) != 0) );
			setState(195);
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
		public TerminalNode LCURLY() { return getToken(Jinja2withHTMLandCSSParser.LCURLY, 0); }
		public TerminalNode RCURLY() { return getToken(Jinja2withHTMLandCSSParser.RCURLY, 0); }
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitCssRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssRuleContext cssRule() throws RecognitionException {
		CssRuleContext _localctx = new CssRuleContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_cssRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			cssSelectorList();
			setState(198);
			match(LCURLY);
			setState(202);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 42)) & ~0x3f) == 0 && ((1L << (_la - 42)) & 67108863L) != 0)) {
				{
				{
				setState(199);
				cssDeclaration();
				}
				}
				setState(204);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(205);
			match(RCURLY);
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
		public List<TerminalNode> COMMA() { return getTokens(Jinja2withHTMLandCSSParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Jinja2withHTMLandCSSParser.COMMA, i);
		}
		public CssSelectorListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssSelectorList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitCssSelectorList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssSelectorListContext cssSelectorList() throws RecognitionException {
		CssSelectorListContext _localctx = new CssSelectorListContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_cssSelectorList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			cssSelector();
			setState(212);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(208);
				match(COMMA);
				setState(209);
				cssSelector();
				}
				}
				setState(214);
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
		public List<SimpleSelectorContext> simpleSelector() {
			return getRuleContexts(SimpleSelectorContext.class);
		}
		public SimpleSelectorContext simpleSelector(int i) {
			return getRuleContext(SimpleSelectorContext.class,i);
		}
		public TerminalNode COLON() { return getToken(Jinja2withHTMLandCSSParser.COLON, 0); }
		public PseudoClassContext pseudoClass() {
			return getRuleContext(PseudoClassContext.class,0);
		}
		public CssSelectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssSelector; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitCssSelector(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssSelectorContext cssSelector() throws RecognitionException {
		CssSelectorContext _localctx = new CssSelectorContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_cssSelector);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			simpleSelector();
			setState(219);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 268435440L) != 0) || ((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & 16387L) != 0)) {
				{
				{
				setState(216);
				simpleSelector();
				}
				}
				setState(221);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(222);
				match(COLON);
				setState(223);
				pseudoClass();
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
	public static class CssElementNameContext extends ParserRuleContext {
		public TagNameContext tagName() {
			return getRuleContext(TagNameContext.class,0);
		}
		public VoidTagNameContext voidTagName() {
			return getRuleContext(VoidTagNameContext.class,0);
		}
		public CssElementNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssElementName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitCssElementName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssElementNameContext cssElementName() throws RecognitionException {
		CssElementNameContext _localctx = new CssElementNameContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_cssElementName);
		try {
			setState(228);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HTML_TAG:
			case HEAD_TAG:
			case BODY_TAG:
			case TITLE_TAG:
			case DIV_TAG:
			case A_TAG:
			case P_TAG:
			case H1_TAG:
			case H2_TAG:
			case H3_TAG:
			case H4_TAG:
			case H5_TAG:
			case H6_TAG:
			case FORM_TAG:
			case LABEL_TAG:
			case BUTTON_TAG:
			case TEXTAREA_TAG:
			case SPAN_TAG:
			case UL_TAG:
			case LI_TAG:
				enterOuterAlt(_localctx, 1);
				{
				setState(226);
				tagName();
				}
				break;
			case META_TAG:
			case LINK_TAG:
			case IMG_TAG:
			case INPUT_TAG:
				enterOuterAlt(_localctx, 2);
				{
				setState(227);
				voidTagName();
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
	public static class ClassNameContext extends ParserRuleContext {
		public TerminalNode IDDEFINER() { return getToken(Jinja2withHTMLandCSSParser.IDDEFINER, 0); }
		public CssElementNameContext cssElementName() {
			return getRuleContext(CssElementNameContext.class,0);
		}
		public ClassNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_className; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitClassName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassNameContext className() throws RecognitionException {
		ClassNameContext _localctx = new ClassNameContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_className);
		try {
			setState(232);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDDEFINER:
				enterOuterAlt(_localctx, 1);
				{
				setState(230);
				match(IDDEFINER);
				}
				break;
			case HTML_TAG:
			case HEAD_TAG:
			case BODY_TAG:
			case META_TAG:
			case TITLE_TAG:
			case LINK_TAG:
			case DIV_TAG:
			case A_TAG:
			case P_TAG:
			case H1_TAG:
			case H2_TAG:
			case H3_TAG:
			case H4_TAG:
			case H5_TAG:
			case H6_TAG:
			case IMG_TAG:
			case FORM_TAG:
			case INPUT_TAG:
			case LABEL_TAG:
			case BUTTON_TAG:
			case TEXTAREA_TAG:
			case SPAN_TAG:
			case UL_TAG:
			case LI_TAG:
				enterOuterAlt(_localctx, 2);
				{
				setState(231);
				cssElementName();
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
	public static class SimpleSelectorContext extends ParserRuleContext {
		public SimpleSelectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleSelector; }
	 
		public SimpleSelectorContext() { }
		public void copyFrom(SimpleSelectorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CustomElementSelectorContext extends SimpleSelectorContext {
		public TerminalNode IDDEFINER() { return getToken(Jinja2withHTMLandCSSParser.IDDEFINER, 0); }
		public CustomElementSelectorContext(SimpleSelectorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitCustomElementSelector(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdSelectorContext extends SimpleSelectorContext {
		public TerminalNode HASH() { return getToken(Jinja2withHTMLandCSSParser.HASH, 0); }
		public TerminalNode IDDEFINER() { return getToken(Jinja2withHTMLandCSSParser.IDDEFINER, 0); }
		public IdSelectorContext(SimpleSelectorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitIdSelector(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ClassSelectorContext extends SimpleSelectorContext {
		public TerminalNode DOT() { return getToken(Jinja2withHTMLandCSSParser.DOT, 0); }
		public ClassNameContext className() {
			return getRuleContext(ClassNameContext.class,0);
		}
		public ClassSelectorContext(SimpleSelectorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitClassSelector(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ElementSelectorContext extends SimpleSelectorContext {
		public ClassNameContext className() {
			return getRuleContext(ClassNameContext.class,0);
		}
		public ElementSelectorContext(SimpleSelectorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitElementSelector(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleSelectorContext simpleSelector() throws RecognitionException {
		SimpleSelectorContext _localctx = new SimpleSelectorContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_simpleSelector);
		try {
			setState(240);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				_localctx = new ElementSelectorContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(234);
				className();
				}
				break;
			case 2:
				_localctx = new CustomElementSelectorContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(235);
				match(IDDEFINER);
				}
				break;
			case 3:
				_localctx = new ClassSelectorContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(236);
				match(DOT);
				setState(237);
				className();
				}
				break;
			case 4:
				_localctx = new IdSelectorContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(238);
				match(HASH);
				setState(239);
				match(IDDEFINER);
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
	public static class PseudoClassContext extends ParserRuleContext {
		public TerminalNode PSEUDO_HOVER() { return getToken(Jinja2withHTMLandCSSParser.PSEUDO_HOVER, 0); }
		public PseudoClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pseudoClass; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitPseudoClass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PseudoClassContext pseudoClass() throws RecognitionException {
		PseudoClassContext _localctx = new PseudoClassContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_pseudoClass);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			match(PSEUDO_HOVER);
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
		public CssPropertyContext cssProperty() {
			return getRuleContext(CssPropertyContext.class,0);
		}
		public TerminalNode COLON() { return getToken(Jinja2withHTMLandCSSParser.COLON, 0); }
		public CssValueContext cssValue() {
			return getRuleContext(CssValueContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(Jinja2withHTMLandCSSParser.SEMICOLON, 0); }
		public CssDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitCssDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssDeclarationContext cssDeclaration() throws RecognitionException {
		CssDeclarationContext _localctx = new CssDeclarationContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_cssDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			cssProperty();
			setState(245);
			match(COLON);
			setState(246);
			cssValue();
			setState(247);
			match(SEMICOLON);
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
	public static class CssPropertyContext extends ParserRuleContext {
		public TerminalNode FONT_FAMILY() { return getToken(Jinja2withHTMLandCSSParser.FONT_FAMILY, 0); }
		public TerminalNode BACKGROUND() { return getToken(Jinja2withHTMLandCSSParser.BACKGROUND, 0); }
		public TerminalNode BACKGROUND_COLOR() { return getToken(Jinja2withHTMLandCSSParser.BACKGROUND_COLOR, 0); }
		public TerminalNode COLOR_PROP() { return getToken(Jinja2withHTMLandCSSParser.COLOR_PROP, 0); }
		public TerminalNode PADDING() { return getToken(Jinja2withHTMLandCSSParser.PADDING, 0); }
		public TerminalNode PADDING_TOP() { return getToken(Jinja2withHTMLandCSSParser.PADDING_TOP, 0); }
		public TerminalNode PADDING_BOTTOM() { return getToken(Jinja2withHTMLandCSSParser.PADDING_BOTTOM, 0); }
		public TerminalNode MARGIN() { return getToken(Jinja2withHTMLandCSSParser.MARGIN, 0); }
		public TerminalNode MARGIN_TOP() { return getToken(Jinja2withHTMLandCSSParser.MARGIN_TOP, 0); }
		public TerminalNode MARGIN_BOTTOM() { return getToken(Jinja2withHTMLandCSSParser.MARGIN_BOTTOM, 0); }
		public TerminalNode WIDTH() { return getToken(Jinja2withHTMLandCSSParser.WIDTH, 0); }
		public TerminalNode HEIGHT() { return getToken(Jinja2withHTMLandCSSParser.HEIGHT, 0); }
		public TerminalNode DISPLAY() { return getToken(Jinja2withHTMLandCSSParser.DISPLAY, 0); }
		public TerminalNode GAP() { return getToken(Jinja2withHTMLandCSSParser.GAP, 0); }
		public TerminalNode FLEX_WRAP() { return getToken(Jinja2withHTMLandCSSParser.FLEX_WRAP, 0); }
		public TerminalNode JUSTIFY_CONTENT() { return getToken(Jinja2withHTMLandCSSParser.JUSTIFY_CONTENT, 0); }
		public TerminalNode TEXT_ALIGN() { return getToken(Jinja2withHTMLandCSSParser.TEXT_ALIGN, 0); }
		public TerminalNode FONT_SIZE() { return getToken(Jinja2withHTMLandCSSParser.FONT_SIZE, 0); }
		public TerminalNode FONT_WEIGHT() { return getToken(Jinja2withHTMLandCSSParser.FONT_WEIGHT, 0); }
		public TerminalNode BORDER() { return getToken(Jinja2withHTMLandCSSParser.BORDER, 0); }
		public TerminalNode BORDER_RADIUS() { return getToken(Jinja2withHTMLandCSSParser.BORDER_RADIUS, 0); }
		public TerminalNode BOX_SHADOW() { return getToken(Jinja2withHTMLandCSSParser.BOX_SHADOW, 0); }
		public TerminalNode TEXT_DECORATION() { return getToken(Jinja2withHTMLandCSSParser.TEXT_DECORATION, 0); }
		public TerminalNode CURSOR() { return getToken(Jinja2withHTMLandCSSParser.CURSOR, 0); }
		public TerminalNode TRANSFORM() { return getToken(Jinja2withHTMLandCSSParser.TRANSFORM, 0); }
		public TerminalNode FLEX_DIRECTION() { return getToken(Jinja2withHTMLandCSSParser.FLEX_DIRECTION, 0); }
		public CssPropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssProperty; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitCssProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssPropertyContext cssProperty() throws RecognitionException {
		CssPropertyContext _localctx = new CssPropertyContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_cssProperty);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			_la = _input.LA(1);
			if ( !(((((_la - 42)) & ~0x3f) == 0 && ((1L << (_la - 42)) & 67108863L) != 0)) ) {
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
	public static class CssValueContext extends ParserRuleContext {
		public List<CssValueAtomContext> cssValueAtom() {
			return getRuleContexts(CssValueAtomContext.class);
		}
		public CssValueAtomContext cssValueAtom(int i) {
			return getRuleContext(CssValueAtomContext.class,i);
		}
		public CssValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssValue; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitCssValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssValueContext cssValue() throws RecognitionException {
		CssValueContext _localctx = new CssValueContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_cssValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(251);
				cssValueAtom();
				}
				}
				setState(254); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & 237639L) != 0) );
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
	public static class CssValueAtomContext extends ParserRuleContext {
		public CssValueAtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssValueAtom; }
	 
		public CssValueAtomContext() { }
		public void copyFrom(CssValueAtomContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssCommaContext extends CssValueAtomContext {
		public TerminalNode COMMA() { return getToken(Jinja2withHTMLandCSSParser.COMMA, 0); }
		public CssCommaContext(CssValueAtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitCssComma(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssLParenContext extends CssValueAtomContext {
		public TerminalNode LPAREN() { return getToken(Jinja2withHTMLandCSSParser.LPAREN, 0); }
		public CssLParenContext(CssValueAtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitCssLParen(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssMinusContext extends CssValueAtomContext {
		public TerminalNode MINUS() { return getToken(Jinja2withHTMLandCSSParser.MINUS, 0); }
		public CssMinusContext(CssValueAtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitCssMinus(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssColorContext extends CssValueAtomContext {
		public TerminalNode CSS_COLOR() { return getToken(Jinja2withHTMLandCSSParser.CSS_COLOR, 0); }
		public CssColorContext(CssValueAtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitCssColor(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssIdentifierContext extends CssValueAtomContext {
		public TerminalNode IDDEFINER() { return getToken(Jinja2withHTMLandCSSParser.IDDEFINER, 0); }
		public CssIdentifierContext(CssValueAtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitCssIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssNumberContext extends CssValueAtomContext {
		public TerminalNode NUMBER() { return getToken(Jinja2withHTMLandCSSParser.NUMBER, 0); }
		public CssNumberContext(CssValueAtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitCssNumber(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssUnitContext extends CssValueAtomContext {
		public TerminalNode CSS_UNIT() { return getToken(Jinja2withHTMLandCSSParser.CSS_UNIT, 0); }
		public CssUnitContext(CssValueAtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitCssUnit(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssRParenContext extends CssValueAtomContext {
		public TerminalNode RPAREN() { return getToken(Jinja2withHTMLandCSSParser.RPAREN, 0); }
		public CssRParenContext(CssValueAtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Jinja2withHTMLandCSSParserVisitor ) return ((Jinja2withHTMLandCSSParserVisitor<? extends T>)visitor).visitCssRParen(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssValueAtomContext cssValueAtom() throws RecognitionException {
		CssValueAtomContext _localctx = new CssValueAtomContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_cssValueAtom);
		try {
			setState(264);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				_localctx = new CssNumberContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(256);
				match(NUMBER);
				}
				break;
			case CSS_UNIT:
				_localctx = new CssUnitContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(257);
				match(CSS_UNIT);
				}
				break;
			case CSS_COLOR:
				_localctx = new CssColorContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(258);
				match(CSS_COLOR);
				}
				break;
			case IDDEFINER:
				_localctx = new CssIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(259);
				match(IDDEFINER);
				}
				break;
			case COMMA:
				_localctx = new CssCommaContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(260);
				match(COMMA);
				}
				break;
			case LPAREN:
				_localctx = new CssLParenContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(261);
				match(LPAREN);
				}
				break;
			case RPAREN:
				_localctx = new CssRParenContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(262);
				match(RPAREN);
				}
				break;
			case MINUS:
				_localctx = new CssMinusContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(263);
				match(MINUS);
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

	public static final String _serializedATN =
		"\u0004\u0001b\u010b\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0001\u0000\u0001\u0000\u0003\u0000=\b\u0000"+
		"\u0001\u0001\u0003\u0001@\b\u0001\u0001\u0001\u0005\u0001C\b\u0001\n\u0001"+
		"\f\u0001F\t\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0005"+
		"\u0003R\b\u0003\n\u0003\f\u0003U\t\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0005\u0003\\\b\u0003\n\u0003\f\u0003_"+
		"\t\u0003\u0001\u0003\u0001\u0003\u0003\u0003c\b\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0005\u0004h\b\u0004\n\u0004\f\u0004k\t\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0003\b|\b\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005"+
		"\u000b\u0089\b\u000b\n\u000b\f\u000b\u008c\t\u000b\u0001\u000b\u0003\u000b"+
		"\u008f\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0004\f\u009b\b\f\u000b\f\f\f\u009c\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0005\u000e\u00a8\b\u000e\n\u000e\f\u000e\u00ab\t\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0005"+
		"\u000f\u00b4\b\u000f\n\u000f\f\u000f\u00b7\t\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0004\u0011"+
		"\u00c0\b\u0011\u000b\u0011\f\u0011\u00c1\u0001\u0011\u0001\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u00c9\b\u0012\n\u0012\f\u0012"+
		"\u00cc\t\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0005\u0013\u00d3\b\u0013\n\u0013\f\u0013\u00d6\t\u0013\u0001\u0014\u0001"+
		"\u0014\u0005\u0014\u00da\b\u0014\n\u0014\f\u0014\u00dd\t\u0014\u0001\u0014"+
		"\u0001\u0014\u0003\u0014\u00e1\b\u0014\u0001\u0015\u0001\u0015\u0003\u0015"+
		"\u00e5\b\u0015\u0001\u0016\u0001\u0016\u0003\u0016\u00e9\b\u0016\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0003"+
		"\u0017\u00f1\b\u0017\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001b\u0004"+
		"\u001b\u00fd\b\u001b\u000b\u001b\f\u001b\u00fe\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0003\u001c\u0109\b\u001c\u0001\u001c\u0000\u0000\u001d\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \""+
		"$&(*,.02468\u0000\u0007\u0001\u0000MN\u0005\u0000\u0004\u0006\b\b\n\u0012"+
		"\u0014\u0014\u0016\u001b\u0004\u0000\u0007\u0007\t\t\u0013\u0013\u0015"+
		"\u0015\u0001\u0000\u001c)\u0003\u0000II]^bb\u0006\u0000\u0004\f\u0013"+
		")ZZ\\\\__bb\u0001\u0000*C\u0118\u0000<\u0001\u0000\u0000\u0000\u0002?"+
		"\u0001\u0000\u0000\u0000\u0004I\u0001\u0000\u0000\u0000\u0006b\u0001\u0000"+
		"\u0000\u0000\bd\u0001\u0000\u0000\u0000\nn\u0001\u0000\u0000\u0000\fr"+
		"\u0001\u0000\u0000\u0000\u000et\u0001\u0000\u0000\u0000\u0010{\u0001\u0000"+
		"\u0000\u0000\u0012}\u0001\u0000\u0000\u0000\u0014\u007f\u0001\u0000\u0000"+
		"\u0000\u0016\u008e\u0001\u0000\u0000\u0000\u0018\u009a\u0001\u0000\u0000"+
		"\u0000\u001a\u009e\u0001\u0000\u0000\u0000\u001c\u00a4\u0001\u0000\u0000"+
		"\u0000\u001e\u00ac\u0001\u0000\u0000\u0000 \u00bc\u0001\u0000\u0000\u0000"+
		"\"\u00bf\u0001\u0000\u0000\u0000$\u00c5\u0001\u0000\u0000\u0000&\u00cf"+
		"\u0001\u0000\u0000\u0000(\u00d7\u0001\u0000\u0000\u0000*\u00e4\u0001\u0000"+
		"\u0000\u0000,\u00e8\u0001\u0000\u0000\u0000.\u00f0\u0001\u0000\u0000\u0000"+
		"0\u00f2\u0001\u0000\u0000\u00002\u00f4\u0001\u0000\u0000\u00004\u00f9"+
		"\u0001\u0000\u0000\u00006\u00fc\u0001\u0000\u0000\u00008\u0108\u0001\u0000"+
		"\u0000\u0000:=\u0003\u0002\u0001\u0000;=\u0003\"\u0011\u0000<:\u0001\u0000"+
		"\u0000\u0000<;\u0001\u0000\u0000\u0000=\u0001\u0001\u0000\u0000\u0000"+
		">@\u0003\u0004\u0002\u0000?>\u0001\u0000\u0000\u0000?@\u0001\u0000\u0000"+
		"\u0000@D\u0001\u0000\u0000\u0000AC\u0003\u0016\u000b\u0000BA\u0001\u0000"+
		"\u0000\u0000CF\u0001\u0000\u0000\u0000DB\u0001\u0000\u0000\u0000DE\u0001"+
		"\u0000\u0000\u0000EG\u0001\u0000\u0000\u0000FD\u0001\u0000\u0000\u0000"+
		"GH\u0005\u0000\u0000\u0001H\u0003\u0001\u0000\u0000\u0000IJ\u0005K\u0000"+
		"\u0000JK\u0005J\u0000\u0000KL\u0005\u0003\u0000\u0000LM\u0005\u0004\u0000"+
		"\u0000MN\u0005M\u0000\u0000N\u0005\u0001\u0000\u0000\u0000OS\u0003\b\u0004"+
		"\u0000PR\u0003\u0016\u000b\u0000QP\u0001\u0000\u0000\u0000RU\u0001\u0000"+
		"\u0000\u0000SQ\u0001\u0000\u0000\u0000ST\u0001\u0000\u0000\u0000TV\u0001"+
		"\u0000\u0000\u0000US\u0001\u0000\u0000\u0000VW\u0003\n\u0005\u0000Wc\u0001"+
		"\u0000\u0000\u0000XY\u0005K\u0000\u0000Y]\u0003\u000e\u0007\u0000Z\\\u0003"+
		"\u0010\b\u0000[Z\u0001\u0000\u0000\u0000\\_\u0001\u0000\u0000\u0000]["+
		"\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000^`\u0001\u0000\u0000"+
		"\u0000_]\u0001\u0000\u0000\u0000`a\u0007\u0000\u0000\u0000ac\u0001\u0000"+
		"\u0000\u0000bO\u0001\u0000\u0000\u0000bX\u0001\u0000\u0000\u0000c\u0007"+
		"\u0001\u0000\u0000\u0000de\u0005K\u0000\u0000ei\u0003\f\u0006\u0000fh"+
		"\u0003\u0010\b\u0000gf\u0001\u0000\u0000\u0000hk\u0001\u0000\u0000\u0000"+
		"ig\u0001\u0000\u0000\u0000ij\u0001\u0000\u0000\u0000jl\u0001\u0000\u0000"+
		"\u0000ki\u0001\u0000\u0000\u0000lm\u0005M\u0000\u0000m\t\u0001\u0000\u0000"+
		"\u0000no\u0005L\u0000\u0000op\u0003\f\u0006\u0000pq\u0005M\u0000\u0000"+
		"q\u000b\u0001\u0000\u0000\u0000rs\u0007\u0001\u0000\u0000s\r\u0001\u0000"+
		"\u0000\u0000tu\u0007\u0002\u0000\u0000u\u000f\u0001\u0000\u0000\u0000"+
		"vw\u0003\u0012\t\u0000wx\u0005I\u0000\u0000xy\u0003\u0014\n\u0000y|\u0001"+
		"\u0000\u0000\u0000z|\u0003\u0012\t\u0000{v\u0001\u0000\u0000\u0000{z\u0001"+
		"\u0000\u0000\u0000|\u0011\u0001\u0000\u0000\u0000}~\u0007\u0003\u0000"+
		"\u0000~\u0013\u0001\u0000\u0000\u0000\u007f\u0080\u0005]\u0000\u0000\u0080"+
		"\u0015\u0001\u0000\u0000\u0000\u0081\u008f\u0003\u0018\f\u0000\u0082\u008f"+
		"\u0003\u0006\u0003\u0000\u0083\u008f\u0003\u001a\r\u0000\u0084\u008f\u0003"+
		"\u001e\u000f\u0000\u0085\u0086\u0005G\u0000\u0000\u0086\u008a\u0005b\u0000"+
		"\u0000\u0087\u0089\u0007\u0004\u0000\u0000\u0088\u0087\u0001\u0000\u0000"+
		"\u0000\u0089\u008c\u0001\u0000\u0000\u0000\u008a\u0088\u0001\u0000\u0000"+
		"\u0000\u008a\u008b\u0001\u0000\u0000\u0000\u008b\u008d\u0001\u0000\u0000"+
		"\u0000\u008c\u008a\u0001\u0000\u0000\u0000\u008d\u008f\u0005H\u0000\u0000"+
		"\u008e\u0081\u0001\u0000\u0000\u0000\u008e\u0082\u0001\u0000\u0000\u0000"+
		"\u008e\u0083\u0001\u0000\u0000\u0000\u008e\u0084\u0001\u0000\u0000\u0000"+
		"\u008e\u0085\u0001\u0000\u0000\u0000\u008f\u0017\u0001\u0000\u0000\u0000"+
		"\u0090\u009b\u0003 \u0010\u0000\u0091\u009b\u0005O\u0000\u0000\u0092\u009b"+
		"\u0005R\u0000\u0000\u0093\u009b\u0005S\u0000\u0000\u0094\u009b\u0005T"+
		"\u0000\u0000\u0095\u009b\u0005Q\u0000\u0000\u0096\u009b\u0005V\u0000\u0000"+
		"\u0097\u009b\u0005W\u0000\u0000\u0098\u009b\u0005X\u0000\u0000\u0099\u009b"+
		"\u0005Y\u0000\u0000\u009a\u0090\u0001\u0000\u0000\u0000\u009a\u0091\u0001"+
		"\u0000\u0000\u0000\u009a\u0092\u0001\u0000\u0000\u0000\u009a\u0093\u0001"+
		"\u0000\u0000\u0000\u009a\u0094\u0001\u0000\u0000\u0000\u009a\u0095\u0001"+
		"\u0000\u0000\u0000\u009a\u0096\u0001\u0000\u0000\u0000\u009a\u0097\u0001"+
		"\u0000\u0000\u0000\u009a\u0098\u0001\u0000\u0000\u0000\u009a\u0099\u0001"+
		"\u0000\u0000\u0000\u009b\u009c\u0001\u0000\u0000\u0000\u009c\u009a\u0001"+
		"\u0000\u0000\u0000\u009c\u009d\u0001\u0000\u0000\u0000\u009d\u0019\u0001"+
		"\u0000\u0000\u0000\u009e\u009f\u0005E\u0000\u0000\u009f\u00a0\u0005E\u0000"+
		"\u0000\u00a0\u00a1\u0003\u001c\u000e\u0000\u00a1\u00a2\u0005F\u0000\u0000"+
		"\u00a2\u00a3\u0005F\u0000\u0000\u00a3\u001b\u0001\u0000\u0000\u0000\u00a4"+
		"\u00a9\u0003 \u0010\u0000\u00a5\u00a6\u0005T\u0000\u0000\u00a6\u00a8\u0003"+
		" \u0010\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a8\u00ab\u0001\u0000"+
		"\u0000\u0000\u00a9\u00a7\u0001\u0000\u0000\u0000\u00a9\u00aa\u0001\u0000"+
		"\u0000\u0000\u00aa\u001d\u0001\u0000\u0000\u0000\u00ab\u00a9\u0001\u0000"+
		"\u0000\u0000\u00ac\u00ad\u0005G\u0000\u0000\u00ad\u00ae\u0005Z\u0000\u0000"+
		"\u00ae\u00af\u0003 \u0010\u0000\u00af\u00b0\u0005\\\u0000\u0000\u00b0"+
		"\u00b1\u0003\u001c\u000e\u0000\u00b1\u00b5\u0005H\u0000\u0000\u00b2\u00b4"+
		"\u0003\u0016\u000b\u0000\u00b3\u00b2\u0001\u0000\u0000\u0000\u00b4\u00b7"+
		"\u0001\u0000\u0000\u0000\u00b5\u00b3\u0001\u0000\u0000\u0000\u00b5\u00b6"+
		"\u0001\u0000\u0000\u0000\u00b6\u00b8\u0001\u0000\u0000\u0000\u00b7\u00b5"+
		"\u0001\u0000\u0000\u0000\u00b8\u00b9\u0005G\u0000\u0000\u00b9\u00ba\u0005"+
		"[\u0000\u0000\u00ba\u00bb\u0005H\u0000\u0000\u00bb\u001f\u0001\u0000\u0000"+
		"\u0000\u00bc\u00bd\u0007\u0005\u0000\u0000\u00bd!\u0001\u0000\u0000\u0000"+
		"\u00be\u00c0\u0003$\u0012\u0000\u00bf\u00be\u0001\u0000\u0000\u0000\u00c0"+
		"\u00c1\u0001\u0000\u0000\u0000\u00c1\u00bf\u0001\u0000\u0000\u0000\u00c1"+
		"\u00c2\u0001\u0000\u0000\u0000\u00c2\u00c3\u0001\u0000\u0000\u0000\u00c3"+
		"\u00c4\u0005\u0000\u0000\u0001\u00c4#\u0001\u0000\u0000\u0000\u00c5\u00c6"+
		"\u0003&\u0013\u0000\u00c6\u00ca\u0005E\u0000\u0000\u00c7\u00c9\u00032"+
		"\u0019\u0000\u00c8\u00c7\u0001\u0000\u0000\u0000\u00c9\u00cc\u0001\u0000"+
		"\u0000\u0000\u00ca\u00c8\u0001\u0000\u0000\u0000\u00ca\u00cb\u0001\u0000"+
		"\u0000\u0000\u00cb\u00cd\u0001\u0000\u0000\u0000\u00cc\u00ca\u0001\u0000"+
		"\u0000\u0000\u00cd\u00ce\u0005F\u0000\u0000\u00ce%\u0001\u0000\u0000\u0000"+
		"\u00cf\u00d4\u0003(\u0014\u0000\u00d0\u00d1\u0005Q\u0000\u0000\u00d1\u00d3"+
		"\u0003(\u0014\u0000\u00d2\u00d0\u0001\u0000\u0000\u0000\u00d3\u00d6\u0001"+
		"\u0000\u0000\u0000\u00d4\u00d2\u0001\u0000\u0000\u0000\u00d4\u00d5\u0001"+
		"\u0000\u0000\u0000\u00d5\'\u0001\u0000\u0000\u0000\u00d6\u00d4\u0001\u0000"+
		"\u0000\u0000\u00d7\u00db\u0003.\u0017\u0000\u00d8\u00da\u0003.\u0017\u0000"+
		"\u00d9\u00d8\u0001\u0000\u0000\u0000\u00da\u00dd\u0001\u0000\u0000\u0000"+
		"\u00db\u00d9\u0001\u0000\u0000\u0000\u00db\u00dc\u0001\u0000\u0000\u0000"+
		"\u00dc\u00e0\u0001\u0000\u0000\u0000\u00dd\u00db\u0001\u0000\u0000\u0000"+
		"\u00de\u00df\u0005O\u0000\u0000\u00df\u00e1\u00030\u0018\u0000\u00e0\u00de"+
		"\u0001\u0000\u0000\u0000\u00e0\u00e1\u0001\u0000\u0000\u0000\u00e1)\u0001"+
		"\u0000\u0000\u0000\u00e2\u00e5\u0003\f\u0006\u0000\u00e3\u00e5\u0003\u000e"+
		"\u0007\u0000\u00e4\u00e2\u0001\u0000\u0000\u0000\u00e4\u00e3\u0001\u0000"+
		"\u0000\u0000\u00e5+\u0001\u0000\u0000\u0000\u00e6\u00e9\u0005b\u0000\u0000"+
		"\u00e7\u00e9\u0003*\u0015\u0000\u00e8\u00e6\u0001\u0000\u0000\u0000\u00e8"+
		"\u00e7\u0001\u0000\u0000\u0000\u00e9-\u0001\u0000\u0000\u0000\u00ea\u00f1"+
		"\u0003,\u0016\u0000\u00eb\u00f1\u0005b\u0000\u0000\u00ec\u00ed\u0005T"+
		"\u0000\u0000\u00ed\u00f1\u0003,\u0016\u0000\u00ee\u00ef\u0005U\u0000\u0000"+
		"\u00ef\u00f1\u0005b\u0000\u0000\u00f0\u00ea\u0001\u0000\u0000\u0000\u00f0"+
		"\u00eb\u0001\u0000\u0000\u0000\u00f0\u00ec\u0001\u0000\u0000\u0000\u00f0"+
		"\u00ee\u0001\u0000\u0000\u0000\u00f1/\u0001\u0000\u0000\u0000\u00f2\u00f3"+
		"\u0005D\u0000\u0000\u00f31\u0001\u0000\u0000\u0000\u00f4\u00f5\u00034"+
		"\u001a\u0000\u00f5\u00f6\u0005O\u0000\u0000\u00f6\u00f7\u00036\u001b\u0000"+
		"\u00f7\u00f8\u0005P\u0000\u0000\u00f83\u0001\u0000\u0000\u0000\u00f9\u00fa"+
		"\u0007\u0006\u0000\u0000\u00fa5\u0001\u0000\u0000\u0000\u00fb\u00fd\u0003"+
		"8\u001c\u0000\u00fc\u00fb\u0001\u0000\u0000\u0000\u00fd\u00fe\u0001\u0000"+
		"\u0000\u0000\u00fe\u00fc\u0001\u0000\u0000\u0000\u00fe\u00ff\u0001\u0000"+
		"\u0000\u0000\u00ff7\u0001\u0000\u0000\u0000\u0100\u0109\u0005^\u0000\u0000"+
		"\u0101\u0109\u0005`\u0000\u0000\u0102\u0109\u0005a\u0000\u0000\u0103\u0109"+
		"\u0005b\u0000\u0000\u0104\u0109\u0005Q\u0000\u0000\u0105\u0109\u0005R"+
		"\u0000\u0000\u0106\u0109\u0005S\u0000\u0000\u0107\u0109\u0005W\u0000\u0000"+
		"\u0108\u0100\u0001\u0000\u0000\u0000\u0108\u0101\u0001\u0000\u0000\u0000"+
		"\u0108\u0102\u0001\u0000\u0000\u0000\u0108\u0103\u0001\u0000\u0000\u0000"+
		"\u0108\u0104\u0001\u0000\u0000\u0000\u0108\u0105\u0001\u0000\u0000\u0000"+
		"\u0108\u0106\u0001\u0000\u0000\u0000\u0108\u0107\u0001\u0000\u0000\u0000"+
		"\u01099\u0001\u0000\u0000\u0000\u0018<?DS]bi{\u008a\u008e\u009a\u009c"+
		"\u00a9\u00b5\u00c1\u00ca\u00d4\u00db\u00e0\u00e4\u00e8\u00f0\u00fe\u0108";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}