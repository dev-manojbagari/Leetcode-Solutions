class Solution {
    public int coinChange(int[] coins, int amount) {
        int n= coins.length;
        int dp[] = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE-1);
        dp[0]=0;
        
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                if(i-coins[j]>=0)
                    dp[i] = Math.min(dp[i],1+dp[i-coins[j]]);
                
            }
        }
        
        return dp[amount]==Integer.MAX_VALUE-1?-1:dp[amount];
    }
}