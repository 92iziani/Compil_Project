package ast;
import tds.Parcours;
import tds.Tds;

import java.util.ArrayList;

public class Paramint implements Ast{

    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ident ident;

    public Paramint(Ident ident){

        this.ident = ident;
    }

    public void acceptTDS(Parcours p, Tds tds){
        p.visit(this, tds);
    }
}
