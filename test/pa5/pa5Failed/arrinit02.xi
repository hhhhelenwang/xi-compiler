use io
use conv

main(args: int[][]) {
a: int[] = {f(1), f(2), f(3), f(4), f(5)}
i: int = 0
while (i < length(a)) {
println(unparseInt(a[i]))
i = i + 1
}
}

f(i: int): int {
print("f() called: ")
println(unparseInt(i))
return i
}

