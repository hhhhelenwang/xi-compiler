package jw795.ast;

/**
 * Representation of array elements in AST. Implements Expr and RValue.
 */
public class ArrIndexExpr implements Expr, LValue{
    Expr array;
    Expr index;

    ArrIndexExpr(Expr arr, Expr i) {
        array = arr;
        index = i;
    }
}
