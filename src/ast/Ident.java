package ast;

import tds.Parcours;
import tds.Tds;

public class Ident implements Ast {

    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public String name;

    public Ident(String name){
        this.name = name;
    }

    public void acceptTDS(Parcours p, Tds tds){
        p.visit(this, tds);
    }
}
