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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        
        return buildTree(preorder,map,0,preorder.length);
    }
    
    TreeNode buildTree(int[] preorder,Map<Integer,Integer> map,int start,int end){
        if(start>end||preIndex>=preorder.length){
            return null;
        }
        
        TreeNode node = new TreeNode(preorder[preIndex++]);
        int index = map.get(node.val);
        
        node.left = buildTree(preorder,map,start,index-1);
        node.right=buildTree(preorder,map,index+1,end);
        
        
        return node;
    }
    
    
}