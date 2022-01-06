package tds;

import ast.*;

import java.util.ArrayList;
import java.util.Stack;

public class Parcours implements AstVisitor<Void> {
    public static int i=1;
    public  ArrayList<Tds> listetds;
    public Stack<Tds> stack;
    private String name;
    private String where;

    public ArrayList<String> listerror= new ArrayList<String>();  //POUR STOCKER LES ERREURS

    //constructeur de parcours
    public Parcours() {
        listetds = new ArrayList<Tds>();
        stack = new Stack<>();
    }

    public void addLigne(Ligne ligne) {
        stack.peek().addLigne(ligne);
    }

    public Tds getTable() {
        return this.stack.peek();
    }
    public String toString() {
        return this.stack.peek().toString();
    }


    ////////////////////METHODES/////////////////
    @Override
    public Void visit(Program program) {
        Tds tds = new Tds(i, "Program");
        i++;

        //ajout à la pile
        stack.push(tds);

        //ajout à la liste
        listetds.add(tds);
        for (Ast ast : program.declarations) {
            if (ast != null){
                ast.accept(this);
            }
        }
        return null;
    }

    @Override
    public Void visit(IfThen ifThen) {
        //CONTROLE SEMANTIQUE : verifier si c'est un booleen dans la condition
        ifThen.condition.accept(this);


        //pas de creation de tds car je vais dans le thenBlock
        LigneIf entry = new LigneIf(ifThen, stack.peek());
        this.addLigne(entry);

        ifThen.condition.accept(this);

        //creation de la tds par le then block
        name = "Then block";
        ifThen.thenBlock.accept(this);
        
        stack.pop();
        return null;
    }

    @Override
    public Void visit(IfThenElse ifThenElse) {
        //pas de creation de tds mais accept des deux enfants

        LigneIf entry = new LigneIf(ifThenElse, stack.peek());
        
        this.addLigne(entry);

        ifThenElse.condition.accept(this);
        
        name = "Then block";
        ifThenElse.thenBlock.accept(this);
        stack.pop();
        name = "Else block";
        ifThenElse.elseBlock.accept(this);

        stack.pop();
        return null;
    }

    @Override
    public Void visit(While whil) {
        //CREER TDS !!!!!
        whil.condition.accept(this); //ADDED


        LigneWhile entry = new LigneWhile(whil, stack.peek());        
        this.addLigne(entry);

        name = "While";
        whil.instruction.accept(this);

        stack.pop(); //ADDED
        return null;
    }

    @Override
    public Void visit(Return retur) {
        return null;
    }

    @Override
    public Void visit(Affectation affect) {
        where = "affectation";
        affect.expr.accept(this);
         //CONTROLE SEMANTIQUE CHECK SI LA VARIBALE D'AFFECTATION EXISTE
        Ident id = (Ident)affect.ident;
        if (!getTable().ifExists2(id.name)){
            listerror.add("ERROR : Variable "+id.name +" utilisée non déclarée !");
            /*System.err.println("ERROR : Variable "+id.name +" utilisée non déclarée !");
            System.exit(1);*/
        }
        return null;
    }

    @Override
    public Void visit(Ident ident) {
        //CONTROLE SEMANTIQUE CHECK SI La variable EXISTE
            if (!getTable().ifExists2(ident.name)){
                listerror.add("ERROR : Variable "+ident.name +" utilisée non déclarée !");
               // System.exit(1);
            } 
        
        return null;
    }

    @Override
    public Void visit(ListeDeclVars liste) {
        for(Ast child : liste.instrList){
            if (child != null){
                child.accept(this);
            }
        }

        return null;
    }

    @Override
    public Void visit(ListeInstruction liste) {
        for(Ast child : liste.instrList){
            if (child != null){
                child.accept(this);
            }
        }
        return null;
    }

    @Override
    public Void visit(Bloc bloc) {
        //CREER TDS !!!!!
        Tds tds = new Tds(stack.peek(),i, name);
        i++;

        listetds.add(tds);
        stack.push(tds);

        //ca peut etre un probleme 
        bloc.declarations.accept(this);
        //stack.pop();
        bloc.instructions.accept(this);

        return null;
    }

    @Override
    public Void visit(Plus plus) {
        //CONTROLE SEMANTIQUE CHECK SI Les variables EXISTEnt

        //je veux des ident pas des entiers
        if (plus.left instanceof Ident){
            Ident left = (Ident)plus.left;
            if (!getTable().ifExists2(left.name)){
                listerror.add("ERROR : Variable "+left.name +" utilisée non déclarée !");
                //System.exit(1);
            } 
        }
        if (plus.right instanceof Ident){
            Ident right = (Ident)plus.right;
            if (!getTable().ifExists2(right.name)){
                listerror.add("ERROR : Variable "+right.name +" utilisée non déclarée !");
                //System.exit(1);
            }
        }
        return null;
    }

