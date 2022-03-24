use io
g1:int[]
g2:int[]
f() : int[] {
    g1 = {1, 2, 3, 4, 5, 6}
    g2 = {7, 8, 9, 10, 11, 12}
    g3:int[] = g1 + g2
    return g3
}

main (a : int[][]) {
    b:int[] = f()
    c:int[] = "Hello World!\n"
    d:int[] = "Hello World!\n"
    print(b + c + d)
    // len:int = length(b + c + d)
    // print({len})
    // print(b + c + d)
    // i:int = 0
    // while (i < len) {
    //    print({(b + c + d)[i]})
    //    i = i + 1
    // }
}