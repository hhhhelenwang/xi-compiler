package jw795.ast;

import jw795.typechecker.Visitor;
import util.edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

import java.util.List;
import java.util.Optional;

/**
 * Representation of a function or procedure definition in AST.
 */
public class FunctionDefine extends ASTNode implements Definition{
    String name;
    List<Type> returnTypes; // procedure does not have return values
    List<FunProcArgs> arguments;
    BlockStmt functionBody;

    public FunctionDefine(String n, List<Type> types, List<FunProcArgs> args, BlockStmt body, int line, int col) {
        super(line, col);
        name = n;
        returnTypes = types;
        arguments = args;
        functionBody = body;
    }

    @Override
    public void prettyPrint(CodeWriterSExpPrinter printer) {
        printer.startList();
        printer.printAtom(name);

        printer.startList();
        for (FunProcArgs arg : arguments) {
            arg.prettyPrint(printer);
        }
        printer.endList();

        printer.startList();
        for (Type returnType : returnTypes) {
            returnType.prettyPrint(printer);
        }
        printer.endList();
        functionBody.prettyPrint(printer);
        printer.endList();
    }

    @Override
    public void accept(Visitor visitor) {

    }
}
