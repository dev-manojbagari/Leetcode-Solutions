class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int maxLen =1;
        int rows=matrix.length;
        int cols = matrix[0].length;
        boolean[][] vis = new boolean[rows][cols];    
        int[][] cache = new int[rows][cols];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                maxLen = Math.max(maxLen,dfs(i,j,matrix,vis,-1,0,cache));
            }
        }
        
        return maxLen;
    }
    
    int dfs(int i,int j,int[][] matrix,boolean[][] vis,int prev,int curLen,int[][] cache){
        
        if(i<0||i>=matrix.length||j<0||j>=matrix[0].length||vis[i][j]||prev>=matrix[i][j])
            return 0;
        
         if(cache[i][j]!=0)
             return cache[i][j];
        
        
        vis[i][j]=true;
        
        int a= dfs(i+1,j,matrix,vis,matrix[i][j],curLen,cache)+1;
        int b= dfs(i,j+1,matrix,vis,matrix[i][j],curLen,cache)+1;
        int c= dfs(i-1,j,matrix,vis,matrix[i][j],curLen,cache)+1;
        int d= dfs(i,j-1,matrix,vis,matrix[i][j],curLen,cache)+1;
        
        vis[i][j]=false;

        return cache[i][j]=Math.max(Math.max(a,b),Math.max(c,d));
        
    }
    
    
    
    
    
    
    
}