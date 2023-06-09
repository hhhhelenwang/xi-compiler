package jw795.ast;

import jw795.Visitor;
import edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

import java.util.List;

/**
 * Representation of a function/procedure declaration in an interface file.
 */
public class FunctionDeclare extends ASTNode implements ProcFuncDecl {
    public String name;
    public List<FunProcArgs> arguments;
    public List<Type> returnTypes;


    public FunctionDeclare(String n, List<FunProcArgs> args, List<Type> types, int line, int col) {
        super(line, col);
        name = n;
        arguments = args;
        returnTypes = types;
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
        printer.endList();
    }

    /**
     * It seems like all interface node doesn't a visit function
     * @param visitor
     */
    @Override
    public void accept(Visitor visitor) throws Exception{
        visitor.visitFunDecl(this);
    }
}
