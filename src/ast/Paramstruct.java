package ast;

import tds.Parcours;
import tds.Tds;

public class Paramstruct implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ident ident1;
    public Ident ident2;


    public Paramstruct(Ident ident1,Ident ident2) {
        this.ident1 = ident1;
        this.ident2 = ident2;

    }
    public void acceptTDS(Parcours p, Tds tds){
        p.visit(this, tds);
    }
}
