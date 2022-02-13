package jw795.ast;

import java.util.List;

/**
 * Representation of the program in AST. The root node of the AST.
 * Contains a list of functions/procedures.
 */
public class Program implements ASTNode{
    List<Function> functions;

    Program(List<Function> fs) {
        functions = fs;
    }
}
