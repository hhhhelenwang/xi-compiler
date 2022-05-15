package edu.cornell.cs.cs4120.xic.ir;

import edu.cornell.cs.cs4120.util.SExpPrinter;

import java.util.Arrays;
import java.util.HashSet;

/** An intermediate representation for a 64-bit integer constant. CONST(n) */
public class IRConst extends IRExpr_c {
    private long value;

    /** @param value value of this constant */
    public IRConst(long value) {
        this.value = value;
    }

    public long value() {
        return value;
    }

    @Override
    public String label() {
        return "CONST(" + value + ")";
    }

    @Override
    public boolean isConstant() {
        return true;
    }

    @Override
    public long constant() {
        return value;
    }

    @Override
    public HashSet<IRTemp> vars() {
        return new HashSet<>();
    }

    @Override
    public HashSet<IRExpr> getSubExprs() {
        return new HashSet<>();
    }

    @Override
    public void printSExp(SExpPrinter p) {
        p.startList();
        p.printAtom("CONST");
        p.printAtom(String.valueOf(value));
        p.endList();
    }
}
