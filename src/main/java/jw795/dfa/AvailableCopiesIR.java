package jw795.dfa;

import edu.cornell.cs.cs4120.xic.ir.IRStmt;
import edu.cornell.cs.cs4120.xic.ir.IRTemp;
import jw795.cfg.CFG;
import jw795.cfg.CFGNode;
import polyglot.util.Pair;

import java.util.LinkedHashSet;
import java.util.List;

public class AvailableCopiesIR extends DataFlowAnalysis<LinkedHashSet<Pair<IRTemp, IRTemp>>, IRStmt>{

    public AvailableCopiesIR(CFG<IRStmt> cfg) {
        super(cfg);
    }

    @Override
    public void initialize() {
        // get the set of all variables



    }

    @Override
    public LinkedHashSet<Pair<IRTemp, IRTemp>> meet(List<LinkedHashSet<Pair<IRTemp, IRTemp>>> input) {
        return null;
    }

    @Override
    public LinkedHashSet<Pair<IRTemp, IRTemp>> fn(LinkedHashSet<Pair<IRTemp, IRTemp>> l,
                                                  LinkedHashSet<Pair<IRTemp, IRTemp>> gen,
                                                  LinkedHashSet<Pair<IRTemp, IRTemp>> kill) {
        return null;
    }

    @Override
    public LinkedHashSet<Pair<IRTemp, IRTemp>> gen(CFGNode<IRStmt> node, LinkedHashSet<Pair<IRTemp, IRTemp>> l) {
        return null;
    }

    @Override
    public LinkedHashSet<Pair<IRTemp, IRTemp>> kill(CFGNode<IRStmt> node, LinkedHashSet<Pair<IRTemp, IRTemp>> l) {
        return null;
    }


}
