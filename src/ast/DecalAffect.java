package ast ;


public class DeclaAffect {

    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ast ident;
    public Ast entier;

    public Affect(Ast ident, Ast entier){
        this.ident = ident;
        this.entier = entier;
    }
}
