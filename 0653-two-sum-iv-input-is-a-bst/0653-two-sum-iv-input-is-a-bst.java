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
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return preorder(root,k,set);
    }
    
    boolean preorder(TreeNode root,int k,Set<Integer> set){
        if(root==null)
            return false;
        
        if(set.contains(k-root.val))
            return true;
        set.add(root.val);
        boolean l = preorder(root.left,k,set);
        boolean r = preorder(root.right,k,set);
        
        return l||r;
    }
}