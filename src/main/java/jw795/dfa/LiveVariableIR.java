package jw795.dfa;

import edu.cornell.cs.cs4120.xic.ir.IRStmt;
import edu.cornell.cs.cs4120.xic.ir.IRTemp;
import jw795.cfg.CFG;
import jw795.cfg.CFGNode;

import java.util.HashSet;
import java.util.List;

/**
 * Live variable analysis on low IR
 */
public class LiveVariableIR extends DataFlowAnalysis<HashSet<IRTemp>, IRStmt>{

    public LiveVariableIR(CFG<IRStmt> cfg) {
        super(cfg);
        top = new HashSet<>();
    }

    /**
     * meet = union
     * @param input lattice elements/data flow values to take meet on
     * @return result of meet
     */
    @Override
    public HashSet<IRTemp> meet(List<HashSet<IRTemp>> input) {
//
//        System.out.println("Inset of successor:");
//        for (HashSet<IRTemp> inSet : input) {
//            System.out.println("in:");
//            for (IRTemp temp : inSet) {
//                System.out.print(temp);
//            }
//        }
        HashSet<IRTemp> result = new HashSet<>();
        for (HashSet<IRTemp> in : input) {
            result.addAll(in);
        }
//
//        System.out.println("Out set of cur:");
//        for (IRTemp temp : result) {
//            System.out.print(temp);
//        }
        return result;
    }

    /**
     * Transfer function F(l) = gen U (l - kill), gen = use, kill = def
     * @param l input data flow value/lattice element
     * @param gen gen set
     * @param kill kill set
     * @return F(l)
     */
    @Override
    public HashSet<IRTemp> fn(HashSet<IRTemp> l, HashSet<IRTemp> gen, HashSet<IRTemp> kill) {

//        System.out.println("Out set of cur before fn:");
//        for (IRTemp temp : l) {
//            System.out.print(temp);
//        }
////        System.out.println("gen of node: ");
//        for (IRTemp temp : gen) {
//            System.out.print(temp);
//        }
//
//
//        System.out.println("kill of node: ");
//        for (IRTemp temp : kill) {
//            System.out.print(temp);
//        }

        HashSet<IRTemp> result = new HashSet<>(l);
        result.removeAll(kill);
        result.addAll(gen);
//
//        System.out.println("live in of cur / Out set of cur after fn:");
//        for (IRTemp temp : result) {
//            System.out.print(temp);
//        }

        return result;
    }

    /**
     * gen(n) = use(n)
     * @param node cfg node
     * @param l input data flow value to the transfer function
     * @return use set of node
     */
    @Override
    public HashSet<IRTemp> gen(CFGNode<IRStmt> node, HashSet<IRTemp> l) {
        return node.getStmt().use();
    }

    /**
     * kill(n) = def(n)
     * @param node cfg node
     * @param l input data flow value to the transfer function
     * @return def set of node
     */
    @Override
    public HashSet<IRTemp> kill(CFGNode<IRStmt> node, HashSet<IRTemp> l) {
        return node.getStmt().def();
    }
}
