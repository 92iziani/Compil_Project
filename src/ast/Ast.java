package ast;

public interface Ast {

    public <T> T accept(AstVisitor<T> visitor);
    public void acceptTDS(Parcours p, Tds tds);
    
}