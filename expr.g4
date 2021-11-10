grammar expr;

@header{
package parser;
}

program :
    decl* EOF;

decl :
<<<<<<< HEAD
    decl_typ | decl_fct | decl_vars ;
||||||| 895074a
    decl_typ | decl_fct; //est ce qu on met aussi decl_vars ?
=======
    decl_typ | decl_fct | decl_vars; 
>>>>>>> 48b934723f8b26464238ab14a107b6beb45f502a

decl_vars :
<<<<<<< HEAD
      'int' (IDENT',')* IDENT ';'
    | 'struct' IDENT ('(' '*' IDENT ')'',')+ ';'
    | 'int' IDENT '=' ENTIER';'
    | 'int' IDENT '=' CHIFFRE';' ;
//'int' (IDENT,',')+ ';'
||||||| 895074a
      'int' (IDENT',')* IDENT ';' #A
    | 'struct' IDENT ('(' '*' IDENT ')'',')+ ';' #B; 

=======
      'int' (IDENT',')* IDENT ';' 
    | 'struct' IDENT ('(' '*' IDENT ')'',')+ ';' 
    | 'int' IDENT '=' ENTIER';' 
    | 'int' IDENT '=' CHIFFRE';' ;

>>>>>>> 48b934723f8b26464238ab14a107b6beb45f502a
decl_typ :
    'struct' IDENT '{' decl_vars* '}' ';';

decl_fct :
<<<<<<< HEAD
    'int' IDENT '(' (param ',')* param?')' bloc
||||||| 895074a
    'int' IDENT '(' (param ',')* param?')' bloc //param? pas surs
=======
    'int' IDENT '(' (param ',')* param?')' bloc 
>>>>>>> 48b934723f8b26464238ab14a107b6beb45f502a
    | 'struct' IDENT '*' IDENT '(' param ','* ')' bloc;

param :
    'int' IDENT | 'struct' IDENT  '*' IDENT;

<<<<<<< HEAD

expr : ENTIER expr1 | IDENT expr1 | CHIFFRE expr1 | IDENT '(' (expr',')* ')' expr1 | '!' expr expr1 | '-' expr expr1 | 'sizeof' '(' 'struct' IDENT ')' expr1 | '(' expr ')' expr1 | ENTIER | IDENT | CHIFFRE | IDENT '(' (expr',')* ')' | '!' expr | '-' expr | 'sizeof' '(' 'struct' IDENT ')' | '(' expr ')' ;
expr1 : '->' IDENT expr1 | OPERATEUR expr expr1 | '->' IDENT | OPERATEUR expr ;

||||||| 895074a
expr :
      ENTIER
    | IDENT
    | expr '->' IDENT
    | IDENT '(' (expr',')* ')' //bizarre la virgule
    | '!' expr | '-' expr
    | expr OPERATEUR expr
    | 'sizeof' '(' 'struct' IDENT ')'
    | '(' expr ')';
=======
expr :
      ENTIER
    | IDENT
    | CHIFFRE
    | expr '->' IDENT
    | IDENT '(' (expr',')* ')' 
    | '!' expr | '-' expr
    | expr OPERATEUR expr
    | 'sizeof' '(' 'struct' IDENT ')'
    | '(' expr ')';
>>>>>>> 48b934723f8b26464238ab14a107b6beb45f502a

instruction :
    ';'
    | expr ';'
<<<<<<< HEAD
    | 'if' '(' expr ')' instruction ('else' instruction)?
    | 'while' '(' expr ')' instruction
    | bloc  | affectation
    | 'return' expr ';'   ;
||||||| 895074a
    | 'if' '(' expr ')' instruction
    | 'if' '(' expr ')' instruction 'else' instruction
    | 'while' '(' expr ')' instruction
    | bloc
    | 'return' expr ';';
=======
    | 'if' '(' expr ')' instruction ('else' instruction)?
    | 'while' '(' expr ')' instruction  
    | bloc  
    | 'return' expr ';'   ;
>>>>>>> 48b934723f8b26464238ab14a107b6beb45f502a

affectation : IDENT '=' expr;

bloc :
    '{' decl_vars* instruction* '}';

OPERATEUR : '=' | '==' | '!=' | '<' | '<=' | '>' | '>=' | '+' | '-' | '*' | '/' | '&&' | '||';

CHIFFRE : ('0'..'9');
<<<<<<< HEAD
ENTIER : '0' | ('1'..'9') CHIFFRE* | '\''CARACTERE'\'';
||||||| 895074a
ENTIER : '0' | ('1'..'9') CHIFFRE* | '\''CARACTERE'\''; //problème dechappement
=======
ENTIER : '0' | ('1'..'9') CHIFFRE* | '\''CARACTERE'\''; 
>>>>>>> 48b934723f8b26464238ab14a107b6beb45f502a
IDENT : ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;
CARACTERE : '!'|'#'|'$'|'%'|'('|')'|';'|'+'|','|'-'|'.'|'&'
            | CHIFFRE|':'|';'|'<'|'='|'>'|'?'|'@'|'['|']'|'^'
            | '_'|'`'|'{'|'}'|'~'|'a'..'z'|'A'..'Z'|'/'|'|'
            ;
WS : ('\n'|' '|'\t'|'\r'|'*/' * '/*' | '//' * '/n')+ -> skip;
