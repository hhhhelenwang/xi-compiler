package jw795.optimizer;

import edu.cornell.cs.cs4120.xic.ir.IRCompUnit;
import jw795.OptSettings;

/**
 * A runner that runs all optimizations on a program at IR level:
 * - copy propagation
 * - dead-code elimination
 */
public class IROptimizationRunner {

    IRCompUnit program;
    OptSettings optSettings;

    public IROptimizationRunner(IRCompUnit program,OptSettings optSettings) {
        this.program = program;
        this.optSettings = optSettings;
    }

    /**
     * Run all optimizations that are turned on.
     * @return optimized IR program
     */
    public IRCompUnit runOptimizations() {
        boolean converged = false;
        while (!converged && (optSettings.copy() || optSettings.dce() || optSettings.cse())) {
            boolean copyNoChange = true;
            if (optSettings.copy()) {
                CopyPropagatorIR copyPropagatorIR = new CopyPropagatorIR(program);
                program = copyPropagatorIR.run();
                System.out.println("running copy");

                copyNoChange = copyPropagatorIR.ifNoChange();
                System.out.println("after running copy");
            }

            boolean cseNoChange = true;
            if (optSettings.cse()) {
                CSEEliminator cseEliminator = new CSEEliminator(program);
                System.out.println("running cse");
                cseNoChange = cseEliminator.ifNoChange();
                program = cseEliminator.run();
//                System.out.println(program);
                System.out.println("after running cse");

            }

            boolean dceNoChange = true;
            if (optSettings.dce()) {
                DeadCodeEliminator deadCodeEliminator = new DeadCodeEliminator(program);
                program = deadCodeEliminator.run();
                dceNoChange = deadCodeEliminator.ifNoChange();
            }


            converged = copyNoChange && dceNoChange && cseNoChange;

        }

        return program;
    }

}
