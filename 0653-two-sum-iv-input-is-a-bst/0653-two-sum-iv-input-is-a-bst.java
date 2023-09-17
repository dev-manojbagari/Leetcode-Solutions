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
    
    enum order{
        INCREASING,DECREASING;
    }
    
    class BSTIterator{
        Stack<TreeNode> stack = new Stack<>();        
        boolean increasingOrder;
        public BSTIterator(TreeNode root,boolean increasingOrder){
            this.increasingOrder = increasingOrder;
            TreeNode curr = root;
            while(curr!=null){
                stack.push(curr);
                curr=increasingOrder?curr.left:curr.right;   
            }
        }
        
        int peek(){
            return stack.peek().val;
        }
        
        boolean hasNext(){
            return !stack.isEmpty();
        }
        
        TreeNode next(){
            if(stack.isEmpty())return null;
            TreeNode node = stack.pop();
            TreeNode curr = increasingOrder?node.right:node.left;
            
            while(curr!=null){
                stack.push(curr);
                curr=increasingOrder?curr.left:curr.right;
            }
            
            return node;
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