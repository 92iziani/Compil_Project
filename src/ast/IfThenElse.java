package ast;

import tds.Parcours;
import tds.Tds;

public class IfThenElse implements Ast {

    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ast condition;
    public Ast thenBlock;
    public Ast elseBlock;

    public IfThenElse(Ast cond, Ast thenB, Ast elseB){
        this.condition = cond;
        this.thenBlock = thenB;
        this.elseBlock = elseB;
    }

    public void acceptTDS(Parcours p, Tds tds){
        p.visit(this, tds);
    }
}
