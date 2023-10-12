class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if(n==1){
            res.add(0);
            return res;
        }
        List<List<Integer>> adjList = new ArrayList<>();
        
        for(int i=0;i<n;i++)
            adjList.add(new ArrayList<>());
        
        int[] inD = new int[n];
        
        for(int[] edge:edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
            inD[edge[0]]++;
            inD[edge[1]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        
        for(int i=0;i<n;i++){
            if(inD[i]==1){
                q.offer(i);
            }
        }
        
        while(n>2){
            int size = q.size();
            n = n-size;
            
            for(int i=0;i<size;i++){
                int node = q.poll();
                for(int x:adjList.get(node)){
                    inD[x]--;
                    if(inD[x]==1){
                        q.offer(x);
                    }
                }
            }
        }
        
        res.addAll(q);
        return res;
    }
}