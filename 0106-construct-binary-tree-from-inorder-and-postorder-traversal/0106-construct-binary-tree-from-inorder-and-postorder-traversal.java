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
    int postIndex=0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> inMap = new HashMap<>();
        
        for(int i=0;i<inorder.length;i++){
            inMap.put(inorder[i],i);
        }
        postIndex=postorder.length-1;
     return buildTree(postorder,inMap,0,postorder.length-1);   
    }
        
    private TreeNode buildTree(int[] postorder,Map<Integer,Integer> inMap,int start,int end){
         if(postIndex>=postorder.length||start>end)
               return null;
    
         TreeNode node = new TreeNode(postorder[postIndex--]);
        
         int index = inMap.get(node.val);
         node.right = buildTree(postorder,inMap,index+1,end);
         node.left = buildTree(postorder,inMap,start,index-1);
                        
          return node;  
        }
}