class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1)
            return Arrays.asList(0);    
        List<List<Integer>> adjList = new ArrayList<>();
        
        for(int i=0;i<n;i++)
            adjList.add(new ArrayList<>());
        
        int[] inDegree = new int[n];
        
        for(int i=0;i<edges.length;i++)
        {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
            inDegree[edges[i][0]]++;
            inDegree[edges[i][1]]++;
        }
        
        Queue<Integer> q  = new LinkedList<>();
        
        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i]==1)
                q.add(i);
        }
        
        while(n>2){
            int size  = q.size();
            n = n-size;
            for(int i=0;i<size;i++){
                int node = q.poll();
                for(int x:adjList.get(node)){
                     inDegree[x]--;
                    if(inDegree[x]==1){
                        q.add(x);
                    }
                }
            }
        }
        
        List<Integer> res = new ArrayList<>();
        res.addAll(q);
        
        return res;
        
        
    }
}