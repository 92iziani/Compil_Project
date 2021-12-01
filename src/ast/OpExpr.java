package ast;

public class OpExpr implements Ast {

    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ast operateur;
    public Ast expr;

    public OpExpr(Ast operateur,Ast expr){
        this.operateur = operateur;
        this.expr = expr;
    }
}

