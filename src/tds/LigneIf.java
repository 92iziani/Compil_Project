package tds;
import ast.*;
public class LigneIf extends Ligne {
    public LigneBloc thenBloc = null;
    public LigneBloc elseBloc = null;

    public LigneIf(IfThen IfThen , Tds father) {
        if (IfThen.thenBlock instanceof Bloc) {
            thenBloc = new LigneBloc((Bloc)IfThen.thenBlock);
            thenBloc.getTable().setFatherTDS(father);
        }
    }

    public LigneIf(IfThenElse ifElse , Tds father) {
        if (ifElse.thenBlock instanceof Bloc) {
            thenBloc = new LigneBloc((Bloc)ifElse.thenBlock);
            thenBloc.getTable().setFatherTDS(father);
        }
        if (ifElse.elseBlock instanceof Bloc) {
            elseBloc = new LigneBloc((Bloc)ifElse.elseBlock);
            elseBloc.getTable().setFatherTDS(father);
        }
    }

    public String toString() {
        String ret = "If";
        if (thenBloc != null) ret += "with a then bloc";
        if (elseBloc != null) ret += "with an else bloc";
        return ret;
    }
}