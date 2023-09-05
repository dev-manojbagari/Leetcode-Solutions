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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new  ArrayList<>();
        if(root==null)
            return list;
        
        levelOrderTraversal(root,list,0);
        
        return list;
    }
    
    void levelOrderTraversal(TreeNode root,List<Integer> list , int curLevel){
        if(root==null)
            return;
        
        if(list.size()==curLevel)
            list.add(root.val);
        
        levelOrderTraversal(root.right,list,curLevel+1);
        levelOrderTraversal(root.left,list,curLevel+1);
    }
}