package jw795.ast;

import java.util.List;

/**
 * Representation of an array in AST.
 */
public class ArrayExpr extends Expr{
    List<Expr> arrayElements;

    ArrayExpr(List<Expr> elements, int line, int col) {
        super(line, col);
        arrayElements = elements;
    }
}
