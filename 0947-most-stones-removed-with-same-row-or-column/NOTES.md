int up = findUP(parent[x]);
parent[x]=up;
return up;
}
void unionBySize(int a,int b){
int upA = findUP(a);
int upB = findUP(b);
if(upA==upB)
return;
if(size[upA]>=size[upB]){
size[upA]+=size[upB];
parent[upB]=upA;
}else{
size[upB]+=size[upA];
parent[upA]=upB;
}
}
}
public int removeStones(int[][] stones) {
int m=Integer.MIN_VALUE;
int n = Integer.MIN_VALUE;
for(int i=0;i<stones.length;i++){
m = Math.max(m,stones[i][0]);
n=  Math.max(n,stones[i][1]);
}
DSU dsu = new DSU(m+n+2);
Set<Integer> set = new HashSet<>();
for(int i=0;i<stones.length;i++){
for(int j=0;j<stones[0].length;j++){
int row = stones[i][0];
int col = stones[i][1]+m+1;
dsu.unionBySize(row,col);
set.add(row);
set.add(col);
}
}