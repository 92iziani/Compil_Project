package ast;

import tds.Parcours;
import tds.Tds;

public class Bloc implements Ast{

    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ast declarations;
    public Ast instructions;

    public Bloc(Ast a, Ast b){
        this.declarations = a;
        this.instructions = b;
    }

    public void acceptTDS(Parcours p, Tds tds){
        p.visit(this, tds);
    }
}