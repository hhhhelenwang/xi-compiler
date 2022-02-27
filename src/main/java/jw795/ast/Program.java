package jw795.ast;

import jw795.typechecker.Visitor;
import util.edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

import java.util.List;

/**
 * Representation of the program in AST. The root node of the AST.
 * Contains a list of functions/procedures.
 */
public class Program extends ASTNode {
    List<Use> uses;
    List<Definition> definitions;

    public Program(List<Use> us,
            List<Definition> defs,
            int line,
            int col) {
        super(line, col);
        uses = us;
        definitions = defs;
    }

    @Override
    public void prettyPrint(CodeWriterSExpPrinter printer) {
        printer.startList();
        printer.startList();
        for (Use use : uses) {
            use.prettyPrint(printer);
        }
        printer.endList();
        printer.startList();
        for (Definition def : definitions) {
            def.prettyPrint(printer);
        }
        printer.endList();
        printer.endList();
    }

    @Override
    public void accept(Visitor visitor) {

    }
}
