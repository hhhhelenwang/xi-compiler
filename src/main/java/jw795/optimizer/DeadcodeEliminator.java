package jw795.optimizer;

import edu.cornell.cs.cs4120.xic.ir.IRCompUnit;
import edu.cornell.cs.cs4120.xic.ir.IRFuncDecl;
import edu.cornell.cs.cs4120.xic.ir.*;
import jw795.cfg.CFG;
import jw795.cfg.CFGGenerator;
import jw795.cfg.CFGNode;
import jw795.cfg.IRCFG;

import java.util.*;

public class DeadcodeEliminator {
    private IRNodeFactory_c irFactory;
    private CFGGenerator cfgGenerator;

    public DeadcodeEliminator(){
        this.irFactory = new IRNodeFactory_c();
        this.cfgGenerator = new CFGGenerator();
    }

    /**
     * run the dead-code eliminator
     * @param node IRCompUnit of the ir
     * @return IRCompUnit with all dead code removed.
     */
    public IRCompUnit run(IRCompUnit node){
        Map<String, IRFuncDecl> removedFunDecl = new HashMap<>();
        for (IRFuncDecl func : node.functions().values()){
            IRFuncDecl body = removeDeadcode(func);
            removedFunDecl.put(func.name(), body);
        }
        IRCompUnit unit = irFactory.IRCompUnit(node.name(), removedFunDecl);
        return unit;
    }

    /**
     * Removes dead code. Dead-code is defined as any assignment x = e where x is not live
     * out of the node.
     * @param funcDecl
     * @return IRFuncDecl with all dead code removed
     */
    private IRFuncDecl removeDeadcode(IRFuncDecl funcDecl){
        IRCFG cfg = cfgGenerator.toIRCFG(funcDecl);
        //TODO: run and get liveVar DFA


        if (funcDecl.body() instanceof IRSeq){
            List<IRStmt> stmts = ((IRSeq) funcDecl.body()).stmts();
            for (int i = 0; i < stmts.size(); i++){
                //TODO: choose whether add this instruction or not
            }
        } else {
                //
        }
        return irFactory.IRFuncDecl(funcDecl.name(), funcDecl.body()); //TODO: change body to updated func body
    }
}
