package GraphVizVisitor;

import java.io.FileOutputStream;
import java.io.IOException;

import ast.*;

public class GraphVizVisitor implements AstVisitor<String> {

    private int state;
    private String nodeBuffer;
    private String linkBuffer;

    public GraphVizVisitor(){
        this.state = 0;
        this.nodeBuffer = "digraph \"ast\"{\n\n\tnodesep=1;\n\tranksep=1;\n\n";
        this.linkBuffer = "\n";
    }

    public void dumpGraph(String filepath) throws IOException{
            
        FileOutputStream output = new FileOutputStream(filepath);

        String buffer = this.nodeBuffer + this.linkBuffer;
        byte[] strToBytes = buffer.getBytes();

        output.write(strToBytes);

        output.close();

    }


    private String nextState(){
        int returnedState = this.state;
        this.state++;
        return "N"+ returnedState;
    }

    private void addTransition(String from,String dest){
        this.linkBuffer += String.format("\t%s -> %s; \n", from,dest);

    }

    private void addNode(String node,String label){
        this.nodeBuffer += String.format("\t%s [label=\"%s\", shape=\"box\"];\n", node,label);

    }


    public String visit(Program program) {
        String nodeIdentifier = this.nextState();

        this.addNode(nodeIdentifier, "Program");

        for (Ast decl:program.declarations){
            if (decl !=null){
                String instructionState = decl.accept(this);
                this.addTransition(nodeIdentifier, instructionState);
            }
            
        }

        return nodeIdentifier;
    }

    public String visit(IfThen ifthen) {
        String nodeIdentifier = this.nextState();

        String conditionState = ifthen.condition.accept(this);
        String thenBlockState = ifthen.thenBlock.accept(this);

        this.addNode(nodeIdentifier, "If");
        this.addNode(thenBlockState, "Then");

        this.addTransition(nodeIdentifier, conditionState);
        this.addTransition(nodeIdentifier, thenBlockState);

        return nodeIdentifier;
    }

    public String visit(IfThenElse ifthenelse) {
        String nodeIdentifier = this.nextState();

        String conditionState = ifthenelse.condition.accept(this);
        String thenBlockState = ifthenelse.thenBlock.accept(this);
        String elseBlockState = ifthenelse.elseBlock.accept(this);

        this.addNode(nodeIdentifier, "If");
        this.addNode(thenBlockState, "Then");
        this.addNode(elseBlockState, "Else");

        //ici il y a 3 branches reliees au noeud courant
        this.addTransition(nodeIdentifier, conditionState);
        this.addTransition(nodeIdentifier, thenBlockState);
        this.addTransition(nodeIdentifier, elseBlockState);

        return nodeIdentifier;
    }

    public String visit(While whil) {
        String nodeIdentifier = this.nextState();

        this.addNode(nodeIdentifier, "While");

        String cond = whil.condition.accept(this);
        String ins = whil.instruction.accept(this);

        this.addTransition(nodeIdentifier,cond);
        this.addTransition(nodeIdentifier,ins);



        return nodeIdentifier;
    }

    public String visit(Return retur) {
        String nodeIdentifier = this.nextState();

        this.addNode(nodeIdentifier, "Return");

        String value = retur.retour.accept(this);

        this.addTransition(nodeIdentifier,value);
        return nodeIdentifier;
    }

    public String visit(Affectation affect) {
        //noeud que l'on va retourner
        String nodeIdentifier = this.nextState();

        //ici partie de gauche ident
        String identState = affect.ident.accept(this);

        //ici partie de droite expression
        String expressionState = affect.expr.accept(this);

        this.addNode(nodeIdentifier, "affect"); //affectation
        //ajout d'un lien entre le noeud courant et ident
        this.addTransition(nodeIdentifier,identState);
        //ajout d'un lien entre le noeud courant et expression
        this.addTransition(nodeIdentifier,expressionState);

        //on retourne le noeud courant
        return nodeIdentifier;
    }

    public String visit(Ident ident) {
        String nodeIdentifier = this.nextState();

        this.addNode(nodeIdentifier, ident.name);

        return nodeIdentifier;

    }

    public String visit(ListeDeclVars liste) {
        String nodeIdentifier = this.nextState();

        this.addNode(nodeIdentifier, "ListeDeclVars");

        for (Ast ast:liste.instrList){

            String astState = ast.accept(this);
            //ajout d'un lien pour chaque fils
            this.addTransition(nodeIdentifier, astState);

        }

        return nodeIdentifier;
    }

    public String visit(ListeInstruction liste) {
        String nodeIdentifier = this.nextState();

        this.addNode(nodeIdentifier, "ListeInstruction");

        for (Ast ast:liste.instrList){

            String astState = ast.accept(this);
            //ajout d'un lien pour chaque fils
            this.addTransition(nodeIdentifier, astState);

        }

        return nodeIdentifier;
    }

    public String visit(Bloc bloc) {
        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier,"Bloc");

