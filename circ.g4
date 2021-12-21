grammar circ;

@header{
package parser;
}

program :
    decl* EOF;

decl :
    decl_typ        
    | decl_fct      
    | decl_vars     ;

decl_vars :
      'int' (IDENT',')* IDENT ';'                       #Decla
    | 'struct' IDENT IDENT* ('(' '*' IDENT ')'',')* ';' #Struct
    | 'int' IDENT '=' ENTIER';'                         #DeclaAffect ;
//'int' (IDENT,',')+ ';'
decl_typ :
    'struct' IDENT '{' liste_decl_vars '}' ';';

decl_fct :
    'int' IDENT '(' liste_param ')' bloc    #IntParam
    | 'struct' IDENT '*' IDENT '(' liste_param ')' bloc    #StructParam ;

//MODIFIED
//liste_param :
  //  param;

liste_expr : (expr',')* ;

//MODIFIED param
liste_param :
    ('int' IDENT ',' )* ('int' IDENT)                        #Paramint
    | 'struct' IDENT  '*' IDENT         #Paramstruct;

//int ident , int ident , int ident
//int ident
// int ident , int ident
/*expr :  ENTIER expr1                            #EntierExpr
        |IDENT expr1                             #IdentExpr
        | IDENT '(' liste_expr ')' expr1          #IdentExprPointeurExpr
        | '!' expr expr1                        #ExclaExprExpr
        | '-' expr expr1                        #TiretExprExpr
        | 'sizeof' '(' 'struct' IDENT ')' expr1 #SizeofExpr
        | '(' expr ')' expr1                    #ParenthExprExpr
        | ENTIER                                #Entier
        | IDENT                                 #Ident
        | IDENT '(' liste_expr ')'              #IdentExprPointeur
        | '!' expr                              #ExclaExpr
        | '-' expr                              #TiretExpr
        | 'sizeof' '(' 'struct' IDENT ')'       #Sizeof
        | '(' expr ')'                          #ParenthExpr
        ;*/

expr :           ENTIER                                #Entier
               | IDENT                                 #Ident
               | IDENT '(' liste_expr ')'              #IdentExprPointeur
               | '!' expr                              #ExclaExpr
               | '-' expr                              #TiretExpr
               | 'sizeof' '(' 'struct' IDENT ')'       #Sizeof
               | '(' expr ')'                          #ParenthExpr
               |  expr OPERATEUR expr                   #OpExpr
               | expr '->' IDENT                        #Fleche
               ;



/*expr1 : '->' IDENT expr1    #FlecheExpr
        |   '->' IDENT         #Fleche
        | OPERATEUR expr expr1     #OpExprExpr
        | OPERATEUR expr    #OpExpr
        ;*/

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
