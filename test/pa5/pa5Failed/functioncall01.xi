use io
use conv

main(args: int[][]) {
println(unparseInt(f(0, 1)))
}

f(x: int, y: int): int {
print("f() called: ")
println(unparseInt(y))
return x + 1
}

