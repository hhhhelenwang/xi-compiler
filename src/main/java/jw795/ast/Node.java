package jw795.ast;

import util.edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

/**
 * Interface definition for an AST node. All nodes extends this interface.
 */
public interface Node {

    /**
     * Pretty Print method for node.
     */
    void prettyPrint(CodeWriterSExpPrinter printer);
}
