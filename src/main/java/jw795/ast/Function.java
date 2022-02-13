package jw795.ast;

import java.util.List;
import java.util.Optional;

/**
 * Representation of a function or procedure definition in AST.
 */
public class Function implements ASTNode{
    String name;
    Optional<List<Type>> returnTypes; // procedure does not have return values
    List<FunProcArgs> arguments;
    BlockStmt functionBody;

    Function(String n, Optional<List<Type>> types, List<FunProcArgs> args, BlockStmt body) {
        name = n;
        returnTypes = types;
        arguments = args;
        functionBody = body;
    }
}
