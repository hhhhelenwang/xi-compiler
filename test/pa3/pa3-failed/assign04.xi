f(x:int[][], y:int, z:int) {
  x[0][1] = 0
  x[y][z] = 0
  x[{1,2,3}[0]][{1,2,3}[1]] = 0
  x[g1()][g2()] = 0
  x[x[0][1]][x[2][3]] = 0
  x[-1][-2] = 0
  x[0+0][0-0] = 0
  x[(0)][(1)] = 0
 }
heyitsaboolean :bool = false;
g1():int {
 return 0
 }
g2():int {
 return 0
}
