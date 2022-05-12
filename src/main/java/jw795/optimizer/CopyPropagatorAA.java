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
    HashMap<CFGNode<AAInstruction>, LinkedHashSet<Pair<AAOperand, AAOperand>>> nodeToValueMap;

    public CopyPropagatorAA(CFG<AAInstruction> cfg,
                            HashMap<CFGNode<AAInstruction>,
                                    LinkedHashSet<Pair<AAOperand, AAOperand>>> nodeToValueMap) {
        this.cfg = cfg;
        this.nodeToValueMap = nodeToValueMap;
    }

    /**
     * Update the cfg with copies propagated
     */
    public void copyPropagate() {
        List<CFGNode<AAInstruction>> cfgNodes = cfg.flatten();

        for (CFGNode<AAInstruction> node : cfgNodes) {
            findAndReplace(node, nodeToValueMap.get(node));
        }
    }

    /**
     * For a cfg node, find if any variables has a copy available and replace.
     * @param node node to update
     */
    private void findAndReplace(CFGNode<AAInstruction> node, LinkedHashSet<Pair<AAOperand, AAOperand>> eqSet) {
        AAInstruction instr = node.getStmt();
        HashSet<AAOperand> useSet = instr.use();
        for (AAOperand var : useSet) {
            for (Pair<AAOperand, AAOperand> pair : eqSet) {
                if (pair.part1().equals(var)) {
                    // the current var in use set has an equality, replace it
                    // TODO: does find and replace both operands work?

                }
            }

        }
    }

    private AAOperand replaceInOperand(AAOperand opr, AAOperand oldVar, AAOperand newVar) {
        return null;
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



}
