package ast;

public class DeclaAffect implements Ast{

    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ast ident;
    public Ast entier;

    public DeclaAffect(Ast ident, Ast entier){
        this.ident = ident;
        this.entier = entier;
    }
}