        ListeDeclVars ldv = (ListeDeclVars) bloc.declarations;
        ListeInstruction li = (ListeInstruction) bloc.instructions;
        if (ldv.instrList.size()==0 && li.instrList.size()>0){
            String instr = bloc.instructions.accept(this);
            this.addTransition(nodeIdentifier,instr);
            return nodeIdentifier;
        }
        if (ldv.instrList.size()>0 && li.instrList.size()==0){
            String instr = bloc.declarations.accept(this);
            this.addTransition(nodeIdentifier,instr);
            return nodeIdentifier;
        }
            //SI LES DEUX FILS SONT ONT TOUS LES DEUX DES FILS
            String dec = bloc.declarations.accept(this);
            String instr = bloc.instructions.accept(this);
            this.addTransition(nodeIdentifier, dec);
            this.addTransition(nodeIdentifier, instr);
            return nodeIdentifier;
    }

    public String visit(Plus plus) {
        String nodeIdentifier = this.nextState();

        String leftState = plus.left.accept(this);
        String rightState = plus.right.accept(this);

        this.addNode(nodeIdentifier, "+");

        this.addTransition(nodeIdentifier, leftState);
        this.addTransition(nodeIdentifier, rightState);

        return nodeIdentifier;
    }

    public String visit(Minus minus) {
        String nodeIdentifier = this.nextState();

        String leftState = minus.left.accept(this);
        String rightState = minus.right.accept(this);

        this.addNode(nodeIdentifier, "-");

        this.addTransition(nodeIdentifier, leftState);
        this.addTransition(nodeIdentifier, rightState);

        return nodeIdentifier;
    }

    public String visit(Divide divide) {

        String nodeIdentifier = this.nextState();

        String leftState = divide.left.accept(this);
        String rightState = divide.right.accept(this);

        //nom du nom que l'on souhaite afficher
        this.addNode(nodeIdentifier, "/");

        this.addTransition(nodeIdentifier, leftState);
        this.addTransition(nodeIdentifier, rightState);

        return nodeIdentifier;

    }

    public String visit(Mult mult) {
        String nodeIdentifier = this.nextState();

        String leftState = mult.left.accept(this);
        String rightState = mult.right.accept(this);

        this.addNode(nodeIdentifier, "*");

        this.addTransition(nodeIdentifier, leftState);
        this.addTransition(nodeIdentifier, rightState);

        return nodeIdentifier;
    }

    /*    public String visit(IntNode entier) {
        String nodeIdentifier = this.nextState();

        this.addNode(nodeIdentifier, entier.value);

        return nodeIdentifier;

    }*/
    public String visit(Entier entier) {
        String nodeIdentifier = this.nextState();

        this.addNode(nodeIdentifier, entier.value);

        return nodeIdentifier;

    }

    
    public String visit(DeclaList declL) {
        String nodeIdentifier = this.nextState();

        this.addNode(nodeIdentifier, "decl liste d'ident"); 

        for (Ast ast:declL.declaList){

            String astState = ast.accept(this);
            //ajout d'un lien pour chaque fils
            this.addTransition(nodeIdentifier, astState);

        }

       
        return nodeIdentifier;
    }

    public String visit(DeclTyp declTyp) {
        String nodeIdentifier = this.nextState();

        String identdecl = declTyp.ident.accept(this);
        String listdec = declTyp.listDeclVar.accept(this);


        this.addNode(nodeIdentifier, "decl Struct"); //affectation
        
        this.addTransition(nodeIdentifier,identdecl);
        this.addTransition(nodeIdentifier,listdec);

        
        return nodeIdentifier;
    }

    public String visit(IntParam intpar) {
        String nodeIdentifier = this.nextState();

        String ident = intpar.ident.accept(this);
        String listp = intpar.listParam.accept(this);
        String blocparam = intpar.bloc.accept(this);


        this.addNode(nodeIdentifier, "Fonction");

        this.addTransition(nodeIdentifier,ident);
        this.addTransition(nodeIdentifier,listp);
        this.addTransition(nodeIdentifier,blocparam);

        return nodeIdentifier;
    }

    //MODIFIED
   /* public String visit(ListeParam listepar) {

        String nodeIdentifier = this.nextState();

        this.addNode(nodeIdentifier, "Param??tres");

        String value = listepar.paramList.accept(this);
        this.addTransition(nodeIdentifier,value);
        return nodeIdentifier;

    }*/

    public String visit(Struct struct) {
        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, "Liste de struct"); 
 

        for (Ident id:struct.structList){

            String astState = id.accept(this);
            //ajout d'un lien pour chaque fils
            this.addTransition(nodeIdentifier, astState);

        }



        return nodeIdentifier;
    }


    public String visit(StructParam structpa) {
        String nodeIdentifier = this.nextState();

        String identstruct1 = structpa.ident1.accept(this);
        String identstruct2 = structpa.ident2.accept(this);
        String listecparam = structpa.listParam.accept(this);
        String blocstruc = structpa.bloc.accept(this);

        this.addNode(nodeIdentifier, "struct Fonction ");
        this.addTransition(nodeIdentifier,identstruct1);
        this.addTransition(nodeIdentifier,identstruct2);
        this.addTransition(nodeIdentifier,listecparam);
        this.addTransition(nodeIdentifier,blocstruc);


        return nodeIdentifier;
    }



    /*public String visit(IntNode x) {
        String nodeIdentifier = this.nextState();

        this.addNode(nodeIdentifier, String.valueOf(x.value));

        return nodeIdentifier;
    }*/

    public String visit(ExclaExpr x) {
        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, "!");

        String v = x.expr.accept(this);

        this.addTransition(nodeIdentifier, v);

        return nodeIdentifier;
    }

    public String visit(Fleche x) {
        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, "->");

        String a = x.expr.accept(this);
        String b = x.ident.accept(this);

        this.addTransition(nodeIdentifier, a);
        this.addTransition(nodeIdentifier, b);

        return nodeIdentifier;
    }

    /*public String visit(FlecheExpr x) {
        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, "->");

        String a = x.ident.accept(this);
        String b = x.expr1.accept(this);

        this.addTransition(nodeIdentifier, a);
        this.addTransition(nodeIdentifier, b);

        return nodeIdentifier;
    }*/

    /*public String visit(Ident x) {
        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, "Ident");

        String v = x.name.accept(this);

        this.addTransition(nodeIdentifier, v);

        return nodeIdentifier;
    }*/

    public String visit(IdentExprPointeur x) {
        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, "IdentExprPointeur");

        String a = x.ident.accept(this);
        String b = x.listexpr.accept(this);

        this.addTransition(nodeIdentifier, a);
        this.addTransition(nodeIdentifier, b);

        return nodeIdentifier;
    }

    public String visit(Operateur x) {
        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, x.name);
        return nodeIdentifier;
    }

    public String visit(OpExpr x) {
        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, "OpExpr");

        String a = x.expr1.accept(this);
        String b = x.operateur.accept(this);
        String c = x.expr2.accept(this);

        this.addTransition(nodeIdentifier, a);
        this.addTransition(nodeIdentifier, b);
        this.addTransition(nodeIdentifier, c);

        return nodeIdentifier;
    }

    /*public String visit(OpExprExpr x) {
        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, "OpExprExpr");

        String a = x.operateur.accept(this);
        String b = x.expr.accept(this);
        String c = x.expr1.accept(this);

        this.addTransition(nodeIdentifier, a);
        this.addTransition(nodeIdentifier, b);
        this.addTransition(nodeIdentifier, c);

        return nodeIdentifier;
    }*/

    public String visit(ParenthExpr x) {
        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, "ParenthExpr");

        String a = x.expr.accept(this);

        this.addTransition(nodeIdentifier, a);

        return nodeIdentifier;
    }

    public String visit(Sizeof x) {
        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, "Sizeof");

        String a = x.ident.accept(this);

        this.addTransition(nodeIdentifier, a);

        return nodeIdentifier;
    }

    public String visit(TiretExpr x) {
        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, "-");

        String a = x.expr.accept(this);

        this.addTransition(nodeIdentifier, a);

        return nodeIdentifier;
    }
