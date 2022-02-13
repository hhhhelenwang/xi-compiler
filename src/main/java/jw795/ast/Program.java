package jw795.ast;

import java.util.List;

/**
 * Representation of the program in AST. The root node of the AST.
 * Contains a list of functions/procedures.
 */
public class Program implements ASTNode{
    List<FunctionDefine> functions;

    Program(List<FunctionDefine> fs) {
        functions = fs;
    }
}
