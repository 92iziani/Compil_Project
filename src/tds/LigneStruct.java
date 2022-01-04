package tds;

import ast.DeclTyp;

public class LigneStruct extends Ligne{
    private Parcours visitor;
    private String name;
    public LigneBloc bloc = null;

    public LigneStruct(DeclTyp declTyp) {
        this.name = declTyp.ident.name;

    }
    public String toString() {

        return "Struct "+name;
    }
}
