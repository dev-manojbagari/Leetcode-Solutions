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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSumUtil(root,targetSum);
    }
    
    
    boolean hasPathSumUtil(TreeNode root,int targetSum){
        if(root==null)
            return false;
        
        if(root.left==null&&root.right==null)
            return root.val==targetSum;
        boolean l= hasPathSumUtil(root.left,targetSum-root.val);
        boolean r = hasPathSumUtil(root.right,targetSum-root.val);
        
        return l||r;
    }
}