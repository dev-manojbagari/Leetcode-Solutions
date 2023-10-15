class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        boolean[] vis= new boolean[n];
        int[] color = new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++){
            if(vis[i]==false){
                color[i]=1;
                if(dfs(i,graph,vis,color)){
                    return false;
                }
        }
    }
        return true;
    }
    
    boolean dfs(int i,int[][] graph,boolean[] vis,int[] color){
        
        for(int x:graph[i]){
            if(vis[x]==false){
                vis[x]=true;
                color[x]=1-color[i];
                if(dfs(x,graph,vis,color)){
                    return true;
                }
            }else if(color[x]==color[i]){
                return true;
            }
        }
        
        return false;
    }
    
    
    
}