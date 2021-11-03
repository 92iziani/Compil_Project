grammar ahmed;

@header{
    package parser;
}

file : declaration* EOF ;

declaration : declaration_type
            | declaration_fonction 
            | declaration_variable
            ;

declaration_fonction : 'int' IDF '('(parameter',')*')' bloc
                    | 'struct' IDF '*' IDF '('(parameter',')*')' bloc 
                    ;

declaration_variable : 'int' (IDF',')+ ';'
                    | 'struct' IDF ('(''*'IDF')'',')+ ';'  
                    ;

declaration_type : 'struct' IDF '{'declaration_variable*'};' ;
                    

parameter : 'int' IDF
            | 'struct' IDF '*' IDF
            ;

expression : INTEGER
            | IDF
            | expression '->' IDF
            | IDF '('(expression',')*')'
            | '!'expression
            | '-'expression
            | expression OPERATOR expression
            | 'sizeof' '(' 'struct' IDF ')'
            | '('expression')'
            ;

bloc : '{' declaration_variable* instruction* '}' ;

instruction : ';'
            | expression ';'
            | 'if' '('expression')' instruction
            | 'if' '('expression')' instruction 'else' instruction
            | 'while' '('expression')' instruction
            | 'return' expression ';'
            | bloc
            ;

NUMBER : ('0'..'9');

INTEGER : 0
        | ('1'..'9') NUMBER*
        | '’'CHARACTER'’'
        ;

IDF : ('a'..'z'|'A'..'Z'|'_')('a'..'z'|'A'..'Z'|'0'..'9')*;

OPERATOR : '=' | '==' | '!=' | '<' | '<=' | '>' | '>=' | '+' | '-' | '*' | '/' | '&&' | '||' ;

CHARACTER : ' '|'!'|'#'|'&'|'$'|'%'|'('|')'|';'|'+'|','|'-'|'.'|'/'| NUMBER
               |':'|';'|'<'|'='|'>'|'?'|'@'| ('A'..'Z') |'['|']'| '^'
               | '_'| '`'| ('a'..'z') | '{'|'}'|'~' | '|'
               |'\\' 
               |'\’'
               |'\"';

WS : ('\n'|' '|'\t'|'\r' | '*/' * '/*' | '//' * '/n')+ -> skip;





