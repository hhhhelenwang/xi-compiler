fun2 (a:int, b:int) : int, int{
    return a, b
}

getFun2 () {
    a:int, b:int = fun2(1, 2);
    _, b:int = fun2(1, 2);
}
