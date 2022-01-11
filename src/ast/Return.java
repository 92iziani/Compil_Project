package ast;


public class Return implements Ast {

    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ast retour;
    public int ligne;

    public Return(int ligne,Ast cond){
        this.retour = cond;
        this.ligne=ligne;
    }

}
