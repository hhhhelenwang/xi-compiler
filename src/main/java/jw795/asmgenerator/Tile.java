package jw795.asmgenerator;

import edu.cornell.cs.cs4120.xic.ir.IRNode;
import jw795.assembly.AAInstruction;
import jw795.assembly.AATemp;

import java.util.List;

/**
 * Representation of a tile of assembly code
 */
public class Tile {

    private List<AAInstruction> assembly;
    private List<IRNode> neighborIRs;
    private int cost;
    private int costOfSubTree;
    private AATemp returnTemp;

    public Tile(List<AAInstruction> asm, List<IRNode> neighbors) {
        assembly = asm;
        neighborIRs = neighbors;

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
        int total = cost;
        for (IRNode neighbor : neighborIRs) {
            total += neighbor.getTile().getCostOfSubTree();
        }
        return total;
    }

    /**
     * Get the neighbor IR nodes of this tile.
     * @return a list of neighbor IR nodes
     */
    public List<IRNode> getNeighborIRs() {
        return neighborIRs;
    }

    /**
     * Set the temporary to put the final value of this tile in.
     * @param temp the temp to put the final values of this tile in.
     */
    public void setReturnTemp(AATemp temp) {
        returnTemp = temp;
    }

    /**
     * Get the temp where the final value of this tile is put in so that a tile that is right above this
     * tile can make use of its value.
     * @return the temp where the final value of this tile is.
     */
    public AATemp getReturnTemp() {
        return returnTemp;
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
