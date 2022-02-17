package jw795.ast;
import util.edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

import java.util.List;

/**
 * Representation of the program in AST. The root node of the AST.
 * Contains a nonempty set of procedure and function declarations without implementations
 * and may contain end-of-line comments.
 */
public class Interface extends ASTNode {
    List<FunctionDeclare> functions;

    public Interface(List<FunctionDeclare> fs, int line, int col) {
        super(line, col);
        functions = fs;
    }

    @Override
    public void prettyPrint(CodeWriterSExpPrinter printer) {
        printer.startList();
        for (FunctionDeclare decl : functions) {
            decl.prettyPrint(printer);
        }
         printer.endList();
    }
}

