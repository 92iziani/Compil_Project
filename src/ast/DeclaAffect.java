package ast;

public class DeclaAffect implements Ast{

    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ident ident;
    public Ast entier;

    public DeclaAffect(Ident ident, Ast entier){
        this.ident = ident;
        this.entier = entier;
    }
}
