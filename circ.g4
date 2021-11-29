grammar circ;

@header{
package parser;
}

program :
    decl* EOF;

decl :
    decl_typ | decl_fct | decl_vars ;

decl_vars :
      'int' (IDENT',')* IDENT ';'                       #Decla
    | 'struct' IDENT IDENT* ('(' '*' IDENT ')'',')* ';' #Struct
    | 'int' IDENT '=' ENTIER';'                         #DeclaAffect ;
//'int' (IDENT,',')+ ';'
decl_typ :
    'struct' IDENT '{' liste_decl_vars '}' ';';
git
decl_fct :
    'int' IDENT '(' liste_param ')' bloc            #IntParam
    | 'struct' IDENT '*' IDENT '(' liste_param ')' bloc  #StructParam ;

liste_param :
    param*;

param :
    'int' IDENT                           #Paramint
    | 'struct' IDENT  '*' IDENT          #Paramstruct;


expr :  ENTIER expr1                            #EntierExpr
        |IDENT expr1                             #IdentExpr
        | IDENT '(' (expr',')* ')' expr1          #IdentExprPointeur
        | '!' expr expr1?                        #ExclaExpr
        | '-' expr expr1?                        #TiretExpr
        | 'sizeof' '(' 'struct' IDENT ')' expr1 #SizeofExpr
        | '(' expr ')' expr1                    #ExprExpr
        | ENTIER                                #Entier
        | IDENT                                 #Ident
        | IDENT '(' (expr',')* ')'              #IdentExprPointeur
        | '!' expr                              #ExclaExpr
        | '-' expr                              #TiretExpr
        | 'sizeof' '(' 'struct' IDENT ')'       #Sizeof
        | '(' expr ')'                          #ParenthExpr ;


expr1 : '->' IDENT expr1?           #Fleche
        | OPERATEUR expr expr1?     #OpExpr;

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

liste_decl_vars :
    decl_vars*;

liste_instruction :
    instruction*;

bloc :
    '{' liste_decl_vars liste_instruction '}';

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
