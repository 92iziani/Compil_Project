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
    | 'struct' IDENT IDENT* ('(' '*' IDENT ')'',')* ';'
    | 'int' IDENT '=' ENTIER';';
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

//deleted ; in instruction
instruction :
     expr ';' #ExprSeule
    | 'if' '(' expr ')' instruction #IfThen
    | 'if' '(' expr ')' instruction 'else' instruction #IfThenElse
    | 'while' '(' expr ')' instruction #While
    | bloc  #BlocInstruct
    | affectation #AffectInstruct
    | 'return' expr ';'    #Return ;

affectation : IDENT '=' expr2 ';' ;
// donc il faut obligatoirement déclarer les vars au début
bloc :
    '{' decl_vars* instruction* '}';

OPERATEUR : '=' | '==' | '!=' | '<' | '<=' | '>' | '>=' | '+' | '-' | '*' | '/' | '&&' | '||';


ENTIER : '0' | ('1'..'9') ('0'..'9')* | CARACTERE;
IDENT : ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
CARACTERE : '\''('!'|'#'|'$'|'%'|'('|')'|';'|'+'|','|'-'|'.'|'&'
            | ('0'..'9')|':'|';'|'<'|'='|'>'|'?'|'@'|'['|']'|'^'
            | '_'|'`'|'{'|'}'|'~'|'a'..'z'|'A'..'Z'|'/'|'|')'\''
            ;
WS : ('\n'|' '|'\t'|'\r'|'/*' .*? '*/' | '//' ~[\r\n]*)+ -> skip;


expr2 : plus;

plus:  mult (('+'|'-') mult)*;

mult : expr (('*'|'/') expr)*;

//BlockComment :   '/*' .*? '*/' -> skip;
