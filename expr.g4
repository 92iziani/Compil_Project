grammar expr;

@header{
package parser;
}

program :
    decl* EOF;

decl :
    decl_typ | decl_fct | decl_vars ;

decl_vars :
      'int' (IDENT',')* IDENT ';'
    | 'struct' IDENT ('(' '*' IDENT ')'',')+ ';'
    | 'int' IDENT '=' ENTIER';'
    | 'int' IDENT '=' CHIFFRE';' ;
//'int' (IDENT,',')+ ';'
decl_typ :
    'struct' IDENT '{' decl_vars* '}' ';';

decl_fct :
    'int' IDENT '(' (param ',')* param?')' bloc
    | 'struct' IDENT '*' IDENT '(' param ','* ')' bloc;

param :
    'int' IDENT | 'struct' IDENT  '*' IDENT;


expr : ENTIER expr1 | IDENT expr1 | CHIFFRE expr1 | IDENT '(' (expr',')* ')' expr1 | '!' expr expr1 | '-' expr expr1 | 'sizeof' '(' 'struct' IDENT ')' expr1 | '(' expr ')' expr1 | ENTIER | IDENT | CHIFFRE | IDENT '(' (expr',')* ')' | '!' expr | '-' expr | 'sizeof' '(' 'struct' IDENT ')' | '(' expr ')' ;
expr1 : '->' IDENT expr1 | OPERATEUR expr expr1 | '->' IDENT | OPERATEUR expr ;


instruction :
    ';'
    | expr ';'
    | 'if' '(' expr ')' instruction ('else' instruction)?
    | 'while' '(' expr ')' instruction
    | bloc  | affectation
    | 'return' expr ';'   ;

affectation : IDENT '=' expr;

bloc :
    '{' decl_vars* instruction* '}';

OPERATEUR : '=' | '==' | '!=' | '<' | '<=' | '>' | '>=' | '+' | '-' | '*' | '/' | '&&' | '||';

CHIFFRE : ('0'..'9');
ENTIER : '0' | ('1'..'9') CHIFFRE* | '\''CARACTERE'\'';
IDENT : ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
CARACTERE : '!'|'#'|'$'|'%'|'('|')'|';'|'+'|','|'-'|'.'|'&'
            | CHIFFRE|':'|';'|'<'|'='|'>'|'?'|'@'|'['|']'|'^'
            | '_'|'`'|'{'|'}'|'~'|'a'..'z'|'A'..'Z'|'/'|'|'
            ;
WS : ('\n'|' '|'\t'|'\r'|'*/' * '/*' | '//' * '/n')+ -> skip;
