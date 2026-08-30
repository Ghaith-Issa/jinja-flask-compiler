parser grammar Jinja2withHTMLandCSSParser;
options { tokenVocab = Jinja2withHTMLandCSSLexer; }

// =================== Entry Points ===================
prog
    : htmlProg      #htmlEntry
    | cssProg       #cssEntry
    ;

// =================== HTML Document ===================
htmlProg
    : doctype? content* EOF
    ;

doctype
    : OPEN_TAG TAG_BANG tagName tagName CLOSE_TAG
    ;

content
    : htmlElement
    | jinjaExpression
    | jinjaBlock
    | jinjaSetStmt
    | textNode
    ;

// =================== HTML Elements ===================
htmlElement
    : OPEN_TAG VOID_TAG_NAME attribute* (SLASH_CLOSE | CLOSE_TAG)                          #voidElement
    | OPEN_TAG tagName attribute* SLASH_CLOSE                                              #selfClosingTag
    | OPEN_TAG tagName attribute* CLOSE_TAG content* OPEN_TAG_SLASH tagName CLOSE_TAG      #openCloseTag
    ;

tagName
    : TAG_NAME
    | VOID_TAG_NAME
    ;

attribute
    : tagName TAG_EQUALS attrValue     #fullAttribute
    | tagName                          #booleanAttribute
    ;

attrValue
    : TAG_DQ_OPEN attrValuePart* DQ_CLOSE     #dqAttrValue
    | TAG_SQ_OPEN sqAttrValuePart* SQ_CLOSE   #sqAttrValue
    | tagName                                 #unquotedAttrValue
    ;

attrValuePart
    : ATTR_TEXT                          #attrLiteral
    | ATTR_LBRACE                        #attrLBrace
    | jinjaExpression                   #attrJinjaExpr
    ;

sqAttrValuePart
    : SQ_ATTR_TEXT                      #sqAttrLiteral
    | SQ_ATTR_LBRACE                    #sqAttrLBrace
    | jinjaExpression                   #sqAttrJinjaExpr
    ;

// =================== Jinja Expressions {{ ... }} ===================
exprOpen
    : JINJA_EXPR_OPEN
    | ATTR_JINJA_EXPR_OPEN
    | SQ_JINJA_EXPR_OPEN
    ;

jinjaExpression
    : exprOpen jinjaExpr JINJA_EXPR_CLOSE
    ;

jinjaExpr
    : jinjaExpr JINJA_PIPE JINJA_ID (JINJA_LPAREN jinjaArgList? JINJA_RPAREN)?   #filterExpr
    | jinjaExpr JINJA_DOT JINJA_ID                                                #memberExpr
    | jinjaExpr JINJA_LBRACKET jinjaExpr JINJA_RBRACKET                           #subscriptExpr
    | jinjaExpr (JINJA_STAR|JINJA_SLASH|JINJA_PERCENT) jinjaExpr                 #multExpr
    | jinjaExpr (JINJA_PLUS|JINJA_MINUS) jinjaExpr                               #addExpr
    | jinjaExpr (JINJA_EQ|JINJA_NE|JINJA_LT|JINJA_GT|JINJA_LE|JINJA_GE) jinjaExpr #compareExpr
    | jinjaExpr JINJA_IS JINJA_ID                                                 #testExpr
    | jinjaExpr JINJA_IN jinjaExpr                                                #inExpr
    | JINJA_NOT jinjaExpr                                                         #notExpr
    | jinjaExpr JINJA_AND jinjaExpr                                               #andExpr
    | jinjaExpr JINJA_OR jinjaExpr                                                #orExpr
    | JINJA_ID JINJA_LPAREN jinjaArgList? JINJA_RPAREN                            #callExpr
    | JINJA_LPAREN jinjaExpr JINJA_RPAREN                                         #parenExpr
    | JINJA_ID                                                                     #nameExpr
    | JINJA_STRING                                                                 #stringLiteral
    | JINJA_NUMBER                                                                 #numberLiteral
    | (JINJA_TRUE | JINJA_FALSE)                                                   #boolLiteral
    | JINJA_NONE                                                                   #noneLiteral
    ;

jinjaArgList
    : jinjaArg (JINJA_COMMA jinjaArg)*
    ;

jinjaArg
    : (JINJA_ID JINJA_ASSIGN)? jinjaExpr
    ;

// =================== Jinja Block Constructs ===================
stmtOpen
    : JINJA_STMT_OPEN
    | ATTR_JINJA_STMT_OPEN
    | SQ_JINJA_STMT_OPEN
    ;

jinjaBlock
    : forBlock
    | ifBlock
    | namedBlock
    ;

forBlock
    : jinjaForOpen content* jinjaForClose
    ;

