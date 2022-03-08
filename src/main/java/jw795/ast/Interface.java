package jw795.ast;
import jw795.typechecker.Visitor;
import edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

import java.util.List;

/**
 * Representation of the program in AST. The root node of the AST.
 * Contains a nonempty set of procedure and function declarations without implementations
 * and may contain end-of-line comments.
 */
public class Interface extends ASTNode {
    public List<ProcFuncDecl> functions;

    public Interface(List<ProcFuncDecl> fs, int line, int col) {
        super(line, col);
        functions = fs;
    }

    @Override
    public void prettyPrint(CodeWriterSExpPrinter printer) {
        printer.startList();
        printer.startList();
        for (ProcFuncDecl decl : functions) {
            decl.prettyPrint(printer);
        }
        printer.endList();
        printer.endList();
    }

    @Override
    public void accept(Visitor visitor) throws Exception{
        for (ProcFuncDecl decl : functions) {
            decl.accept(visitor);
        }
        visitor.visitInterface(this);
    }
}

