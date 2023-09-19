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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>>  list = new ArrayList<>();
        
        pathSum(root,targetSum,list,new ArrayList<>());
        
        return list;
    }
    
    private void pathSum(TreeNode root,int targetSum,List<List<Integer>> list,List<Integer> tempList){
        if(root==null)
            return;
        
        tempList.add(root.val);

        if(root.left==null&&root.right==null){
            if(targetSum-root.val==0){
                list.add(new ArrayList<>(tempList));
            }
            
        }else{
            pathSum(root.left,targetSum-root.val,list,tempList);
            pathSum(root.right,targetSum-root.val,list,tempList);
        }
        
        tempList.remove(tempList.size()-1);
    }
}