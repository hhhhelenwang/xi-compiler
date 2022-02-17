package jw795.ast;

import util.edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

import java.util.Optional;

/**
 * Representation of array type. Contains the type of the array's elements.
 */
public class ArrayType extends Type {
    Type elemType;
    Optional<Expr> length;

    ArrayType(Type type, int line, int col) {
        super(line, col);
        elemType = type;
        length = Optional.empty();
    }

    ArrayType(Type type, Expr len, int line, int col) {
        super(line, col);
        elemType = type;
        length = Optional.of(len);
    }

    @Override
    public void prettyPrint(CodeWriterSExpPrinter printer) {
        printer.startList();
        printer.printAtom("[]");
        if (length.isPresent()) {
            length.get().prettyPrint(printer);
        }
        elemType.prettyPrint(printer);
        printer.endList();
    }
}
