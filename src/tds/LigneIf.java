package tds;
import ast.*;
public class LigneIf extends Ligne {
    public String type;

    public LigneIf(IfThen IfThen , Tds father) {
        type = "If Then";

    }

    public LigneIf(IfThenElse ifElse , Tds father) {
        type = "If Then Else";
    }

    public String toString() {
        return type;
    }
}
