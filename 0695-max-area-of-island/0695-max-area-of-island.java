class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    maxArea=Math.max(maxArea,dfs(i,j,grid,vis));
                }
            }
        }
            
            
        return maxArea;
    }
    
    int dfs(int i,int j,int[][] grid,boolean[][] vis){
        
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]==0||vis[i][j]==true)
            return 0;
        
        vis[i][j]=true;
        
        int a = dfs(i+1,j,grid,vis);
        int b = dfs(i,j+1,grid,vis);
        int c = dfs(i-1,j,grid,vis);
        int d = dfs(i,j-1,grid,vis);
        
        
        return 1+(a+b+c+d);
        
    }
    
    
}