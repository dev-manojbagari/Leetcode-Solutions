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
        distanceK(root,target,k,list);
        return list;
    }
    
    int distanceK(TreeNode root,TreeNode target,int k,List<Integer> list){
        if(root==null)
            return -1;
        
        if(root==target){
            distanceKDown(root,k,list);
            return 0;
        }
        
        int dl = distanceK(root.left,target,k,list);
        
        if(dl!=-1){
            if(1+dl==k){
                list.add(root.val);
            }else{
                distanceKDown(root.right,k-dl-2,list);
            }
            
            return dl+1;
        }
        
        int dr = distanceK(root.right,target,k,list);
        
        if(dr!=-1){
            if(1+dr==k){
                list.add(root.val);
            }else{
                distanceKDown(root.left,k-dr-2,list);
            }
            
            return dr+1;
        }
        
        return -1;
    }
    
    void distanceKDown(TreeNode root,int level ,List<Integer> list){
        if(root==null)
            return;
        
        if(level==0){
            list.add(root.val);
        }else{
            distanceKDown(root.left,level-1,list);
            distanceKDown(root.right,level-1,list);
        }

    }
}