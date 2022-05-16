use conv
main(args:int[][]) {
  a:int = 7
  b:int = 9
  c:int = 0

  d:int = 17
  f:int[] = "abcdefg"


  j:int
  k:int
  q:int
  y:int
  z:int
  while (c < 1000) {
    j = a * a * b * b  +  a * a * b * b + f[3]
    j = a * a * b * b  +  a * a * b * b + f[3]
    k = a * a * b * b  +  a * a * b * b + f[3]
    q = a * a * b * b  +  a * a * b * b + f[3]

    d = a * a * b * b * d * d +  a * a * b * b * d * d
    y = a * a * b * b * d * d +  a * a * b * b * d * d
    z = a * a * b * b * d * d +  a * a * b * b * d * d

    c = c + 1
  }
  print(unparseInt(q))
  print(unparseInt(j))
  print(unparseInt(k))
  print(unparseInt(q))
  print(unparseInt(y))
  print(unparseInt(z))
}