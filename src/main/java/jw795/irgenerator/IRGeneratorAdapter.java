package jw795.irgenerator;

import edu.cornell.cs.cs4120.util.CodeWriterSExpPrinter;
import edu.cornell.cs.cs4120.util.SExpPrinter;
import edu.cornell.cs.cs4120.xic.ir.IRCompUnit;
import jw795.Visitor;
import jw795.ast.Program;
import jw795.typechecker.*;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static jw795.util.FileUtil.generateTargetFile;

public class IRGeneratorAdapter {
    TypeCheckerAdapter typeCheckerAdapter;
    String destPath; // the path to put the typed file in
    String libPath; // path to find the interface files in
    String fileName; // already contains source dir + file name
    HashMap<String, String> funcNames;
    HashMap<String, Long> funcRetLengths;

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
        // typeCheckAdapter.gentypecheck() will print Lexical, Syntax, or Semantic errors if those errors exist
        System.out.println("start generating ir");
        Program checkedProgram = (Program) typeCheckerAdapter.generateTypeCheck();
        funProcess();

        // create irVisitor
        Visitor irVisitor = new IRGenerator(funcNames, funcRetLengths);
        IRCompUnit lowerIR = null;
        // generate the target .irsol file
        FileWriter targetWriter = null;
        try{
            File targetIrsol = generateTargetFile(fileName, destPath, "ir");
            targetWriter = new FileWriter(targetIrsol);

            // Generating IR
            checkedProgram.accept(irVisitor);
            IRCompUnit root = checkedProgram.ir;
            IRLower lirTranslator = new IRLower();
            lowerIR = (IRCompUnit) lirTranslator.lower(root); //TODO: cast directly?

            // Writing to target file, adapted from IRNode_c.java
            System.out.println("trying to write to the file!!");
            System.out.println(root == null);

            targetWriter.write(prettyPrint(root));
            targetWriter.close();
        } catch (Exception e) {
            System.out.println("unknown error while generating IR: "+ e.getMessage());
        }

        return lowerIR;
    }

    // Helper function adapted from given code, start recursively print
    private static String prettyPrint(IRCompUnit compUnit) {
        StringWriter sw = new StringWriter();
        try (PrintWriter pw = new PrintWriter(sw);
             SExpPrinter sp = new CodeWriterSExpPrinter(pw)) {
            compUnit.printSExp(sp);
        }
        return sw.toString();
    }

    private void funProcess() {
        HashMap<String, Sigma> funs = typeCheckerAdapter.getFunctions();
        for (Map.Entry<String, Sigma> entry : funs.entrySet()) {
            if (entry.getValue() instanceof Fn) {
                funcNames.put(entry.getKey(), funNameBuild(entry.getKey(), (Fn) entry.getValue()));
                funcRetLengths.put(entry.getKey(), retLength(((Fn) entry.getValue()).outputType));
            }
        }
    }

    private String funNameBuild(String funcName, Fn type) {
        String newName = funcName.replaceAll("_", "__");
        return "_I" + newName + "_" + outputNameBuild(type.outputType) + inputNameBuild(type.inputType);
    }

    private String inputNameBuild(T inputType) {
        if (inputType instanceof Int) {
            return "i";
        } else if (inputType instanceof Bool) {
            return "b";
        } else if (inputType instanceof TypedArray) {
            return "a" + inputNameBuild(((TypedArray) inputType).elementType);
        } else if (inputType instanceof Unit) {
            return "";
        } else if (inputType instanceof Prod){
            String result = "";
            for (Tau t : ((Prod) inputType).elementTypes) {
                result.concat(inputNameBuild(t));
            }
            return result;
        }
        return null;
    }

    private String outputNameBuild(T outputType) {
        if (outputType instanceof Int) {
            return "i";
        } else if (outputType instanceof Bool) {
            return "b";
        } else if (outputType instanceof TypedArray) {
            return "a" + inputNameBuild(((TypedArray) outputType).elementType);
        } else if (outputType instanceof Unit) {
            return "p";
        } else if (outputType instanceof Prod){
            String result = "t".concat(String.valueOf(((Prod) outputType).elementTypes.size()));
            for (Tau t : ((Prod) outputType).elementTypes) {
                result.concat(outputNameBuild(t));
            }
            return result;
        }
        return null;
    }

    private Long retLength(T outputType) {
        if (outputType instanceof Int) {
            return 1L;
        } else if (outputType instanceof Bool) {
            return 1L;
        } else if (outputType instanceof TypedArray) {
            return 1L;
        } else if (outputType instanceof Unit) {
            return 0L;
        } else if (outputType instanceof Prod){
            return (long) ((Prod) outputType).elementTypes.size();
        }
        return null;
    }
}

