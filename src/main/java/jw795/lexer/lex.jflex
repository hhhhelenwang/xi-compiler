package jw795.lexer;
%%
%public
%class Lexer
%type Token
%function nextToken
%unicode
%line
%column

%eofval{
    if(yystate() == CHARACTER){
        return new Token(TokenType.ERROR, "Incomplete char", charstartcol);
    } else if (yystate() == STRING){
        return new Token(TokenType.ERROR, "Invalid String", stringstartcol);
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
        ERROR
    }

    public class Token {
        TokenType type;
        Object value;
        int line;
        int column;

        Token (TokenType t) {
            type = t;
            line = yyline;
            column = yycolumn;
        }

        Token(TokenType t, Object val) {
            type = t;
            value = val;
            line = yyline;
            column = yycolumn;
        }

        Token(TokenType t, Object val, int col){
            type = t;
            value = val;
            line = yyline;
            column = col;
        }

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

    Boolean charRead = false;

    StringBuffer sb = new StringBuffer();
    int stringstartcol = 0;
    int charstartcol = 0;
%}

Letter = [a-zA-Z]
Digit = [0-9]
Char = [U+000000-U+10FFFF]

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
    "use" {return new Token(TokenType.USE);}
    "if" {return new Token(TokenType.IF);}
    "while" {return new Token(TokenType.WHILE);}
    "else" {return new Token(TokenType.ELSE);}
    "return" {return new Token(TokenType.RETURN);}
    "length" {return new Token(TokenType.LENGTH);}

    /* type names */
    "int" {return new Token(TokenType.INTTYPE);}
    "bool" {return new Token(TokenType.BOOLTYPE);}

    /* Data */
    {Integer} {return new Token(TokenType.INT, Integer.parseInt(yytext()));}
    {Boolean} {return new Token(TokenType.BOOL, parseBool(yytext()));}

    /* Identifier */
    {Identifier} {return new Token(TokenType.ID, yytext());}

    /* Operator */
    "!" {return new Token(TokenType.NOT);}
    "*" {return new Token(TokenType.MULT);}
    "*>>" {return new Token(TokenType.HIGHMULT);}
    "/" {return new Token(TokenType.DIV);}
    "%" {return new Token(TokenType.MOD);}
    "+" {return new Token(TokenType.ADD);}
    "-" {return new Token(TokenType.SUB);}
    "<" {return new Token(TokenType.LT);}
    "<=" {return new Token(TokenType.LEQ);}
    ">=" {return new Token(TokenType.GEQ);}
    ">" {return new Token(TokenType.GT);}
    "==" {return new Token(TokenType.EQ);}
    "!=" {return new Token(TokenType.NEQ);}
    "&" {return new Token(TokenType.AND);}
    "|" {return new Token(TokenType.OR);}

    ":" {return new Token(TokenType.COLON);}
    "=" {return new Token(TokenType.ASSIGN);}
    "(" {return new Token(TokenType.LPAREN);}
    ")" {return new Token(TokenType.RPAREN);}
    "[" {return new Token(TokenType.LBRACK);}
    "]" {return new Token(TokenType.RBRACK);}
    "{" {return new Token(TokenType.LBRACE);}
    "}" {return new Token(TokenType.RBRACE);}
    "," {return new Token(TokenType.COMMA);}
    ";" {return new Token(TokenType.SEMICOLON);}
    "_" {return new Token(TokenType.UNDERSCORE);}

    "/""/" { yybegin(COMMENT);}
    "'" {   yybegin(CHARACTER);
            charstartcol = yycolumn;}
    "\"" {  yybegin(STRING);
            sb = new StringBuffer();
            stringstartcol = yycolumn;}

    {WhiteSpace}|"\n" { /* ignore */}

    [^]  { return new Token(TokenType.ERROR, "Invalid input");}
}

<COMMENT> {
    {WhiteSpace}   { /* ignore */}
    "\n"|"\r"      {yybegin(YYINITIAL);}
    [^]            { /* ignore */}
}

<CHARACTER> {
    [^\n\\\'] {charRead = true; return new Token(TokenType.CHARLIT, yytext(), charstartcol);}

    \\n {charRead = true; return new Token(TokenType.CHARLIT, "\\n",  charstartcol);}

    \\\\ {charRead = true; return new Token(TokenType.CHARLIT, '\\', charstartcol);}

    \\\' {charRead = true; return new Token(TokenType.CHARLIT, '\'', charstartcol);}

    {Char}{Char}{Char}* {return new Token(TokenType.ERROR, "Illegal character <"+ yytext() +">");}

    {Hex} { sb = new StringBuffer();
            charRead = true;
            sb.append(parseHex(yytext()));
            String result = sb.toString();
            return new Token(TokenType.CHARLIT, result, charstartcol);
           }

    "'" {
        if (charRead) {
            charRead = false;
            yybegin(YYINITIAL);
        }
        else {
            return new Token(TokenType.ERROR, "Invalid character constant", charstartcol);
        }
    }

    [^] {return new Token(TokenType.ERROR, "Invalid character constant", charstartcol);}
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
        return new Token(TokenType.STRINGLIT, result, stringstartcol);
    }

    [^]  {return new Token(TokenType.ERROR, "Invalid String", stringstartcol);}
}




