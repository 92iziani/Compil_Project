grammar laury;

@header{
package parser;
}

fichier :
    decl* EOF;

decl :
    decl_typ | decl_fct; //est ce qu'on met aussi decl_vars ?

decl_vars :
      'int' (IDENT',')+ IDENT ';' 
    | 'struct' IDENT ('(' '*' IDENT ')'',')+ ';';

decl_typ :
    'struct' IDENT '{' decl_vars* '}' ';';

decl_fct :
    'int' IDENT '(' (param ',')* param?')' bloc //param? pas surs
    | 'struct' IDENT '*' IDENT '(' param ','* ')' bloc;

param :
    'int' IDENT | 'struct' IDENT  '*' IDENT;

expr :
      ENTIER
    | IDENT
    | expr '->' IDENT
    | IDENT '(' (expr',')* ')' //bizarre la virgule
    | '!' expr | '-' expr
    | expr OPERATEUR expr
    | 'sizeof' '(' 'struct' IDENT ')'
    | '(' expr ')';

instruction :
    ';'
    | expr ';'
    | 'if' '(' expr ')' instruction
    | 'if' '(' expr ')' instruction 'else' instruction
    | 'while' '(' expr ')' instruction
    | bloc
    | 'return' expr ';';

bloc : 
    '{' decl_vars* instruction* '}';

OPERATEUR : '=' | '==' | '!=' | '<' | '<=' | '>' | '>=' | '+' | '-' | '*' | '/' | '&&' | '||';

CHIFFRE : ('0'..'9');
ENTIER : '0' | ('1'..'9') CHIFFRE* | '\''CARACTERE'\''; //problème d'echappement
IDENT : ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
CARACTERE : ' '|'!'|'#'|'$'|'%'|'('|')'|';'|'+'|','|'-'|'.'|'&'
            | CHIFFRE|':'|';'|'<'|'='|'>'|'?'|'@'|'['|']'|'^'
            | '_'|'`'|'{'|'}'|'~'|'a'..'z'|'A'..'Z'|'/'|'|'
            |'\\'
            |'\''
            |'\"';

<<<<<<< HEAD
WS : ('\n'|' '|'\t'|'\r'|'*/' * '/*' | '//' * '/n')+ -> skip;
||||||| 51087b4
WS : ('\n'|' '|'\t'|'\r')+ -> skip;
=======
WS : ('\n'|' '|'\t'|'\r')+ -> skip;
>>>>>>> 754631363cb120b565597ebbe7ebec8f6449086f
