package jw795.ast;

/**
 * Representation of array elements in AST. Implements Expr and RValue.
 */
public class ArrIndexExpr extends Expr implements LValue{
    Expr array;
    Expr index;

    ArrIndexExpr(Expr arr, Expr i, int line, int col) {
        super(line, col);
        array = arr;
        index = i;
    }
}
