package jw795.ast;

import util.edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

/**
 * Representation of a use command.
 */
public class Use extends ASTNode {
    String interfaceName;

    Use(String name, int line, int col) {
        super(line, col);
        interfaceName = name;
    }

    @Override
    public void prettyPrint(CodeWriterSExpPrinter printer) {

    }
}
