```
class Solution {
int count=0;
public int pathSum(TreeNode root, int targetSum) {
Map<Long,Integer> map = new HashMap<>();
map.put(0l,1);
pathSum(root,targetSum,map,0);
return count;
}
void pathSum(TreeNode root,int targetSum,Map<Long,Integer> map,long curSum){
if(root==null)
return;
curSum += root.val;
if(map.containsKey(curSum-targetSum))
count+=map.get(curSum-targetSum);
map.put(curSum,map.getOrDefault(curSum,0)+1);
pathSum(root.left,targetSum,map,curSum);
pathSum(root.right,targetSum,map,curSum);
if(map.get(curSum)==1)
map.remove(curSum);
else