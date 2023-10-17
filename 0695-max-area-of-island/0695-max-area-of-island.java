class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max=0;
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                max = Math.max(max,dfs(i,j,grid,vis));
            }
        }
        
        return max;
    }
    
    int dfs(int i,int j,int[][] grid,boolean[][] vis){
        
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]==0||vis[i][j])
            return 0;
        
        vis[i][j]=true;
        
        int a = dfs(i+1,j,grid,vis);
        int b = dfs(i,j+1,grid,vis);
        int c = dfs(i-1,j,grid,vis);
        int d = dfs(i,j-1,grid,vis);
        
        return a+b+c+d+1;
    }
    
    
    
}