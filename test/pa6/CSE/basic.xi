use io
use conv
main (a : int[][]) {
    g:int = 1;
    p:int = 2;
    l:int = 3;
    u:int = 4;

    a:int;
    b:int;
    c:int;

    a = g + p + l*u;
    b = p + l*u;
    c = l*u;
    println("Hello, World!")
}
