class Solution {
    public boolean canFinish(int n, int[][] p) {
        List<List<Integer>> adjList = new ArrayList<>();
        
        for(int i=0;i<n;i++)
            adjList.add(new ArrayList<>());
        
        int[] inDegree = new int[n];
        for(int i=0;i<p.length;i++){
            adjList.get(p[i][1]).add(p[i][0]);
            inDegree[p[i][0]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i]==0)
                q.offer(i);
        }
        
        List<Integer> topoSort = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            topoSort.add(node);
            for(int x:adjList.get(node))
            {
                inDegree[x]--;
                if(inDegree[x]==0)
                {
                    q.offer(x);
                }
            }
        }
        
        return topoSort.size()==n;
    }
}