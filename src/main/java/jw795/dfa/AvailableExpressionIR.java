package jw795.dfa;

import edu.cornell.cs.cs4120.xic.ir.*;
import jw795.cfg.CFG;
import jw795.cfg.CFGNode;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

public class AvailableExpressionIR extends DataFlowAnalysis<LinkedHashSet<IRExpr>, IRStmt>{

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
    public LinkedHashSet<IRExpr> meet(List<LinkedHashSet<IRExpr>> exprSets) {
        if (exprSets.size() == 0){
            return new LinkedHashSet<>();
        }

        LinkedHashSet<IRExpr> metSet = new LinkedHashSet<>(exprSets.get(0));
        for (LinkedHashSet<IRExpr> exprSet : exprSets){
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
    public LinkedHashSet<IRExpr> fn(LinkedHashSet<IRExpr> l, LinkedHashSet<IRExpr> gen, LinkedHashSet<IRExpr> kill) {
        return null;
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
    public LinkedHashSet<IRExpr> gen(CFGNode<IRStmt> node, LinkedHashSet<IRExpr> l) {
        LinkedHashSet<IRExpr> genSet = new LinkedHashSet<>();
        IRStmt stmt = node.getStmt();

        if (stmt instanceof IRMove){
            IRExpr dest = ((IRMove) stmt).target();
            IRExpr src = ((IRMove) stmt).source();

            genSet.addAll(dest.getSubExprs());
            genSet.addAll(src.getSubExprs());
        } else if (stmt instanceof IRCJump){
            genSet.addAll(((IRCJump) stmt).cond().getSubExprs());
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
    public LinkedHashSet<IRExpr> kill(CFGNode<IRStmt> node, LinkedHashSet<IRExpr> l) {
        LinkedHashSet<IRExpr> killSet = new LinkedHashSet<>();
        IRStmt stmt = node.getStmt();

        if (stmt instanceof IRMove){
            IRExpr dest = ((IRMove) stmt).target();
            IRExpr src = ((IRMove) stmt).source();

            killSet.addAll(dest.getSubExprs());

            if (dest instanceof IRMem){
                killSet.addAll(aliasExpr((IRMem) dest, l));
            } else if (dest instanceof IRTemp){
                killSet.addAll(exprsWithX((IRTemp) dest, l));
            }

            if (src instanceof IRCall){
                killSet.addAll(dest.getSubExprs());
                killSet.addAll(modifiedExpr(src, l));
            }
        }

        return killSet;
    }

    /**
     * Get all expressions that contains IRTemp x from input exprs
     * @param x the IRTemp
     * @param l set of expressions to look through
     * @return the set of all expressions containing x
     */
    private LinkedHashSet<IRExpr> exprsWithX(IRTemp x, LinkedHashSet<IRExpr> l){
        LinkedHashSet<IRExpr> exprWithX = new LinkedHashSet<>();

        for (IRExpr expr : l){
            // if this expresion contains IRTemp x, add it to exprWithX set
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
     * @param l set of expressions to look through
     * @return the set of all expressions [e'] that might alias with given expression [e]
     */
    private LinkedHashSet<IRExpr> aliasExpr(IRMem e, LinkedHashSet<IRExpr> l){
        LinkedHashSet<IRExpr> alias = new LinkedHashSet<>();

        for (IRExpr expr : l){
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
    private LinkedHashSet<IRExpr> modifiedExpr(IRExpr e, LinkedHashSet<IRExpr> l) {
        LinkedHashSet<IRExpr> modified = new LinkedHashSet<>();

        for (IRExpr expr : l){
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
    private LinkedHashSet<IRExpr> computeTop() {
        LinkedHashSet<IRExpr> allExpr = new LinkedHashSet<>();
        for (CFGNode<IRStmt> node : cfg.flatten()) {
            IRStmt stmt = node.getStmt();

            if (stmt instanceof IRCallStmt){
                for (IRExpr expr : ((IRCallStmt) stmt).args()){
                    allExpr.addAll(expr.getSubExprs());
                }
            } else if (stmt instanceof IRCJump){
                allExpr.addAll(((IRCJump) stmt).cond().getSubExprs());
            } else if (stmt instanceof IRReturn){
                for (IRExpr ret : ((IRReturn) stmt).rets()){
                    allExpr.addAll(ret.getSubExprs());
                }
            }
        }
        return allExpr;
    }

}
