%class Lexer
%unicode
%line
%column

%{

    enum TokenType {
        USE,
        IF,
        WHILE,
        ELSE,
        RETURN,
        LENGTH,
        INT,
        BOOL,
        CHAR,
        STRING,
        ID,
        COMMENT,
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

%}

Letter = [a-zA-Z]
Digit = [0-9]
Character = [U+000000-U+10FFFF]


Integer = 0 | [1-9]{Digit}*
Boolean = true | false
CharLit = '{Character}'
String = "{Character}*"
ESCAPE = \n | \\ | \' | \x({Digit} | [a-fA-F])({Digit} | [a-fA-F])


Identifier = Letter(Letter | Digit | _ | ')*
Comment = //{Character}*\n

/** char escape ? */

%state COMMENT
%state STRING

%%

<YYINITIAL> {
    /* keywords */
    {"use"} {return new Token(TokenType.USE);}
    {"if"} {return new Token(TokenType.IF);}
    {"while"} {return new Token(TokenType.WHILE);}
    {"else"} {return new Token(TokenType.ELSE);}
    {"return"} {return new Token(TokenType.RETURN);}
    {"length"} {return new Token(TokenType.LENGTH);}

    /* Identifier */
    {Identifier} {return new Token(TokenType.ID, yytext());}

    /* Data */
    {Integer} {return new Token(TokenType.INT, Integer.parseInt(yytext());}
    {Boolean} {return new Token(TokenType.BOOL, Token.parseBool(yytext());}
    {Character} {return new Token(TokenType.CHAR, yytext());}

    /* Operator */
    {"!"} {return new Token(TokenType.NOT);}
    {"*"} {return new Token(TokenType.MULT);}
    {"*>>"} {return new Token(TokenType.HIGHMULT);}
    {"/"} {return new Token(TokenType.DIV);}
    {"%"} {return new Token(TokenType.MOD);}
    {"+"} {return new Token(TokenType.ADD);}
    {"-"} {return new Token(TokenType.SUB);}
    {"<"} {return new Token(TokenType.LT);}
    {"<="} {return new Token(TokenType.LEQ);}
    {">="} {return new Token(TokenType.GEQ);}
    {">"} {return new Token(TokenType.GT);}
    {"=="} {return new Token(TokenType.EQ);}
    {"!="} {return new Token(TokenType.NEQ);}
    {"&"} {return new Token(TokenType.AND);}
    {"|"} {return new Token(TokenType.OR);}

    {":"} {return new Token(TokenType.COLON);}
    {"="} {return new Token(TokenType.ASSIGN);}
    {"("} {return new Token(TokenType.LPAREN);}
    {")"} {return new Token(TokenType.RPAREN);}
    {"["} {return new Token(TokenType.LBRACK);}
    {"]"} {return new Token(TokenType.RBRACK);}
    {"{"} {return new Token(TokenType.LBRACE);}
    {"}"} {return new Token(TokenType.RBRACE);}
    {","} {return new Token(TokenType.COMMA);}
    {";"} {return new Token(TokenType.SEMICOLON);}
    {"_"} {return new Token(TokenType.UNDERSCORE);}

}

<YYCOMMENT> {

}

<YYSTRING> {

}




