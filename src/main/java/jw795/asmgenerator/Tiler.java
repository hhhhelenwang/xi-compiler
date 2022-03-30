package jw795.asmgenerator;

/**
 * A visitor that traverse an IR tree and translate IR into tiles of abstract assembly.
 */
public class Tiler {
//    public Tiler(IRNodeFactory inf) {
//
//    }

//    /**
//     * Translate an IR node into a tile of abstract assembly instructions.
//     * @param parent The parent AST node of {@code n} or {@code null} when it is the root.
//     * @param n The original node in the input AST
//     * @param n2 The node returned by {@link IRNode#visitChildren(IRVisitor)}, which should
//     *    look like n except that the children have been visited.
//     * @param v2 The new node visitor created by {@link #enter(IRNode, IRNode)}, or {@code this}.
//     * @return this node but visited
//     */
//    //tttTODO: --> NOTE: Consider leave() == the visit function we used to write in our own ast visitor.
//    // This is the function interfaced by IRVisitor in the release code. You may wanna
//    // check out the docstrings in IRVisitor to understand how their visitor works.
//    // It is similar to the visitor we learned to write but weirder.
//    @Override
//    protected IRNode leave(IRNode parent, IRNode n, IRNode n2, IRVisitor v2) {
//        // tttTODO: translate IR node to tile for each kinds of IR node,
//        // can have helper functions for each nodes if this methods gets too big
//
//        //tttTODO: remember to add a field in IR to hold the optimal tile for IR node
//        if (n instanceof IRCompUnit ) {
//            // whatever need to be done for CompUnit
//        } else {
//            // same pattern for other nodes
//        }
//        return null;
//    }
}
