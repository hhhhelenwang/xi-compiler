package jw795.lexer;
%%
%public
%class Lexer
%type Token
%function nextToken
%unicode
%line
%column


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

    private char parseHex (String hexTex) {
        Integer code = Integer.parseInt(hexTex.substring(3, hexTex.length() - 1), 16);
        return Character.toChars(code)[0];
    }

    Boolean charRead = false;

    StringBuffer sb = new StringBuffer();
    int stringstartcol = 0;
%}

Letter = [a-zA-Z]
Digit = [0-9]
Char = [U+000000-U+10FFFF]

Hex =  "\\x{"({Digit} | [a-fA-F])({Digit} | [a-fA-F])"}"
Integer = 0 | [1-9]{Digit}*
Boolean = "true" | "false"
CharData = {Char}'

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

    "/""/" { yybegin(COMMENT); System.out.println("Starting comment");}
    "'" { yybegin(CHARACTER); System.out.println("Starting character");}
    "\"" {  yybegin(STRING);
            System.out.println("Starting string");
            sb = new StringBuffer();
            stringstartcol = yycolumn;}

    {WhiteSpace}|"\n" { /* ignore */}

    [^]  { return new Token(TokenType.ERROR, "Invalid input");}
}

<COMMENT> {
    {WhiteSpace}   { /* ignore */}
    "\n"|"\r"    {System.out.println("Ended comment");yybegin(YYINITIAL); }
    [^]            { /* ignore */}
}

<CHARACTER> {
    [^\n\\\'] {charRead = true; return new Token(TokenType.CHARLIT, yytext());}

    \\n {charRead = true; return new Token(TokenType.CHARLIT, "\\n");}

    \\\\ {charRead = true; return new Token(TokenType.CHARLIT, '\\');}

    \\\' {charRead = true; return new Token(TokenType.CHARLIT, '\'');}

    {Char}{Char}{Char}* {return new Token(TokenType.ERROR, "Illegal character <"+ yytext() +">");}

    {Hex} {charRead = true; return new Token(TokenType.CHARLIT, sb.append(parseHex(yytext())));}

    "'" {
        if (charRead) {
            charRead = false;
            yybegin(YYINITIAL);
            System.out.println("Ended character");
        }
        else {
            return new Token(TokenType.ERROR, "Invalid character constant");
        }
    }

    [^] {return new Token(TokenType.ERROR, "Invalid character constant");}
}

<STRING> {
    [^\n\\\"] {sb.append(yytext());}

    \\n {sb.append("\\n");}

    \\\\ {sb.append("\\\\");}

    \\\" {sb.append("\"");}

    {Hex} {sb.append(parseHex(yytext()));}

    "\"" {
        yybegin(YYINITIAL);
        System.out.println("Ended string");
        String result = sb.toString();
        sb = new StringBuffer();
        return new Token(TokenType.STRINGLIT, result, stringstartcol);
    }

    [^] {return new Token(TokenType.ERROR, "Invalid String");}
}




