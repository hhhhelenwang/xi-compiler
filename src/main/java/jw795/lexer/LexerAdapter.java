package jw795.lexer;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileWriter;

import jw795.lexer.Lexer.TokenType;
import java_cup.runtime.Symbol;

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
     * @param filename filename to the source file
     * @param path path to put the diagnostice file in
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
        List<Symbol> tokens = new ArrayList();
        boolean isEndofTokens = false;

        while (!isEndofTokens) {
                try{
                Symbol token = lexer.next_token();
                if (token == null){
                    isEndofTokens = true;
                } else {
                    tokens.add(token);
                    //Exit reading tokens because an error occurred
                    if (TokenType.values()[token.sym].toString().equals("ERROR")){
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
        String end = file.substring(file.length()-3,file.length());
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
                line.append(tokenTypeToString(TokenType.values()[t.sym]));
                if (t.value != null){
                    if (TokenType.values()[t.sym].toString().equals("ERROR")){
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
    private String tokenTypeToString(TokenType tokenType){
        String res;
        switch(tokenType) {
            case USE:
                res = "use";
                break;
            case IF:
                res = "if";
                break;
            case WHILE:
                res = "while";
                break;
            case ELSE:
                res = "else";
                break;
            case RETURN:
                res = "return";
                break;
            case LENGTH:
                res = "length";
                break;
            case INTTYPE:
                res = "int";
                break;
            case BOOLTYPE:
                res = "bool";
                break;

            case INT:
                res = "integer";
                break;
            case BOOL:
                res = "boolean";
                break;
            case CHARLIT:
                res = "character";
                break;
            case STRINGLIT:
                res = "string";
                break;
            case ID:
                res = "id";
                break;
            case NOT:
                res = "!";
                break;
            case MULT:
                res = "*";
                break;
            case HIGHMULT:
                res = "*>>";
                break;

            case DIV:
                res = "/";
                break;
            case MOD:
                res = "%";
                break;
            case ADD:
                res = "+";
                break;
            case SUB:
                res = "-";
                break;
            case LT:
                res = "<";
                break;
            case LEQ:
                res = "<=";
                break;
            case GEQ:
                res = ">=";
                break;
            case GT:
                res = ">";
                break;

            case EQ:
                res = "==";
                break;
            case NEQ:
                res = "!=";
                break;
            case AND:
                res = "&";
                break;
            case OR:
                res = "|";
                break;
            case COLON:
                res = ":";
                break;
            case ASSIGN:
                res = "=";
                break;
            case LPAREN:
                res = "(";
                break;
            case RPAREN:
                res = ")";
                break;

            case LBRACK:
                res = "[";
                break;
            case RBRACK:
                res = "]";
                break;
            case LBRACE:
                res = "{";
                break;
            case RBRACE:
                res = "}";
                break;
            case COMMA:
                res = ",";
                break;
            case SEMICOLON:
                res = ";";
                break;
            case UNDERSCORE:
                res = "_";
                break;

            case ERROR:
                res = "error";
                break;
            default: res = "Invalid Token Type";
                break;
        }
        return res;
    }

}
