use conv
main(args:int[][]) {
  a:int = 7
  b:int = 9
  c:int = 0
  d:int = 17

  e:int
  f: int
  g:int
  h:int
  i:int
  j:int
  k:int
  q:int
  y:int
  z:int
  while (c < (a+b)/(b-a) + 4*a-2*b) {
    d = a * a * b * b * d * d +  a * a * b * b * d * d

    e = a * a * b * b * d * d +  a * a * b * b * d * d
    f = a * a * b * b * d * d +  a * a * b * b * d * d
    g = a * a * b * b * d * d +  a * a * b * b * d * d
    h = a * a * b * b * d * d +  a * a * b * b * d * d
    i = a * a * b * b * d * d +  a * a * b * b * d * d
    j = a * a * b * b * d * d +  a * a * b * b * d * d
    k = a * a * b * b * d * d +  a * a * b * b * d * d
    q = a * a * b * b * d * d +  a * a * b * b * d * d
    y = a * a * b * b * d * d +  a * a * b * b * d * d
    z = a * a * b * b * d * d +  a * a * b * b * d * d

    e = e+f+g+h+i+j+k+q+y+z
    c = c + 1
  }
}