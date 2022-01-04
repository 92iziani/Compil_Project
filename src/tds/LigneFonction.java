package tds;

import ast.*;

public class LigneFonction extends Ligne{

    //private Parcours visitor;
    private Ident ident=null,ident1=null,ident2=null;
    private String type;

    //public LigneBloc bloc;

    /*public LigneFonction(Parcours visitor, String nomFonction, String typeRetour){
        super();
        this.visitor = visitor;
    }*/

    public LigneFonction(IntParam intparam, Tds father){
        this.ident = intparam.ident;
        this.type = "INT";
       // this.bloc = new LigneBloc((Bloc)intparam.bloc);

        //bloc.getTable().setFatherTDS(father);
       // Parcours blocVisitor = bloc.getVisitor();
        //intparam.bloc.accept(blocVisitor);
    }

    public LigneFonction(StructParam fct, Tds father){
        this.ident1 = fct.ident1;
        this.ident2 = fct.ident2;
        this.type = "STRUCT";
       // this.bloc = new LigneBloc((Bloc)fct.bloc);

       // bloc.getTable().setFatherTDS(father);
        //Parcours blocVisitor = bloc.getVisitor();
        //fct.bloc.accept(blocVisitor);

    }
    public String toString() {
        if (ident !=null){
            return "function " +" nom: "+ ident.name + " type retour: " + type;
        }
        else {
            if (ident1 != null && ident2 != null){
                return "function " + "nom:" +ident2.name + " retour : "+ident1.name  +" type retour: " + type;
            }
        }
        return null;
    }

}
