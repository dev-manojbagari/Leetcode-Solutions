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
    
    class BSTIterator{
        Stack<TreeNode> stack;
        boolean isForward = false;
       
        BSTIterator(TreeNode root,boolean isForward){
            this.isForward= isForward;
            stack = new Stack<>();
            while(root!=null){
                stack.push(root);
                root = isForward?root.left:root.right;
            }
            
        }
        
        
        boolean hasNext(){
            return !stack.isEmpty();
            
        }
        
        int peek(){
            return stack.peek().val;
        }
        
        int next(){
            TreeNode node = stack.pop();
            TreeNode x = node;
           node = isForward?node.right:node.left;
            while(node!=null){
                stack.push(node);
                node = isForward?node.left:node.right;
            }
            
            return x.val;
        }
    }
    
    
    public boolean findTarget(TreeNode root, int k) {
        BSTIterator left = new BSTIterator(root,true);
        BSTIterator right = new BSTIterator(root,false);
        
        while(left.hasNext()&&right.hasNext()){
            if(left.peek()>=right.peek())
                return false;
            int sum = left.peek()+right.peek();
            if(sum==k)
                return true;
            else if(sum<k)
                left.next();
            else
                right.next();
        }
        
        return false;
        
    }
}