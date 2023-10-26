class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if(n==1){
            res.add(0);
            return res;
        }
        List<List<Integer>> adjList = new ArrayList<>();
        int[] id = new int[n];
        for(int i=0;i<n;i++)
            adjList.add(new ArrayList<>());
        for(int[] edge:edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
            id[edge[0]]++;
            id[edge[1]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<n;i++){
            if(id[i]==1)
                q.offer(i);
        }
        
        while(n>2){
            int levelSize = q.size();
            n=n-levelSize;    
            for(int i=0;i<levelSize;i++){
                int node=q.poll();
                for(int x:adjList.get(node)){
                    id[x]--;
                    if(id[x]==1){
                     q.offer(x);
                    }
                }
            }
        }
                
        while(!q.isEmpty())
            res.add(q.poll());
        
        return res;
    }
}