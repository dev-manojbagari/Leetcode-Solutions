class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0)
            return 0;
        int ans  = coinChange2(coins,amount,new Integer[amount+1]); 
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    
    int coinChange2(int[] coins,int amount,Integer[] dp){
         if(amount < 0){
            return Integer.MAX_VALUE;
        }
        
        if(amount == 0){
            return 0;
        }        

        if(dp[amount]!=null)
            return dp[amount];
        
        int minCoins = Integer.MAX_VALUE;

        for(int i=0; i<coins.length; i++){
            int res = coinChange2(coins,amount-coins[i],dp);
            
            // Ensure we don't overflow Integer.MAX_VALUE
            if(res != Integer.MAX_VALUE)
                minCoins = Math.min(minCoins,res+1);
        }

       return dp[amount] = minCoins;
    }
}