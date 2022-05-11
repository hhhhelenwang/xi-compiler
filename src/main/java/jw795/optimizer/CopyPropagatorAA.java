package jw795.optimizer;

import jw795.assembly.*;
import jw795.cfg.CFG;
import jw795.cfg.CFGNode;
import polyglot.util.Pair;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Carries out copy propagation on generated abstract assembly code
 */
public class CopyPropagatorAA {

    CFG<AAInstruction> cfg;
    HashMap<CFGNode<AAInstruction>, LinkedHashSet<Pair<String, String>>> nodeToValueMap;

    public CopyPropagatorAA(CFG<AAInstruction> cfg,
                            HashMap<CFGNode<AAInstruction>, LinkedHashSet<Pair<String, String>>> nodeToValueMap) {
        this.cfg = cfg;
        this.nodeToValueMap = nodeToValueMap;
    }

    /**
     * Update the cfg with copies propagated
     */
    public void copyPropagate() {
        List<CFGNode<AAInstruction>> cfgNodes = cfg.flatten();

        for (CFGNode<AAInstruction> node : cfgNodes) {
            AAInstruction instr = node.getStmt();

        }

    }

    /**
     * For a cfg node, find if any variables
     * @param node node to update
     */
    private void findAndReplace(CFGNode<AAInstruction> node) {
        AAInstruction instr = node.getStmt();
    }

    /**
     * Variables used in an abstract assembly instruction
     * @param instr an aa instruction
     * @return variable used in instr
     */
    private HashSet<AAOperand> use(AAInstruction instr) {
        HashSet<AAOperand> useSet = new HashSet<>();
        // instr

        return null;
    }

//    /**
//     * The set of variables used by an AAOperand expr
//     * @return variables used by expr
//     */
//    private HashSet<AAOperand> vars(AAOperand expr) {
//        HashSet<AAOperand> result = new HashSet<>();
//        if (expr instanceof AAImm || expr instanceof AADynamic) {
//            return result;
//        } else if (expr instanceof AAReg || expr instanceof AATemp) {
//            result.add(expr);
//        } else if (expr instanceof AAMem) {
//            ((AAMem) expr).base.ifPresent(result::add);
//            ((AAMem) expr).base.ifPresent(result::add);
//        }
//        return result;
//    }



}
