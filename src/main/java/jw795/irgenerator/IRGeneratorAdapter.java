package jw795.irgenerator;

import edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;
import edu.cornell.cs.cs4120.util.SExpPrinter;
import edu.cornell.cs.cs4120.xic.ir.IRCompUnit;
import jw795.Visitor;
import jw795.ast.ASTNode;
import jw795.ast.Program;
import jw795.typechecker.TypeCheckerAdapter;

import java.io.*;

import static jw795.util.FileUtil.generateTargetFile;

public class IRGeneratorAdapter {
    TypeCheckerAdapter typeCheckerAdapter;
    String destPath; // the path to put the typed file in
    String libPath; // path to find the interface files in
    String fileName; // already contains source dir + file name

    public IRGeneratorAdapter(String fileName, String dest, String lib) {
        this.destPath = dest;
        this.libPath = lib;
        this.fileName = fileName;
        try {
            FileReader fr = new FileReader(fileName);
            typeCheckerAdapter = new TypeCheckerAdapter(fr, fileName, dest, lib, false);
        } catch (FileNotFoundException e) {
            System.out.println(fileName + ": " + " " + "File not found.");
        }
    }

    public IRCompUnit generateIR() {
        // typeCheckAdapter.gentypecheck() will print Lexical, Syntax, or Semantic if exist
        System.out.println("start generating ir");
        Program checkedProgram = (Program) typeCheckerAdapter.gentypecheck();

        // create irVisitor
        Visitor irVisitor = new IRGenerator();

        // generate the target .irsol file
        FileWriter targetWriter = null;

        try{
            File targetIrsol = generateTargetFile(fileName, destPath, "irsol");
            targetWriter = new FileWriter(targetIrsol);

            // Generating IR
            checkedProgram.accept(irVisitor);
            IRCompUnit root = checkedProgram.ir;

            // Writing to target file, adapted from IRNode_c.java
            StringWriter sw = new StringWriter();
            try (PrintWriter pw = new PrintWriter(sw);
                 SExpPrinter sp = new CodeWriterSExpPrinter(pw)) {
                root.printSExp(sp);
                targetWriter.write(sw.toString());
                targetWriter.close();
            } catch (Exception e){
                System.out.println("Printer initialization error");
                targetWriter.close();
            }
        } catch (Exception e) {
            System.out.println("unknown error while generating IR: "+ e.getMessage());
        }

        return checkedProgram.ir;
    }
}
