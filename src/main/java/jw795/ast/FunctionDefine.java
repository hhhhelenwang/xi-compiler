package jw795.ast;

import edu.cornell.cs.cs4120.xic.ir.IRFuncDecl;
import jw795.Visitor;
import jw795.typechecker.*;
import edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

import java.util.ArrayList;
import java.util.List;

/**
 * Representation of a function or procedure definition in AST.
 */
public class FunctionDefine extends ASTNode implements Definition{
    public String name;
    public List<Type> returnTypes; // procedure does not have return values
    public List<FunProcArgs> arguments;
    public BlockStmt functionBody;
    public IRFuncDecl ir;

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
     * First enter a scope, and then put in fun arg and return
     * @param visitor
     */
    @Override
    public void accept(Visitor visitor) throws Exception {
        // enter scope
        visitor.enterScope();
        for (FunProcArgs arg : arguments) {
            arg.accept(visitor);
        }
        // for all return types, add return types, only happens in type-checking
        if (visitor instanceof TypeChecker) {
            List<Tau> retTauList = new ArrayList<>();
            for (Type retType : returnTypes) {
                retTauList.add(((TypeChecker) visitor).typeToTau(retType));
            }

            // generate corresponding return type to put into symbol table
            T returns;
            if (retTauList.size() == 0){
                returns = new Unit();
            } else if (retTauList.size() == 1){
                returns = retTauList.get(0);
            } else {
                returns = new Prod(retTauList);
            }
            Sigma ret = new Ret(returns);
            ((TypeChecker) visitor).env.addVar("return", ret);
        }

        functionBody.accept(visitor);
        visitor.leaveScope();

        visitor.visitFunDef(this);

    }
}
