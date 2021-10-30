grammar coline;

@header{
package parser;
}


fichier :
        decl* EOF;

decl :
        decl_typ
    |   decl_fct ;

decl_vars :
        'int' (IDENT ',')+ ';'
    |   'struct' IDENT ('(''*' IDENT ')'',')+ ';' ;

decl_typ :
        'struct' IDENT '{' decl_vars* '}'';' ;

decl_fct :
        'int' IDENT '(' (param',')* ')' bloc
    |   'struct' IDENT '*' IDENT '(' (param',')* ')' bloc ;

param :
        'int' IDENT
    |   'struct' IDENT '*' IDENT ;   //bail des |

expr :
        ENTIER
    |   IDENT
    |   expr '->' IDENT
    |   IDENT '(' (expr',')* ')'
    |   '!' expr
    |   '-' expr  //bail des |...
    |   expr OPERATEUR expr
    |   'sizeof' '(' 'struct' IDENT ')'
    |   '(' expr ')' ;

instruction :
        ';'
    |   expr ';'
    |   'if' '(' expr ')' instruction
    |   'if' '(' expr ')' instruction 'else'
    |   'while' '(' expr ')' instruction
    |   bloc
    |   'return' expr ';' ;

bloc :
        '{' decl_vars* instruction* '}' ;


CHIFFRE : ('0'..'9');

ENTIER : '0' | CHIFFRE* ; //à voir

CARACTERE : ('a'..'z'|'A'..'Z'|'_')('a'..'z'|'A'..'Z'|'0'..'9')*;  //à voir !

WS : ('\n'|' '|'\t'|'\r'|'*/'*'*/'|'//'*'/n')+ -> skip;   //à voir

IDENT : ('a'..'z'|'A'..'Z'|'_')('a'..'z'|'A'..'Z'|'0'..'9')*;   //à voir

OPERATEUR : '='|'=='|'!='|'<'|'<='|'>'|'=>'|'+'|'-'|'*'|'/'|'&&'|'||' ; //à voir ?

/* voir aussi pour la definition des mots clefs */