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
           List<List<Integer>> list = new ArrayList<>();
           if(root==null)
                return list;
            preOrder(root,targetSum,0,list,new ArrayList());
        return list;
    }
    
     private void preOrder(TreeNode root, int targetSum,int curSum,List<List<Integer>> list,List<Integer> tempList) {
            if(root==null)
                return;
            tempList.add(root.val);
         
           if(root.left==null&&root.right==null){
                if(targetSum-curSum-root.val==0){
                        list.add(new ArrayList(tempList));
             
                }
               tempList.remove(tempList.size()-1);
         return;
           }

            preOrder(root.left,targetSum,curSum+root.val,list,tempList);
            preOrder(root.right,targetSum,curSum+root.val,list,tempList);

            tempList.remove(tempList.size()-1);
         
         
        }
   }