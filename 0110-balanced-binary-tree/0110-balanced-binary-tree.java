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
    class Height{
        int h;
    }
    public boolean isBalanced(TreeNode root) {
        return isBalanced(root,new Height());
    }
    
    boolean isBalanced(TreeNode node,Height height){
        if(node==null)
            return true;
        Height lh  = new Height();
        Height rh = new Height();

        boolean l = isBalanced(node.left,lh);
        boolean r = isBalanced(node.right,rh);
        
        height.h = 1+Math.max(lh.h,rh.h);
        
        if(Math.abs(lh.h-rh.h)>1)
            return false;
        
        return l&&r;
    }
    
}