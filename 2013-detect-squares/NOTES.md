class DetectSquares {
int[][] count = new int[1001][1001];
List<int[]> points = new ArrayList<>();
public DetectSquares() {
}
public void add(int[] point) {
if(count[point[0]][point[1]]==0){
points.add(point);
}
count[point[0]][point[1]]++;
}
public int count(int[] point) {
int totalSquare=0;
int x1 = point[0],y1=point[1];
for(int[] curPoint : points){
int x3 = curPoint[0],y3=curPoint[1];
if(x3!=x1&&y3!=y1&&Math.abs(x3-x1)==Math.abs(y3-y1))
totalSquare += count[x1][y3]*count[x3][y1]*count[x3][y3];
}
return totalSquare;
}
}
​
​