    @Override
    public Void visit(Minus minus) {
        //CONTROLE SEMANTIQUE CHECK SI Les variables EXISTEnt

        //je veux des ident pas des entiers
        if (minus.left instanceof Ident){
            Ident left = (Ident)minus.left;
            if (!getTable().ifExists2(left.name)){
                listerror.add("ERROR : Variable "+left.name +" utilisée non déclarée !");
                //System.exit(1);
            } 
        }
        if (minus.right instanceof Ident){
            Ident right = (Ident)minus.right;
            if (!getTable().ifExists2(right.name)){
                listerror.add("ERROR : Variable "+right.name +" utilisée non déclarée !");
               // System.exit(1);
            }
        }
        return null;
    }

    @Override
    public Void visit(Divide divide) {
        // CONTROLE SEMANTIQUE : division par 0
        where = "divide";
        divide.right.accept(this);

        //CONTROLE SEMANTIQUE CHECK SI Les variables EXISTEnt

        //je veux des ident pas des entiers
        if (divide.left instanceof Ident){
            Ident left = (Ident)divide.left;
            if (!getTable().ifExists2(left.name)){
                listerror.add("ERROR : Variable "+left.name +" utilisée non déclarée !");
                //System.exit(1);
            } 
        }
        if (divide.right instanceof Ident){
            Ident right = (Ident)divide.right;
            if (!getTable().ifExists2(right.name)){
                listerror.add("ERROR : Variable "+right.name +" utilisée non déclarée !");
                //System.exit(1);
            }
        }

        return null;
    }

    @Override
    public Void visit(Mult mult) {
        //CONTROLE SEMANTIQUE CHECK SI Les variables EXISTEnt

        //je veux des ident pas des entiers
        if (mult.left instanceof Ident){
            Ident left = (Ident)mult.left;
            if (!getTable().ifExists2(left.name)){
                listerror.add("ERROR : Variable "+left.name +" utilisée non déclarée !");
               // System.exit(1);
            } 
        }
        if (mult.right instanceof Ident){
            Ident right = (Ident)mult.right;
            if (!getTable().ifExists2(right.name)){
                listerror.add("ERROR : Variable "+right.name +" utilisée non déclarée !");
                //System.exit(1);
            }
        }
        return null;
    }

    @Override
    public Void visit(DeclaList declaList) {
        for(int i=0 ; i<declaList.declaList.size();i++) {
            //CONTROLE SEMANTIQUE CHECK SI UNE VAR EST DECLAREE PLUSIEURS FOIS
            Ident id = (Ident) declaList.declaList.get(i);
            if (getTable().ifExists(id.name)) {
                listerror.add("ERROR : Variable " + id.name + " déclarée plusieurs fois !");
                //System.exit(1);
            }
            //this.addLigne(new LigneVariable(declaList));
            ArrayList<Ident> lvar = new ArrayList<Ident>();
            lvar.add(id);
            DeclaList dcl = new DeclaList(lvar);
            this.addLigne(new LigneVariable(dcl));
        }
        return null;

    }

    @Override
    public Void visit(DeclTyp declTyp) {
        //CONTROLE SEMANTIQUE CHECK SI UN TYPE EST DECLARE PLUSIEURS FOIS
        if (getTable().ifExists3(declTyp.ident.name)){
            listerror.add("ERROR : Type "+declTyp.ident.name+ " ne peut pas être défini plusieurs fois !");
            //System.exit(1);
        }

        this.addLigne(new LigneStruct(declTyp));
        //creation d'une tds avec une liste de decl vars
        Tds tds= new Tds(stack.peek(),i, "Struct");
        i++;

        listetds.add(tds);
        stack.push(tds);

        declTyp.listDeclVar.accept(this);
        
        stack.pop();

        return null;
    }

    @Override
    public Void visit(DeclaAffect dAffect) {
        Ident id = (Ident)dAffect.ident;
        if (getTable().ifExists(id.name)){
            listerror.add("ERROR : Variable "+id.name +" déclarée plusieurs fois !");
            //System.exit(1);
        }

        this.addLigne(new LigneVariable(dAffect));
        return null;
    }

    @Override
    public Void visit(Entier entier) {
        //CONTROLE SEMANTIQUE DE DIVIDE
        if (where == "divide"){
            if (entier.value.equals("0")){
                //printError("DIVISION PAR 0");
                listerror.add("ERROR : Divison par 0 !");
                
            }
        }
        
        return null;
    }

    @Override
    public Void visit(IntParam intParam) {
         //CONTROLE SEMANTIQUE CHECK SI LA FONCTION A ETE Déjà déclarée
        if (getTable().ifExists2(intParam.ident.name)){
            listerror.add("ERROR : Fonction "+intParam.ident.name+ " ne peut pas être déclarée deux fois");
            //System.exit(1);
        }
        //CREER TDS !!!!!
        LigneFonction entry = new LigneFonction(intParam);
        this.addLigne(entry);
        name = "Fonction "+intParam.ident.name;
        intParam.bloc.accept(this);
        intParam.listParam.accept(this);
        this.stack.pop();
        return null;
    }

