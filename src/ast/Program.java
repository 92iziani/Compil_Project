package ast;

public class Program implements Ast {

    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ast instructions;

    public Program(Ast instr){
        this.instructions = instr;
    }

}
