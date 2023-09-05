class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length,cols=matrix[0].length;
        int[][]dp = new int[rows][cols];
        int max=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(i==0||j==0)
                    dp[i][j]=matrix[i][j]-'0';
                else if(matrix[i][j]=='0')
                    dp[i][j]=0;
                else{
		            dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
                }
                max = Math.max(max,dp[i][j]);                
            }
        }
        
        return max*max;
    }
}