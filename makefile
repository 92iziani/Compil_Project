
parser :
	java -jar ./lib/antlr-4.9.2-complete.jar ./circ.g4 -no-listener -visitor -o ./src/parser

compile :
	javac -cp ./lib/antlr-4.9.2-complete.jar:./src ./src/Main.java -d ./bin

run :
	java -cp ./lib/antlr-4.9.2-complete.jar:./bin Main $(target)

ast :
	dot -Tsvg ./out/tree.dot -o ./out/tree.svg

soutenance :
	java -jar ./lib/antlr-4.9.2-complete.jar ./circ.g4 -no-listener -visitor -o ./src/parser
	javac -cp ./lib/antlr-4.9.2-complete.jar:./src ./src/Main.java -d ./bin
	java -cp ./lib/antlr-4.9.2-complete.jar:./bin Main $(target)

