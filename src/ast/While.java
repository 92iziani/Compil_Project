package ast;

public class While implements Ast {

    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ast condition;
    public Ast instruction;
    public int ligne;

    public While(int ligne,Ast cond, Ast inst){
        this.condition = cond;
        this.instruction = inst;
        this.ligne = ligne;
    }

}
