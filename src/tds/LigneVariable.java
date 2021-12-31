package tds;

public class LigneVariable extends Ligne{

    private Parcours visitor;
    private String nomvar; //nom de la variable
    private String nom="variable";

    public LigneVariable(Parcours visitor, String nomvar){
        super();
        this.visitor=visitor;
        this.nomvar = nomvar;
    }

    @Override
    public String toString() {
        return "LigneVariable{" +
                "nomvar='" + nomvar + '\'' +
                ", nom='" + nom + '\'' +
                '}';
    }
}
