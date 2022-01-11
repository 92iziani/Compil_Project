package tds;

import java.util.ArrayList;
import java.util.HashMap;
import ast.Ast;
import ast.Ident;
import ast.List;

public class Tds{

    private int nv_imbrication;
   // private HashMap<String,Ligne> map;
    private  int numero;
    private ArrayList<Ligne> contenu;
    private Tds father=null;
    private String name;

    public Tds(int i, String name) {
        this.numero=i;
        this.nv_imbrication=0; //car le pere
        this.contenu = new ArrayList<Ligne>();
        this.name = name;
    }
    public Tds(Tds father, int i, String name){
        this.father=father;
        this.nv_imbrication=father.getNiveau()+1;
        this.numero=i;
        this.contenu = new ArrayList<Ligne>();
        this.name=name;
    }

    public int addEntry(Ligne entry) {
        contenu.add(entry);
        return contenu.size();
    }

    private int getNiveau() {
        return this.nv_imbrication;
    }

    public void addLigne(Ligne elem){
        this.contenu.add(elem);
    }

    public Tds getFather() { return this.father;}

    public String getName(){
        return this.name;
    }

    public ArrayList<Ligne> getContenu(){
        return this.contenu;
    }


    public void setFatherTDS(Tds father) { this.father = father;}

        public boolean ifExists(String nom){

        if (contenu==null){
            return false;
        }
        for (Ligne lg : contenu){
            if (lg instanceof LigneVariable){
                LigneVariable var = (LigneVariable) lg;
               if( var.id2 != null && var.id2.name.equals(nom) ){
                   return true;
               }
               if (var.id1 != null){
                   for(Ident id:var.id1){
                       if (id.name.equals(nom)){
                           return true;
                       }
                   }
               }
               //verif des paramètres
               if (var.idparam != null && var.idparam.name.equals(nom)){
                    return true;
               }
               
               //je dois vérifier si le struct n'existe pas deja (plus loin pour le type)
                if( var.struct != null && var.struct.name.equals(nom)){
                    return true;
                }
            }


            if (lg instanceof LigneFonction){
                LigneFonction var = (LigneFonction) lg;
                if (var.ident != null && var.ident.name.equals(nom)){
                    return true;
                }
                if (var.ident2 != null && var.ident2.name.equals(nom)){
                    return true;
                }

            }

            if (lg instanceof LigneStructParam){
                LigneStructParam var = (LigneStructParam) lg;
                if (var.ident2 != null && var.ident2.name.equals(nom)){
                    return true;
                }

            }

        }
        return false;

    }


    public boolean ifExists2(String nom){
        while (father != null){
            if (ifExists(nom)){
                return true;
            }
            else {
                return father.ifExists2(nom);
            }
        }
        if (ifExists(nom)){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean ifExistsStruct(String nom){
        for (Ligne lg : contenu){
            if (lg instanceof LigneStruct){
                LigneStruct st = (LigneStruct) lg;
                if(st.name.equals(nom)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean ifExists3(String nom){
        while (father != null){
            if (ifExistsStruct(nom)){
                return true;
            }
            else {
                return father.ifExists3(nom);
            }
        }
        if (ifExistsStruct(nom)){
            return true;
        }
        else {
            return false;
        }
    }

    public String find_type(String nom){
        //je parcours le contenu
        String type = "int";
        for (Ligne lg : contenu){
            //je vérifie si c'est une instance de LigneVariable
            if (lg instanceof LigneVariable){
                LigneVariable var = (LigneVariable) lg;

                
                //verif des struct
                if (var.struct != null && var.struct.name.equals(nom)){
                    type=var.typeStruct.name;
                }
            }
            /*if (lg instanceof LigneStructParam){
                LigneStructParam var = (LigneStructParam) lg;
                type=var.ident1.name;
            }*/
        }
        return type;

    }


    public String find_type2(String nom){
        while (father != null){
            if (ifExists(nom)){
                return find_type(nom);
            }
            else {
                return father.find_type(nom);
            }
        }
        if (ifExists(nom)){
            return find_type(nom);
        }
        else {
            return find_type(nom);
        }
    }
    //FONCTION QUI DONNE LA LISTE DES TYPES DES PARAM D'UNE FCT DANS L'ORDRE (DECLARATION DE FONCTION) : CHERCHE UNIQUEMENT DANS LA TABLE COURANTE
    public ArrayList<String> listParam(){
        ArrayList<String> listtypeparam = new ArrayList<String>();
        for(Ligne lg:contenu){
            if (lg instanceof LigneStructParam){
                LigneStructParam par = (LigneStructParam)lg;
                if (par.ident1 != null){
                    listtypeparam.add(par.ident1.name);
                }
            }
            if (lg instanceof LigneVariable){
                LigneVariable par = (LigneVariable)lg;
                if(par.idparam != null){
                    listtypeparam.add("int");
                }
            }
        }
        return listtypeparam;
    }

    /**
    * Renvoie le type struct de la variable nom
    * @param nom du struct a trouvé
     * @return
     */
    /*public String findTypeStruct(String nom){
        
    }*/





    public String toString() {
        String result = "TDS "+name+" | Numéro: "+ numero+" | Nv imbrication: "+ this.nv_imbrication+"\n";
        result += "__________________________________________________\n";
        for (Ligne lg : contenu) {
            result += "Entry: "+lg.toString() + "\n";
        }
        return result;
    }

    

}
