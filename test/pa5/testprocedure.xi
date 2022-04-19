use io
g1:int[][]
g2:int[][]
f() {
    g1 = {{1, 2, 3}, {4, 5, 6}}
    g2 = {{7, 8, 9}, {10, 11, 12}}
}

main (a : int[][]) {
    f()
    c:int[][] = {"Hello World!\n"}
    d:int[][] = {"Hello World!\n"}
    print((g1 + g2 + c + d)[5])
}