package ast;

public class Fleche implements Ast {

    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ast ident;

    public Fleche(Ast ident){
        this.ident = ident;
    }
}

