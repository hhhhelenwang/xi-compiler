use io
use conv

main(args: int[][]) {
a: int[][] = {{f(1)}, {f(2), f(3)}, {f(4), f(5), f(6)}, {f(7), f(8), f(9), f(10)}}
{
i: int = 0
while (i < length(a)) {
j: int = 0
while (j < length(a[i])) {
println(unparseInt(a[i][j]))
j = j + 1
}
i = i + 1
}
}
}

f(i: int): int {
print("f() called: ")
println(unparseInt(i))
return i
}

