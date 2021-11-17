package ast;

public class Program implements Ast {


    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ast declarations;

    public Program(Ast decl){
        this.declarations = decl;
    }

}
