package jw795.asmgenerator;

import edu.cornell.cs.cs4120.xic.ir.IRNode;
import jw795.assembly.AAInstruction;

import java.util.List;

/**
 * Representation of a tile of assembly code
 */
public class Tile {

    public List<AAInstruction> assembly;
    public IRNode neighborIR;
    public int cost;
    public int costOfSubTree;

    public Tile(List<AAInstruction> asm, IRNode neighbor) {
        assembly = asm;
        neighborIR = neighbor;

        cost = computeCostOfTile(); // calculate the cost of tile at construction
        costOfSubTree = computeCostOfSubTree();
    }

    /**
     * Getter for the cost of the subtree.
     * @return cost of subtree
     */
    public int getCostOfSubTree() {
        return costOfSubTree;
    }

    /**
     * Calculate the cost of this tile.
     * @return cost of this tile
     */
    public int computeCostOfTile() {
        return assembly.size();
    }

    /**
     * Suppose this tile is the tiling for node n. costOfTile is the total cost of tiling the
     * subtree with n as root plus the cost of this tile.
     * @return total cost of tiling the IR tree with n(this node) as root
     */
    public int computeCostOfSubTree() {
        return cost + neighborIR.getTile().getCostOfSubTree();
    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (AAInstruction asm : assembly) {
            str.append(asm).append("\n");
        }
        return str.toString();
    }
}
