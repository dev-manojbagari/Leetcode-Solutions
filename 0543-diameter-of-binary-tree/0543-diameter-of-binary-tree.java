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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = {0};
        height(root,diameter);
        return diameter[0];
    }
    
    int height(TreeNode root,int[] diameter){
        if(root==null)
            return -1;
        
        int lh = height(root.left,diameter);
        int rh = height(root.right,diameter);
        
        diameter[0] = Math.max(diameter[0],2+lh+rh);
        
        return 1+Math.max(lh,rh);
    }
    
}