    @Override
    public Void visit(Struct struct) {
        //CONTROLE SEMANTIQUE CHECK SI LE TYPE EXISTE
        if (!getTable().ifExists3(struct.structList.get(0).name)){
            listerror.add("ERROR : Type "+struct.structList.get(0).name+ " n'existe pas !");
            //System.exit(1);
        }
        // pas de creation de tds
        // creation de plusieurs lignes
        Ident type = struct.structList.get(0);
        for (int i=1; i<struct.structList.size(); i++){
            LigneVariable entry = new LigneVariable(struct.structList.get(i),type);
            this.addLigne(entry);
        }
        return null;
    }

    @Override
    public Void visit(StructParam structParam) {
        //CONTROLE SEMANTIQUE CHECK SI LA FONCTION A ETE Déjà déclarée
        if (getTable().ifExists2(structParam.ident2.name)){
            listerror.add("ERROR : Fonction "+structParam.ident2.name+ " ne peut pas être déclarée deux fois");
            //System.exit(1);
        }
        LigneFonction entry = new LigneFonction(structParam);
        this.addLigne(entry);
        //creer une tds avec bloc
        name = "Fonction "+structParam.ident2.name;
        structParam.bloc.accept(this);
        stack.pop();
        return null;
    }

    @Override
    public Void visit(ExclaExpr x) {
        //CONTROLE SEMANTIQUE CHECK SI Les variables EXISTEnt

        //je veux des ident pas des entiers
        if (x.expr instanceof Ident){
            Ident e = (Ident)x.expr;
            if (!getTable().ifExists2(e.name)){
                listerror.add("ERROR : Variable "+e.name +" utilisée non déclarée !");
                //System.exit(1);
            } 
        }
        return null;
    }

    @Override
    public Void visit(Fleche x) {
        return null;
    }

    @Override
    public Void visit(IdentExprPointeur x) {
        if (!getTable().ifExists2(x.ident.name)){
            listerror.add("ERROR : Fonction "+x.ident.name+ " n'existe pas");
            /*System.err.println("ERROR : Fonction "+x.ident.name+ " n'existe pas");
            System.exit(1);*/
        }

        return null;
    }

    @Override
    public Void visit(Operateur x) {
        return null;
    }

    @Override
    public Void visit(OpExpr x) {
         //CONTROLE SEMANTIQUE CHECK SI Les variables EXISTEnt

        //je veux des ident pas des entiers
        if (x.expr1 instanceof Ident){
            Ident left = (Ident)x.expr1;

            if (!getTable().ifExists2(left.name)){
                listerror.add("ERROR : Variable "+left.name+" utilisée dans la condition non déclarée !");
            } 
        }
        if (x.expr2 instanceof Ident){
            Ident right = (Ident)x.expr2;
            if (!getTable().ifExists2(right.name)){
                listerror.add("ERROR : Variable "+right.name+" utilisée dans la condition non déclarée !");

            }
        }
        return null;
    }

    @Override
    public Void visit(ParenthExpr x) {
        //CONTROLE SEMANTIQUE CHECK SI Les variables EXISTEnt

        //je veux des ident pas des entiers
        if (x.expr instanceof Ident){
            Ident e = (Ident)x.expr;
            if (!getTable().ifExists2(e.name)){
                listerror.add("ERROR : Variable "+e.name +" utilisée non déclarée !");
                //System.exit(1);
            } 
        }
        return null;
    }

    @Override
    public Void visit(Sizeof x) {
        return null;
    }

    @Override
    public Void visit(TiretExpr x) {
        //CONTROLE SEMANTIQUE CHECK SI Les variables EXISTEnt

        //je veux des ident pas des entiers
        if (x.expr instanceof Ident){
            Ident e = (Ident)x.expr;
            if (!getTable().ifExists2(e.name)){
                listerror.add("ERROR : Variable "+e.name +" utilisée non déclarée !");
                //System.exit(1);
            } 
        }
        return null;
    }

    @Override
    public Void visit(ListeExpr listexpr) {

        return null;
    }

    @Override
    public Void visit(Paramint x) {

        LigneVariable ligne = new LigneVariable(x);
        this.addLigne(ligne);
        return null;
    }

    @Override
    public Void visit(Paramstruct x) {
        LigneStructParam ligne = new LigneStructParam(x);
        this.addLigne(ligne);
        return null;
    }

    @Override
    public Void visit(List x) {

         for(Ast ast:x.astlist){
            if(ast != null){
                ast.accept(this);
            }
        }
        return null;
    }

    @Override
    public Void visit(Vide x) {
        return null;
    }

    public static void printError(String msg) {
        System.out.println("Error! " + msg);
        System.exit(1);
    }
}

