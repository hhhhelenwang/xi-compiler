use io
g1:int[][]
g2:int[][]
g4:int
f() : int[][] {
    g1 = {"Somebody", "once", "told", "me"}
    g2 = {"the", "world", "is", "gonna", "roll", "me"}
    g3:int[][] = g1 + g2
    g4 = 3
    return g3
}

fun(time:int, start:int) : int {
    while (time > 0) {
        start = start + 1
        time = time - 1
    }
    return start
}

main (a : int[][]) {
    arr:int[][] = f()
    b:int = 0;
    c:int = fun(5, 0)
    d:int = c + b;
    e:int = c - b;
    f:int = c * b;
    g:int = c / c;
    h:int = c % c;
    i:int[] = {0, 1, 2, 3, 4, 5}
    j:int = i[b+f]
    println(arr[b]) //Somebody
    println(arr[c]) //world
    println(arr[d]) //world
    println(arr[e]) //world
    println(arr[f]) //Somebody
    println(arr[g]) //once
    println(arr[h]) //Somebody
    println(arr[j]) //Somebody
    println(arr[g4]) //me
}