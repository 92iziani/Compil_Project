package ast;

public class Sizeof implements Ast {

    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ident ident;
    public int ligne;

    public Sizeof(int ligne, Ident ident){
        this.ident = ident;
        this.ligne=ligne;
    }

}

