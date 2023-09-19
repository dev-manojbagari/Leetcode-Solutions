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
        if(root==null)
            return;
       
        flatten(root,null);
      
    }
    
    private TreeNode flatten(TreeNode root,TreeNode pre){
        if(root==null)
            return pre;
        
        TreeNode preRight = flatten(root.right,pre);
        TreeNode preLeft = flatten(root.left,preRight);
        
        root.left = null;
        root.right = preLeft;
        
        preLeft = root;
        
        return preLeft;
    }
    
}