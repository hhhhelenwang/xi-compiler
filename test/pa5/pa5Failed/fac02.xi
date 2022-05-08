use io
use conv

main(args: int[][]) {
println(unparseInt(fac(7)))
}

fac(n: int): int {
i: int = 1
result: int = 1
while (i <= n) {
result = result * i
i = i + 1
}
return result
}

