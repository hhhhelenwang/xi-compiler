package jw795.lexer;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileWriter;

import jw795.lexer.Lexer.TokenType;
import java_cup.runtime.Symbol;

import jw795.parser.sym;

/**
 * An adapter class that connects the main class Compiler.class the Lexer.class generated using JFlex. Takes
 * in a reader that reads user-provided source file, the filename for the file, and the path to put the lexed
 * file in specified by user.
 */
public class LexerAdapter {

    Lexer lexer;
    String fileName;
    String lexedPath; // the path to store the lexed result file, indicated by user

    /**
     * Create an instance of LexerAdapter
     * @param reader a reader to read the source file
     * @param name filename to the source file
     * @param path path to put the diagnostic file in
     */
    public LexerAdapter (Reader reader, String name , String path) {
        lexer = new Lexer(reader);
        fileName = name;
        lexedPath = path;
    }

    /**
     * Calls next_token() method in Lexer.class to generate a list of tokens, and output a diagnostic file.
     */
    public void generateTokens () {
        List<Symbol> tokens = new ArrayList<>();
        boolean isEndofTokens = false;

        while (!isEndofTokens) {
                try{
                Symbol token = lexer.next_token();
                if (token == null){
                    isEndofTokens = true;
                } else {
                    tokens.add(token);
                    //Exit reading tokens because an error occurred
                    if (tokenTypeToString(token.sym).equals("error")){
                        break;
                    }
                }
            } catch (IOException ex){
                System.out.println("IO Error with generating tokens: " + ex.getMessage());
            }
        }

        // build the full directory to put the lexed file in
        String[] dirs = fileName.split("/");
        String fullPath = lexedPath + "/";
        for (int i = 0; i < dirs.length - 1; i ++) {
            fullPath += dirs[i] + "/";
        }
        // build the name of the lexed file
        String file = dirs[dirs.length - 1];
        String lexedFile;
        String end = file.substring(file.length()-3);
        if(end.equals(".xi")) {
            lexedFile =file.substring(0,file.length()-3)  + ".lexed";
        }else{
            lexedFile =file.substring(0,file.length()-4)  + ".lexed";
        }

        // check if directory to put the lexed file in exists, create a new dir if doesn't
        File directory = new File(fullPath);
        if (!directory.exists()) {
            directory.mkdir();
        }

        // output tokens into the target file
        File targetFile = new File(fullPath + lexedFile);
        try{
            FileWriter targetWriter = new FileWriter(targetFile);
            for (Symbol t : tokens){
                StringBuilder line = new StringBuilder();
                line.append(t.left+1);
                line.append(":");
                line.append(t.right+1);
                line.append(" ");
                line.append(tokenTypeToString(t.sym));
                if (t.value != null){
                    if (tokenTypeToString(t.sym).equals("error")){
                        //follow the specification of error output
                        line.append(":");
                    } else {
                        line.append(" ");
                    }
                    line.append(t.value);
                }
                line.append("\n");
                targetWriter.write(line.toString());
            }
            targetWriter.close();
        }
        catch (IOException ex){
            System.out.println("IO Error when writing lexed file: " + ex.getMessage());
        }
    }

    /**
     * Convert a TokenType to appropriate string to be displayed in the diagnostic file.
     * @param tokenType the type of token as defined in Lexer.class
     * @return the appropriate string representation for a tokenType
     */
    public static String tokenTypeToString(int tokenType){
        String res;
        switch(tokenType) {
            case sym.USE:
                res = "use";
                break;
            case sym.IF:
                res = "if";
                break;
            case sym.WHILE:
                res = "while";
                break;
            case sym.ELSE:
                res = "else";
                break;
            case sym.RETURN:
                res = "return";
                break;
            case sym.LENGTH:
                res = "length";
                break;
            case sym.INTTYPE:
                res = "int";
                break;
            case sym.BOOLTYPE:
                res = "bool";
                break;

            case sym.INT:
                res = "integer";
                break;
            case sym.BOOL:
                res = "boolean";
                break;
            case sym.CHARLIT:
                res = "character";
                break;
            case sym.STRINGLIT:
                res = "string";
                break;
            case sym.ID:
                res = "id";
                break;
            case sym.NOT:
                res = "!";
                break;
            case sym.MULT:
                res = "*";
                break;
            case sym.HIGHMULT:
                res = "*>>";
                break;

            case sym.DIV:
                res = "/";
                break;
            case sym.MOD:
                res = "%";
                break;
            case sym.ADD:
                res = "+";
                break;
            case sym.SUB:
                res = "-";
                break;
            case sym.LT:
                res = "<";
                break;
            case sym.LEQ:
                res = "<=";
                break;
            case sym.GEQ:
                res = ">=";
                break;
            case sym.GT:
                res = ">";
                break;

            case sym.EQ:
                res = "==";
                break;
            case sym.NEQ:
                res = "!=";
                break;
            case sym.AND:
                res = "&";
                break;
            case sym.OR:
                res = "|";
                break;
            case sym.COLON:
                res = ":";
                break;
            case sym.ASSIGN:
                res = "=";
                break;
            case sym.LPAREN:
                res = "(";
                break;
            case sym.RPAREN:
                res = ")";
                break;

            case sym.LBRACK:
                res = "[";
                break;
            case sym.RBRACK:
                res = "]";
                break;
            case sym.LBRACE:
                res = "{";
                break;
            case sym.RBRACE:
                res = "}";
                break;
            case sym.COMMA:
                res = ",";
                break;
            case sym.SEMICOLON:
                res = ";";
                break;
            case sym.UNDERSCORE:
                res = "_";
                break;

            case sym.error:
                res = "error";
                break;

            case sym.INTERFACE_FILE:
                res = "interface";
                break;

            case sym.PROGRAM_FILE:
                res = "program";
                break;

            default: res = "Invalid Token Type";
                break;
        }
        return res;
    }

}
