package jw795.ast;

import util.edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

/**
 * Representation of a use command.
 */
public class Use extends ASTNode {
    String interfaceName;

    public Use(String name, int line, int col) {
        super(line, col);
        interfaceName = name;
    }

    @Override
    public void prettyPrint(CodeWriterSExpPrinter printer) {
        printer.startList();
        printer.printAtom("use");
        printer.printAtom(interfaceName);
        printer.endList();
    }
}
