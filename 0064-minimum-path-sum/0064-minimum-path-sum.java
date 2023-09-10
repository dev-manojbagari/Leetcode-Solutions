class Solution {
    Integer[][] dp;
    public int minPathSum(int[][] grid) {
        int rows= grid.length,cols=grid[0].length;
        dp = new Integer[rows][cols];
        return dfs(0,0,grid);        
        
    }
    
    int  dfs(int i,int j,int[][] grid){
        if(i==grid.length-1&&j==grid[0].length-1){
            return grid[i][j];
        }
        
       if(i<0||i>=grid.length||j<0||j>=grid[0].length)
           return Integer.MAX_VALUE;
        
        if(dp[i][j]!=null)
            return dp[i][j];
        
        
      int right =  dfs(i,j+1,grid);
      int down  =  dfs(i+1,j,grid);
        
      return dp[i][j] = Math.min(right,down)+grid[i][j];  
    }
}