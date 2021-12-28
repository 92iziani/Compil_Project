package tds;

import ast.Ident;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class TdsAbs{

    private TdsAbs father ;
    private ArrayList<TdsAbs> fils;
    private HashMap<String, Ident> ident;
    private static int num_region = 0;
    private int nv_imbrication;
    //private int num_table_mere;
    private ArrayList contenu;


    public TdsAbs(){
        num_region++; //car nouvelle table créée
        this.father = null; // n'a pas de père
        this.nv_imbrication = 0;
        //this.ident = new HashMap<>();
        //this.fils = new ArrayList<Tds>();
        this.contenu = new ArrayList<>();
    }
 
    public TdsAbs(TdsAbs parent) {
        this();
        this.father = parent;
        this.nv_imbrication = parent.getNiveau()+1;
    }

    public int getNiveau(){
        return this.nv_imbrication;
    }

    

    /*public void ajouterIdentificateur(Ident identificateur)
    {
        ident.put(identificateur.name,identificateur);
    }*/

    //public int addEntry(Tds entry) { fils.add(entry); return fils.size(); }

    public void addElement(){

    }

    protected abstract String nomBloc();


    public TdsAbs getFather() {
        return father;
    }

    public ArrayList<TdsAbs> getFils() {
        return fils;
    }

    public HashMap<String, Ident> getIdent() {
        return ident;
    }

    public  int getNum_region() {
        return num_region;
    }

    public ArrayList getContenu() {
        return contenu;
    }
}
