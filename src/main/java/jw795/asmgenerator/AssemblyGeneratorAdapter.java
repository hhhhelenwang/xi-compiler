package jw795.asmgenerator;

import edu.cornell.cs.cs4120.xic.ir.IRCompUnit;
import edu.cornell.cs.cs4120.xic.ir.IRNode;
import edu.cornell.cs.cs4120.xic.ir.IRNodeFactory_c;

import java.io.File;
import java.io.FileWriter;

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

        IRNode visited = asmvisit.visit(sourceIR);
        // assume that compunit provide all the code we need
        try{
            printTile(visited.getTile());
            asmWriter.close();
        } catch (Exception e){
            System.out.println("got an eroor while printing the string for a tile");
        }
    }

    private void printTile(Tile node) throws Exception{
        if (node != null){
            asmWriter.write(node.toString());
        }
        for(IRNode e: node.getNeighborIRs()){
            printTile(e.getTile());
        }
    }







}
