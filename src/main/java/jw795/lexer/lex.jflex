%class Lexer
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
        UNDERSCORE
    }

    class Token {
        TokenType type;
        Object value;
        int line;
        int column;

        Token (TokenType t) {
            type = t;
            line = yyline;
            column = yycolumn;
        }

        Token(int t, Object val) {
            type = t;
            value = val;
            line = yyline;
            column = yycolumn;
        }

    }

    Boolean parseBool (String boolTex) {
        if (boolText.equals("true")) {
            return true;
        } else if (boolText.equals("false")) {
            return false;
        } else {
            return false; // should match the above two cases
        }
    }

    Boolean charRead = false;

    StringBuffer sb = new StringBuffer();
%}

Letter = [a-zA-Z]
Digit = [0-9]
Char = [U+000000-U+10FFFF]

Integer = 0 | [1-9]{Digit}*
Boolean = "true" | "false"
CharData = {Char}'

Identifier = Letter(Letter | Digit | _ | ')*

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
    {Integer} {return new Token(TokenType.INT, Integer.parseInt(yytext());}
    {Boolean} {return new Token(TokenType.BOOL, Token.parseBool(yytext());}

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
    "'" { yybegin(CHARACTER); System.out.println("Starting character");
    """ { yybegin(STRING); System.out.println("Starting string");}

}

<COMMENT> {
    "/""n" {yybegin(YYINITIAL); System.out.println("Ended comment");}

}

<CHARACTER> {
    [{Char}^\n\\\'] {return new Token(TokenType.CHARLIT, yytext()); charRead = true;}

    \\n {return new Token(TokenType.CHARLIT, '\n'); charRead = true;}

    \\\\ {return new Token(TokenType.CHARLIT, '\\'); charRead = true;}

    \\\' {return new Token(TokenType.CHARLIT, '\''); charRead = true;}

    {Char}{Char}{Char}* {throw new Error("Illegal character <"+ yytext() +">");}

    "'" {
        if (charRead) {
            charRead = false;
            yybegin(YYINITIAL);
            System.out.println("Ended character");
        }
        else {
            throw Error("Invalid character constant");
        }
    }

    [^] {throw new Error("Invalid character constant");}
}

<STRING> {
    [{Char}^\n\\\"] {sb.append(yytext());}

    \\n {sb.append('\n');}

    \\\\ {sb.append('\\');}

    \\\" {sb.append('\"');}

    """ {
        return new Token(TokenType.STRINGLIT, sb.toString());
        sb = new StringBuffer();
        yybegin(YYINITIAL);
        System.out.println("Ended string");
    }

    [^] {throw new Error("Invalid character constant");}
}




