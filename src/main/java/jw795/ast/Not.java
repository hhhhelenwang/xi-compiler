package jw795.ast;

/**
 * Representation of Not, the boolean negation.
 */
public class Not extends UnOpExpr{
    Not(Expr val, int line, int col) {
        super(val, line, col);
    }
}
