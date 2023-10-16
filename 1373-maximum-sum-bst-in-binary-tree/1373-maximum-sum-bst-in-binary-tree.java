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
        boolean isBst=true;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum=0;
    }
    public int maxSumBST(TreeNode root) {
        int[] max = {0};
        maxSumBST(root,max);
        return max[0];
    }
    
    MinMax maxSumBST(TreeNode root,int[] max){
        if(root==null){
            return new MinMax();
        }
        
        MinMax left = maxSumBST(root.left,max);
        MinMax right = maxSumBST(root.right,max);
        MinMax minMax = new MinMax();
        
        if(left.isBst&&right.isBst&&left.max<root.val&&root.val<right.min){
            minMax.isBst=true;
            minMax.min = root.left!=null?left.min:root.val;
            minMax.max = root.right!=null?right.max:root.val;
            minMax.sum = left.sum+root.val+right.sum;
            max[0] = Math.max(max[0],minMax.sum);
        }else
            minMax.isBst=false;
        
        
        return minMax;
    }
    
    
}