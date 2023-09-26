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
    class Tree{
        boolean isBST=true;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int sum=0;
    }
    public int maxSumBST(TreeNode root) {
        
        int maxSum[] = {0};
        maxSumBST(root,maxSum);
        return maxSum[0];
    }
    
    private Tree maxSumBST(TreeNode root,int[] maxSum){
        if(root==null)
            return new Tree();
        
        Tree lst = maxSumBST(root.left,maxSum);
        Tree rst = maxSumBST(root.right,maxSum);
        Tree tree = new Tree();
        if(lst.isBST&&rst.isBST&&lst.max<root.val&&root.val<rst.min){
            tree.isBST = true;
            tree.min = root.left!=null?lst.min:root.val;
            tree.max= root.right!=null?rst.max:root.val;
            tree.sum = root.val+lst.sum+rst.sum;
            maxSum[0] = Math.max(maxSum[0],tree.sum);
        }else
            tree.isBST=false;
        
        return tree;
    }
    
    
    
    
}