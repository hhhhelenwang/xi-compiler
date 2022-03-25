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

/**
 * Take in an input source file and produce an IR for it.
 */
public class IRGeneratorAdapter {
    TypeCheckerAdapter typeCheckerAdapter;
    String destPath; // the path to put the typed file in
    String libPath; // path to find the interface files in
    String fileName; // already contains source dir + file name
    HashMap<String, String> funcNames = new HashMap<>();
    HashMap<String, Long> funcRetLengths = new HashMap<>();
    boolean optimize;

    public IRGeneratorAdapter(String fileName, String dest, String lib, boolean opt) {
        this.destPath = dest;
        this.libPath = lib;
        this.fileName = fileName;
        this.optimize = opt;
        try {
            FileReader fr = new FileReader(fileName);
            typeCheckerAdapter = new TypeCheckerAdapter(fr, fileName, dest, lib, false);
        } catch (FileNotFoundException e) {
            System.out.println(fileName + ": " + " " + "File not found.");
        }
    }


    /**
     * Generate IR code for the file specified for adaptor, and write generated IR code to target file
     * @return a root node for the lowered IR ast
     */
    public IRCompUnit generateIR() {
        // typeCheckAdapter.gentypecheck() will print Lexical, Syntax, or Semantic errors if those errors exist
        Program checkedProgram = (Program) typeCheckerAdapter.generateTypeCheck();
        if (checkedProgram != null) {
            if(this.optimize){
                ConstantFoldingAst confold= new ConstantFoldingAst(checkedProgram);
                checkedProgram = confold.fold();
            }
            funProcess();
            // create irVisitor
            String[] name = fileName.split("/");
            String dotXiName = name[name.length - 1];
            String finalName = dotXiName.split("\\.")[0];
            Visitor irVisitor = new IRGenerator(finalName, funcNames, funcRetLengths);
            IRCompUnit lowerIR = null;
            IRCompUnit reorderedIR = null;
            // generate the target .ir file
            FileWriter targetWriter = null;

            try{
                File targetIrsol = generateTargetFile(fileName, destPath, "ir");
                targetWriter = new FileWriter(targetIrsol);


                // Generating IR
                checkedProgram.accept(irVisitor);
                IRCompUnit root = checkedProgram.ir;
                IRLower lirTranslator = new IRLower();
                lowerIR = lirTranslator.lower(root);
                if(this.optimize){
                    ConstantFolding confold = new ConstantFolding(lowerIR);
                    lowerIR = confold.foldComp();
                }
                JumpReorder jumpReorder = new JumpReorder();
                reorderedIR = jumpReorder.reorder(lowerIR);

                // Writing to target file
                targetWriter.write(prettyPrint(reorderedIR));
                targetWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("unknown error while generating IR: "+ e.getMessage());
            }

            return reorderedIR;

        } else {
            return null;
        }
    }

    /**
     * Helper function prettyPrint is adapted from given code
     * @param compUnit The root IR node of the program
     * @return a string representation of all IR code in compUnit
     */
    private static String prettyPrint(IRCompUnit compUnit) {
        StringWriter sw = new StringWriter();
        try (PrintWriter pw = new PrintWriter(sw);
             SExpPrinter sp = new CodeWriterSExpPrinter(pw)) {
            compUnit.printSExp(sp);
        }
        return sw.toString();
    }

    /**
     * fill up funcNames and funcRetLengths after typechecking
     */
    private void funProcess() {
        HashMap<String, Sigma> funs = typeCheckerAdapter.getFunctions();
        for (Map.Entry<String, Sigma> entry : funs.entrySet()) {
            if (entry.getValue() instanceof Fn) {
                funcNames.put(entry.getKey(), funNameBuild(entry.getKey(), (Fn) entry.getValue()));
                funcRetLengths.put(entry.getKey(), retLength(((Fn) entry.getValue()).outputType));
            }
        }
    }

    /**
     * build the name of a function following the abi naming convention for a function
     * @param funcName the original name of the function
     * @param type the type of the function
     * @return the name of the function following the abi naming convention
     */
    private String funNameBuild(String funcName, Fn type) {
        String newName = funcName.replaceAll("_", "__");
        return "_I" + newName + "_" + outputNameBuild(type.outputType) + inputNameBuild(type.inputType);
    }

    /**
     * generate the input part of the function name building
     * @param inputType the input type of the function
     * @return the input part of the function name building
     */
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

    /**
     * generate the output part of the function name building
     * @param outputType the output type of the function
     * @return the output part of the function name building
     */
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

    /**
     * generate the output length of a function with output type outputType
     * @param outputType the output type of the function
     * @return output length of a function with output type outputType
     */
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
