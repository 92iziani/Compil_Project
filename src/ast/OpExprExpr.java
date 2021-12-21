package ast;

public class OpExprExpr implements Ast {

    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Operateur operateur;
    public Ast expr;
    public Ast expr1;

    public OpExprExpr(Operateur operateur,Ast expr,Ast expr1){
        this.operateur = operateur;
        this.expr = expr;
        this.expr1 = expr1;
    }
}
