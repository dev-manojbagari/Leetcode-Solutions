class Solution {
    public boolean canFinish(int n, int[][] prereq) {
        List<List<Integer>> adjList = new ArrayList<>();
        int[] inDeg = new int[n];
        for(int i=0;i<n;i++)
            adjList.add(new ArrayList<>());
        
        for(int[] pre:prereq){
            adjList.get(pre[1]).add(pre[0]);
            inDeg[pre[0]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<inDeg.length;i++){
            if(inDeg[i]==0){
                q.offer(i);
            }
        }
        
        boolean[] vis= new boolean[n];
        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            vis[node]=true;
            list.add(node);
            for(int x:adjList.get(node)){
                if(!vis[x]){
                    inDeg[x]--;
                    if(inDeg[x]==0){
                        q.offer(x);
                    }
                }
            }
        }
        
        return list.size()==n; 
        
        
        
    }
}