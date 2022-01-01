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
import tds.Tds;

public class Main2 {

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



            // Visiteur de création de l'AST + création de l'AST
            AstCreator creator = new AstCreator();
            Ast ast = program.accept(creator);

            // Visiteur de représentation graphique + appel
            GraphVizVisitor graphViz = new GraphVizVisitor();
            ast.accept(graphViz);

            graphViz.dumpGraph("./out/tree.dot");

            Tds tds = new Tds();
            Parcours par =  new Parcours();
            ast.accept(par);
            //par.table.toString();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (RecognitionException e) {
            e.printStackTrace();
        }
    }

}

