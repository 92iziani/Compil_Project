package ast;

public class Paramint implements Ast{

    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ident ident;

    public Paramint(Ident ident){

        this.ident = ident;
    }

}
