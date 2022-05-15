package jw795.dfa;

import edu.cornell.cs.cs4120.xic.ir.*;
import edu.cornell.cs.cs4120.xic.ir.interpret.IRSimulator;
import jw795.cfg.CFG;
import jw795.cfg.CFGNode;
import polyglot.util.Pair;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

public class AvailableExpressionIR extends DataFlowAnalysis<LinkedHashSet<Pair<IRExpr, IRStmt>>, IRStmt>{

    public AvailableExpressionIR(CFG<IRStmt> cfg){
        super(cfg);
        top = computeTop();
    }

    /**
     * meet = intersection
     * @param exprSets lattice elements/data flow values to take meet on
     * @return intersection of all sets in input
     */
    @Override
    public LinkedHashSet<Pair<IRExpr, IRStmt>> meet(List<LinkedHashSet<Pair<IRExpr, IRStmt>>> exprSets) {
        if (exprSets.size() ==0 || exprSets.get(0).size() == 0){
            return new LinkedHashSet<>();
        }

        LinkedHashSet<Pair<IRExpr, IRStmt>> metSet = new LinkedHashSet<>(exprSets.get(0));
        for (LinkedHashSet<Pair<IRExpr, IRStmt>> exprSet : exprSets){
            metSet.retainAll(exprSet);
        }
        return metSet;
    }

    /**
     * fn(in[n]) = out[n] = in[n] U gen[n] - kill[n]
     * l = in[n]
     * @param l input data flow value/lattice element
     * @param gen gen set
     * @param kill kill set
     * @return fn(in[n])
     */
    @Override
    public LinkedHashSet<Pair<IRExpr, IRStmt>> fn(LinkedHashSet<Pair<IRExpr, IRStmt>> l,
                                                  LinkedHashSet<Pair<IRExpr, IRStmt>> gen,
                                                  LinkedHashSet<Pair<IRExpr, IRStmt>> kill) {
        LinkedHashSet<Pair<IRExpr, IRStmt>> fn_l = new LinkedHashSet<>(l);
        fn_l.addAll(gen);
        fn_l.removeAll(kill);
        return fn_l;
    }

    /**
     * n                    |  gen[n]
     * -------------------------------------
     * x <- e               |  {e, e.subExprs()}
     * [e1] <- e2           |  {e2, [e1], e1.subExprs(), e2.subExprs()}
     * if e                 |  {e, e.subExprs()}
     * x <- f(e)            |  {e, e.subExprs()}
     * @param node cfg node
     * @param l in set
     * @return gen[node]
     */
    @Override
    public LinkedHashSet<Pair<IRExpr, IRStmt>> gen(CFGNode<IRStmt> node, LinkedHashSet<Pair<IRExpr, IRStmt>> l) {
        LinkedHashSet<Pair<IRExpr, IRStmt>> genSet = new LinkedHashSet<>();
        IRStmt stmt = node.getStmt();

        if (stmt instanceof IRMove){
            IRExpr dest = ((IRMove) stmt).target();
            IRExpr src = ((IRMove) stmt).source();
            genSet.addAll(newGen(l, dest.getSubExprs(), stmt));
            genSet.addAll(newGen(l, src.getSubExprs(), stmt));
        } else if (stmt instanceof IRCJump){
            genSet.addAll(newGen(l,((IRCJump) stmt).cond().getSubExprs(), stmt));
        }

        return genSet;
    }

    /**
     * Helper function to get a set of pairs<IRExpr, IRStmt> where IRExpr were not defined in l
     * @param l available expressions at current program point
     * @param exprs a set of expressions to check, any expressions not seen in l is added to return set
     * @param stmt IRStmt where the expr generated
     * @return Set of Pair<expr_passed_check, stmt_passed_in>
     */
    private LinkedHashSet<Pair<IRExpr, IRStmt>> newGen(LinkedHashSet<Pair<IRExpr, IRStmt>> l,
                                                                HashSet<IRExpr> exprs,
                                                                IRStmt stmt){
        LinkedHashSet<Pair<IRExpr, IRStmt>> genSet = new LinkedHashSet<>();
        boolean generatedInPred;

        for (IRExpr e : exprs){
            generatedInPred = l.stream().anyMatch(pair -> pair.part1().equals(e));
            if (!generatedInPred){
                genSet.add(new Pair<>(e, stmt));
            }
        }

        return genSet;
    }

    /**
     * n                    |  kill[n]
     * -------------------------------------
     * x <- e               |  all expr containing x
     * [e1] <- e2           |  all expr [e'] that might alias [e1]
     * if e                 |  empty set
     * x <- f(e)            |  expr containing x and expr [e'] that could be changed by function call to f
     * @param node cfg node
     * @param l in set
     * @return kill[node]
     */
    @Override
    public LinkedHashSet<Pair<IRExpr, IRStmt>> kill(CFGNode<IRStmt> node, LinkedHashSet<Pair<IRExpr, IRStmt>> l) {
        LinkedHashSet<Pair<IRExpr, IRStmt>> killSet = new LinkedHashSet<>();
        IRStmt stmt = node.getStmt();

        if (stmt instanceof IRMove){
            IRExpr dest = ((IRMove) stmt).target();
            IRExpr src = ((IRMove) stmt).source();

            if (dest instanceof IRMem){
                killSet.addAll(killPredSet(l, aliasExpr((IRMem) dest, l), stmt));
            } else if (dest instanceof IRTemp){
                killSet.addAll(killPredSet(l, exprsWithX((IRTemp) dest, l), stmt));
            }

            if (src instanceof IRCall) {
                killSet.addAll(killPredSet(l, modifiedExpr(src, l), stmt));
            }
        }

        return killSet;
    }


