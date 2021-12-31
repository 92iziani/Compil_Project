package tds;

import ast.*;

public class Parcours implements AstVisitor<Void> {
    private Tds table;

    //constructeur de parcours
    public Parcours() {
        table = new Tds("Table initiale");
    }

    public void addLigne(Ligne ligne) {
        this.table.addLigne(ligne);
    }

    public Tds getTable() {
        return this.table;
    }

    @Override
    public Void visit(Program program) {
        for (Ast ast : program.declarations) {
            ast.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(IfThen ifThen) {
        LigneIf entry = new LigneIf(ifThen, this.table);
        if (entry.thenBloc != null) {
            //this.addEntry(entry.thenBloc);
        }
        this.addLigne(entry);
        return null;
    }

    @Override
    public Void visit(IfThenElse ifThenElse) {

        LigneIf entry = new LigneIf(ifThenElse, this.table);
        if (entry.thenBloc != null) {
            // this.addEntry(entry.thenBloc);
        }
        if (entry.elseBloc != null) {
            //this.addEntry(entry.elseBloc);
        }
        this.addLigne(entry);
        return null;
    }

    @Override
    public Void visit(While whil) {
        //LigneBloc ligne = new LigneBloc(whil, this.table);

        //this.addLigne(ligne);
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
        return null;
    }

    @Override
    public Void visit(ListeInstruction liste) {
        return null;
    }

    @Override
    public Void visit(Bloc bloc) {
        this.addLigne(new LigneBloc(bloc));
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
        return null;
    }

    @Override
    public Void visit(DeclTyp declTyp) {

        this.addLigne(new LigneStruct(declTyp, this.table));
        return null;
    }

    @Override
    public Void visit(DeclaAffect dAffect) {
        return null;
    }

    @Override
    public Void visit(Entier entier) {
        return null;
    }

    @Override
    public Void visit(IntParam intParam) {
        return null;
    }

    @Override
    public Void visit(Struct struct) {
        return null;
    }

    @Override
    public Void visit(StructParam structParam) {
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
        return null;
    }

    @Override
    public Void visit(Paramstruct x) {
        return null;
    }

    @Override
    public Void visit(List x) {
        return null;
    }

    @Override
    public Void visit(Vide x) {
        return null;
    }


    //en paramètre la tds que je dois remplir
    // ici ça va être la tds parent

}

