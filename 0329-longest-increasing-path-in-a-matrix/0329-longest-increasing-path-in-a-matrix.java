class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int rows=matrix.length,cols=matrix[0].length;
        int max=1;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                max = Math.max(max,dfs(i,j,matrix,-1,new Integer[rows][cols]));
            }
        }
        
        return max;
    }
    
    int dfs(int i,int j,int[][] matrix,int prev,Integer[][] cache){
        
        if(i<0||i>=matrix.length||j<0||j>=matrix[0].length||prev>=matrix[i][j]){
            return 0;
        }
        
        if(cache[i][j]!=null)
            return cache[i][j];
        
        int a = 1+dfs(i+1,j,matrix,matrix[i][j],cache);
        int b = 1+dfs(i,j+1,matrix,matrix[i][j],cache);
        int c = 1+dfs(i-1,j,matrix,matrix[i][j],cache);
        int d = 1+dfs(i,j-1,matrix,matrix[i][j],cache);
        
        return cache[i][j]= Math.max(Math.max(a,b),Math.max(c,d));
    }
}