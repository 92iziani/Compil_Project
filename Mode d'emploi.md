# Mode d'emploi

Ce mode d'emploi présente les commandes du makefile à utiliser sur linux, et la structure de notre projet

##  Structure
Situé à la racine du projet, le fichier **circ.g4** contient la définition de notre grammaire.

Le dossier **src** contient nos programmes écrits en java pour la construction de la tds, de l'ast, ainsi que le parser et le lexer généré par antlr.

Le dossier **examples** contient des codes en Cir-C, certains etant corrects, certains contenant des erreurs syntaxiques, lexicales ou sémantiques.
Le dossier **out** contient l'image des AST.

##  Quick Start

On peut l'utiliser après avoir téléchargé notre projet. Cette commande compile la grammaire, et génère le parser avec visiteurs. Ensuite elle compile le **Main**, qui gère la construction des Asts, les contrôles sémantique, et le cas échéant, l'affichage de la TDS du code contenu dans le fichier.

Cependant, il n'est pas utile de régénérer à chaque fois les fichiers crées par antlr, et de recompiler le Main. Cette méthode n'est pas optimale quand la grammaire ou les classes n'ont pas été modifiées.
```bash
make soutenance target=examples/semantique.c
```
## Commandes

### a- Compilation de la grammaire

```bash
make parser
```

## b - TDS et contrôles sémantiques
Il s'agit dans un premier temps de la compilation et de l'execution du Main sur un exemple. La première commande n'est à faire que la première fois, ou si le main a été modifié.

```bash
make compile
```

```bash
make run target=examples/semantique.c
```



## c - Affichage de l'arbre

L'AST se trouve dans le dossier out, sous format svg
```bash
make ast
```

