package jw795.asmgenerator;

import edu.cornell.cs.cs4120.xic.ir.*;
import edu.cornell.cs.cs4120.xic.ir.visit.IRVisitor;
import jw795.assembly.*;

import java.util.ArrayList;
import java.util.List;

/**
 * A visitor that traverse an IR tree and translate IR into tiles of abstract assembly.
 */
public class Tiler extends IRVisitor {
    public Tiler(IRNodeFactory inf) {
        super(inf);

    }

    /**
     * Translate an IR node into a tile of abstract assembly instructions.
     * @param parent The parent AST node of {@code n} or {@code null} when it is the root.
     * @param n The original node in the input AST
     * @param n2 The node returned by {@link IRNode#visitChildren(IRVisitor)}, which should
     *    look like n except that the children have been visited.
     * @param v2 The new node visitor created by {@link #enter(IRNode, IRNode)}, or {@code this}.
     * @return this node but visited
     */
    @Override
    protected IRNode leave(IRNode parent, IRNode n, IRNode n2, IRVisitor v2) {
        // TODO: translate IR node to tile for each kinds of IR node:
        //  (lower IR only)
        //  stmt: move, call_m, jump, cjump, label, return, seq
        //  expr: const, temp, mem, name, binop

        //  can have helper functions for each nodes if this methods gets too big

        if (n2 instanceof IRCompUnit) {
            // whatever need to be done for CompUnit
        } else if (n2 instanceof IRFuncDecl) {

        } else if (n2 instanceof IRSeq){
            // same pattern for other nodes
        } else if (n2 instanceof IRMove) {

        } else if (n2 instanceof IRCallStmt) {

        } else if (n2 instanceof IRJump) {

        } else if (n2 instanceof IRCJump) {

        } else if (n2 instanceof IRLabel) {

        } else if (n2 instanceof IRReturn) {

        }
        // expressions
        else if (n2 instanceof IRConst) {

        } else if (n2 instanceof IRTemp) {

        } else if (n2 instanceof IRMem) {

        } else if (n2 instanceof IRName) {

        } else if (n2 instanceof IRBinOp) {
            return tileBinop((IRBinOp) n2);

        } else {
            System.out.println("IR is not lowered.");
            return null;
        }
        return null;
    }

    /**
     * Tile a binop IR instruction
     * @param node a binop IR node
     * @return a binop IR node labeled with its tile of assembly
     */
    private IRNode tileBinop(IRBinOp node) {
        AAOperand operand1;
        AAOperand operand2;
        List<IRNode> neighbors = new ArrayList<>();

        // basic tiling for binop, no optimization
        // first decides the two operands
        // TODO: ok this is wrong
        if (node.left() instanceof IRConst) {
            operand1 = new AAImm(((IRConst) node.left()).value());
        } else if (node.left() instanceof IRTemp) {
            operand1 = new AATemp(((IRTemp) node.left()).name());
        } else {
            Tile childTile = node.getTile();
            operand1 = childTile.getReturnTemp();
            neighbors.add(node.left());
        }

        if (node.right() instanceof IRConst) {
            operand2 = new AAImm(((IRConst) node.left()).value());
        } else if (node.right() instanceof IRTemp) {
            operand2 = new AATemp(((IRTemp) node.left()).name());
        } else {
            Tile childTile = node.getTile();
            operand2 = childTile.getReturnTemp();
            neighbors.add(node.right());
        }

        switch (node.opType()){
            case ADD:
                // basic tiling, no optimization yet
                // TODO: match node against some patterns where optimization is possible through if-else
                List<AAInstruction> aasm = new ArrayList<>();
                AAAdd add = new AAAdd(operand1, operand2);
                aasm.add(add);
                Tile basicTile = new Tile(aasm, neighbors);
                // set return temp

            default:
                break;

        }


        return null;
    }
}
