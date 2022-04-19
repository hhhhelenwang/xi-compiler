use io
g1:int[]
g2:int[]
result:int

f() {
    g1 = "Hello World!\n"
    g2 = "My name is compiler"
}

g(n:int[]) {
    if (n[0] >= 5) {
        result = -1
        if (n[0] <= 10) {
            result = result + 1
        }
    }
    else {
        result = 1
    }
}

h(n:int[]) {
    while (n[0] < 2) {
        n[0] = n[0] + 1
    }
}

main (a : int[][]) {
    f()
    i:int[1]
    i[0] = 0
    h(i)
    g(i)
    print(({g1} + {g2})[result])
    return
}