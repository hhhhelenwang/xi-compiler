package jw795.ast;
import java.util.List;

/**
 * Representation of the program in AST. The root node of the AST.
 * Contains a nonempty set of procedure and function declarations without implementations
 * and may contain end-of-line comments.
 */
public class Interface extends ASTNode {
    List<FunctionDeclare> functions;

    Interface(List<FunctionDeclare> fs, int line, int col) {
        super(line, col);
        functions = fs;
    }

}

