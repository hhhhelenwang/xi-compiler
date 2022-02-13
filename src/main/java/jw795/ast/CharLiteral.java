package jw795.ast;

/**
 * Representation of character literal in AST.
 */
public class CharLiteral implements Expr{
    char value;

    CharLiteral(char val) {
        value = val;
    }
}
