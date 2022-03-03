/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package jw795;
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
    String destPath = ".";
    String sourcePath = ".";
    String libPath = ".";
    List<String> files = new ArrayList<>();
    Options options;

    /**
     * Initialize the CommandLine Interface
     * @param args the arguments passed in with CLI command.
     * @throws ParseException if
     */
    public void init_cli(String[] args) throws ParseException {
        options = new Options();
        options.addOption("h", "help", false, "display the help page");
        options.addOption("lex", "lex", false, "perform lexical analysis on the input file");
        options.addOption("D", "destination", true, "set path for diagnostic files");
        options.addOption("parse", "parse", false, "generate output from syntactic analysis");
        options.addOption("typechecck", "typecheck", false, "generate output from semantic analysis");
        options.addOption("sourcepath", "sourcepath", true, "specify where to find input source files");
        options.addOption("libpath", "libpath", true, "specify where to find library interface files");

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
            this.destPath = cmd.getOptionValue("D");
        } else if (cmd.hasOption("sourcepath")) {
            this.sourcePath = cmd.getOptionValue("sourcepath");
        } else if (cmd.hasOption("libpath")) {
            this.libPath = cmd.getOptionValue("libpath");
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
        files = cmd.getArgList();
        if (cmd.hasOption("lex")) {
            for (String file : files) {
                if (file.endsWith("xi")) {
                    System.out.println(file);
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
            files = cmd.getArgList();
            for (String file : files) {
                if (file.endsWith("xi")) {
                    System.out.println(file);
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
                System.out.println(file);
                if (file.endsWith(".xi")) {
                    System.out.println(sourcePath + file);
                    typeCheckFile(sourcePath + file);
                }
            }
        }
    }
    public void typeCheckFile(String fileName) {
        try {
            // Generate token file
            Reader reader = new FileReader(fileName);
            TypeCheckerAdapter typeAdapt = new TypeCheckerAdapter(reader, fileName, destPath, libPath);
            typeAdapt.gentypecheck();
        } catch (FileNotFoundException e) {
            System.out.println(fileName + ": " + " " + "File not found.");
        }
    }

    public static void main(String[] args) {
        Compiler compiler = new Compiler();
        try {
            compiler.init_cli(args);
        } catch (ParseException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Started");
        compiler.help();
        compiler.setPaths();
        compiler.lex();
        compiler.parse();
        compiler.typeCheck();
    }
}
