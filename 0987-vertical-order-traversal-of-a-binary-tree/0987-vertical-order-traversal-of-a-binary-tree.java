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
            this.node = node;
            this.hd=hd;
            this.level = level;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> list  = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0,0));
        Map<Integer,List<Pair>> map = new HashMap<>();
        int minHD=Integer.MAX_VALUE,maxHD=Integer.MIN_VALUE;
        int level=0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Pair pair = q.poll();
                TreeNode node = pair.node;
                int hd = pair.hd;
                minHD = Math.min(minHD,hd);
                maxHD = Math.max(maxHD,hd);
                
                map.computeIfAbsent(hd,(k->new ArrayList<>())).add(pair);
                
                if(node.left!=null)
                    q.offer(new Pair(node.left,hd-1,level+1));
                if(node.right!=null)
                    q.offer(new Pair(node.right,hd+1,level+1));
            }
            level++;
        }
        
        for(int i=minHD;i<=maxHD;i++){
            map.get(i).sort((a,b)->{
                if(a.level==b.level)
                    return Integer.compare(a.node.val,b.node.val);
                return Integer.compare(a.level,b.level);
            });
            List<Integer> tempList = new ArrayList<>();
            for(Pair p:map.get(i)){
                tempList.add(p.node.val);
            }
            list.add(tempList);
        }
        
        return list;
        
    }
}