lexer grammar Jinja2withHTMLandCSSLexer;

WS                : [ \n\t\r]+ -> channel(HIDDEN);
JINJA_COMMENT     : '{#' .*? '#}' -> skip ;

DOCTYPE_TAG : 'DOCTYPE';
HTML_TAG    : 'html';
HEAD_TAG    : 'head';
BODY_TAG    : 'body';
META_TAG    : 'meta';
TITLE_TAG   : 'title';
LINK_TAG    : 'link';
DIV_TAG       : 'div';
A_TAG         : 'a';
P_TAG         : 'p';
H1_TAG        : 'h1';
H2_TAG        : 'h2';
H3_TAG        : 'h3';
H4_TAG        : 'h4';
H5_TAG        : 'h5';
H6_TAG        : 'h6';
IMG_TAG       : 'img';
FORM_TAG      : 'form';
INPUT_TAG     : 'input';
LABEL_TAG     : 'label';
BUTTON_TAG    : 'button';
TEXTAREA_TAG  : 'textarea';
SPAN_TAG      : 'span';
UL_TAG        : 'ul';
LI_TAG        : 'li';


CHARSET_ATT     : 'charset';
STYLE_ATT       : 'style';
ALT_ATT         : 'alt';
HREF_ATT        : 'href';
SRC_ATT         : 'src';
REL_ATT         : 'rel';
CLASS_ATT       : 'class';
METHOD_ATT      : 'method';
TYPE_ATT        : 'type';
NAME_ATT        : 'name';
STEP_ATT        : 'step';
REQUIRED_ATT    : 'required';


FONT_FAMILY    : 'font-family';
BACKGROUND     : 'background';
BACKGROUND_COLOR : 'background-color';
COLOR_PROP     : 'color';
PADDING        : 'padding';
PADDING_TOP    : 'padding-top';
PADDING_BOTTOM : 'padding-bottom';
MARGIN         : 'margin';
MARGIN_TOP     : 'margin-top';
MARGIN_BOTTOM  : 'margin-bottom';
WIDTH          : 'width';
HEIGHT         : 'height';
DISPLAY        : 'display';
GAP            : 'gap';
FLEX_WRAP      : 'flex-wrap';
JUSTIFY_CONTENT: 'justify-content';
TEXT_ALIGN     : 'text-align';
FONT_SIZE      : 'font-size';
FONT_WEIGHT    : 'font-weight';
BORDER         : 'border';
BORDER_RADIUS  : 'border-radius';
BOX_SHADOW     : 'box-shadow';
TEXT_DECORATION: 'text-decoration';
CURSOR         : 'cursor';
TRANSFORM      : 'transform';
FLEX_DIRECTION : 'flex-direction';


PSEUDO_HOVER : 'hover';

LCURLY           : '{';
RCURLY           : '}';
BLOCK_START      : '{%';
BLOCK_END        : '%}';
ASSIGN           : '=';
NOT              : '!';
OPEN_TAG         : '<';
OPEN_TAG_SLASH   : '</';
CLOSE_TAG        : '>';
SELF_CLOSD       :'/>';
COLON            : ':';
SEMICOLON        : ';';
COMMA            : ',';
LPAREN           : '(';
RPAREN           : ')';
DOT              : '.';
HASH             : '#';
PLUS             : '+';
MINUS            : '-';
STAR             : '*';
DIVISION         : '/';
FOR              : 'for';
END_FOR          : 'endfor';
IN               : 'in';
STRING
    : '"' (~["\r\n])* '"'
    | '\'' (~["\r\n])* '\''
    ;
NUMBER           : ('-' | '+')? [0-9]+ ('.' [0-9]+)? ;
BOOL             : 'true' | 'false' ;
CSS_UNIT : 'px' | 'em' | 'rem'| '%' ;

fragment HEX : [0-9a-fA-F];

CSS_COLOR : '#' HEX HEX HEX (HEX HEX HEX)?;

IDDEFINER       : [a-zA-Z_$][-a-zA-Z0-9_$]*;
