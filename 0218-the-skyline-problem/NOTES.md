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