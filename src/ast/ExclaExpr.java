package ast;

public class ExclaExpr implements Ast {

    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ast expr;

    public ExclaExpr(Ast expr){
        this.expr = expr;
    }

}
