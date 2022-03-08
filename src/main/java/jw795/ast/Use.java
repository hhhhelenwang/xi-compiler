package jw795.ast;

import jw795.typechecker.Visitor;
import edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

/**
 * Representation of a use command.
 */
public class Use extends ASTNode {
    public String interfaceName;

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

    @Override
    public void accept(Visitor visitor) throws Exception {
        visitor.visitUse(this);
    }
}
