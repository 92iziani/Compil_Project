package ast;

public class Operateur implements Ast {

    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public String name;
    public int ligne;

    public Operateur(int ligne, String name){
        this.name = name;
        this.ligne = ligne;
    }

}
