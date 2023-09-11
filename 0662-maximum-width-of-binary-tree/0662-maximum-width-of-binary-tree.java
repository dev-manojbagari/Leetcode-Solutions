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
    int maxWidth=0;
    public int widthOfBinaryTree(TreeNode root) {
        List<Integer> startOfLevel = new ArrayList<>();
        
        levelOrder(root,startOfLevel,0,1);
        
        return maxWidth;
    }
    
    void levelOrder(TreeNode root,List<Integer> list,int curLevel,int index){
        if(root==null)
            return;
        
        if(list.size()==curLevel)
            list.add(index);
        
        maxWidth = Math.max(maxWidth , index-list.get(curLevel)+1);
        
        levelOrder(root.left,list,curLevel+1,2*index);
        levelOrder(root.right,list,curLevel+1,2*index+1);
    }
}