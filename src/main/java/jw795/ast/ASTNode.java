package jw795.ast;

import util.edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

/**
 * Representation of an AST node. Stores node content.
 */
public abstract class ASTNode implements Node{
    public int line;
    public int col;

    public ASTNode (int li, int co) {
        line = li;
        col = co;
    }


}
