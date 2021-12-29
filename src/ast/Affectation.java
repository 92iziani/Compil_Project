package ast;

import tds.Parcours;
import tds.Tds;

public class Affectation implements Ast{

    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ast ident;
    public Ast expr;

    public Affectation(Ast ident, Ast expr){
        this.ident = ident;
        this.expr = expr;
    }

    public void acceptTDS(Parcours p, Tds tds){
        p.visit(this, tds);
    }
}
