class Solution {
public int[] minInterval(int[][] intervals, int[] queries) {
int[] res = new int[queries.length];
Arrays.sort(intervals,(a,b)->a[0]-b[0]);
int[] Q = queries.clone();
Arrays.sort(Q);
Map<Integer,Integer> map = new HashMap<>();
TreeMap<Integer,Integer> treeMap = new TreeMap<>();
int j=0,n=intervals.length;
for(int i=0;i<Q.length;i++){
int point = Q[i];
while(j<n&&intervals[j][0]<=point){
int start = intervals[j][0],end = intervals[j][1];
treeMap.put(end-start+1,end);
j++;
}
while(!treeMap.isEmpty()&&treeMap.firstEntry().getValue()<point)
treeMap.pollFirstEntry();
map.put(point,treeMap.isEmpty()?-1:treeMap.firstKey());
}
int i=0;
for(int q:queries)
res[i++]=map.get(q);
return res;
}
}