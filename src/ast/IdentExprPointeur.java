package ast;

public class IdentExprPointeur implements Ast {

    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ident ident;
    public Ast listexpr;

    public IdentExprPointeur(Ident ident,Ast listexpr) {
        this.ident = ident;
        this.listexpr = listexpr;
    }
}

