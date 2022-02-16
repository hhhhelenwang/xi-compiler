package jw795.ast;

import java.util.List;

/**
 * Representation of the program in AST. The root node of the AST.
 * Contains a list of functions/procedures.
 */
public class Program extends ASTNode {
    List<Use> uses;
    List<FunctionDefine> functions;

    Program(List<Use> us, List<FunctionDefine> fs, int line, int col) {
        super(line, col);
        uses = us;
        functions = fs;
    }
}
