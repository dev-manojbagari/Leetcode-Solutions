class Solution {
    public int numSquares(int n) {
        return f(n,new Integer[n+1]);
    }
    
    int f(int n,Integer[] dp){
        if(n==0)
            return 0;
        if(dp[n]!=null)
            return dp[n];
        int min = n;
        for(int i=1;i*i<=n;i++){
            min = Math.min(min,1+f(n-(i*i),dp));
        }
        
        
        return dp[n] = min;
    }
    
    
}