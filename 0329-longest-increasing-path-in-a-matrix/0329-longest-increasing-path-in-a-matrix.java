class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int rows= matrix.length,cols=matrix[0].length;
        //boolean[][] vis = new boolean[rows][cols];
        int max = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                max=Math.max(max,dfs(i,j,matrix,-1,0,new Integer[rows][cols]));
            }
        }
        
        return max;
    }
    
    int dfs(int i,int j,int[][] matrix,int prev,int len,Integer[][] dp){
        
        if(i<0||i>=matrix.length||j<0||j>=matrix[0].length||prev>=matrix[i][j])
            return 0;
        
        if(dp[i][j]!=null)
            return dp[i][j];
        
        // vis[i][j]=true;
        prev = matrix[i][j];
        int a = dfs(i+1,j,matrix,prev,len,dp);
        int b = dfs(i,j+1,matrix,prev,len,dp);
        int c = dfs(i-1,j,matrix,prev,len,dp);
        int d = dfs(i,j-1,matrix,prev,len,dp);
        
        // vis[i][j]=false;
        
        
        return dp[i][j]=1+Math.max(Math.max(a,b),Math.max(c,d));
    }
    
    
    
}