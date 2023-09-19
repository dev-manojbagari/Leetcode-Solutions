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
        List<Integer> list = new ArrayList<>();
        rightSideView(root,list,0);
        return list;
    }
    
    void rightSideView(TreeNode root,List<Integer> list,int level){
        if(root==null)
            return;
        
        if(level==list.size())
            list.add(root.val);
        
        rightSideView(root.right,list,level+1);
        rightSideView(root.left,list,level+1);
        
        
        
    }
    
    
}