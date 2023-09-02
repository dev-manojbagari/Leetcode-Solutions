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
    TreeNode prev=null;
    public void flatten(TreeNode root) {
        
        preOrder(root);
    
    }
    
    void preOrder(TreeNode root){
        if(root==null)
            return;
  
        preOrder(root.right);
        preOrder(root.left);
        
        root.left=null;
        root.right=prev;
        prev=root;
     
        
    }
}