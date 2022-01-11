package ast;

public class IntParam implements Ast{

    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ident ident ;
    public Ast listParam;
    public Ast bloc;
    public int ligne;

    public IntParam(int ligne, Ident ident, Ast listParam, Ast bloc){
        this.ident = ident;
        this.listParam = listParam;
        this.bloc=bloc;
        this.ligne = ligne;
    }

}