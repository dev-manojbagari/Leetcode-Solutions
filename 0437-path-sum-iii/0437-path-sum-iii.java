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
        if(root==null)
            return 0;
        Map<Long,Integer> map = new HashMap<>();
        map.put(0l,1);
        pathSum(root,targetSum,0,map);
        return count;
    }
    
    void pathSum(TreeNode root,int targetSum,long curPathSum,Map<Long,Integer> map ){
        if(root==null)
            return;
        
        curPathSum += root.val;
        long oldPathSum = curPathSum-targetSum;
        count += map.getOrDefault(oldPathSum,0);
        
        map.put(curPathSum,map.getOrDefault(curPathSum,0)+1);
        
        pathSum(root.left,targetSum,curPathSum,map);
        pathSum(root.right,targetSum,curPathSum,map);
        
        if(map.get(curPathSum)==1){
            map.remove(curPathSum);
        }else{
            map.put(curPathSum,map.get(curPathSum)-1);
        }

    }
}