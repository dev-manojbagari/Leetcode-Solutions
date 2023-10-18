```
class Solution {
public int maxPoints(int[][] points) {
int maxPoints=0;
for(int i=0;i<points.length;i++){
Map<String,Integer> map = new HashMap<>();
int curMaxPoints = 0;
for(int j=i+1;j<points.length;j++){
int dx = points[j][0]-points[i][0];
int dy = points[j][1]-points[i][1];
int gcd = gcd(dx,dy);
dx = dx/gcd;
dy  = dy/gcd;
String key = dx+","+dy;
map.put(key,map.getOrDefault(key,0)+1);
curMaxPoints = Math.max(curMaxPoints,map.get(key));
}
maxPoints = Math.max(maxPoints,curMaxPoints+1);
}
return maxPoints;