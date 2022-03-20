/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package jw795;
import edu.cornell.cs.cs4120.xic.ir.IRCompUnit;
import edu.cornell.cs.cs4120.xic.ir.interpret.IRSimulator;
import jw795.irgenerator.IRGeneratorAdapter;
import jw795.lexer.LexerAdapter;
import jw795.parser.ParserAdapter;
import jw795.typechecker.TypeCheckerAdapter;
import org.apache.commons.cli.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * Main class of xi-compiler.
 */
public class Compiler {
    CommandLine cmd;
    String destPath = "./";
    String sourcePath = "./";
    String libPath = "./";
    List<String> files = new ArrayList<>();
    Options options;

    /**
     * Initialize the CommandLine Interface
     * @param args the arguments passed in with CLI command.
     * @throws ParseException if
     */
    public void init_cli(String[] args) throws ParseException {
        options = new Options();
        options.addOption("h", "help", false,
                "display the help page");
        options.addOption("lex", "lex", false,
                "perform lexical analysis on the input file");
        options.addOption("D", "destination", true,
                "set path for diagnostic files");
        options.addOption("parse", "parse", false,
                "generate output from syntactic analysis");
        options.addOption("typechecck", "typecheck", false,
                "generate output from semantic analysis");
        options.addOption("sourcepath", "sourcepath", true,
                "specify where to find input source files");
        options.addOption("libpath", "libpath", true,
                "specify where to find library interface files");
        options.addOption("irgen", "irgen", false,
                "generate intermediate code on the input file");
        options.addOption("irrun", "irrun", false,
                "generate and interpret intermediate code");
        options.addOption("O", "O", false,
                "Disable optimization for generating IR");
        CommandLineParser parser = new DefaultParser();
        cmd = parser.parse(options, args);

    }

    /**
     * Display the help page.
     */
    public void help(){
        if (cmd.hasOption("h")){
            String syntax = "./xic [options] <source-files>";
            String header = "Available options to use the compiler with:";
            String footer = "Have fun!";
            HelpFormatter helpFormatter = new HelpFormatter();
            helpFormatter.printHelp(syntax, header, options, footer);

        }
    }

    /**
     * Set the path to place the diagnostic files
     */
    public void setPaths() {
        if (cmd.hasOption("D")) {
            this.destPath = cmd.getOptionValue("D")+"/";
        }
        if (cmd.hasOption("sourcepath")) {
            this.sourcePath = cmd.getOptionValue("sourcepath")+"/";
        }
        if (cmd.hasOption("libpath")) {
            this.libPath = cmd.getOptionValue("libpath")+ "/";
        }
    }

    /**
     * Produce lexical analysis for one file
     * @param fileName the name of the file
     */
    public void lexFile(String fileName) {
        try {
            // Generate token file
            Reader reader = new FileReader(fileName);
            LexerAdapter lexerAdapt = new LexerAdapter(reader, fileName, destPath);
            lexerAdapt.generateTokens();
        } catch (FileNotFoundException e) {
            System.out.println(fileName + ": " + " " + "File not found.");
        }
    }

    /**
     * Produce lexical analysis on all input source files.
     */
    public void lex(){
        if (cmd.hasOption("lex")) {
            // TODO: delete stdout before submitting
            System.out.println("Delete before submitting: Lexing >>");
            files = cmd.getArgList();
            for (String file : files) {
                if (file.endsWith("xi")) {
                    lexFile(file);
                }
            }
        }
    }

    /**
     * Produce syntactic analysis on all input source files.
     */
    public void parse(){
        if (cmd.hasOption("parse")) {
            // TODO: delete stdout before submitting
            System.out.println("Delete before submitting: Parsing >>");
            files = cmd.getArgList();
            for (String file : files) {
                if (file.endsWith("xi")) {
                    parseFile(file);
                }
            }
        }
    }

    public void parseFile(String fileName) {
        try {
            // Generate token file
            Reader reader = new FileReader(fileName);
            ParserAdapter parserAdapt = new ParserAdapter(reader, fileName, destPath);
            parserAdapt.generateAST();
        } catch (FileNotFoundException e) {
            System.out.println(fileName + ": " + " " + "File not found.");
        }
    }

    public void typeCheck(){
        if (cmd.hasOption("typecheck")) {
            files = cmd.getArgList();
            for (String file : files) {
                if (file.endsWith(".xi")) {
                    typeCheckFile(sourcePath + file);
                }
            }
        }
    }
    public void typeCheckFile(String fileName) {
        try {
            // Generate token file
            Reader reader = new FileReader(fileName);
            TypeCheckerAdapter typeAdapt = new TypeCheckerAdapter(reader, fileName, destPath, libPath, true);
            typeAdapt.generateTypeCheck();
        } catch (FileNotFoundException e) {
            System.out.println(fileName + ": " + " " + "File not found.");
        }
    }

    /**
     * Generate the intermediate representation for fileName
     * @param fileName the input xi file
     * @return an IRCompUnit which is the root node of generated IR
     */
    // TODO: produce IR for one file
    public IRCompUnit generateIRForFile(String fileName) {
        IRGeneratorAdapter irGeneratorAdapter = new IRGeneratorAdapter(fileName, this.destPath, this.libPath);
        IRCompUnit ir = irGeneratorAdapter.generateIR();
        return ir;
    }

    // TODO: generate IR
    public void generateIR() {
        if (cmd.hasOption("irgen")) {
            this.files = cmd.getArgList();
            for (String file : files) {
                generateIRForFile(file);
            }
        }

    }

    // TODO: generate IR for all input files, and run all generated IR file
    public void runIR() {
        if (cmd.hasOption("irrun")) {
            this.files = cmd.getArgList();
            for (String file : files) {
                IRCompUnit ir = generateIRForFile(file);
                IRSimulator sim = new IRSimulator(ir);
                //TODO:
                // ??? so to interpret an ir we need to call its main function
                // but how do we know if
                // 1) it has a main function and
                // 2) what should be passed in as arguments?
                long result = sim.call("_Imain_paai", 1);
            }

        }
    }


    public static void main(String[] args) {
        Compiler compiler = new Compiler();
        try {
            compiler.init_cli(args);
        } catch (ParseException e){
            System.out.println(e.getMessage());
        }
//        System.out.println("Started >>>");
        compiler.help();
        compiler.setPaths();
        compiler.lex();
        compiler.parse();
        compiler.typeCheck();
        compiler.generateIR();
        compiler.runIR();
    }
}
