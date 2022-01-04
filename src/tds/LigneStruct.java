package tds;

import ast.DeclTyp;
import ast.Ident;

public class LigneStruct extends Ligne{
    private String name;
    private Ident type;
    


    public LigneStruct(DeclTyp declTyp) {
        this.name = declTyp.ident.name;

    }
    public String toString() {

        return "Struct "+name;
    }
}
