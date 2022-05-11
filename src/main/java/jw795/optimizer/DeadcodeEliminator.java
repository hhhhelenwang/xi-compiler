package jw795.optimizer;

import edu.cornell.cs.cs4120.xic.ir.IRCompUnit;
import edu.cornell.cs.cs4120.xic.ir.IRFuncDecl;
import edu.cornell.cs.cs4120.xic.ir.*;

import java.util.HashMap;
import java.util.Map;

public class DeadcodeEliminator {
    private IRNodeFactory_c irFactory;

    public DeadcodeEliminator(){
        this.irFactory = new IRNodeFactory_c();
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
     * @param func
     * @return IRFuncDecl with all dead code removed
     */
    private IRFuncDecl removeDeadcode(IRFuncDecl func){
        //TODO
        return irFactory.IRFuncDecl(func.name(), func.body());
    }
}
