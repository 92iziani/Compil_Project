# Compilation de la Grammaire et Création d'arbres



## a - compilation du parser


Sur __Linux__, compilez avec la commande :
```bash
java -jar ./lib/antlr-4.9.2-complete.jar circ.g4 -no-listener -visitor -o ./src/parser
```

Sur __Windows__, compilez avec la commande :
```bash
java -jar ./lib/antlr-4.9.2-complete.jar circ.g4 -no-listener -visitor -o ./src/parser
```

Si tout se passe bien, cette commande doit générer dans le dossier src un sous dossier parser ainsi que 2 classes java :

* ```exprLexer.java``` : qui est l'analyseur lexical construit
* ```exprParser.java``` : qui est l'analyseur syntaxique produit (tables LL(k)).

Ces deux classes permettent d'analyser un texte et de vérifier s'il peut être reconnu par la grammaire expr.


## b - Affichage de l'arbre syntaxique

### Linux
Compiler Main.java avec la commande :
```
javac  -cp ./lib/antlr-4.9.2-complete.jar:./src ./src/Main.java -d ./bin```
```

Vous devriez générer des fichiers .class dans le dossier bin

Vous pouvez tester avec les programmes du dossier examples avec la commande :

```
java -cp ./lib/antlr-4.9.2-complete.jar:./bin Main ./examples/good.exp
```

### Windows

Compiler Main.java avec la commande :
```
javac  -cp "./lib/antlr-4.9.2-complete.jar;./src" ./src/Main.java -d ./bin```
```
Vous devriez générer des fichiers .class dans le dossier bin



Vous pouvez tester avec les programmes du dossier examples avec la commande :

```
java -cp "./lib/antlr-4.9.2-complete.jar;./bin" Main ./examples/good.c
```