public String visit(DeclaAffect declaff){
        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, "declaraffect");

        String a = declaff.ident.accept(this);
        String b = declaff.entier.accept(this);

        this.addTransition(nodeIdentifier, a);
        this.addTransition(nodeIdentifier, b);

        return nodeIdentifier;
    }

@Override
public String visit(ListeExpr listexpr) {
        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, "Expressions");
        for (Ast ast:listexpr.list){
            String astState = ast.accept(this);
            //ajout d'un lien pour chaque fils
            this.addTransition(nodeIdentifier, astState);
        }
        return nodeIdentifier;
}

    public String visit(Paramint x){
        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, "Paramint");
        String a = x.ident.accept(this);
        this.addTransition(nodeIdentifier, a);
        return nodeIdentifier;
    }

    @Override
    public String visit(Paramstruct x) {
        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, "Paramstruct");
        String a = x.ident1.accept(this);
        String b = x.ident2.accept(this);
        this.addTransition(nodeIdentifier, a);
        this.addTransition(nodeIdentifier, b);
        return nodeIdentifier;
    }

    @Override
    public String visit(List x) {
        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, "Liste param??tres");
        for (Ast ast : x.astlist) {
            if (ast instanceof Paramint) {
                //System.out.println("oui");
                Paramint a = (Paramint) ast;
                String st = a.ident.accept(this);
                this.addTransition(nodeIdentifier, st);
                // this.addTransition(nodeIdentifier, a);
            } else {
                String astState = ast.accept(this);
                //ajout d'un lien pour chaque fils
                this.addTransition(nodeIdentifier, astState);
            }
        }
        return nodeIdentifier;

    }

    @Override
    public String visit(Vide x) {
        String nodeIdentifier = this.nextState();
        this.addNode(nodeIdentifier, "Vide");
        return nodeIdentifier;
    }

}
