package jw795.optimizer;

import edu.cornell.cs.cs4120.xic.ir.*;
import jw795.cfg.CFG;
import jw795.cfg.CFGGenerator;
import jw795.cfg.CFGNode;
import jw795.dfa.AvailableCopiesIR;
import jw795.dfa.AvailableExpressionIR;
import polyglot.util.Pair;

import java.util.*;

/**
 * Carries out common subExpression elimination on a lower IR program
 */
public class CSEEliminator {

    IRCompUnit program;
    CFGGenerator cfgGenerator;
    int cseTempCounter = 0;

    public CSEEliminator(IRCompUnit program){
        this.program = program;
        this.cfgGenerator = new CFGGenerator();
    }


    public IRCompUnit run(){
        HashMap<String, IRFuncDecl> newFunctions = new HashMap<>();
        for (IRFuncDecl function : program.functions().values()) {
            IRFuncDecl newFunction = cseEliminateFunction(function);
            newFunctions.put(function.name(), newFunction);
        }

        return new IRCompUnit(program.name(), newFunctions, program.ctors(), program.dataMap());
    }

    private IRFuncDecl cseEliminateFunction(IRFuncDecl func) {
        CFG<IRStmt> cfg = cfgGenerator.toIRCFG(func);

        AvailableExpressionIR availableExpreIR = new AvailableExpressionIR(cfg);
        HashMap<CFGNode<IRStmt>, LinkedHashSet<Pair<IRExpr, IRStmt>>> nodeToValueMap = availableExpreIR.forward();

        List<IRStmt> newBody = new ArrayList<>();
        IRStmt body = func.body();

        HashMap<IRExpr, IRTemp> commonExprToTemps = new HashMap<>();

        if (body instanceof IRSeq){
            for (IRStmt stmt : ((IRSeq) body).stmts()){
                CFGNode<IRStmt> node = cfg.getNode(stmt);
                LinkedHashSet<Pair<IRExpr, IRStmt>> outOfNode = nodeToValueMap.get(node);
                HashSet<IRExpr> availableExpr = new HashSet<>();
                outOfNode.stream().forEach(pair -> availableExpr.add(pair.part1()));

                HashSet<IRExpr> subExprOfCurStmt = stmt.subExprs();
                for (IRExpr e : subExprOfCurStmt){

                    //check if there is a common subexpression
                    if (availableExpr.contains(e)){ // if there is a available subexpression
                        IRTemp newTemp;

                        //check which temp to use
                        if (commonExprToTemps.containsKey(e)){
                            newTemp = commonExprToTemps.get(e);
                        } else {
                            newTemp = newCSETemp();
                            commonExprToTemps.put(e, newTemp);
                        }

                        //generate new stmt, with common sub expression replaced by temp
                        findAndReplace(stmt, e, newTemp);
                    }
                }
            }
        } else {
            System.out.println("CSEEliminator: invalid function body.");
        }

        return new IRFuncDecl(func.name(), new IRSeq(newBody));
    }

    /**
     * Find and replace the expression that appears in stmt with the IRTemp that stores the cse
     * @param stmt stmt to modify
     * @param eTarget the cse we are looking for in  stmt
     * @param newTemp the temp that stores the cse
     * @return updated stmt
     */
    private IRStmt findAndReplace(IRStmt stmt, IRExpr eTarget, IRTemp newTemp) {
        if (stmt instanceof IRCallStmt){
            List<IRExpr> newArgs = new ArrayList<>();
            for (IRExpr expr : ((IRCallStmt) stmt).args()){
                newArgs.add(findAndReplaceExpr(expr, eTarget, newTemp));
            }

            return new IRCallStmt(((IRCallStmt) stmt).target(), ((IRCallStmt) stmt).n_returns(), newArgs);

        } else if (stmt instanceof IRCJump){
            return new IRCJump(findAndReplaceExpr(((IRCJump) stmt).cond(), eTarget, newTemp),
                    ((IRCJump) stmt).trueLabel());

        } else if (stmt instanceof IRReturn){
            List<IRExpr> newRets = new ArrayList<>();
            for (IRExpr expr : ((IRReturn) stmt).rets()){
                newRets.add(findAndReplaceExpr(expr, eTarget, newTemp));
            }
            return new IRReturn(newRets);

        } else if (stmt instanceof IRMove){
            IRExpr target = ((IRMove) stmt).target();
            IRExpr src = ((IRMove) stmt).source();

            if (((IRMove) stmt).target() instanceof IRMem){
                target = findAndReplaceExpr(target, eTarget, newTemp);
            }
            if (((IRMove) stmt).source() instanceof IRBinOp || ((IRMove) stmt).source() instanceof IRMem){
                src = findAndReplaceExpr(src, eTarget, newTemp);
            }
            return new IRMove(target, src);

        } else {
            //no expression in this stmt, thus, no modification
            return stmt;
        }
    }

    /**
     * Find and replace the target subexpression with given Temp in the given expression
     * @param exprBefore the expr to be modified
     * @param eTarget  the target common subexpression we are looking for in exprBefore
     * @param newTemp the temp containing cse
     * @return updated IRExpr
     */
    private IRExpr findAndReplaceExpr(IRExpr exprBefore, IRExpr eTarget, IRTemp newTemp) {
        if (exprBefore instanceof IRMem){
            if (((IRMem) exprBefore).expr().equals(eTarget)){
                return new IRMem(newTemp);
            } else {
                return new IRMem(findAndReplaceExpr(((IRMem) exprBefore).expr(), eTarget, newTemp));
            }
        } else if (exprBefore instanceof IRBinOp){
            IRExpr leftExpr = ((IRBinOp)exprBefore).left();
            IRExpr rightExpr = ((IRBinOp)exprBefore).right();
            if (leftExpr.equals(eTarget)){
                return new IRBinOp(((IRBinOp) exprBefore).opType(), newTemp, rightExpr);
            } else if (rightExpr.equals(eTarget)){
                return new IRBinOp(((IRBinOp) exprBefore).opType(), leftExpr, newTemp);
            } else {
                return new IRBinOp(((IRBinOp) exprBefore).opType(),
                        findAndReplaceExpr(leftExpr, eTarget, newTemp),
                        findAndReplaceExpr(rightExpr, eTarget, newTemp));
            }
        } else {
            return exprBefore;
        }
    }

    /**
     * Generate a new temp to store the hoisted out cse
     * @return new temp
     */

    private IRTemp newCSETemp(){
        IRTemp cseTemp = new IRTemp("cse" + cseTempCounter);
        cseTempCounter++;
        return cseTemp;
    }
}
