package ast;

import tds.Parcours;
import tds.Tds;

public class Sizeof implements Ast {

    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ident ident;

    public Sizeof(Ident ident){
        this.ident = ident;
    }

    public void acceptTDS(Parcours p, Tds tds){
        p.visit(this, tds);
    }
}

