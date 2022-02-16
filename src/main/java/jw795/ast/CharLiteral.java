package jw795.ast;

/**
 * Representation of character literal in AST.
 */
public class CharLiteral extends Expr{
    char value;

    CharLiteral(char val, int line, int col) {
        super(line, col);
        value = val;
    }
}
