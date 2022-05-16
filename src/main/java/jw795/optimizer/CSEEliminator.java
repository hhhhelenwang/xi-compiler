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
//        System.out.println("called cseEliminateFunction");
        CFG<IRStmt> cfg = cfgGenerator.toIRCFG(func);

        AvailableExpressionIR availableExpreIR = new AvailableExpressionIR(cfg);
        HashMap<CFGNode<IRStmt>, LinkedHashSet<Pair<IRExpr, IRStmt>>> nodeToValueMap = availableExpreIR.forward();

        List<IRStmt> newBody = new ArrayList<>();
        List<IRStmt> semiBody = new ArrayList<>();
        IRStmt body = func.body();

        HashMap<IRStmt, Pair<IRTemp, IRExpr>> stmtreplayedByNewTemp = new HashMap<>(); //stmt to be added with new temp

        HashMap<IRStmt, IRStmt> originalStmtToNewStmt = new HashMap<>();
        HashMap<IRStmt, HashSet<IRTemp>> originalStmtToAssign = new HashMap<>();
        HashMap<String, IRTemp> cseToTemps = new HashMap<>();
        HashMap<IRTemp, IRExpr> tempToCSE = new HashMap<>();

//        System.out.println(((IRSeq) body).stmts().get((((IRSeq) body).stmts()).size()-1));
        if (body instanceof IRSeq){

//            System.out.println("THIS IS ALL STMTS");
//            ((IRSeq) body).stmts().stream().forEach(stmt -> System.out.println(stmt));
//            System.out.println("*****************************************************");
            for (IRStmt stmt : ((IRSeq) body).stmts()) {
                CFGNode<IRStmt> node = cfg.getNode(stmt);
                List<CFGNode<IRStmt>> preds = node.getPredecessors();
                List<LinkedHashSet<Pair<IRExpr, IRStmt>>> predsOut = new ArrayList<>();

                preds.stream().forEach(pred -> predsOut.add(nodeToValueMap.get(pred)));

//                System.out.println("====================");
//                System.out.println(predsOut.size());
//                System.out.println(stmt);
//                System.out.println(nodeToValueMap.keySet().contains(stmt));


                LinkedHashSet<Pair<IRExpr, IRStmt>> outOfNode = intersect(predsOut);

                HashMap<String, IRStmt> availableExpr = new HashMap<>(); //expr, stmt to update
                outOfNode.stream().forEach(pair -> availableExpr.put(pair.part1().toString(), pair.part2()));
//                System.out.println("++++++++++++++++ available expressions");
//                outOfNode.stream().forEach(pair -> System.out.println(pair.part1().toString() + " --- " + pair.part2().toString()));

                HashSet<IRExpr> subExprOfCurStmt = stmt.subExprs();
//                System.out.println("=========================== ");
//                System.out.println("the current stmt is " + stmt);
//                System.out.println("++++++++++++++++ sub expressions are");
//                subExprOfCurStmt.stream().forEach(e -> System.out.println(e));

                IRStmt newStmt;
                for (IRExpr e : subExprOfCurStmt) {
//                    System.out.println("the subexpression is " + e);
                    if (availableExpr.keySet().contains(e.toString())) { // if there is a available subexpression
//                        System.out.println("enter contains e");
                        IRTemp newTemp;
                        //check which temp to use
                        if (cseToTemps.containsKey(e.toString())) {
//                            System.out.println("temp already exist");

                            newTemp = cseToTemps.get(e.toString());

                            newStmt = findAndReplace(stmt, e, newTemp);
//                            System.out.println(newStmt);

                            originalStmtToNewStmt.put(stmt, newStmt);
//                            semiBody.add(newStmt);
                        } else {
//                            System.out.println("creating new temp");

                            newTemp = newCSETemp();
                            tempToCSE.put(newTemp, e);
                            cseToTemps.put(e.toString(), newTemp);
                            newStmt = findAndReplace(stmt, e, newTemp);
                            originalStmtToNewStmt.put(stmt, newStmt);

//                            semiBody.add(newStmt);

                            IRStmt generatingStmt = availableExpr.get(e.toString()); // the stmt where the cse is defined
                            HashSet<IRTemp> temps = originalStmtToAssign.getOrDefault(generatingStmt, new HashSet<>());
                            temps.add(newTemp);
                            originalStmtToAssign.put(generatingStmt, temps);
                            newStmt = findAndReplace(generatingStmt, e, newTemp);
                            originalStmtToNewStmt.put(generatingStmt, newStmt);
                        }
                        break;
                    }
                }
                semiBody.add(stmt);
            }


            for (IRStmt curStmt: ((IRSeq) body).stmts()) {

//                if (originalStmtToAssign.keySet())
//                System.out.println("=================================gen funBody");
//                System.out.println(curStmt);
                if (originalStmtToAssign.keySet().contains(curStmt)) {
//                    System.out.println("enter adding new MOVE");
                    for (IRTemp t : originalStmtToAssign.get(curStmt)){
                        IRExpr cse = tempToCSE.get(t);
                        newBody.add(new IRMove(t, cse));
                    }

//                    System.out.println(newTemp);
//                    System.out.println(cse);
                }

                if (originalStmtToNewStmt.keySet().contains(curStmt)){
//                    System.out.println("adding the new line");
//                    System.out.println(originalStmtToNewStmt.get(curStmt));
//
                    newBody.add(originalStmtToNewStmt.get(curStmt));
                } else {
                    newBody.add(curStmt);
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
            IRExpr cond = ((IRCJump) stmt).cond();
            if (exprEquals(cond, eTarget)){
                cond = newTemp;
            } else {
                cond = findAndReplaceExpr(cond, eTarget, newTemp);
            }
            return new IRCJump(cond, ((IRCJump) stmt).trueLabel());

        } else if (stmt instanceof IRReturn){
            List<IRExpr> newRets = new ArrayList<>();
            for (IRExpr expr : ((IRReturn) stmt).rets()){
                if (exprEquals(expr, eTarget)){
                    newRets.add(newTemp);
                } else {
                    newRets.add(findAndReplaceExpr(expr, eTarget, newTemp));
                }
            }
            return new IRReturn(newRets);

        } else if (stmt instanceof IRMove){
            IRExpr target = ((IRMove) stmt).target();
            IRExpr src = ((IRMove) stmt).source();

            if (src instanceof IRBinOp || src instanceof IRMem){
                if (exprEquals(src, eTarget)){
                    src = newTemp;
                } else {
                    src = findAndReplaceExpr(src, eTarget, newTemp);
                }
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
            if (exprEquals(exprBefore, eTarget)){
                return new IRMem(newTemp);
            } else {
                return new IRMem(findAndReplaceExpr(((IRMem) exprBefore).expr(), eTarget, newTemp));
            }
        } else if (exprBefore instanceof IRBinOp){
            IRExpr leftExpr = ((IRBinOp)exprBefore).left();
            IRExpr rightExpr = ((IRBinOp)exprBefore).right();
            if (exprEquals(leftExpr, eTarget)){
                leftExpr = newTemp;
                rightExpr = findAndReplaceExpr(rightExpr, eTarget, newTemp);
            } else if (exprEquals(rightExpr, eTarget)){
                leftExpr = findAndReplaceExpr(leftExpr, eTarget, newTemp);
                rightExpr = newTemp;
            } else {
                leftExpr = findAndReplaceExpr(leftExpr, eTarget, newTemp);
                rightExpr = findAndReplaceExpr(rightExpr, eTarget, newTemp);

            }
            return new IRBinOp(((IRBinOp) exprBefore).opType(), leftExpr, rightExpr);
        } else {
            return exprBefore;
        }
    }

    private boolean exprEquals(IRExpr e1, IRExpr e2){
        return e1.toString().equals(e2.toString());
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

    /**
     * Get the intersection of a list of preds' out[n]
     * @param predsOuts
     * @return intersection of all sets in input
     */
    public LinkedHashSet<Pair<IRExpr, IRStmt>> intersect(List<LinkedHashSet<Pair<IRExpr, IRStmt>>> predsOuts) {
        if (predsOuts.size() == 0){
            return new LinkedHashSet<>();
        }

//        System.out.println("==========================");
//        System.out.println(predsOuts.size());
//        System.out.println(predsOuts.get(0) == null);
        if (predsOuts.get(0).size() == 0){
            return new LinkedHashSet<>();
        }

        LinkedHashSet<Pair<IRExpr, IRStmt>> intersection = new LinkedHashSet<>(predsOuts.get(0));
        for (LinkedHashSet<Pair<IRExpr, IRStmt>> exprSet : predsOuts){
            intersection.retainAll(exprSet);
        }
        return intersection;
    }

}
