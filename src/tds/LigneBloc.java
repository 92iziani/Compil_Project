package tds;
import ast.Ast;
import ast.Bloc;
public class LigneBloc extends Ligne{
    private Parcours visitor;
    private String nom="While";

    public LigneBloc(Parcours visitor){
        super();
        this.visitor = visitor;
    }

   /* public LigneBloc(Bloc bloc){
        this.visitor = new Parcours();
        if (bloc.declarations != null ) {
            bloc.declarations.accept(this.visitor);
        }

    }*/


}
