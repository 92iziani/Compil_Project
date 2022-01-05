package tds;

import ast.*;

import java.util.ArrayList;
import java.util.Stack;

public class Parcours implements AstVisitor<Void> {
    public static int i=1;
    public  ArrayList<Tds> listetds;
    public Stack<Tds> stack;
    private String name;

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
        //pas de creation de tds car je vais dans le thenBlock
        LigneIf entry = new LigneIf(ifThen, stack.peek());
        this.addLigne(entry);

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

        LigneWhile entry = new LigneWhile(whil, stack.peek());        
        this.addLigne(entry);

        name = "While";
        whil.instruction.accept(this);

        return null;
    }

    @Override
    public Void visit(Return retur) {
        return null;
    }

    @Override
    public Void visit(Affectation affect) {
        return null;
    }

    @Override
    public Void visit(Ident ident) {
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
        return null;
    }

    @Override
    public Void visit(Minus minus) {
        return null;
    }

    @Override
    public Void visit(Divide divide) {
        return null;
    }

    @Override
    public Void visit(Mult mult) {
        return null;
    }

    @Override
    public Void visit(DeclaList declaList) {
        this.addLigne(new LigneVariable(declaList));
        return null;
    }

    @Override
    public Void visit(DeclTyp declTyp) {
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
        this.addLigne(new LigneVariable(dAffect));
        return null;
    }

    @Override
    public Void visit(Entier entier) {
        return null;
    }

    @Override
    public Void visit(IntParam intParam) {
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
        return null;
    }

    @Override
    public Void visit(Fleche x) {
        return null;
    }

    @Override
    public Void visit(IdentExprPointeur x) {

        return null;
    }

    @Override
    public Void visit(Operateur x) {
        return null;
    }

    @Override
    public Void visit(OpExpr x) {
        return null;
    }

    @Override
    public Void visit(ParenthExpr x) {
        return null;
    }

    @Override
    public Void visit(Sizeof x) {
        return null;
    }

    @Override
    public Void visit(TiretExpr x) {
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

}

