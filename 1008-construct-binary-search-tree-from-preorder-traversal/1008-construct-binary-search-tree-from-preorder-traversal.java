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
    int preIndex=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return buildBST(preorder,Integer.MAX_VALUE);
    }
    
    TreeNode buildBST(int[] preorder,int max){
        if(preIndex>=preorder.length||preorder[preIndex]>=max)
            return null;
        
        TreeNode node = new TreeNode(preorder[preIndex++]);
        node.left= buildBST(preorder,node.val);
        node.right=buildBST(preorder,max);
        return node;
    }
    
    
}