package ast;

public class Vide implements Ast {

    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public int ligne;

    public Vide(int ligne){
        this.ligne=ligne;
    }

}