package tds;

public class LigneFonction extends Ligne{

    private Parcours visitor;
    private String nomFonction;
    private String typeRetour;
    private String nom="Fonction";

    public LigneFonction(Parcours visitor, String nomFonction, String typeRetour){
        super();
        this.visitor = visitor;
    }

    @Override
    public String toString() {
        return "LigneFonction{" +
                "nomFonction='" + nomFonction + '\'' +
                ", typeRetour='" + typeRetour + '\'' +
                '}';
    }

}
