package ast;

import parser.circParser;

public interface AstVisitor<T> {


    public T visit(Program affect);
    public T visitProgram(circParser.ProgramContext ctx)

}
