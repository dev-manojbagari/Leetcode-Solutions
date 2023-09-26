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
     class Pair{
        TreeNode node;
        int hd;
        int level;
        Pair(TreeNode node,int hd,int level){
            this.node=node;
            this.hd=hd;
            this.level=level;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root==null)
            return list;
        Map<Integer,List<Pair>> map = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0,0));
        int minHd=Integer.MAX_VALUE,maxHd = Integer.MIN_VALUE;
        int curLevel=0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
            Pair pair = q.poll();
            TreeNode node = pair.node;
            int hd = pair.hd;
            
            if(map.get(hd)==null)
                map.put(hd,new ArrayList<>());
                
            map.get(hd).add(pair);
            
            
            minHd = Math.min(minHd,hd);
            maxHd = Math.max(maxHd,hd);
            
            if(node.left!=null)
                q.offer(new Pair(node.left,hd-1,curLevel));
            
            if(node.right!=null)
                q.offer(new Pair(node.right,hd+1,curLevel));
            
            }
            curLevel++;
        }
        for(int i=minHd;i<=maxHd;i++){
            List<Pair> tempList = map.get(i);
            tempList.sort((a,b)->{
                if(a.level==b.level)
                    return a.node.val-b.node.val;
                return a.hd-b.hd;
            });
            List<Integer> temp = new ArrayList<>();
            for(Pair pair:tempList)
                temp.add(pair.node.val);
            
            list.add(temp);
        }
        
        
        return list;
    }
}