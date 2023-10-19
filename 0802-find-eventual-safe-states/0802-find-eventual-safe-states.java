class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean[] vis = new boolean[n];
        boolean[] pathVis = new boolean[n];
       
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i,graph,vis,pathVis);
            }
        }
        List<Integer> list = new ArrayList<>();
        
        for(int i=0;i<n;i++)
            if(!pathVis[i])
                list.add(i);
        return list;
    }
    
    boolean dfs(int i,int[][] graph,boolean[] vis,boolean[] pathVis){
        vis[i]=true;
        pathVis[i]=true;
        
          for(int x:graph[i]){
            if(!vis[x]){
                if(dfs(x,graph,vis,pathVis))
                    return true;
                
            }else if(pathVis[x]==true)
                return true;
        }
        
        pathVis[i]=false;
        return false;
    }
}