```
class Solution {
public List<List<Integer>> getSkyline(int[][] buildings) {
List<int[]> list = new ArrayList<>();
for(int[] building:buildings){
list.add(new int[]{building[0],-building[2]});
list.add(new int[]{building[1],building[2]});
}
list.sort((a,b)->{
if(a[0]!=b[0])
return a[0]-b[0];
else
return a[1]-b[1];
});
List<List<Integer>> res = new ArrayList<>();
TreeMap<Integer,Integer> treeMap = new TreeMap<Integer,Integer>(Collections.reverseOrder());
int prevHeight = 0;
for(int[] height:list){
if(height[1]<0)
treeMap.put(-height[1],treeMap.getOrDefault(-height[1],0)+1);
else
{
int count = treeMap.get(height[1])-1;
if(count==0)
treeMap.remove(height[1]);
else
treeMap.put(height[1],count);
}
int curHeight = treeMap.isEmpty()?0:treeMap.firstKey();
if(prevHeight!=curHeight){
res.add(Arrays.asList(height[0],curHeight));
prevHeight = curHeight;
}
}
return res;
}
}
```