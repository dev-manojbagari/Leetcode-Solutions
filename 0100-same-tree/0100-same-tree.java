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
    public boolean isSameTree(TreeNode p, TreeNode q) {
            
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.offer(p);
        q2.offer(q);
        
        while(!q1.isEmpty()&&!q2.isEmpty()){
            TreeNode pNode = q1.poll();
            TreeNode qNode = q2.poll();
            
            if(pNode==null&&qNode==null)
                continue;
            if(pNode==null||qNode==null)
                return false;
            
            if(pNode.val!=qNode.val)
                return false;
            
            
            q1.offer(pNode.left);
            q1.offer(pNode.right);
            
            q2.offer(qNode.left);
            q2.offer(qNode.right);
        }
        
        return q1.isEmpty()&&q2.isEmpty();
    }
}