package jw795.asmgenerator;

import edu.cornell.cs.cs4120.xic.ir.IRCompUnit;
import edu.cornell.cs.cs4120.xic.ir.IRFuncDecl;
import edu.cornell.cs.cs4120.xic.ir.IRNode;
import edu.cornell.cs.cs4120.xic.ir.IRNodeFactory_c;
import jw795.assembly.AAAdd;
import jw795.assembly.AAInstruction;
import jw795.assembly.AAOperand;
import jw795.assembly.AATemp;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static jw795.util.FileUtil.generateTargetFile;

/**
 * An adapter class that takes in a single source file and generates the assembly code for that file.
 */
public class AssemblyGeneratorAdapter {
    String fileName; // already contains source dir + file name
    IRCompUnit sourceIR; // ir of the source file
    String destPathAsm;
    boolean optimize;
    FileWriter asmWriter;

    public AssemblyGeneratorAdapter(String file, IRCompUnit ir, String dest, boolean opt) {
        fileName = file;
        sourceIR = ir;
        destPathAsm = dest;
        optimize = opt;
        try {
            File targetAsmSol = generateTargetFile(fileName, destPathAsm, "s");
            asmWriter = new FileWriter(targetAsmSol);
        } catch (Exception e) {
            System.out.println("Compiler error: target file not found");
        }

    }

    /**
     * Generate assembly for file.
     */
    public void generateAssembly() {
        System.out.println("asm gen called!");
        Tiler asmvisit = new Tiler(new IRNodeFactory_c(),new TempSpiller());

        //after visiting, it should be still IRCompunit
        IRCompUnit visited = (IRCompUnit) asmvisit.visit(sourceIR);
        // we already handled the prologue and epilogue in fundecl
        try{
            asmWriter.write(visited.getTile().toString());
            for(IRNode node: visited.getTile().getNeighborIRs()){
                printTile(node.getTile());
            }
            asmWriter.close();
        } catch (Exception e){
            System.out.println("got an error while printing the string for a tile");
        }
    }

    /**
     * print a given tile with Depth first recursion
     * @param node the given tile
     * @throws Exception
     */
    private void printTile(Tile node) throws Exception{
        for(IRNode e: node.getNeighborIRs()){
            printTile(e.getTile());
        }
        if (node != null){
            asmWriter.write(node.toString());
        }
    }
}
