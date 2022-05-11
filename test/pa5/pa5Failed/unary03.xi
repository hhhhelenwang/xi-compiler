use io
use conv

main(args: int[][]) {
println(b2s(!true))
println(b2s(!false))
}

b2s(b: bool): int[] {
if (b) { return "true" } else { return "false" }
}

