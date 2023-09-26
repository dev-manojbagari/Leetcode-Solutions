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
    public int maxPathSum(TreeNode root) {
        int maxSum[] = {Integer.MIN_VALUE};
        
        maxPathSum(root,maxSum);        
        return maxSum[0];
    }
    
    private int maxPathSum(TreeNode root,int[] maxSum){
        if(root==null)
            return 0;
        
        int ls = maxPathSum(root.left,maxSum);
        if(ls<0) ls=0;
        int rs = maxPathSum(root.right,maxSum);
        if(rs<0) rs=0;
        
        maxSum[0] = Math.max(maxSum[0],ls+root.val+rs);
        
        return root.val+Math.max(ls,rs);
    }
    
    
    
    
    
}