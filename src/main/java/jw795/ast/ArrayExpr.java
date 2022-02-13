package jw795.ast;

import java.util.List;

/**
 * Representation of an array in AST.
 */
public class ArrayExpr implements Expr{
    List<Expr> arrayElements;

    ArrayExpr(List<Expr> elements) {
        arrayElements = elements;
    }
}
