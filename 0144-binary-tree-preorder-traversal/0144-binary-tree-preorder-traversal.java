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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list =new ArrayList<>();
        if(root==null)
            return list;
        Stack<TreeNode> stack1 = new Stack<>();
        stack1.push(root);

        while(!stack1.isEmpty()){
            TreeNode node = stack1.pop();
            list.add(node.val);
            if(node.right!=null)
                stack1.push(node.right);
            if(node.left!=null)
                stack1.push(node.left);
        }
        
        return list;
    }
}