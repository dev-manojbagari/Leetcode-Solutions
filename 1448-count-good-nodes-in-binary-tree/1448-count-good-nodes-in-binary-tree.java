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
        int goodNodes[] ={0};
        countGoodNodes(root,goodNodes,root.val);
        return goodNodes[0];
    }
    
    void countGoodNodes(TreeNode root,int[] goodNodes,int max){
        if(root==null)
            return;
        
        if(root.val>=max){
            goodNodes[0]++;
            max = Math.max(max,root.val);
        }
        
        countGoodNodes(root.left,goodNodes,max);
        countGoodNodes(root.right,goodNodes,max);
    }
}