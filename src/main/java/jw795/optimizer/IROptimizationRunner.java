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
        System.out.println(optSettings.copy());
        System.out.println(optSettings.dce());
        boolean converged = false;
        while (!converged && (optSettings.copy() || optSettings.dce())) {
            boolean copyNoChange = true;
            if (optSettings.copy()) {
                CopyPropagatorIR copyPropagatorIR = new CopyPropagatorIR(program);
                program = copyPropagatorIR.run();
                copyNoChange = copyPropagatorIR.ifNoChange();
            }

            boolean dceNoChange = true;
            if (optSettings.dce()) {
                DeadCodeEliminator deadCodeEliminator = new DeadCodeEliminator(program);
                program = deadCodeEliminator.run();
                dceNoChange = deadCodeEliminator.ifNoChange();
            }
            converged = copyNoChange && dceNoChange;

        }
        return program;
    }

}
