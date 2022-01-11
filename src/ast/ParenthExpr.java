package ast;

public class ParenthExpr implements Ast {

    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ast expr;
    public int ligne;

    public ParenthExpr(int ligne, Ast expr){
        this.expr = expr;
        this.ligne = ligne;
    }
}
