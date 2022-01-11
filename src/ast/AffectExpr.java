package ast;

public class AffectExpr implements Ast{

    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ast exprg;
    public Ast exprd;
    public int ligne;

    public AffectExpr(int ligne,Ast exprg, Ast exprd){
        this.exprg = exprg;
        this.exprd = exprd;
        this.ligne = ligne;
    }

}
