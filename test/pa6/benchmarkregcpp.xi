
foo(x: int){
    if(x < 1){
        return;
    }
    a:int = 12345
    b:int = a
    c:int = b
    d:int = c
    e:int = d
    f:int = e
    g:int = f
    h:int = g
    i:int = h
    j:int = i
    k:int = j
    l:int = h
    m:int = l
    n:int = m
    o:int = n
    p:int = o
    q:int = p

    y:int = x + a + g + q
    z:int = y*x
    foo(x - 1)
}


main(args: int[][] ){
    foo(200);
}