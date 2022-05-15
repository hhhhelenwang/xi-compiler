package edu.cornell.cs.cs4120.xic.ir;

import edu.cornell.cs.cs4120.util.SExpPrinter;

import java.util.HashSet;

public class IREnd extends IRStmt{
    @Override
    public HashSet<IRTemp> use() {
        return new HashSet<>();
    }

    @Override
    public HashSet<IRTemp> def() {
        return new HashSet<>();
    }

    @Override
    public HashSet<IRTemp> vars() {
        return new HashSet<>();
    }

    @Override
    public HashSet<IRExpr> subExprs() {
        return new HashSet<>();
    }

    @Override
    public String label() {
        return "end";
    }

    @Override
    public void printSExp(SExpPrinter p) {
        p.startList();
        p.printAtom("end");
        p.endList();
    }
}
