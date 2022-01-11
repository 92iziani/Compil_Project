package ast;

public class Sizeof implements Ast {

    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ident ident;

    public Sizeof(Ident ident){
        this.ident = ident;
    }

}

