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
    public int goodNodes(TreeNode root) {
        int[] count = {0};
        goodNodes(root,Integer.MIN_VALUE,count);
        return count[0];
    }
    
    void goodNodes(TreeNode root,int max,int[] count){
        if(root==null)
            return;
        
        if(max<=root.val){
            count[0]++;
        }
        
        goodNodes(root.left,Math.max(max,root.val),count);
        goodNodes(root.right,Math.max(max,root.val),count);
    }
    
    
}