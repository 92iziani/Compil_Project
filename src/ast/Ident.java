package ast;

public class Ident implements Ast {

    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public String name;

    public Ident(String name){
        this.name = name;
    }
}
