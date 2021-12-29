package ast;

import tds.Parcours;
import tds.Tds;

public class Fleche implements Ast {

    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ident ident;
    public Ast expr;

    public Fleche(Ast expr, Ident ident){
        this.expr = expr;
        this.ident = ident;
    }

    public void acceptTDS(Parcours p, Tds tds){
        p.visit(this, tds);
    }
}

