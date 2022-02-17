package jw795.ast;

import util.edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

/**
 * Representation of character literal in AST.
 */
public class CharLiteral extends Expr{
    char value;

    public CharLiteral(char val, int line, int col) {
        super(line, col);
        value = val;
    }

    @Override
    public void prettyPrint(CodeWriterSExpPrinter printer) {
        printer.printAtom(String.valueOf(value));
    }
}
