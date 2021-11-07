TP Projet compilation des langages
Introduction
L'objectif de ce TP est l'apprentissage et la mise en oeuvre de l'utilisation d'Antlr.

Antlr est un générateur d’analyseur syntaxique descendant. Il permet de générer un "parseur" de langage à partir d'une grammaire.

Pour ce TP, nous utiliserons la version 4 d'Antlr. En première année, vous avez étudié les analyseurs syntaxiques LL(1). Antlr permet de générer des analyseurs LL(*). Cela signifie que l'analyseur connaît le nombre minimum de caractères nécessaires à lire pour pouvoir analyser un texte. Grâce à cela, nous allons pouvoir écrire les grammaires beaucoup plus simplement.

Partie 0 : Préambule
Ce dépôt git contient déjà le jar d'Antlr.

Notez que plusieurs IDE comme visual studio code ou Jetbrains InteliJ possèdent des extensions qui facilitent le dévelopement avec Antlr. Nous vous invitons à les installer.

Partie 1 : Première grammaire
a - Etude de la grammaire
Ouvrir le fichier expr.g4 situé à la racine du projet.

Le fichier commence par le nom de la grammaire.

grammar expr;.

Il est important de noter que la grammaire doit avoir le même nom que le fichier.

Une règle grammaticale se construit de la façon suivante: nom_de_la_regle : contenu ;

ainsi, la règle grammaticale A -> A B | C s'écrit dans antlr sous la forme:

a : a b | c ;

On peut remarquer deux types de règles différentes. Les règles "en majuscules" (comme par exemple la règle INT) permettent de décrire les terminaux de la grammaire. On les appelle les règles d'analyse lexicale.

Les règles, écrites "en minuscules" (comme par exemple la règle exp), sont des productions de la grammaire. Notez bien que les non-terminaux sont écrits en minuscules sous Antlr. C'est l'inverse de ce l'on voit habituellement dans les ouvrages de théorie des langages.

On peut remarquer les choses suivantes :

Les tokens (ou unités lexicales) dans les règles grammaticales sont encadrés par des quotes simple (‘+’)
La syntaxe des expressions régulières (?, +, *) est également utilisable dans Antlr.
Chaque règle se termine par un ;
Il est nécessaire de différencier les règles terminales (en majuscule) des règles non terminales (en minuscule). Dans le fichier contenant la grammaire, les régles décrivant les unités lexicales sont placées habituellement à la fin du fichier.
Dans les règles terminales, on peut utiliser la syntaxe .. pour désigner un ensemble de caractères. (‘0’..’9’) signifie l’ensemble des caractères entre 0 et 9.
La barre verticale | est un OU, elle permet de lister deux alternatives pour une même règle (et même à l’intérieur d’une règle). On reconnait dans cette notation la syntaxe des expressions régulières (regexp) vue dans le module "Shell".
Bon, il est temps de pratiquer un peu maintenant.

b - Les identifiants
En vous appuyant sur la grammaire expr, écrivez la règle de lexer permettant de definir les identifiants (on la notera IDF). Ils obéissent aux règles suivante :

Un identifiant peut contenir des lettres, des chiffres et le caractère '_'
Un identifiant ne peut pas commencer par un chiffre
c - Affectation de variable
Ecrivez une rêgle permettant l'affectation de variable à une expression de la forme.

nom_variable = expression ;

Cette règle doit respecter la syntaxe suivante :

La règle se termine par un ;
Seule une variable peut être affectée
Une expression peut être une variable ou un calcul
(indice : Vous avez le droit de modifier les règles précédentes et d'ajouter des règles auxiliaires)

d - Instruction et programme
Créez une règle instruction qui contiendra l'ensemble des instructions du langage. Pour le moment, la seule instruction que nous connaissons est l'affectation, nous allons en ajouter dans les parties suivantes.

Modfiez ensuite la rêgle program en commentaires qui correspond à une suite non nulle d'instructions terminées par le caractère spécial EOF (ne l'oubliez pas sinon vous aurez des erreurs à la fin).

Cette règle sera l'axiome de notre grammaire.

e - Instruction conditionnelle If
Ajoutez une règle permettant l'écriture d'une instruction conditionnelle if dont la syntaxe sera la suivante : if (condition) {instruction+} else {instruction+}

Le if obéit aux contraintes suivantes:

La condition est soit une expression, soit une variable
La partie else {instruction+} est optionnelle.
Ajoutez cette règle dans la liste des instructions.

f - Instruction d'affichage Print
Ajoutez une règle print qui obéit à la syntaxe suivante:

print valeur ;

La règle print obéit respecte la sémantique suivante :

La valeur est soit une expression, soit une variable
Ajoutez cette règle à la liste des instructions.

g- Ignorer certains caractères
Lorsque l'on écrit dans un langage de programmation, on utilise souvent les espaces et les retours à la ligne. Espacer les identificateurs et les lignes permet une meilleure lisibilité du code. Cependant, ces symboles ne sont pas des unités lexicales, ils ne doivent pas être traités par l'analyseur syntaxique.

Il faut donc dire au lexer d'ignorer certains caractères lors de l'analyse.

Antlr permet de réaliser cette opération grâce à l'instruction suivante:

