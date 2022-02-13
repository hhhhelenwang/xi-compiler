# xi-compiler

A compiler of the Xi language built with Java. Uses JFlex as generating lexer and CUP for generating parser.

To build the compiler:
```
./xic-build
```

To use the compiler:
```
./xic [options] <source files>
```
where currently available options are:
- –help: display the help page
- –lex: produce lexical analysis on source files
- -D: specify where to put the lexed files produced by the –lex option.

Examples:
```
./xic
./xic –lex test/test1.xi
./xic –lex test/test1.xi -D lexed
```
