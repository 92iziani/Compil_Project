package ast;

import tds.Parcours;
import tds.Tds;

public class While implements Ast {

    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ast condition;
    public Ast instruction;

    public While(Ast cond, Ast inst){
        this.condition = cond;
        this.instruction = inst;
    }

    public void acceptTDS(Parcours p, Tds tds){
        p.visit(this, tds);
    }

}
