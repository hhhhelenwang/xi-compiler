package edu.cornell.cs.cs4120.xic.ir;

import edu.cornell.cs.cs4120.util.SExpPrinter;
import edu.cornell.cs.cs4120.xic.ir.visit.*;
import jw795.asmgenerator.Tile;

/** A node in an intermediate-representation abstract syntax tree. */
public interface IRNode {

    /**
     * Set the currently optimal tile for the IRNode
     * @param tile optimal tile
     */
    void setTile(Tile tile);

    /**
     * Get the tile of this IRNode.
     */
    Tile getTile();

    /**
     * Visit the children of this IR node.
     *
     * @param v the visitor
     * @return the result of visiting children of this node
     */
    IRNode visitChildren(IRVisitor v);

    <T> T aggregateChildren(AggregateVisitor<T> v);

    InsnMapsBuilder buildInsnMapsEnter(InsnMapsBuilder v);

    IRNode buildInsnMaps(InsnMapsBuilder v);

    CheckCanonicalIRVisitor checkCanonicalEnter(CheckCanonicalIRVisitor v);

    boolean isCanonical(CheckCanonicalIRVisitor v);

    boolean isConstFolded(CheckConstFoldedIRVisitor v);

    String label();

    /**
     * Print an S-expression representation of this IR node.
     *
     * @param p the S-expression printer
     */
    void printSExp(SExpPrinter p);
}
