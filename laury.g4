grammar laury;

@header{
package parser;
}

fichier :
    decl* EOF;

decl :
    decl_typ | decl_fct;

decl_vars :
      'int' IDENT ','+ ';' 
    | 'struct' IDENT '(*' IDENT ')'','+ ';';

decl_typ :
    'struct' IDENT '{' decl_vars* '};';

decl_fct :
    'int' IDENT '(' param ','* ')' bloc
    | 'struct' IDENT '*' IDENT '(' param ','* ')' bloc;

param :
    'int' IDENT | 'struct' IDENT  '*' IDENT;

expr :
      ENTIER
    | IDENT
    | expr '->' IDENT
    | IDENT '(' expr* ',' ')'
    | '!' expr | '-' expr
    | expr operateur expr
    | 'sizeof' '(' 'struct' IDENT ')'
    | '(' expr ')';

instruction :
    ';'
    | expr ';'
    | 'if' '(' expr ')' instruction
    | 'if' '(' expr ')' instruction 'else' instruction
    | 'while' '(' expr ')' instruction
    | bloc
    | 'return' expr;

bloc : 
    '{' decl_vars* instruction* '}';

operateur : '=' | '==' | '!=' | '<' | '<=' | '>' | '>=' | '+' | '-' | '*' | '/' | '&&' | '||';

CHIFFRE : ('0'..'9');
ENTIER : '0' | ('1'..'9') CHIFFRE* | '\''CARACTERE'\'';
IDENT : ('a'..'z'|'A'..'Z'|'_')('a'..'z'|'A'..'Z'|'0'..'9')*;
CARACTERE : ' '|'!'|'#'|'$'|'%'|'('|')'|';'|'+'|','|'-'|'.'
            | CHIFFRE|':'|';'|'<'|'='|'>'|'?'|'@'|'['|']'|'^'
            | '_'|'`'|'{'|'}'|'~'|'a'..'z'|'A'..'Z'
            |'\\' 
            |'\''
            |'\"';

WS : ('\n'|' '|'\t'|'\r')+ -> skip;
