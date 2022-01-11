package ast;

public class Paramint implements Ast{

    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ident ident;
    public int ligne;

    public Paramint(int ligne, Ident ident){
        this.ligne=ligne;
        this.ident = ident;
    }

}
