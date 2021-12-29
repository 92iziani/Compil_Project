package ast;

import tds.Parcours;
import tds.Tds;

public class DeclTyp implements Ast{

    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ident ident ;
    public Ast listDeclVar;

    public DeclTyp(Ident ident, Ast listDeclVar){
        this.ident = ident;
        this.listDeclVar = listDeclVar;
    }

    public void acceptTDS(Parcours p, Tds tds){
        p.visit(this, tds);
    }
}