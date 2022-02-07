package jw795.lexer;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileWriter;

import jw795.lexer.Lexer.TokenType;
import jw795.lexer.Lexer.Token;


public class LexerAdapter {

    Lexer lexer;
    String fileName;
    String lexedPath; // the path to store the lexed result file, indicated by user

    public LexerAdapter (Reader reader, String filename, String path) {
        lexer = new Lexer(reader);
        fileName = filename;
        lexedPath = path;
    }

    public void generateTokens () {
        List<Token> tokens = new ArrayList();
        boolean isEndofTokens = false;
        System.out.println(" =============================================get in the branch");
        while (!isEndofTokens) {
            try{
                Token token = lexer.nextToken();
                if (token == null){
                    isEndofTokens = true;
                }else {
                    System.out.println(token.type.toString());
                    tokens.add(token);
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
        String lexedFile = file.substring(0, file.length()-3) + ".lexed";

        // check if directory to put the lexed file in exists, create a new dir if doesn't
        File directory = new File(fullPath);
        if (!directory.exists()) {
            directory.mkdir();
        }

        // output tokens into the target file
        File targetFile = new File(fullPath + lexedFile);
        try{
            FileWriter targetWriter = new FileWriter(targetFile);
            for (Token t : tokens){
                StringBuilder line = new StringBuilder();
                line.append(t.line+1);
                line.append(":");
                if(t.type == TokenType.CHARLIT){
                    line.append(t.column);
                }else{
                    line.append(t.column+1);
                }
                line.append(" ");
                line.append(tokenTypeToString(t.type));
                if (t.value != null){
                    line.append(" ");
                    line.append(t.value);
                }
                line.append("\n");
                targetWriter.write(line.toString());
            }
            targetWriter.close();
        }
        catch (IOException ex){
            System.out.println("IO Error in LexerAdapter: " + ex.getMessage());
        }
    }

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
                res = "";
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

            default: res = "Invalid Token Type";
                break;
        }
        return res;
    }

}
