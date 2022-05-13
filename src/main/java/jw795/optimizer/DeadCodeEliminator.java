package jw795.optimizer;

import edu.cornell.cs.cs4120.xic.ir.IRMove;
import edu.cornell.cs.cs4120.xic.ir.IRStmt;
import edu.cornell.cs.cs4120.xic.ir.IRTemp;
import jw795.cfg.CFG;
import jw795.cfg.CFGNode;
import jw795.dfa.LiveVariableIR;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class DeadCodeEliminator {

    CFG<IRStmt> cfg;
    boolean noChange; // if there are changes during this run of copy propagation

    public DeadCodeEliminator(CFG<IRStmt> cfg) {
        this.cfg = cfg; // pass in an unoptimized cfg
        this.noChange = true; // default to true, set to false if there is change
    }

    public boolean ifNoChange() {
        return noChange;
    }

    /**
     * Remove dead code. A dead code is x <- e where x is not live out of the node.
     * @return CFG with all dead nodes removed.
     */
    public CFG<IRStmt> removeDeadCode() {
        // run a live vars analysis on the cfg
        LiveVariableIR liveVariableIR = new LiveVariableIR(cfg);
        HashMap<CFGNode<IRStmt>, HashSet<IRTemp>> liveIns = liveVariableIR.backward();

        List<CFGNode<IRStmt>> nodesOfOldCfg = cfg.flatten();

        for (CFGNode<IRStmt> node : cfg.flatten()) {
            IRStmt stmt = node.getStmt();
            // check if stmt is x<-e
            if (stmt instanceof IRMove && ((IRMove) stmt).target() instanceof IRTemp) {
                HashSet<IRTemp> liveOut = liveOut(node, liveIns);
                IRTemp target = (IRTemp)((IRMove) stmt).target();
                if (!liveOut.contains(target)) {
                    // changes occurs
                    noChange = false;
                    // remove this node
                    List<CFGNode<IRStmt>> predecessors = node.getPredecessors();
                    List<CFGNode<IRStmt>> successors = node.getSuccessors();
                    // remove itself from all of its predecessors' successor list
                    for (CFGNode<IRStmt> pred : predecessors) {
                        pred.removeSuccessor(node);
                    }
                    // remove itself from all of its successor's predecessor list
                    for (CFGNode<IRStmt> succ : successors) {
                        succ.removePredecessor(node);
                    }
                    // add all of its successors to all of its predecessors' successor list
                    for (CFGNode<IRStmt> pred : predecessors) {
                        for (CFGNode<IRStmt> succ : successors) {
                            pred.addSuccessor(succ);
                        }
                    }
                    // add all of its predecessors to all of its successors' predecessor list
                    for (CFGNode<IRStmt> succ : successors) {
                        for (CFGNode<IRStmt> pred : predecessors) {
                            pred.addPredecessor(succ);
                        }
                    }
                }
            }

        }

        return cfg;
    }

    /**
     * Get the live-out set of node, which is union of all node's live-in
     * @param node current node
     * @return live-out of node
     */
    private HashSet<IRTemp> liveOut(CFGNode<IRStmt> node, HashMap<CFGNode<IRStmt>, HashSet<IRTemp>> liveIns) {
        HashSet<IRTemp> liveOutSet = new HashSet<>();
        for (CFGNode<IRStmt> successor : node.getSuccessors()) {
            liveOutSet.addAll(liveIns.get(node));
        }
        return liveOutSet;
    }

}
