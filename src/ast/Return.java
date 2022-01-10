package ast;


public class Return implements Ast {

    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ast retour;

    public Return(Ast cond){
        this.retour = cond;
    }

}
