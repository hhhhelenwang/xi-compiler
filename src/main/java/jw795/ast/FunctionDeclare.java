package jw795.ast;

import java.util.List;
import java.util.Optional;

/**
 * Representation of a function/procedure declaration in an interface file.
 */
public class FunctionDeclare extends ASTNode {
    String name;
    List<FunProcArgs> arguments;
    Optional<List<Type>> returnTypes;

    FunctionDeclare(String n, List<FunProcArgs> args, Optional<List<Type>> types, int line, int col) {
        super(line, col);
        name = n;
        arguments = args;
        returnTypes = types;
    }

}
