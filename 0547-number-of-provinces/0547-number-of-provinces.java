class Solution {
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> list= new ArrayList<>();
        int n = isConnected.length;
        for(int i=0;i<n;i++)
            list.add(new ArrayList<>());
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j&&isConnected[i][j]==1){
                    list.get(i).add(j);
                }
            }
        }
        
        boolean[] vis = new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                count++;
                dfs(i,list,vis);
            }
        }
        
        return count;
    }
    
    void dfs(int i,List<List<Integer>> list,boolean[] vis){
        vis[i]=true;
        for(int x:list.get(i)){
            if(!vis[x]){
                dfs(x,list,vis);
            }
        }
    }
}