package jw795.ast;

import jw795.typechecker.Visitor;
import util.edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

import java.util.Optional;

/**
 * Representation of array type. Contains the type of the array's elements.
 */
public class ArrayType extends Type {
    public Type elemType;
    public Optional<Expr> length;

    public ArrayType(Type type, int line, int col) {
        super(line, col);
        if (! (type instanceof ArrayType)) {
            length = Optional.empty();
            elemType = type;
        } else {
            Type next = type;
            ArrayType pre = this;
            while (next instanceof ArrayType) {
                pre = (ArrayType) next;
                next = ((ArrayType) next).elemType;
            }
            pre.elemType = new ArrayType(next, line, col);
            this.elemType = ((ArrayType) type).elemType;
            this.length = ((ArrayType) type).length;
        }
    }

    public ArrayType(Type type, Expr len, int line, int col) {
        super(line, col);
        if (! (type instanceof ArrayType)) {
            length = Optional.of(len);
            elemType = type;
        } else {
            Type next = type;
            ArrayType pre = this;
            while (next instanceof ArrayType) {
                pre = (ArrayType) next;
                next = ((ArrayType) next).elemType;
            }
            pre.elemType = new ArrayType(next, len, line, col);
            this.elemType = ((ArrayType) type).elemType;
            this.length = ((ArrayType) type).length;
        }
    }

    @Override
    public void prettyPrint(CodeWriterSExpPrinter printer) {
        printer.startList();
        printer.printAtom("[]");
        elemType.prettyPrint(printer);
        length.ifPresent(expr -> expr.prettyPrint(printer));
        printer.endList();
    }

    @Override
    public void accept(Visitor visitor) throws Exception {
        if (length.isPresent()) {
            length.get().accept(visitor);
        }
    }
}
