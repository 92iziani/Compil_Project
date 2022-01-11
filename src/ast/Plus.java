package ast;

public class Plus implements Ast {

    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ast left;
    public Ast right;
    public int ligne;

    public Plus(int ligne,Ast left, Ast right){
        this.left = left;
        this.right = right;
        this.ligne=ligne;
    }

}
