package ast;

import tds.Parcours;
import tds.Tds;

public class IfThen implements Ast{

    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ast condition;
    public Ast thenBlock;

    public IfThen(Ast cond, Ast then){
        this.condition = cond;
        this.thenBlock = then;
    }

}
