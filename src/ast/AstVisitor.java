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

}
