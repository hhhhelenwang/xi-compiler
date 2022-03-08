package jw795.ast;

import jw795.typechecker.Visitor;
import edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;
import java.math.BigInteger;

/**
 * Representation of an integer in AST.
 */
public class IntLiteral extends Expr{
    BigInteger value;

    public IntLiteral(BigInteger val, int line, int col) {
        super(line, col);
        value = val;
    }

    @Override
    public void prettyPrint(CodeWriterSExpPrinter printer) {
        printer.printAtom(value.toString());
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitIntLiteral(this);
    }
}
