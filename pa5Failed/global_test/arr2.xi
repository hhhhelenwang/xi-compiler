use io
use conv

x : int[]

f(a : int[]) : int {
a[0] = 5
return length(a)
}

main(args:int[][]) {
x = {0,0,0}
println(unparseInt(x[0])) // 0
len : int = f(x)
println(unparseInt(x[0])) // 5
}

