# xi-compiler

A compiler of Xi language built with Java. Uses JFlex for generating lexer and CUP for generating parser.

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
- –-lex: produce lexical analysis on source files
- –-parse: produce syntactic analysis on source files
- –-typecheck: produce semantic analysis
- –-sourcepath: specify where to find the source files
- –-libpath: specify where to find the interface files
- -D: specify where to put the lexed files produced by the –lex option.

Examples:
```
./xic
./xic –lex test/test1.xi
./xic –lex test/test1.xi -D lexed
./xic --parse test/testparse.xi
./xic --parse test/testparse.xi -D parsed
./xic --typecheck test/test1.xi
./xic --typecheck test /test1.xi –sourcepath source –libpath libs

```
