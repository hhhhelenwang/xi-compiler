package edu.cornell.cs.cs4120.xic.ir;

import edu.cornell.cs.cs4120.util.SExpPrinter;

import java.util.HashSet;

public class IRStart extends IRStmt{
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
    public String label() {
        return "start";
    }

    @Override
    public void printSExp(SExpPrinter p) {
        p.startList();
        p.printAtom("start");
        p.endList();
    }
}
