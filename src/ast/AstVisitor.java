package ast;

import parser.circParser;

import javax.swing.*;

public interface AstVisitor<T> {

    public T visit(Program program);
    public T visit(IfThen ifthen);
    public T visit(IfThenElse ifthenelse);
    public T visit(While whil);
    public T visit(Return retur);
    public T visit(Affectation affect);
    public T visit(Ident ident);
    public T visit(ListeDeclVars liste);
    public T visit(ListeInstruction liste);
    public T visit(Bloc bloc);
    public T visit(Plus plus);
    public T visit(Minus minus);
    public T visit(Divide divide);
    public T visit(Mult mult);
    public T visit(DeclaList declaList);
    public T visit(DeclTyp declTyp);
    public T visit(DeclaAffect dAffect);
    public T visit(Entier entier);
    public T visit(IntParam intParam);
    //public T visit(ListeParam listeParam);   DELETED
    public T visit(Struct struct);
    public T visit(StructParam structParam);
    //public T visit(IntNode x);
    public T visit(ExclaExpr x);
    public T visit(Fleche x);
    //public T visit(FlecheExpr x);
    //public T visit(Ident x); 
    public T visit(IdentExprPointeur x); 
    public T visit(Operateur x);
    public T visit(OpExpr x);
    //public T visit(OpExprExpr x); // ADDED
    public T visit(ParenthExpr x);
    public T visit(Sizeof x);
    public T visit(TiretExpr x); 
    public T visit(ListeExpr listexpr);

    public T visit(Paramint x);
    public T visit(Paramstruct x);
    public T visit(List x); //ADDED

    public T visit(Vide x); //ADDED
}
