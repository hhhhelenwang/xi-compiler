package jw795.ast;

import jw795.typechecker.XiType;
import util.edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;

/**
 * Representation of an AST node. Stores node content.
 */
public abstract class ASTNode implements Node{
    private int line;
    private int col;
    public XiType type; // the type given

    public ASTNode (int li, int co) {
        line = li;
        col = co;
    }

    @Override
    public int getLine() {
        return line;
    }

    @Override
    public int getCol() {
        return col;
    }

}
