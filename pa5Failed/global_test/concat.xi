use io
use conv

f(a : int[], n : int) : int[] {
if (n == 0) { return "" }
return a + f(a,n-1)
}
x : int = 2
main(args:int[][]) {
println(f("hello", x))
}

