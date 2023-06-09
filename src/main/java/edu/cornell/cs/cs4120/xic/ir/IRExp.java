package edu.cornell.cs.cs4120.xic.ir;

import edu.cornell.cs.cs4120.util.SExpPrinter;
import edu.cornell.cs.cs4120.xic.ir.visit.AggregateVisitor;
import edu.cornell.cs.cs4120.xic.ir.visit.CheckCanonicalIRVisitor;
import edu.cornell.cs.cs4120.xic.ir.visit.IRVisitor;

import java.util.HashSet;

/**
 * An intermediate representation for evaluating an expression for side effects, discarding the
 * result EXP(e)
 */
public class IRExp extends IRStmt {
    private IRExpr expr;

    /** @param expr the expression to be evaluated and result discarded */
    public IRExp(IRExpr expr) {
        this.expr = expr;
    }

    public IRExpr expr() {
        return expr;
    }

    @Override
    public String label() {
        return "EXP";
    }

    @Override
    public IRNode visitChildren(IRVisitor v) {
        IRExpr expr = (IRExpr) v.visit(this, this.expr);

        if (expr != this.expr) return v.nodeFactory().IRExp(expr);

        return this;
    }

    @Override
    public <T> T aggregateChildren(AggregateVisitor<T> v) {
        T result = v.unit();
        result = v.bind(result, v.visit(expr));
        return result;
    }

    @Override
    public CheckCanonicalIRVisitor checkCanonicalEnter(CheckCanonicalIRVisitor v) {
        return v.enterExp();
    }

    @Override
    public void printSExp(SExpPrinter p) {
        p.startList();
        p.printAtom("EXP");
        expr.printSExp(p);
        p.endList();
    }

    // this node should not present in lower IR
    @Override
    public HashSet<IRTemp> use() {
        // should not be called
        System.out.println("IRExp in cfg");
        return new HashSet<>();
    }

    @Override
    public HashSet<IRTemp> def() {
        // should not be called
        System.out.println("IRExp in cfg");
        return new HashSet<>();
    }

    @Override
    public HashSet<IRTemp> vars() {
        System.out.println("IRExp in cfg");
        return new HashSet<>();
    }

    @Override
    public HashSet<IRExpr> subExprs() {
        System.out.println("IRExp in cfg");
        return new HashSet<>();
    }
}
