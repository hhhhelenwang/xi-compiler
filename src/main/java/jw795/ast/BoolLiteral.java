package jw795.ast;

public class BoolLiteral extends Expr{
    boolean value;

    BoolLiteral(boolean val, int line, int col) {
        super(line, col);
        value = val;
    }

}
