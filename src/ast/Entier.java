package ast;

public class Entier implements Ast {

    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public String num;

    public Entier(String num){
        this.num = num;
    }
}
