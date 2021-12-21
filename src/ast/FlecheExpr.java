package ast;

public class FlecheExpr implements Ast {

    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ident ident;
    public Ast expr1;

    public FlecheExpr(Ident ident,Ast expr1){

        this.ident = ident;
        this.expr1 = expr1;
    }
}

