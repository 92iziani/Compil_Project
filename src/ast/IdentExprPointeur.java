package ast;

public class IdentExprPointeur implements Ast {

    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ast ident;
    public Ast listexpr;

    public IdentExprPointeur(Ast ident,Ast listexpr) {
        this.ident = ident;
        this.listexpr = listexpr;
    }
}

