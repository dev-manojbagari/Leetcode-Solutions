class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows= grid.length,cols = grid[0].length;
        boolean[][] vis = new boolean[rows][cols];
        int maxArea =0;
        int[] curArea = new int[1];
        curArea[0]=0;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(vis[i][j]==false){
                    dfs(i,j,grid,vis,curArea);
                    maxArea = Math.max(maxArea,curArea[0]);
                    curArea[0]=0;
                }
            }
        }
        
        return maxArea;
    }
    
    
    void dfs(int i,int j,int[][] grid,boolean[][] vis,int[] curArea){
        
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||vis[i][j]||grid[i][j]!=1)
            return;

        vis[i][j]=true;
        curArea[0]++;
                
        dfs(i+1,j,grid,vis,curArea);
        dfs(i,j+1,grid,vis,curArea);
        dfs(i-1,j,grid,vis,curArea);
        dfs(i,j-1,grid,vis,curArea);
        
        
    }
}