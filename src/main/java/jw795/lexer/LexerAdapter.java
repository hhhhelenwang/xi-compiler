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
    String PATH = "../../../../../";
    String fileName = "";

    public LexerAdapter (Reader reader, String filename) {
        lexer = new Lexer(reader);
        fileName = filename;
    }

    public void generateTokens () {
        List<Token> tokens = new ArrayList();
        boolean isEndofTokens = false;
        System.out.println(" =============================================get in the branch");
        while (!isEndofTokens) {
            try{
                System.out.println(" =============================================get to try");
                Token token = lexer.nextToken();
                System.out.println(" =============================================token");
                if (token == null){
                    isEndofTokens = true;
                }else {
                    tokens.add(token);
                }
            } catch (IOException ex){
                System.out.println("An I/O-Error in lex adapter"); //throw new error?
            }
        }

        // output tokens into a file
        File targetFile = new File(fileName +".lexed");
        try{
            FileWriter targetWriter = new FileWriter(targetFile);
            for (Token t : tokens){
                StringBuilder line = new StringBuilder();
                line.append(t.line+1);
                line.append(":");
                line.append(t.column+1);
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
            System.out.println("An I/O-Error in lex adapter: output file"); //throw new error?
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
