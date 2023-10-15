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
    public int widthOfBinaryTree(TreeNode root) {
        int[] max = {0};
        List<List<Integer>> list = new ArrayList<>();
        widthOfBinaryTree(root,list,max,0,0);
        return max[0];
    }
    
    void widthOfBinaryTree(TreeNode root,List<List<Integer>> list ,int[] max,int curLevel,int curIndex){
        if(root==null)
            return;
        
        if(list.size()==curLevel){
            list.add(new ArrayList());
        }
        
        list.get(curLevel).add(curIndex);
        
        max[0] = Math.max(max[0],curIndex-list.get(curLevel).get(0)+1);
        
        widthOfBinaryTree(root.left,list,max,curLevel+1,curIndex*2);
        widthOfBinaryTree(root.right,list,max,curLevel+1,curIndex*2+1);
    }
}