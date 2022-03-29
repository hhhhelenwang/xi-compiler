package jw795.asmgenerator.tiles;

/**
 * Representation of a tile of assembly code
 */
public abstract class Tile {

    // TODO: the designs of tiles need (A LOT) more thinking through. Here is a rough sketch of current design:
    //  Tile {
    //      List<AAInstruction> assembly;
    //      neighborTile or neighborIRNode; (have not decided which to go with yet)
    //      function calculateCost()
    //  }

    // TODO: things to consider:
    //  ======
    //  1. Do we want to use multiple kinds of tiles?
    //      One reason we might want to make different kinds of Tiles that extends this abstract Tile is to
    //      differentiate Expr and Stmt. Tiling expression may involve moving result into a "return temp"
    //      but tiling stmt does not need this. The Stmt that uses this expression needs to know about this
    //      "return temp". See the translation function T[t, e] in lecture notes "Instruction Selection".
    //      Another reason is that there are some fixed patterns for tiling each IR ???
    //  ========
    //  2. How do tiles connect with each other?

    /**
     * Suppose this tile is the tiling for node n. costOfTile is the total cost of tiling the
     * subtree with n as root plus the cost of this tile.
     * @return total cost of tiling the IR tree with n(this node) as root
     */
    public abstract int costOfTile();

    @Override
    public abstract String toString();
}
