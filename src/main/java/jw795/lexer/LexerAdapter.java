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

    public LexerAdapter (Reader reader) {
        lexer = new Lexer(reader);
    }

    public void generateTokens () {
        List<Token> tokens = new ArrayList();
        boolean isEndofTokens = false;

        while (!isEndofTokens) {
            try{
                Token token = lexer.nextToken();
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
        File targetFile = new File(PATH + fileName +".lexed");
        try{
            FileWriter targetWriter = new FileWriter(fileName);
            for (Token t : tokens){
                StringBuilder line = new StringBuilder();
                line.append(t.line);
                line.append(":");
                line.append(t.column);
                line.append(" ");
                line.append(tokenTypeToString(t.type));
                if (t.value != null){
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


            default: res = "Invalid Token Type";
                break;
        }

        return res;
    }



}
