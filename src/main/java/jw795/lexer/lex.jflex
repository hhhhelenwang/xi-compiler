package jw795.lexer;

import java_cup.runtime.*;
import jw795.parser.sym;
import java.math.BigInteger;

%%
%public
%class Lexer
%implements java_cup.runtime.Scanner
%function next_token
%type java_cup.runtime.Symbol
%unicode
%line
%column

%eofval{
    if(yystate() == CHARACTER){
        return newsymbol(sym.error, "Incomplete char", charstartcol);
    } else if (yystate() == STRING){
        return newsymbol(sym.error, "Invalid String", stringstartcol);
    } else {
        return null;
    }
%eofval}


%{
    public enum TokenType {
        // keywords
        USE,
        IF,
        WHILE,
        ELSE,
        RETURN,
        LENGTH,
        RECORD,
        BREAK,

        //type name
        INTTYPE,
        BOOLTYPE,

        //data
        INT,
        BOOL,
        CHARLIT,
        STRINGLIT,
        NULL,

        //identifier
        ID,

        //operators
        NOT,
        MULT,
        HIGHMULT,
        DIV,
        MOD,
        ADD,
        SUB,
        LT,
        LEQ,
        GEQ,
        GT,
        EQ,
        NEQ,
        AND,
        OR,
        DOT,

        //punctuation
        COLON,
        ASSIGN,
        LPAREN,
        RPAREN,
        LBRACK,
        RBRACK,
        LBRACE,
        RBRACE,
        COMMA,
        SEMICOLON,
        UNDERSCORE,

        //error
        ERROR,

        //filetype
        PROGRAM_FILE,
        INTERFACE_FILE
    }


    private Symbol newsymbol(int t){
        return new Symbol(t, yyline, yycolumn);
    }
    private Symbol newsymbol(int t, Object value){
        return new Symbol(t, yyline, yycolumn, value);
    }
    private Symbol newsymbol(int t, Object value, int col){
        return new Symbol(t, yyline, col, value);
    }


    private Boolean parseBool (String boolText) {
        if (boolText.equals("true")) {
            return true;
        } else if (boolText.equals("false")) {
            return false;
        } else {
            return false; // should match the above two cases
        }
    }

    private String parseHex (String hexTex) {
        Integer intTex = Integer.parseInt(hexTex.substring(3, hexTex.length() - 1), 16);
        String strTex =  Character.toChars(intTex)[0] + "";

        // handle special character
        if (strTex.equals("\n")){
            strTex = "\\n";
        }
        return strTex;
    }

    int charRead = 0;
    StringBuffer sb = new StringBuffer();
    int stringstartcol = 0;
    int charstartcol = 0;
%}

Letter = [a-zA-Z]
Digit = [0-9]
//Char = [U+000000-U+10FFFF]

HexNum = (({Digit} | [a-fA-F]){1, 6})
Hex =  "\\x{"{HexNum}"}"
Integer = 0 | [1-9]{Digit}*
Boolean = "true" | "false"

WhiteSpace = " "|\t|\r|\v|\f

