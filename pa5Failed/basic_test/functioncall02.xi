use io
use conv

main(args: int[][]) {
println(unparseInt(f(f(f(f(f(f(f(0, 1), 2), 3), 4), 5), 6), 7)))
}

f(x: int, y: int): int {
print("f() called: ")
println(unparseInt(y))
return x + 1
}

