package jw795.ast;

import jw795.typechecker.Prod;
import jw795.typechecker.Tau;
import jw795.typechecker.Visitor;
import util.edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Representation of a function or procedure definition in AST.
 */
public class FunctionDefine extends ASTNode implements Definition{
    public String name;
    public List<Type> returnTypes; // procedure does not have return values
    public List<FunProcArgs> arguments;
    public BlockStmt functionBody;

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

    /**
     * First enter a scope, and thenput in fun arg and return
     * @param visitor
     */
    @Override
    public void accept(Visitor visitor) throws Exception {
        for(FunProcArgs fp:arguments ){
            fp.accept(visitor);
        }
        for(Type e:returnTypes){
            e.accept(visitor);
        }
        functionBody.accept(visitor);

        visitor.visitFundef(this);

    }
}
