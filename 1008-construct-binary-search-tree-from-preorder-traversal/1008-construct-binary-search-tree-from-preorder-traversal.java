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
    //   int[] inorder = preorder.clone();
     //   Arrays.sort(inorder);
       
        
        return buildBST(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    
    private TreeNode buildBST(int[] preorder,int min,int max){
        if(preIndex==preorder.length||min>=max)
            return null;
      
        int next = preorder[preIndex];
        if(min>=next||next>=max)
            return null;
       
        TreeNode node = new TreeNode(preorder[preIndex++]);
        
        node.left = buildBST(preorder,min,node.val);
        node.right= buildBST(preorder,node.val,max);
        
        return node;
    }
    
    
    
}