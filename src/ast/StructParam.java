package ast;


public class StructParam implements Ast{

    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public Ident ident1 ;
    public Ident ident2 ;
    public Ast listParam;
    public Ast bloc;
    public int ligne;

    public StructParam(int ligne, Ident ident1, Ident ident2, Ast listParam, Ast bloc){
        this.ident1 = ident1;
        this.ident2 = ident2; 
        this.listParam = listParam;
        this.bloc = bloc;
        this.ligne=ligne;
    }

}