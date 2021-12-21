package ast;

public class Entier implements Ast {

    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public String value;

    public Entier(String val){
        this.value = val;
    }

}