    /**
     * Helper function to get a set of pairs<IRExpr, IRStmt> where IRExpr were defined in l
     * @param l available expressions at current program point
     * @param exprs a set of expressions to check, any expressions not seen in l is added to return set
     * @param stmt IRStmt where the expr generated
     * @return Set of Pair<expr_passed_check, stmt_passed_in>
     */
    private LinkedHashSet<Pair<IRExpr, IRStmt>> killPredSet(LinkedHashSet<Pair<IRExpr, IRStmt>> l,
                                                       HashSet<IRExpr> exprs,
                                                       IRStmt stmt) {
        LinkedHashSet<Pair<IRExpr, IRStmt>> killSet = new LinkedHashSet<>();

        for (IRExpr e : exprs){
            if (l.stream().anyMatch(pair -> pair.part1().equals(e))){
                killSet.add(new Pair<>(e, stmt));
            }
        }

        return killSet;
    }

    /**
     * Get all expressions that contains IRTemp x from input exprs
     * @param x the IRTemp
     * @param l set of Pair<expressions, stmt></expressions,> to look through
     * @return the set of all expressions containing x
     */
    private LinkedHashSet<IRExpr> exprsWithX(IRTemp x, LinkedHashSet<Pair<IRExpr, IRStmt>> l){
        LinkedHashSet<IRExpr> exprWithX = new LinkedHashSet<>();

        for (Pair<IRExpr, IRStmt> pair : l){
            // if this expresion contains IRTemp x, add it to exprWithX set
            IRExpr expr = pair.part1();
            HashSet<IRTemp> vars = expr.vars();
            for (IRTemp var : vars){
                if (x.equals(var)){
                    exprWithX.add(expr);
                }
            }
        }

        return exprWithX;
    }


    /**
     * Get all expressions [e'] that might alias with given expression [e]. We conservatively remove all memory expr
     * @param e expression in memory operation [e]
     * @param l set of Pair<expressions, stmt></expressions,> to look through
     * @return the set of all expressions [e'] that might alias with given expression [e]
     */
    private LinkedHashSet<IRExpr> aliasExpr(IRMem e, LinkedHashSet<Pair<IRExpr, IRStmt>> l){
        LinkedHashSet<IRExpr> alias = new LinkedHashSet<>();

        for (Pair<IRExpr, IRStmt> pair : l){
            IRExpr expr = pair.part1();
            for (IRExpr subExpr : expr.getSubExprs()){
                if (subExpr instanceof IRMem){
                    alias.add(subExpr);
                }
            }
        }

        return alias;
    }


    /**
     * Get all expression [e'] that could be modified by f(e). We conservatively remove all memory expr.
     * @param e expression in memory operation [e]
     * @param l set of expressions to look through
     * @return the set of all expressions [e'] that might alias with given expression [e]
     */
    private LinkedHashSet<IRExpr> modifiedExpr(IRExpr e,  LinkedHashSet<Pair<IRExpr, IRStmt>> l) {
        LinkedHashSet<IRExpr> modified = new LinkedHashSet<>();

        for (Pair<IRExpr, IRStmt> pair : l){
            IRExpr expr = pair.part1();
            for (IRExpr subExpr : expr.getSubExprs()){
                if (subExpr instanceof IRMem){
                    modified.add(subExpr);
                }
            }
        }
        return modified;
    }


        /**
         * Compute all possible equalities to be used as the top of this avail expression dfa
         * @return the set of all possible equalities
         */
    private LinkedHashSet<Pair<IRExpr, IRStmt>> computeTop() {
        LinkedHashSet<Pair<IRExpr, IRStmt>> allExpr = new LinkedHashSet<>();
        for (CFGNode<IRStmt> node : cfg.flatten()) {
            IRStmt stmt = node.getStmt();
            stmt.subExprs().stream().forEach(expr -> allExpr.add(new Pair<>(expr, stmt)));

//            if (stmt instanceof IRCallStmt){
//                for (IRExpr expr : ((IRCallStmt) stmt).args()){
//                    expr.getSubExprs().stream().forEach(e -> allExpr.add(new Pair<>(e, stmt)));
//                }
//            } else if (stmt instanceof IRCJump){
//                ((IRCJump) stmt).cond().getSubExprs().stream().forEach(e -> allExpr.add(new Pair<>(e, stmt)));
//
//            } else if (stmt instanceof IRReturn){
//                for (IRExpr ret : ((IRReturn) stmt).rets()){
//                    ret.getSubExprs().stream().forEach(e -> allExpr.add(new Pair<>(e, stmt)));
//                }
//            } else if (stmt instanceof IRMove){
//                if (((IRMove) stmt).target() instanceof IRMem){
//                    ((IRMove) stmt).target().getSubExprs().stream().forEach(e -> allExpr.add(new Pair<>(e, stmt)));
//                }
//
//                if (((IRMove) stmt).source() instanceof IRBinOp || ((IRMove) stmt).source() instanceof IRMem){
//                    ((IRMove) stmt).source().getSubExprs().stream().forEach(e -> allExpr.add(new Pair<>(e, stmt)));
//                }
//            }
        }
//        System.out.println(allExpr.size());
        return allExpr;
    }

}
