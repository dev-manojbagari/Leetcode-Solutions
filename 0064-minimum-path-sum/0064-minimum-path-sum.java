class Solution {
    Integer[][] dp;
    public int minPathSum(int[][] grid) {
        int rows= grid.length,cols=grid[0].length;
        boolean[][] vis = new boolean[rows][cols];
        int[] minPathSum={Integer.MAX_VALUE};
        dp = new Integer[rows][cols];
        return dfs(0,0,0,grid,vis,minPathSum);        
        
    }
    
    int  dfs(int i,int j,int curSum,int[][] grid,boolean[][] vis,int[] minPathSum){
        if(i==grid.length-1&&j==grid[0].length-1){
            return grid[i][j];
        }
        
       if(i<0||i>=grid.length||j<0||j>=grid[0].length||vis[i][j])
           return Integer.MAX_VALUE;
        
        if(dp[i][j]!=null)
            return dp[i][j];
        
        
      int right =  dfs(i,j+1,curSum+grid[i][j],grid,vis,minPathSum);
      int down  =  dfs(i+1,j,curSum+grid[i][j],grid,vis,minPathSum);
        
      return dp[i][j] = Math.min(right,down)+grid[i][j];  
    }
}