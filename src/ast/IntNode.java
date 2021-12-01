package ast;

public class IntNode implements Ast {

    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public String value;

    public IntNode(String val){
        this.value = val;
    }
    
}