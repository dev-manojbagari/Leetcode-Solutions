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
    
    TreeNode preOrder(TreeNode root){
        if(root==null)
            return root;
  
     TreeNode leftTail =  preOrder(root.left);
     TreeNode rightTail = preOrder(root.right);
        
     if(root.left!=null){
         TreeNode temp = root.right;
         root.right=root.left;
         root.left=null;
         leftTail.right=temp;
     }
        
    if(rightTail!=null)
        return rightTail;
    else if(leftTail!=null)
        return leftTail;
    else
        return root;
        
    }
}