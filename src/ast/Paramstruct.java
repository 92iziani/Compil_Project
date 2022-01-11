package ast;

public class Paramstruct implements Ast {

    public <T> T accept(AstVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Ident ident1;
    public Ident ident2;
    public int ligne;


    public Paramstruct(int ligne, Ident ident1,Ident ident2) {
        this.ident1 = ident1;
        this.ident2 = ident2;
        this.ligne = ligne;

    }
}
