/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> list = new ArrayList<>();
        if(root==null)
            return list;
        
        distanceK(root,target,k,list);
        
        return list;
    }
    
    private int distanceK(TreeNode root,TreeNode target,int k,List<Integer> list){
        if(root==null)
            return -1;
        
        if(root==target){
            distanceKBelow(root,k,list);
            return 0;
        }
        
        int ld = distanceK(root.left,target,k,list);
        
        if(ld!=-1){
            if(ld+1==k){
                list.add(root.val);
            }else if(ld+1<k){
                distanceKBelow(root.right,k-ld-2,list);
            }
            
            return ld+1;
        }
        
        int rd = distanceK(root.right,target,k,list);
        
        if(rd!=-1){
            if(rd+1==k){
                list.add(root.val);
            }else if(rd+1<k){
                distanceKBelow(root.left,k-rd-2,list);
            }
            
            return rd+1;
        }
        
        return -1;        
    }
    
    private void distanceKBelow(TreeNode root,int k,List<Integer> list){
        if(root==null)
            return;
        
        if(k==0){
            list.add(root.val);
            return;
        }
        
        distanceKBelow(root.left,k-1,list);
        distanceKBelow(root.right,k-1,list);
    }
}