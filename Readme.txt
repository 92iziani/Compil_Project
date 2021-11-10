Sur Linux, compilez avec la commande :
java -jar ./lib/antlr-4.9.2-complete.jar expr.g4 -no-listener -no-visitor -o ./src/parser

Sur Windows, compilez avec la commande :
java -jar ./lib/antlr-4.9.2-complete.jar expr.g4 -no-listener -no-visitor -o ./src/parser

Si tout se passe bien, cette commande doit générer dans le dossier src un sous dossier parser ainsi que 2 classes java :
exprLexer.java : qui est l'analyseur lexical construit
exprParser.java : qui est l'analyseur syntaxique produit (tables LL(k)).
Ces deux classes permettent d'analyser un texte et de vérifier s'il peut être reconnu par la grammaire expr.


c - Affichage de l'arbre syntaxique (Linux)
La classe Main à la racine de src contient tout ce qui est nécessaire pour tester notre parser. Essayez de compiler Main.java avec la commande :

javac -cp ./lib/antlr-4.9.2-complete.jar:./src ./src/Main.java -d ./bin

Vous pouvez tester avec les programmes du dossier examples avec la commande :

java -cp ./lib/antlr-4.9.2-complete.jar:./bin Main ./examples/good.exp

d - Affichage de l'arbre syntaxique (Windows)
La classe Main à la racine de src contient tout ce qui est nécessaire pour tester notre parser. Essayez de compiler Main.java avec la commande :

javac -cp "./lib/antlr-4.9.2-complete.jar;./src" ./src/Main.java -d ./bin


Recompilez ensuite la grammaire, puis réexécutez la commande précédente. Vous devriez générer des fichiers .class dans le dossier bin

Vous pouvez tester les deux programmes du dossier examples avec la commande :

java -cp "./lib/antlr-4.9.2-complete.jar;./bin" Main ./examples/good.exp

