package ast;

import java.util.ArrayList;

public class Struct implements Ast {
    
    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public ArrayList<Ident> structList;
    public int ligne;

    public Struct(int ligne, ArrayList<Ident> structList) {
        this.structList = structList;
        this.ligne=ligne;

    }


}
