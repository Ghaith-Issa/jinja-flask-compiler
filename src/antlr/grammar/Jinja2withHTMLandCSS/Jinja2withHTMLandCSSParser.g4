parser grammar Jinja2withHTMLandCSSParser;

options { tokenVocab=Jinja2withHTMLandCSSLexer; }

prog
    : jinja2Prog #jinja2
    | cssProg    #css
 ;

jinja2Prog
    : doctype? elementContent* EOF
    ;

doctype
    : OPEN_TAG NOT DOCTYPE_TAG HTML_TAG CLOSE_TAG
    ;

htmlelement
    : startTag elementContent* endTag                          #openCloseTag
    | OPEN_TAG voidTagName attribute* (SELF_CLOSD | CLOSE_TAG) #selfClosingTag
    ;

startTag
    : OPEN_TAG tagName attribute* CLOSE_TAG
    ;

endTag
    : OPEN_TAG_SLASH tagName CLOSE_TAG
    ;

tagName
    : HTML_TAG
    | HEAD_TAG
    | BODY_TAG
    | TITLE_TAG
    | DIV_TAG
    | A_TAG
    | P_TAG
    | H1_TAG | H2_TAG | H3_TAG | H4_TAG | H5_TAG | H6_TAG
    | FORM_TAG
    | LABEL_TAG
    | BUTTON_TAG
    | TEXTAREA_TAG
    | SPAN_TAG
    | UL_TAG
    | LI_TAG
    ;

voidTagName
    : META_TAG
    | LINK_TAG
    | IMG_TAG
    | INPUT_TAG
    ;

attribute
    : attributeName ASSIGN attributeValue #fullAttr
    | attributeName                       #booleanAttr
    ;

attributeName
    : CHARSET_ATT
    | ALT_ATT
    | HREF_ATT
    | SRC_ATT
    | REL_ATT
    | CLASS_ATT
    | METHOD_ATT
    | TYPE_ATT
    | NAME_ATT
    | STEP_ATT
    | REQUIRED_ATT
    | STYLE_ATT
    ;

attributeValue : STRING;

elementContent
    : statement    #textContent
    | htmlelement  #nestedElement
    | expression   #jinjaExpression
    | block        #jinjaBlock
    | BLOCK_START IDDEFINER (IDDEFINER | ASSIGN | STRING | NUMBER)* BLOCK_END #jinjaStatement
    ;

statement : (anyId| COLON | LPAREN | RPAREN | DOT | COMMA | PLUS | MINUS | STAR | DIVISION)+ ;

expression
    : LCURLY LCURLY memberAccess RCURLY RCURLY
    ;

memberAccess
    : anyId (DOT anyId)*
    ;

// The collection is a memberAccess, not a bare name: iterating a nested field
// ({% for item in group.items %}) is ordinary Jinja and failed to parse before.
block
    : BLOCK_START FOR anyId IN memberAccess BLOCK_END
      elementContent*
      BLOCK_START END_FOR BLOCK_END
    ;
anyId
    : IDDEFINER
    | HTML_TAG | HEAD_TAG | BODY_TAG | DIV_TAG | A_TAG | P_TAG
    | SPAN_TAG | FORM_TAG | LABEL_TAG | BUTTON_TAG | UL_TAG | LI_TAG
    | TITLE_TAG | META_TAG | LINK_TAG | IMG_TAG | INPUT_TAG | TEXTAREA_TAG
    | NAME_ATT | TYPE_ATT | CLASS_ATT | HREF_ATT | SRC_ATT | REL_ATT
    | STYLE_ATT | CHARSET_ATT | ALT_ATT | METHOD_ATT | STEP_ATT | REQUIRED_ATT
    | FOR | IN | BOOL
    ;
// ================= CSS =================

cssProg
    : cssRule+ EOF
    ;

cssRule
    : cssSelectorList LCURLY cssDeclaration* RCURLY
    ;

cssSelectorList
    : cssSelector (COMMA cssSelector)*
    ;

cssSelector
    : simpleSelector (simpleSelector)* (COLON pseudoClass)?
    ;

cssElementName
    : tagName
    | voidTagName
    ;

className
    : IDDEFINER
    | cssElementName
    ;

simpleSelector
    : className           #ElementSelector
    | IDDEFINER           #CustomElementSelector
    | DOT className       #ClassSelector
    | HASH IDDEFINER      #IdSelector
    ;

pseudoClass
    : PSEUDO_HOVER
    ;

cssDeclaration
    : cssProperty COLON cssValue SEMICOLON
    ;

cssProperty
    : FONT_FAMILY | BACKGROUND | BACKGROUND_COLOR | COLOR_PROP
    | PADDING | PADDING_TOP | PADDING_BOTTOM | MARGIN
    | MARGIN_TOP | MARGIN_BOTTOM | WIDTH | HEIGHT | DISPLAY
    | GAP | FLEX_WRAP | JUSTIFY_CONTENT | TEXT_ALIGN | FONT_SIZE
    | FONT_WEIGHT | BORDER | BORDER_RADIUS | BOX_SHADOW
    | TEXT_DECORATION | CURSOR | TRANSFORM | FLEX_DIRECTION
    ;

cssValue
    : cssValueAtom+
    ;

cssValueAtom
    : NUMBER        #cssNumber
    | CSS_UNIT      #cssUnit
    | CSS_COLOR     #cssColor
    | IDDEFINER     #cssIdentifier
    | COMMA         #cssComma
    | LPAREN        #cssLParen
    | RPAREN        #cssRParen
    | MINUS         #cssMinus
    ;
