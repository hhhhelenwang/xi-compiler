package jw795.optimizer;

import edu.cornell.cs.cs4120.xic.ir.*;
import jw795.cfg.CFG;
import jw795.cfg.CFGGenerator;
import jw795.cfg.CFGNode;
import jw795.dfa.AvailableCopiesIR;
import polyglot.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Carries out copy propagation on a lower IR program
 */
public class CopyPropagatorIR {

    IRCompUnit program;
    CFGGenerator cfgGenerator;
    boolean noChange; // if there are changes during this run of copy propagation

    public CopyPropagatorIR(IRCompUnit program) {
        this.program = program;
        this.cfgGenerator = new CFGGenerator();
        this.noChange = true; // initialize to true, set to false when a variable is replaced
    }

    public boolean ifNoChange() {
        return noChange;
    }

    /**
     * Run copy propagation on the entire program.
     * @return copy-propagated program
     */
    public IRCompUnit run() {
        HashMap<String, IRFuncDecl> newFunctions = new HashMap<>();
        for (IRFuncDecl function : program.functions().values()) {
            IRFuncDecl newFunction = copyPropagateFunction(function);
            newFunctions.put(newFunction.name(), newFunction);
        }

        return new IRCompUnit(program.name(), newFunctions, program.ctors(), program.dataMap());
    }

    /**
     * Run copy propagation on the given function, return the updated function
     */
    public IRFuncDecl copyPropagateFunction(IRFuncDecl function) throws RuntimeException{
        // generate cfg for function
        CFG<IRStmt> cfg = cfgGenerator.toIRCFG(function);
        // do an available copies analysis on the cfg
        AvailableCopiesIR availableCopiesIR = new AvailableCopiesIR(cfg);
        HashMap<CFGNode<IRStmt>, LinkedHashSet<Pair<IRTemp, IRTemp>>> nodeToValueMap = availableCopiesIR.forward();

        // copy propagate
        List<IRStmt> newBody = new ArrayList<>();
        IRStmt body = function.body();
        if (body instanceof IRSeq) {
            for (IRStmt stmt : ((IRSeq) body).stmts()) {
                CFGNode<IRStmt> node = cfg.getNode(stmt);
                LinkedHashSet<Pair<IRTemp, IRTemp>> outOfNode = nodeToValueMap.get(node);
                IRStmt newStmt = findAndReplace(stmt, outOfNode);
                newBody.add(newStmt);
            }
        } else {
            throw new RuntimeException("Invalid function body.");
        }

        // create the new function
        IRFuncDecl newFunc = new IRFuncDecl(function.name(), new IRSeq(newBody));
//        System.out.println("after" + newFunc);
        return newFunc;
    }

    /**
     * Find and replace the variables that occurs in stmt with its equal variable, if such variable exists in eqSet.
     * @param stmt stmt to modify
     * @param eqSet a set of equalities known at the out point of stmt.
     * @return updated stmt
     */
    private IRStmt findAndReplace(IRStmt stmt, LinkedHashSet<Pair<IRTemp, IRTemp>> eqSet) {
        if (stmt instanceof IRMove) {
            IRExpr newTarget;
            if (((IRMove) stmt).target() instanceof IRTemp) {
                newTarget = ((IRMove) stmt).target(); // if target is a temp, don't replace it
            } else {
                // for a mem, replace for the mem operand
                newTarget = findAndReplaceExpr(((IRMove) stmt).target(), eqSet);
            }
            IRExpr newSource = findAndReplaceExpr(((IRMove) stmt).source(), eqSet);
            return new IRMove(newTarget, newSource);

        } else if (stmt instanceof IRCallStmt) {
            List<IRExpr> newArgs = new ArrayList<>();
            for (IRExpr oldArg : ((IRCallStmt) stmt).args()) {
                IRExpr newArg = findAndReplaceExpr(oldArg, eqSet);
                newArgs.add(newArg);
            }
            return new IRCallStmt(((IRCallStmt) stmt).target(), ((IRCallStmt) stmt).n_returns(), newArgs);

        } else if (stmt instanceof IRJump) {
            IRExpr newTarget = findAndReplaceExpr(((IRJump) stmt).target(), eqSet);
            return new IRJump(newTarget);

        } else if (stmt instanceof IRCJump) {
            IRExpr newCond = findAndReplaceExpr(((IRCJump) stmt).cond(), eqSet);
            return new IRCJump(newCond, ((IRCJump) stmt).trueLabel(), ((IRCJump) stmt).falseLabel());

        } else if (stmt instanceof IRLabel) {
            return stmt;

        } else if (stmt instanceof IRReturn) {
            List<IRExpr> newRets = new ArrayList<>();
            for (IRExpr oldRet : ((IRReturn) stmt).rets()) {
                IRExpr newRet = findAndReplaceExpr(oldRet, eqSet);
                newRets.add(newRet);
            }
            return new IRReturn(newRets);

        } else {
            System.out.println("Invalid stmt for cfg: " + stmt);
            return stmt;
        }

    }

    /**
     * Find and replace variables with their equal.
     * @param expr expr to replace
     * @param eqSet a set of equalities between variables
     * @return new expression with variable possibly replaced
     */
    private IRExpr findAndReplaceExpr(IRExpr expr, LinkedHashSet<Pair<IRTemp, IRTemp>> eqSet) {

        if (expr instanceof IRConst) {
            return expr;

        } else if (expr instanceof IRTemp) {
            for (Pair<IRTemp, IRTemp> pair : eqSet) {
                if (pair.part1().name().equals(((IRTemp) expr).name())) {
                    noChange = false; // temp is replaced so this run has not converged
                    return pair.part2();
                }
            }
            return expr;

        } else if (expr instanceof IRMem) {
            IRExpr newAddr = findAndReplaceExpr(((IRMem) expr).expr(), eqSet);
            return new IRMem(newAddr);

        } else if (expr instanceof IRName) {
            return expr;

        } else if (expr instanceof IRBinOp) {
            IRExpr newLeft = findAndReplaceExpr(((IRBinOp) expr).left(), eqSet);
            IRExpr newRight = findAndReplaceExpr(((IRBinOp) expr).right(), eqSet);
            return new IRBinOp(((IRBinOp) expr).opType(), newLeft, newRight);

        } else {
            System.out.println("Invalid expr for cfg: " + expr);
            return expr;
        }

    }

}
