package jw795.ast;

/**
 * Representation of integer negation.
 */
public class IntNeg extends UnOpExpr{
    IntNeg(Expr val, int line, int col) {
        super(val, line, col);
    }
}
