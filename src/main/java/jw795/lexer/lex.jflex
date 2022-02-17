package jw795.lexer;

import java_cup.runtime.*;

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
        return newsymbol(TokenType.ERROR, "Incomplete char", charstartcol);
    } else if (yystate() == STRING){
        return newsymbol(TokenType.ERROR, "Invalid String", stringstartcol);
    } else {
        return null;
    }
%eofval}


%{
    enum TokenType {
        // keywords
        USE,
        IF,
        WHILE,
        ELSE,
        RETURN,
        LENGTH,

        //type name
        INTTYPE,
        BOOLTYPE,

        //data
        INT,
        BOOL,
        CHARLIT,
        STRINGLIT,

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


    private Symbol newsymbol(TokenType t){
        return new Symbol(t.ordinal(), yyline, yycolumn);
    }
    private Symbol newsymbol(TokenType t, Object value){
        return new Symbol(t.ordinal(), yyline, yycolumn, value);
    }
    private Symbol newsymbol(TokenType t, Object value, int col){
        return new Symbol(t.ordinal(), yyline, col, value);
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
    "use" {return newsymbol(TokenType.USE);}
    "if" {return newsymbol(TokenType.IF);}
    "while" {return newsymbol(TokenType.WHILE);}
    "else" {return newsymbol(TokenType.ELSE);}
    "return" {return newsymbol(TokenType.RETURN);}
    "length" {return newsymbol(TokenType.LENGTH);}

    /* type names */
    "int" { return newsymbol(TokenType.INTTYPE);}
    "bool" {return newsymbol(TokenType.BOOLTYPE);}

    /* Data */
    {Integer} {
    //since negative sign is still seperate token right now, we only check the face value
        Long readint = Long.parseLong(yytext());
        long range = Integer.MAX_VALUE;
        range = range +1;
        if(readint <= range){return newsymbol(TokenType.INT, readint);}
        else{return newsymbol(TokenType.ERROR, "Int value out of range");}
    }
    {Boolean} {return newsymbol(TokenType.BOOL, parseBool(yytext()));}

    /* Identifier */
    {Identifier} {return newsymbol(TokenType.ID, yytext());}

    /* Operator */
    "!" {return newsymbol(TokenType.NOT);}
    "*" {return newsymbol(TokenType.MULT);}
    "*>>" {return newsymbol(TokenType.HIGHMULT);}
    "/" {return newsymbol(TokenType.DIV);}
    "%" {return newsymbol(TokenType.MOD);}
    "+" {return newsymbol(TokenType.ADD);}
    "-" {return newsymbol(TokenType.SUB);}
    "<" {return newsymbol(TokenType.LT);}
    "<=" {return newsymbol(TokenType.LEQ);}
    ">=" {return newsymbol(TokenType.GEQ);}
    ">" {return newsymbol(TokenType.GT);}
    "==" {return newsymbol(TokenType.EQ);}
    "!=" {return newsymbol(TokenType.NEQ);}
    "&" {return newsymbol(TokenType.AND);}
    "|" {return newsymbol(TokenType.OR);}

    ":" {return newsymbol(TokenType.COLON);}
    "=" {return newsymbol(TokenType.ASSIGN);}
    "(" {return newsymbol(TokenType.LPAREN);}
    ")" {return newsymbol(TokenType.RPAREN);}
    "[" {return newsymbol(TokenType.LBRACK);}
    "]" {return newsymbol(TokenType.RBRACK);}
    "{" {return newsymbol(TokenType.LBRACE);}
    "}" {return newsymbol(TokenType.RBRACE);}
    "," {return newsymbol(TokenType.COMMA);}
    ";" {return newsymbol(TokenType.SEMICOLON);}
    "_" {return newsymbol(TokenType.UNDERSCORE);}

    "/""/" { yybegin(COMMENT);}
    "'" {   yybegin(CHARACTER);
            charRead = 0;
            sb = new StringBuffer();
            charstartcol = yycolumn;}
    "\"" {  yybegin(STRING);
            sb = new StringBuffer();
            stringstartcol = yycolumn;}

    {WhiteSpace}|"\n" { /* ignore */}

    [^]  { return newsymbol(TokenType.ERROR, "Invalid input");}
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
            return newsymbol(TokenType.CHARLIT, sb.toString(), charstartcol);
        } else {
            return newsymbol(TokenType.ERROR, "Invalid character constant", charstartcol);
        }
    }

    [^] {return newsymbol(TokenType.ERROR, "Invalid character constant", charstartcol);}
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
        return newsymbol(TokenType.STRINGLIT, result, stringstartcol);
    }

    [^]  {return newsymbol(TokenType.ERROR, "Invalid String", stringstartcol);}
}




