class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE-1);
        dp[0]=0;
        
        
        for(int j=1;j<=n;j++)
            for(int i=1;i*i<=j;i++){
                dp[j] = Math.min(dp[j],1+dp[j-i*i]);
            }
        
      return dp[n];
    }
    
}