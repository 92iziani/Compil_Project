package tds;

//représente une ligne de la tds par exemple une variable
// chaque type de ligne extends cette classe car chaque ligne n'a pas les mêmes informations

import ast.Ident;

import java.util.HashMap;

public abstract class Ligne {

    private String type; //type = int, fonction, struct, param..
    private HashMap<String, Ident> map;

    public abstract String toString();

}
