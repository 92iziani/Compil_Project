package ast;

public class Sizeof implements Ast {

    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ast ident;

    public Sizeof(Ast ident){
        this.ident = ident;
    }
}

