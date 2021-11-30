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
    public T visit(Entier entier);
    public T visit(IntParam intParam);
    public T visit(ListeParam listeParam);
    public T visit(Struct struct);
    public T visit(StructParam structParam);


}
