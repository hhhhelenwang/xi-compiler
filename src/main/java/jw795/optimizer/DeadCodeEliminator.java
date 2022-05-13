package jw795.optimizer;

import edu.cornell.cs.cs4120.xic.ir.*;
import jw795.cfg.CFG;
import jw795.cfg.CFGGenerator;
import jw795.cfg.CFGNode;
import jw795.dfa.LiveVariableIR;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class DeadCodeEliminator {

    IRCompUnit program;
    CFGGenerator cfgGenerator;
    boolean noChange; // if there are changes during this run of copy propagation

    public DeadCodeEliminator(IRCompUnit program) {
        this.program = program;
        cfgGenerator = new CFGGenerator();
        this.noChange = true; // default to true, set to false if there is change
    }

    public boolean ifNoChange() {
        return noChange;
    }

    /**
     * Run dead code elimination on program.
     * @return program with dead code removed
     */
    public IRCompUnit run() {
        HashMap<String, IRFuncDecl> newFunctions = new HashMap<>();
        for (IRFuncDecl function : program.functions().values()) {
            IRFuncDecl newFunction = removeDeadCodeForFunction(function);
            newFunctions.put(newFunction.name(), newFunction);
        }

        return new IRCompUnit(program.name(), newFunctions, program.ctors(), program.dataMap());
    }

    /**
     * Remove dead code. A dead code is x <- e where x is not live out of the node.
     * @return CFG with all dead nodes removed.
     */
    public IRFuncDecl removeDeadCodeForFunction(IRFuncDecl function) {
        // generate cfg for function
        CFG<IRStmt> cfg = cfgGenerator.toIRCFG(function);

        // run a live vars analysis on the cfg
        LiveVariableIR liveVariableIR = new LiveVariableIR(cfg);
        HashMap<CFGNode<IRStmt>, HashSet<IRTemp>> liveIns = liveVariableIR.backward();

        List<IRStmt> newBody = new ArrayList<>();
        IRStmt body = function.body();
        if (body instanceof IRSeq) {
            for (IRStmt stmt : ((IRSeq) body).stmts()) {
                // check if stmt is x <- e
                if (stmt instanceof IRMove && ((IRMove) stmt).target() instanceof IRTemp) {
                    CFGNode<IRStmt> node = cfg.getNode(stmt);
                    HashSet<IRTemp> liveOut = liveOut(node, liveIns);
                    IRTemp target = (IRTemp) ((IRMove) stmt).target();
                    if (liveOut.contains(target)) {
                        // keep this instruction
                        newBody.add(stmt);
                    }
                    // if target not in liveOut, don't add it to newBody
                } else {
                    // not a x <- e stmt, keep it
                    newBody.add(stmt);
                }

            }
        } else {
            throw new RuntimeException("Invalid function body.");
        }

        return new IRFuncDecl(function.name(), new IRSeq(newBody));
    }

    /**
     * Get the live-out set of node, which is union of all node's live-in
     * @param node current node
     * @return live-out of node
     */
    private HashSet<IRTemp> liveOut(CFGNode<IRStmt> node, HashMap<CFGNode<IRStmt>, HashSet<IRTemp>> liveIns) {
        HashSet<IRTemp> liveOutSet = new HashSet<>();
        for (CFGNode<IRStmt> successor : node.getSuccessors()) {
            liveOutSet.addAll(liveIns.get(successor));
        }
        return liveOutSet;
    }

}
