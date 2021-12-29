package ast;

import tds.Parcours;
import tds.Tds;

public class DeclaAffect implements Ast{

    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ident ident;
    public Ast entier;

    public DeclaAffect(Ident ident, Ast entier){
        this.ident = ident;
        this.entier = entier;
    }

    public void acceptTDS(Parcours p, Tds tds){
        p.visit(this, tds);
    }
}