jinjaForOpen
    : stmtOpen KW_FOR STMT_ID KW_IN stmtExpr JINJA_STMT_CLOSE
    ;

jinjaForClose
    : stmtOpen KW_ENDFOR JINJA_STMT_CLOSE
    ;

ifBlock
    : jinjaIfOpen content* (jinjaElse content*)? jinjaEndIf
    ;

jinjaIfOpen
    : stmtOpen KW_IF stmtExpr JINJA_STMT_CLOSE
    ;

jinjaElse
    : stmtOpen KW_ELSE JINJA_STMT_CLOSE
    ;

jinjaEndIf
    : stmtOpen KW_ENDIF JINJA_STMT_CLOSE
    ;

namedBlock
    : jinjaBlockOpen content* jinjaBlockClose
    ;

jinjaBlockOpen
    : stmtOpen KW_BLOCK STMT_ID JINJA_STMT_CLOSE
    ;

jinjaBlockClose
    : stmtOpen KW_ENDBLOCK JINJA_STMT_CLOSE
    ;

jinjaSetStmt
    : stmtOpen KW_SET STMT_ID STMT_ASSIGN stmtExpr JINJA_STMT_CLOSE
    ;

stmtExpr
    : stmtExpr STMT_PIPE STMT_ID (STMT_LPAREN stmtArgList? STMT_RPAREN)?        #stmtFilterExpr
    | stmtExpr STMT_DOT STMT_ID                                                   #stmtMemberExpr
    | stmtExpr STMT_LBRACKET stmtExpr STMT_RBRACKET                                #stmtSubscriptExpr
    | stmtExpr (STMT_STAR|STMT_SLASH|STMT_PERCENT) stmtExpr                       #stmtMultExpr
    | stmtExpr (STMT_PLUS|STMT_MINUS) stmtExpr                                    #stmtAddExpr
    | stmtExpr (STMT_EQ|STMT_NE|STMT_LT|STMT_GT|STMT_LE|STMT_GE) stmtExpr       #stmtCompareExpr
    | stmtExpr KW_IS STMT_ID                                                      #stmtTestExpr
    | stmtExpr KW_IN stmtExpr                                                     #stmtInExpr
    | KW_NOT stmtExpr                                                             #stmtNotExpr
    | stmtExpr KW_AND stmtExpr                                                    #stmtAndExpr
    | stmtExpr KW_OR stmtExpr                                                     #stmtOrExpr
    | STMT_ID STMT_LPAREN stmtArgList? STMT_RPAREN                                 #stmtCallExpr
    | STMT_LPAREN stmtExpr STMT_RPAREN                                             #stmtParenExpr
    | STMT_ID                                                                      #stmtNameExpr
    | STMT_STRING                                                                  #stmtStringLiteral
    | STMT_NUMBER                                                                  #stmtNumberLiteral
    | (STMT_TRUE | STMT_FALSE)                                                     #stmtBoolLiteral
    | STMT_NONE                                                                    #stmtNoneLiteral
    ;

stmtArgList
    : stmtArg (STMT_COMMA stmtArg)*
    ;

stmtArg
    : (STMT_ID STMT_ASSIGN)? stmtExpr
    ;

textNode
    : (TEXT | LBRACE)+
    ;

// =================== CSS (external .css file) ===================
cssProg
    : cssRule* EOF
    ;

cssRule
    : cssSelectorList CSS_LCURLY cssDeclaration* CSS_RCURLY
    ;

cssSelectorList
    : cssSelector (CSS_COMMA cssSelector)*
    ;

cssSelector
    : cssSimpleSelector ((CSS_GT | CSS_PLUS | CSS_TILDE)? cssSimpleSelector)* (CSS_COLON CSS_COLON? CSS_IDENT)?
    ;

cssSimpleSelector
    : CSS_IDENT                 #cssElementSelector
    | CSS_DOT CSS_IDENT         #cssClassSelector
    | CSS_HASH CSS_IDENT        #cssIdSelector
    | CSS_STAR                  #cssUniversalSelector
    ;

cssDeclaration
    : CSS_IDENT CSS_COLON cssValueList CSS_IMPORTANT? CSS_SEMICOLON?
    ;

cssValueList
    : cssValue+
    ;

cssValue
    : CSS_NUMBER CSS_IDENT?                                 #cssNumberWithUnit
    | CSS_NUMBER CSS_PERCENT                                #cssPercentage
    | CSS_HEX_COLOR                                         #cssColor
    | CSS_IDENT                                             #cssIdent
    | CSS_STRING                                            #cssString
    | CSS_IDENT CSS_LPAREN cssValueList CSS_RPAREN          #cssFunctionCall
    | CSS_COMMA                                             #cssComma
    | CSS_SLASH                                             #cssSlash
    ;
