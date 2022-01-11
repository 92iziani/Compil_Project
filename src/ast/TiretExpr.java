package ast;


public class TiretExpr implements Ast {

    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ast expr;

    public TiretExpr(Ast expr){
        this.expr = expr;
    }

}

