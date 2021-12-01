## Parcours de l'arbre syntaxique

Sur __Linux__, utilisez la commande :
```bash
make parser
 ```

Sur __Windows__, utilisez la commande : 
```bash
java -jar ./lib/antlr-4.9.2-complete.jar expr.g4 -no-listener -visitor -o ./src/parser
 ```

Dans le dossier ```src/parser```, vous venez de générer 4 fichiers java : ```exprBaseVisitor```, ```exprLexer```, ```exprParser``` et ```exprVisitor```.


Ouvrez la classe ```exprBaseVisitor```. Elle contient un ensemble de méthodes de la forme :

```java
T visit[Noeud]([Noeud]Context ctx);
 ```

Ces méthodes sont une surcouche du pattern visiteur expliqué plus tôt. Elles permettent de parcourir simplement chaque noeud de l'arbre syntaxique. L'objet ```ctx``` passé en argument représente le noeud de l'arbre syntaxique, ```T``` représente le type de retour du visiteur. Ce type générique permet de créer simplement plusieurs visiteurs avec des types de retour différents. Dans la suite, nous allons utiliser un visiteur pour créer l'AST.

Dans le dossier ```src/ast```, nous avons écrit l'ensemble des classes nécessaire pour construire l'AST de la grammaire Expr. Elles sont regroupées sous l'interface ```Ast```. Il y a également un objet ```AstCreator``` qui étend la classe ```exprBaseVisitor<Ast>```. 

#### a1. Préparation (Linux)

 Avant de commencer, compilez votre code en utilisant les commandes de la dernière fois. Pour les utilisateurs de __Linux__, nous avons mis à disposition un Makefile qui permet de compiler simplement la grammaire et le code java.


Pour compiler le Main :
```bash 
make compile
 ```

Pour exécuter le main sur un fichier donné :
```bash 
make run target=[path_du_fichier]
 ```

 Nous vous demandons d'éxécuter la seconde commande pour le moment.

#### a2. Préparation (Windows - PowerShell)

Pour les utilisateurs de __Windows__, nous ne sommes pas en mesure de fournir un Makefile sans vous faire installer plein de packages supplémentaires. Nous vous invitons à utiliser les commandes du TP précédent.

Pour compiler le Main :
```bash 
javac  -cp "./lib/antlr-4.9.2-complete.jar;./src" ./src/Main.java -d ./bin
 ```

Pour exécuter le main sur un fichier donné :
```bash 
java -cp "./lib/antlr-4.9.2-complete.jar;./bin" Main [nom_du_fichier]
 ```

 Nous vous demandons d'exécuter la seconde commande pour le moment.

#### b - Représentation graphique


Nous utilisons la syntaxe dot de graphViz pour générer l'arbre. Un noeud de l'arbre est représenté par le code :
```
NOM_DU_NOEUD [label="UN_LABEL", shape="box"];
 ```

Une transition est représentée par le code  :

```
NOEUD_DE_DEPART -> NOEUD_D_ARRIVEE;
 ```


Dans notre cas, la classe ```GraphVizVisitor``` va tout faire puisqu'elle génère un fichier .dot valide représentant l'AST passé en argument et l'enregistre dans le fichier ```out/tree.dot```.

Pour visualiser le fichier, on exécute simplement la commande :
```dot -Tsvg ./out/tree.dot -o ./out/tree.svg```

Ceci crée un fichier svg que nous pouvons visualiser avec n'importe quelle visionneuse d'images.


 


