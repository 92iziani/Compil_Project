package ast;

public class Fleche implements Ast {

    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ident ident;
    public Ast expr;
    public int ligne;

    public Fleche(int ligne, Ast expr, Ident ident){
        this.expr = expr;
        this.ident = ident;
        this.ligne = ligne;
    }

}

