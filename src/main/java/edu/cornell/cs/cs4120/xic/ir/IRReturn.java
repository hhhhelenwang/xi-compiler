package edu.cornell.cs.cs4120.xic.ir;

import edu.cornell.cs.cs4120.util.SExpPrinter;
import edu.cornell.cs.cs4120.xic.ir.visit.AggregateVisitor;
import edu.cornell.cs.cs4120.xic.ir.visit.IRVisitor;
import polyglot.util.Pair;

import java.util.*;

/** RETURN statement */
public class IRReturn extends IRStmt {
    protected List<IRExpr> rets;

    public IRReturn() {
        this(new ArrayList<>());
    }

    /** @param rets values to return */
    public IRReturn(IRExpr... rets) {
        this(Arrays.asList(rets));
    }

    /** @param rets values to return */
    public IRReturn(List<IRExpr> rets) {
        this.rets = rets;
    }

    public List<IRExpr> rets() {
        return rets;
    }

    @Override
    public String label() {
        return "RETURN";
    }

    @Override
    public IRNode visitChildren(IRVisitor v) {
        boolean modified = false;

        List<IRExpr> results = new ArrayList<>(rets.size());

        for (IRExpr ret : rets) {
            IRExpr newExpr = (IRExpr) v.visit(this, ret);
            if (newExpr != ret) modified = true;
            results.add(newExpr);
        }

        if (modified) return v.nodeFactory().IRReturn(results);

        return this;
    }

    @Override
    public <T> T aggregateChildren(AggregateVisitor<T> v) {
        T result = v.unit();
        for (IRExpr ret : rets) result = v.bind(result, v.visit(ret));
        return result;
    }

    @Override
    public void printSExp(SExpPrinter p) {
        p.startList();
        p.printAtom("RETURN");
        for (IRExpr ret : rets) ret.printSExp(p);
        p.endList();
    }

    @Override
    public HashSet<IRTemp> use() {
        HashSet<IRTemp> use = new HashSet<>();
        for (IRExpr expr : rets()) {
            use.addAll(expr.vars());
        }
        return use;
    }

    @Override
    public HashSet<IRTemp> def() {
        return new HashSet<>();
    }

    @Override
    public HashSet<IRTemp> vars() {
        HashSet<IRTemp> vars = new HashSet<>();
        for (IRExpr expr : rets()) {
            vars.addAll(expr.vars());
        }
        return vars;
    }

    @Override
    public HashSet<IRExpr> subExprs() {
        HashSet<IRExpr> exprs = new HashSet<>();
        for (IRExpr ret : rets()){
            exprs.addAll(ret.getSubExprs());
            if (ret instanceof IRBinOp){
                exprs.add(ret);
            }
        }
        return exprs;
    }
}