Identifier = {Letter}({Letter} | {Digit} | _ | ')*

%state YYINITIAL
%state COMMENT
%state CHARACTER
%state STRING

%%

<YYINITIAL> {
    /* keywords */
    "use" {return newsymbol(sym.USE);}
    "if" {return newsymbol(sym.IF);}
    "while" {return newsymbol(sym.WHILE);}
    "else" {return newsymbol(sym.ELSE);}
    "return" {return newsymbol(sym.RETURN);}
    "length" {return newsymbol(sym.LENGTH);}
    "record" {return newsymbol(sym.RECORD);}
    "break"  {return newsymbol(sym.BREAK);}
    "null"   {return newsymbol(sym.NULL);}

    /* type names */
    "int" { return newsymbol(sym.INTTYPE);}
    "bool" {return newsymbol(sym.BOOLTYPE);}

    /* Data */
    {Integer} {
    //since negative sign is still seperate token right now, we only check the face value
        BigInteger readint = new BigInteger(yytext());
        BigInteger range = new BigInteger("9223372036854775809");
        if(range.compareTo(readint) == 1){return newsymbol(sym.INT, readint);}
        else{return newsymbol(sym.error, "Int value out of range");}
    }
    {Boolean} {return newsymbol(sym.BOOL, parseBool(yytext()));}

    /* Identifier */
    {Identifier} {return newsymbol(sym.ID, yytext());}

    /* Operator */
    "!" {return newsymbol(sym.NOT);}
    "*" {return newsymbol(sym.MULT);}
    "*>>" {return newsymbol(sym.HIGHMULT);}
    "/" {return newsymbol(sym.DIV);}
    "%" {return newsymbol(sym.MOD);}
    "+" {return newsymbol(sym.ADD);}
    "-" {return newsymbol(sym.SUB);}
    "<" {return newsymbol(sym.LT);}
    "<=" {return newsymbol(sym.LEQ);}
    ">=" {return newsymbol(sym.GEQ);}
    ">" {return newsymbol(sym.GT);}
    "==" {return newsymbol(sym.EQ);}
    "!=" {return newsymbol(sym.NEQ);}
    "&" {return newsymbol(sym.AND);}
    "|" {return newsymbol(sym.OR);}
    "." {return newsymbol(sym.DOT);}

    ":" {return newsymbol(sym.COLON);}
    "=" {return newsymbol(sym.ASSIGN);}
    "(" {return newsymbol(sym.LPAREN);}
    ")" {return newsymbol(sym.RPAREN);}
    "[" {return newsymbol(sym.LBRACK);}
    "]" {return newsymbol(sym.RBRACK);}
    "{" {return newsymbol(sym.LBRACE);}
    "}" {return newsymbol(sym.RBRACE);}
    "," {return newsymbol(sym.COMMA);}
    ";" {return newsymbol(sym.SEMICOLON);}
    "_" {return newsymbol(sym.UNDERSCORE);}

    "/""/" { yybegin(COMMENT);}
    "'" {   yybegin(CHARACTER);
            charRead = 0;
            sb = new StringBuffer();
            charstartcol = yycolumn;}
    "\"" {  yybegin(STRING);
            sb = new StringBuffer();
            stringstartcol = yycolumn;}

    {WhiteSpace}|"\n" { /* ignore */}

    [^]  { return newsymbol(sym.error, "Invalid input");}
}

<COMMENT> {
    {WhiteSpace}   { /* ignore */}
    "\n"|"\r"      {yybegin(YYINITIAL);}
    [^]            { /* ignore */}
}

<CHARACTER> {
    [^\n\\\'] {charRead += 1; sb.append(yytext());}

    \\n {charRead += 1; sb.append("\\n");}

    \\\\ {charRead += 1; sb.append('\\');}

    \\\' {charRead += 1; sb.append('\'');}

    {Hex} {charRead += 1; sb.append(parseHex(yytext()));}

    "'" {
        if (charRead == 1) {
            charRead = 0;
            yybegin(YYINITIAL);
            return newsymbol(sym.CHARLIT, sb.toString().charAt(0), charstartcol);
        } else {
            return newsymbol(sym.error, "Invalid character constant", charstartcol);
        }
    }

    [^] {return newsymbol(sym.error, "Invalid character constant", charstartcol);}
}

<STRING> {
    [^\n\\\"] {sb.append(yytext());}

    \\n {sb.append("\\n");}

    \\\\ {sb.append("\\");}

    \\\" {sb.append("\"");}

    {Hex} {sb.append(parseHex(yytext()));}

    "\"" {
        yybegin(YYINITIAL);
        String result = sb.toString();
        sb = new StringBuffer();
        return newsymbol(sym.STRINGLIT, result, stringstartcol);
    }

    [^]  {return newsymbol(sym.error, "Invalid String", stringstartcol);}
}




