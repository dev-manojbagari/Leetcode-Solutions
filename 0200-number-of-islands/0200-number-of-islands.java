class Solution {
    public int numIslands(char[][] grid) {
        int rows=grid.length,cols=grid[0].length;
        int islands=0;
        boolean[][] vis = new boolean[rows][cols];
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]=='1'&&vis[i][j]==false){
                    islands++;
                    dfs(i,j,grid,vis);
                }
            }
        }
        
        return islands;
    }
    
    
    void dfs(int i,int j,char[][] grid,boolean[][] vis){
        
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||vis[i][j]||grid[i][j]=='0')
            return;
        vis[i][j]=true;
        
        dfs(i+1,j,grid,vis);
        dfs(i,j+1,grid,vis);
        dfs(i-1,j,grid,vis);
        dfs(i,j-1,grid,vis);
    }
}