package edu.cornell.cs.cs4120.xic.ir;

import edu.cornell.cs.cs4120.util.SExpPrinter;
import edu.cornell.cs.cs4120.xic.ir.visit.AggregateVisitor;
import edu.cornell.cs.cs4120.xic.ir.visit.CheckCanonicalIRVisitor;
import edu.cornell.cs.cs4120.xic.ir.visit.IRVisitor;

import java.util.HashSet;

/** An intermediate representation for a move statement MOVE(target, expr) */
public class IRMove extends IRStmt {
    private IRExpr target;
    private IRExpr src;

    /**
     * @param target the destination of this move
     * @param src the expression whose value is to be moved
     */
    public IRMove(IRExpr target, IRExpr src) {
        this.target = target;
        this.src = src;
    }

    public IRExpr target() {
        return target;
    }

    public IRExpr source() {
        return src;
    }

    @Override
    public String label() {
        return "MOVE";
    }

    @Override
    public CheckCanonicalIRVisitor checkCanonicalEnter(CheckCanonicalIRVisitor v) {
        return v.enterMove();
    }

    @Override
    public IRNode visitChildren(IRVisitor v) {
        IRExpr target = (IRExpr) v.visit(this, this.target);
        IRExpr expr = (IRExpr) v.visit(this, src);

        if (target != this.target || expr != src) return v.nodeFactory().IRMove(target, expr);

        return this;
    }

    @Override
    public <T> T aggregateChildren(AggregateVisitor<T> v) {
        T result = v.unit();
        result = v.bind(result, v.visit(target));
        result = v.bind(result, v.visit(src));
        return result;
    }

    @Override
    public void printSExp(SExpPrinter p) {
        p.startList();
        p.printAtom("MOVE");
        target.printSExp(p);
        src.printSExp(p);
        p.endList();
    }

    @Override
    public HashSet<IRTemp> use() {
        HashSet<IRTemp> use = new HashSet<>(source().vars()); // temps in source are always used
        if (!(target() instanceof IRTemp)) {
            // if target is not a temp, the temps in that expression are used to evaluate target
            use.addAll(target().vars());
        }
        return use;
    }

    @Override
    public HashSet<IRTemp> def() {
        HashSet<IRTemp> def = new HashSet<>();
        if (target() instanceof IRTemp) {
            // only def target if target is an ir temp
            def.add((IRTemp) target());
        }
        return def;
    }

    @Override
    public HashSet<IRTemp> vars() {
        // all variables in both dest and source
        HashSet<IRTemp> vars = new HashSet<>(target().vars());
        vars.addAll(source().vars());
        return vars;
    }
}
