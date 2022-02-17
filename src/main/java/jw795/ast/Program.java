package jw795.ast;

import util.edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

import java.util.List;

/**
 * Representation of the program in AST. The root node of the AST.
 * Contains a list of functions/procedures.
 */
public class Program extends ASTNode {
    List<Use> uses;
    List<FunctionDefine> functions;
    List<VarDeclareStmt> globals;

    public Program(List<Use> us,
            List<FunctionDefine> fs,
            List<VarDeclareStmt> gvs,
            int line,
            int col) {
        super(line, col);
        uses = us;
        functions = fs;
        globals = gvs;
    }

    @Override
    public void prettyPrint(CodeWriterSExpPrinter printer) {
        printer.startList();
        for (Use use : uses) {
            use.prettyPrint(printer);
        }
        printer.endList();
        printer.startList();
        for (VarDeclareStmt glob : globals) {
            glob.prettyPrint(printer);
        }
        for (FunctionDefine fun : functions) {
            fun.prettyPrint(printer);
        }
        printer.endList();
    }
}
