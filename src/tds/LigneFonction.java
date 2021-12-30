package tds;

public class LigneFonction extends Ligne{

    private String nomFonction;
    private String typeRetour;

    @Override
    public String toString() {
        return "LigneFonction{" +
                "nomFonction='" + nomFonction + '\'' +
                ", typeRetour='" + typeRetour + '\'' +
                '}';
    }

}
