package jw795.ast;

import jw795.typechecker.Visitor;
import edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

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
     * Accepts a visitor to perform type check.
     * @param visitor
     */
    void accept(Visitor visitor) throws Exception;
}
