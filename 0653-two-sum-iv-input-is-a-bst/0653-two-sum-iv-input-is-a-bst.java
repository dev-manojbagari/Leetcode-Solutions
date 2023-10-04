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
        Stack<TreeNode> stack = new Stack<>();
        boolean forward;
        
        BSTIterator(TreeNode root,boolean forward){
            this.forward=forward;
            
            TreeNode curr = root;
                while(curr!=null){
                    stack.push(curr);
                    curr=forward?curr.left:curr.right;
                }
           
        }
        
        int val(){
            return stack.peek().val;
        }
        boolean hasNext(){
            return !stack.isEmpty();
        }
        
        void next(){
            TreeNode curr = stack.pop();
            curr = forward?curr.right:curr.left;
            
                while(curr!=null){
                    stack.push(curr);
                    curr=forward?curr.left:curr.right;
                }
            
        }
    }
    
    public boolean findTarget(TreeNode root, int k) {
        
        BSTIterator left = new BSTIterator(root,true);
        BSTIterator right = new BSTIterator(root,false);
        
        
        while(left.hasNext()&&right.hasNext()&&left.val()<right.val()){
            int sum = left.val()+right.val();
            
            if(sum==k){
                return true;
            }else if(sum<k){
                left.next();                
            }else{
                right.next();
            }
            
            
        }
        return false;
    }
}