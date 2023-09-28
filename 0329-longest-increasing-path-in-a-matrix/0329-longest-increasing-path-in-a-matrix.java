class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int rows= matrix.length,cols=matrix[0].length;
        boolean[][] vis = new boolean[rows][cols];
        int max = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                max=Math.max(max,dfs(i,j,matrix,vis,-1,0,new Integer[rows][cols]));
            }
        }
        
        return max;
    }
    
    int dfs(int i,int j,int[][] matrix,boolean[][] vis,int prev,int len,Integer[][] dp){
        
        if(i<0||i>=matrix.length||j<0||j>=matrix[0].length||vis[i][j]||prev>=matrix[i][j])
            return 0;
        
        if(dp[i][j]!=null)
            return dp[i][j];
        
        vis[i][j]=true;
        prev = matrix[i][j];
        int a = 1+dfs(i+1,j,matrix,vis,prev,len,dp);
        int b = 1+dfs(i,j+1,matrix,vis,prev,len,dp);
        int c = 1+dfs(i-1,j,matrix,vis,prev,len,dp);
        int d = 1+dfs(i,j-1,matrix,vis,prev,len,dp);
        
        vis[i][j]=false;
        
        
        return dp[i][j]=Math.max(Math.max(a,b),Math.max(c,d));
    }
    
    
    
}