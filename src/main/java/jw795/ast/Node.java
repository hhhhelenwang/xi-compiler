package jw795.ast;

import jw795.typechecker.Visitor;
import jw795.typechecker.XiType;
import util.edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

/**
 * Interface definition for an AST node. All nodes extends this interface.
 */
public interface Node {

    /**
     * Getter methods for line and column.
     */
    int getLine();

    int getCol();

    /**
     * Pretty Print method for node.
     */
    void prettyPrint(CodeWriterSExpPrinter printer);

    /**
     * Getter method for the node's type
     * @return the type given by type checking process.
     */
    XiType type();

    /**
     * Accepts a visitor to perform type check.
     * @param visitor
     */
    void accept(Visitor visitor);
}
