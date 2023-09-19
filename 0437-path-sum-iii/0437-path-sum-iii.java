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
    int count =0;
    public int pathSum(TreeNode root, int targetSum) {

        Map<Long,Integer> map = new HashMap<>();
        map.put(0l,1);
        pathSum(root,targetSum,0,map);
        
        return count;
    }
    
    void pathSum(TreeNode root,int targetSum,long curSum,Map<Long,Integer> map){
        if(root==null)
            return;
        
        curSum += root.val;
        
        count += map.getOrDefault(curSum-targetSum,0);
        
        map.put(curSum,map.getOrDefault(curSum,0)+1);
        
        pathSum(root.left,targetSum,curSum,map);
        pathSum(root.right,targetSum,curSum,map);
      
        if(map.get(curSum)==1)
            map.remove(curSum);
        else
            map.put(curSum,map.get(curSum)-1);
        
    }
}