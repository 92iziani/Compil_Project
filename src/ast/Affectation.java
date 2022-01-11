package ast;

public class Affectation implements Ast{

    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ast ident;
    public Ast expr;
    public int ligne;

    public Affectation(int ligne,Ast ident, Ast expr){
        this.ident = ident;
        this.expr = expr;
        this.ligne = ligne;
    }

}
