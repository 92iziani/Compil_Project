package ast;

import tds.Parcours;
import tds.Tds;

public class OpExpr implements Ast {

    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Operateur operateur;
    public Ast expr1;
    public Ast expr2;

    public OpExpr(Ast expr1, Operateur operateur,Ast expr2){
        this.operateur = operateur;
        this.expr1 = expr1;
        this.expr2 = expr2;

    }

    public void acceptTDS(Parcours p, Tds tds){
        p.visit(this, tds);
    }
}

