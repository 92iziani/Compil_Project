package tds;

import ast.Bloc;
import ast.While;

public class LigneWhile extends Ligne{
    public LigneBloc bloc = null;

    public LigneWhile(While whil, Tds father){
        if (whil.instruction instanceof Bloc){
            bloc = new LigneBloc((Bloc) whil.instruction);
            bloc.getTable().setFatherTDS(father);
        }
    }

    public String toString(){
        String ret = "While";
        if (bloc != null) ret += " with a bloc";
        return ret;
    }
}
