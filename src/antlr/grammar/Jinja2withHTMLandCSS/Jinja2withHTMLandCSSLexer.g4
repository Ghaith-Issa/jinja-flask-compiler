lexer grammar Jinja2withHTMLandCSSLexer;

// ================================================================
//                     DEFAULT_MODE (HTML Body)
// ================================================================

HTML_COMMENT         : '<!--' .*? '-->' -> skip ;
JINJA_COMMENT        : '{#' .*? '#}' -> skip ;

JINJA_EXPR_OPEN      : '{{' -> pushMode(JINJA_EXPR) ;
JINJA_STMT_OPEN      : '{%' -> pushMode(JINJA_STMT) ;

OPEN_TAG_SLASH       : '</' -> pushMode(TAG) ;
OPEN_TAG             : '<'  -> pushMode(TAG) ;

LBRACE               : '{' ;
TEXT                 : ~[<{]+ ;

// ================================================================
//                     TAG Mode (<tag attr="val">)
// ================================================================

mode TAG;

TAG_WS               : [ \t\r\n]+ -> skip ;
TAG_EQUALS           : '=' ;
TAG_BANG             : '!' ;
SLASH_CLOSE          : '/>' -> popMode ;
CLOSE_TAG            : '>'  -> popMode ;

TAG_DQ_OPEN          : '"'  -> pushMode(ATTR_VALUE_DQ) ;
TAG_SQ_OPEN          : '\'' -> pushMode(ATTR_VALUE_SQ) ;

VOID_TAG_NAME        : 'area' | 'base' | 'br' | 'col' | 'embed' | 'hr'
                     | 'img' | 'input' | 'link' | 'meta' | 'param'
                     | 'source' | 'track' | 'wbr' ;

TAG_NAME             : [a-zA-Z_][a-zA-Z0-9_:-]* ;

// ================================================================
//                     ATTR_VALUE_DQ Mode ("value")
// ================================================================

mode ATTR_VALUE_DQ;

ATTR_JINJA_EXPR_OPEN : '{{' -> pushMode(JINJA_EXPR) ;
ATTR_JINJA_STMT_OPEN : '{%' -> pushMode(JINJA_STMT) ;
DQ_CLOSE             : '"'  -> popMode ;
ATTR_LBRACE          : '{' ;
ATTR_TEXT            : ~["{]+ ;

// ================================================================
//                     ATTR_VALUE_SQ Mode ('value')
// ================================================================

mode ATTR_VALUE_SQ;

SQ_JINJA_EXPR_OPEN   : '{{' -> pushMode(JINJA_EXPR) ;
SQ_JINJA_STMT_OPEN   : '{%' -> pushMode(JINJA_STMT) ;
SQ_CLOSE             : '\'' -> popMode ;
SQ_ATTR_LBRACE       : '{' ;
SQ_ATTR_TEXT         : ~['{]+ ;

// ================================================================
//                     JINJA_EXPR Mode ({{ expr }})
// ================================================================

mode JINJA_EXPR;

JINJA_EXPR_CLOSE     : '}}' -> popMode ;
JINJA_WS             : [ \t\r\n]+ -> skip ;

JINJA_DOT            : '.' ;
JINJA_PIPE           : '|' ;
JINJA_COMMA          : ',' ;
JINJA_COLON          : ':' ;
JINJA_LPAREN         : '(' ;
JINJA_RPAREN         : ')' ;
JINJA_LBRACKET       : '[' ;
JINJA_RBRACKET       : ']' ;

JINJA_EQ             : '==' ;
JINJA_NE             : '!=' ;
JINJA_LE             : '<=' ;
JINJA_GE             : '>=' ;
JINJA_LT             : '<' ;
JINJA_GT             : '>' ;
JINJA_ASSIGN         : '=' ;

JINJA_PLUS           : '+' ;
JINJA_MINUS          : '-' ;
JINJA_STAR           : '*' ;
JINJA_SLASH          : '/' ;
JINJA_PERCENT        : '%' ;

JINJA_TRUE           : 'true' | 'True' ;
JINJA_FALSE          : 'false' | 'False' ;
JINJA_NONE           : 'none' | 'None' ;
JINJA_NOT            : 'not' ;
JINJA_AND            : 'and' ;
JINJA_OR             : 'or' ;
JINJA_IS             : 'is' ;
JINJA_IN             : 'in' ;

JINJA_STRING         : '"' (~["\r\n\\] | '\\' .)* '"'
                     | '\'' (~['\r\n\\] | '\\' .)* '\'' ;
JINJA_NUMBER         : [0-9]+ ('.' [0-9]+)? ;
JINJA_ID             : [a-zA-Z_][a-zA-Z0-9_]* ;

// ================================================================
//                     JINJA_STMT Mode ({% stmt %})
// ================================================================

mode JINJA_STMT;

JINJA_STMT_CLOSE     : '%}' -> popMode ;
STMT_WS              : [ \t\r\n]+ -> skip ;

KW_FOR               : 'for' ;
KW_ENDFOR            : 'endfor' ;
KW_IF                : 'if' ;
KW_ELSE              : 'else' ;
KW_ENDIF             : 'endif' ;
KW_SET               : 'set' ;
KW_BLOCK             : 'block' ;
KW_ENDBLOCK          : 'endblock' ;
KW_IN                : 'in' ;
KW_NOT               : 'not' ;
KW_AND               : 'and' ;
KW_OR                : 'or' ;
KW_IS                : 'is' ;

STMT_TRUE            : 'true' | 'True' ;
STMT_FALSE           : 'false' | 'False' ;
STMT_NONE            : 'none' | 'None' ;

STMT_DOT             : '.' ;
STMT_PIPE            : '|' ;
STMT_COMMA           : ',' ;
STMT_COLON           : ':' ;
STMT_LPAREN          : '(' ;
STMT_RPAREN          : ')' ;
STMT_LBRACKET        : '[' ;
STMT_RBRACKET        : ']' ;

STMT_EQ              : '==' ;
STMT_NE              : '!=' ;
STMT_LE              : '<=' ;
STMT_GE              : '>=' ;
STMT_LT              : '<' ;
STMT_GT              : '>' ;
STMT_ASSIGN          : '=' ;

STMT_PLUS            : '+' ;
STMT_MINUS           : '-' ;
STMT_STAR            : '*' ;
STMT_SLASH           : '/' ;
STMT_PERCENT         : '%' ;

STMT_STRING          : '"' (~["\r\n\\] | '\\' .)* '"'
                     | '\'' (~['\r\n\\] | '\\' .)* '\'' ;
STMT_NUMBER          : [0-9]+ ('.' [0-9]+)? ;
STMT_ID              : [a-zA-Z_][a-zA-Z0-9_]* ;

// ================================================================
//                     CSS Mode (.css external files)
// ================================================================

mode CSS;

CSS_COMMENT          : '/*' .*? '*/' -> skip ;
CSS_WS               : [ \t\r\n]+ -> skip ;

CSS_IMPORTANT        : '!' [ \t\r\n]* 'important' ;

CSS_LCURLY           : '{' ;
CSS_RCURLY           : '}' ;
CSS_COLON            : ':' ;
CSS_SEMICOLON        : ';' ;
CSS_COMMA            : ',' ;
CSS_DOT              : '.' ;
CSS_HASH             : '#' ;
CSS_LPAREN           : '(' ;
CSS_RPAREN           : ')' ;
CSS_STAR             : '*' ;
CSS_GT               : '>' ;
CSS_PLUS             : '+' ;
CSS_TILDE            : '~' ;
CSS_PERCENT          : '%' ;
CSS_SLASH            : '/' ;

CSS_HEX_COLOR        : '#' [0-9a-fA-F]+ ;
CSS_STRING           : '"' (~["\r\n\\] | '\\' .)* '"'
                     | '\'' (~['\r\n\\] | '\\' .)* '\'' ;
CSS_NUMBER           : ('-' | '+')? [0-9]+ ('.' [0-9]+)? ;
CSS_IDENT            : ('-' | '--')? [a-zA-Z_][a-zA-Z0-9_-]* ;
