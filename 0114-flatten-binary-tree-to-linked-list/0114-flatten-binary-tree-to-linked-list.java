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
    public void flatten(TreeNode root) {
        TreeNode[] prev = {null};
        flatten(root,prev);
    }
    void flatten(TreeNode root,TreeNode[] prev){
        if(root==null)
            return;
        
        flatten(root.right,prev);
        flatten(root.left,prev);
        root.right=prev[0];
        root.left=null;
        prev[0]=root;
    }
}