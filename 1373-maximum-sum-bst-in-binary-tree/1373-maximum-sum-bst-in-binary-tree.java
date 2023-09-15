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
    class MinMax{
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int sum =0;
        boolean isBST = true;
    }
        int max[]={0};
    public int maxSumBST(TreeNode root) {
        MinMax minMax = maxSumBST2(root);
        return max[0];
    }
    
    MinMax maxSumBST2(TreeNode root){
        if(root==null)
            return new MinMax();
        
        MinMax left = maxSumBST2(root.left);
        MinMax right =maxSumBST2(root.right);
        
        MinMax minMax = new MinMax();
        
        if(left.isBST&&right.isBST&&left.max<root.val&&root.val<right.min){
            minMax.isBST = true; 
            minMax.min = Math.min(left.min,root.val);
            minMax.max = Math.max(right.max,root.val);
            minMax.sum = root.val+left.sum+right.sum;
        
            max[0] = Math.max(max[0],minMax.sum);
            return minMax;
        }
        
        minMax.isBST=false;
        minMax.sum = Math.max(left.sum,right.sum);
        return minMax;
    }
}