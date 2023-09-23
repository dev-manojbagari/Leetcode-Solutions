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
    int width=0;
    
    public int widthOfBinaryTree(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        
        widthOfBinaryTree(root,list,0,0);
        
        return width;
    }
    
    void widthOfBinaryTree(TreeNode root,List<List<Integer>> list , int level,int curIndex)
    {
        if(root==null)
            return;
        
        if(list.size()==level)
            list.add(new ArrayList<>());
        
        list.get(level).add(curIndex);
        width = Math.max(width,Math.abs(curIndex-list.get(level).get(0))+1);
        
        
        widthOfBinaryTree(root.left,list,level+1,2*curIndex+1);
        widthOfBinaryTree(root.right,list,level+1,2*curIndex+2);
        
        
        
    }
    
    
    
}