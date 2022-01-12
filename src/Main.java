import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.io.IOException;

import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;

import GraphVizVisitor.GraphVizVisitor;
import ast.Ast;
import ast.AstCreator;
import parser.*;
import parser.circParser.ProgramContext;
import tds.Parcours;
import tds.Tables;
import tds.Tds;

public class Main {
    public static Tables tb = new Tables();


    public static void main(String[] args){

        if (args.length < 1){
            System.out.println("Error : Expected 1 argument filepath, found 0");
            return;
        }

        String testFile = args[0];

        try {
            //chargement du fichier et construction du parser
            CharStream input = CharStreams.fromFileName(testFile);
            circLexer lexer0 = new circLexer(input);
            CommonTokenStream stream = new CommonTokenStream(lexer0);
            circParser parser = new circParser(stream);

            ProgramContext program = parser.program();

            //CommonTree tree = (CommonTree)parser.program().getTree();

            // code d'affichage de l'arbre syntaxique
            /*JFrame frame = new JFrame("Antlr AST");
            JPanel panel = new JPanel();
            TreeViewer viewer = new TreeViewer(Arrays.asList(
                    parser.getRuleNames()),program);
            viewer.setScale(1.5); // Scale a little
            panel.add(viewer);
            frame.add(panel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);*/


            // Visiteur de création de l'AST + création de l'AST
            AstCreator creator = new AstCreator();
            Ast ast = program.accept(creator);

            // Visiteur de représentation graphique + appel
            GraphVizVisitor graphViz = new GraphVizVisitor();
            ast.accept(graphViz);
        
            graphViz.dumpGraph("./out/tree.dot");


            Parcours par =  new Parcours();
            //ast.accept(par);
           // par.toString();
            //Ajoute print aux fonctions
            ArrayList<String> printparam = new ArrayList<String>();
            printparam.add("int");
            par.listeparam.put("print",printparam);
            //Ajout malloc aux fonctions
            ArrayList<String> mallocparam = new ArrayList<String>();
            mallocparam.add("int");
            par.listeparam.put("malloc",mallocparam);

            ast.accept(par);

            String rouge = "\033[31m";
            String blanc = "\033[0m";
            String bold = "\033[1m";
            String normal = "\033[0m";
            int numero = 1;
            if(!par.listeparam.containsKey("main")){
                par.listerror.add(rouge+"ERROR :"+blanc+" Fonction"+bold+ " int main()"+normal +" manquante !");
            }
            if(par.listerror.size() > 0){
                System.out.println("\t"); //c plus jolie avec des \t ;)
                for (String erreur: par.listerror){
                    System.err.println(" "+erreur);
                    numero++;
                }
                System.out.println("\t"); //c plus jolie avec des \t ;)

            }
            else {
                for (Tds tds : par.listetds) {
                    if (tds != null) {
                        System.out.println(tds.toString());

                    }
                }
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (RecognitionException e) {
            e.printStackTrace();
        }
    }

}

