/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long,Integer> map= new HashMap<>();
        map.put(0l,1);
        int[] count = {0};
        pathSum(0,root,targetSum,map,count);
        return count[0];
    }
    
    void pathSum(long curSum,TreeNode root,int targetSum,Map<Long,Integer> map,int[] count){
        if(root==null)
            return;
        curSum += root.val;
        if(map.containsKey(curSum-targetSum))
            count[0]+=map.get(curSum-targetSum);
        
        map.put(curSum,map.getOrDefault(curSum,0)+1);
        
        pathSum(curSum,root.left,targetSum,map,count);
        pathSum(curSum,root.right,targetSum,map,count);
        
        int c = map.get(curSum)-1;
        if(c==0)
            map.remove(curSum);
        else
            map.put(curSum,c);
    }
    
}