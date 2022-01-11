package ast;

import java.util.ArrayList;

public class DeclaList implements Ast {
    
    // Utile pour la dernière partie
    public <T> T accept(AstVisitor<T> visitor){
        return visitor.visit(this);
    }

    public ArrayList<Ident> declaList;
    public int ligne;

    public DeclaList(int ligne,ArrayList<Ident> declaList) {
        this.declaList = declaList;
        this.ligne = ligne;

    }


}