WS : '\n'+ -> skip ;
Cette instruction permet de dire à l'analyseur lexical d'ignorer les caractères de l'expression régulière [\n]+. Cette règle permet ainsi d'ignorer les retours à la ligne.

Ajoutez cette règle dans votre grammaire (dans la partie lexicale, c'est à dire à la fin du fichier) et modifiez-la pour ignorer les tabulations et les espaces.

Partie 2 : Priorisation des opérateurs
a - Petit rappel
En première année, vous avez travaillé sur l'analyse syntaxique descendante en MI. Durant l'un des TD, on vous a présenté le concept de priorisation d'opérateur. Comme un petit rappel ne fait jamais de mal, nous vous proposons l'exercice suivant:

Ecrivez l'arbre syntaxique correspondant à l'expression arithmétique 2*3+4 en utilisant la grammaire suivante: A -> B (*|+) A | B
B -> idf | int

Vous devez remarquer dans l'arbre syntaxique que l'ordre des opérateurs n'est pas respecté, la multiplication se trouvant "plus haut" dans l'arbre que l'addition. Durant l'exécution, le calcul 3+4 sera donc effectué avant le calcul 2*3, ce qui ne respecte pas la priorité des opérateurs * et +.

Il faut donc intégrer cette priorité supérieure de la multiplication vis à vis de l'addition dans la grammaire.

Pour cela, on décompose la première règle en plusieurs sous règles (une par niveau de priorité). Cela donne la grammaire : A -> B + A | B B -> C * B | C C -> idf | int

De cette façon, l'opérateur + apparaîtra toujours avant l'opérateur * dans l'arbre syntaxique (et donc aussi dans l'arbre abstrait).

b - Implémentation de la grammaire expr
Antlr permet d'éviter l'utilisation de grammaire récursive comme celle de la partie précédente. Nous pouvons à la place utiliser l'étoile * pour écrire toutes les opérations de la même priorité sur une seule règle. Dans la règle exp, vous devrez avoir quelque chose de la forme : exp : (INT|IDF) ( ('+'|'-'|'*'|'/') (INT|IDF) )* ;

Dans cette règle, les opérateurs sont ajoutés les uns à la suite des autres. Bien que cette façon de faire soit contre-intuitive (on aimerait construire l'arbre de priorité tout de suite), elle simplifiera énormément l'écriture de l'arbre abstrait dans les prochains TP.

Partie 3 : Compilation de la grammaire et tests
Nous avons terminé l'écriture de notre grammaire, il serait temps de la lancer pour voir si ça marche non ?

a - installation de java
Dans cette partie, nous allons installer java en version 17 (pour ceux qui l'on déjà, vous pouvez passer à la suite). Vérifiez bien que

i. Sur linux (ubuntu, debian, popOs ...)
On met à jour le répository distant :

sudo apt update
on installe ensuite le jdk dans sa version 16:

sudo apt install openjdk-17-jdk
Ensuite, on va définir mettre à jour le jdk utilisé par défaut :

sudo update-alternatives --config java
Choisissez le numéro correspondant à la version 17 de java que vous venez d'installer.

ii. Linux (Arch, Manjaro)
On installe le jdk (dans sa dernière version) à l'aide du gestionnaire de packet Pacman:

sudo pacman -S jdk-openjdk
Pour changer la version de base de java, un tutoriel est disponible en suivant ce lien.

iii. Mac
On installe le jdk en utilisant le gestionnaire de packet homebrew. Tappez la commande suivante dans un terminal :

brew install java
iv. Windows
Vous devriez changer d'os ^^.

Blague à part, pour ceux qui ne l'on pas encore installé, vous pouvez télécharger la bonne version du jdk en suivant ce lien. Télécharger l'installeur et lancez l'installation.

Pour changer la version par default de java, le site happycoders propose un petit tutoriel ici. Vous devez changer la variable d'environnement JAVA_HOME pour le path de votre version du jdk (en temps normal, ce sera C:\Program Files\Java\jdk-17).

Pour tester la version, utilisez la commande :

java -v
b - compilation du parser
Nous avons terminé l'écriture de notre grammaire, il serait temps la lancer la construction de l'analyseur syntaxique pour voir si ça fonctionne, non ?

'Normalement', tout devrait fonctionner.

java -jar ./lib/antlr-4.9.2-complete.jar

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


Vous pouvez tester avec les deux programmes du dossier examples avec la commande :

java -cp ./lib/antlr-4.9.2-complete.jar:./bin Main ./examples/good.exp
java -cp ./lib/antlr-4.9.2-complete.jar:./bin Main ./examples/bad.exp
d - Affichage de l'arbre syntaxique (Windows)
La classe Main à la racine de src contient tout ce qui est nécessaire pour tester notre parser. Essayez de compiler Main.java avec la commande :

javac -cp "./lib/antlr-4.9.2-complete.jar;./src" ./src/Main.java -d ./bin


Recompilez ensuite la grammaire, puis réexécutez la commande précédente. Vous devriez générer des fichiers .class dans le dossier bin

Vous pouvez tester avec les deux programmes du dossier examples avec la commande :

java -cp "./lib/antlr-4.9.2-complete.jar;./bin" Main ./examples/good.exp
java -cp "./lib/antlr-4.9.2-complete.jar;./bin" Main ./examples/bad.exp