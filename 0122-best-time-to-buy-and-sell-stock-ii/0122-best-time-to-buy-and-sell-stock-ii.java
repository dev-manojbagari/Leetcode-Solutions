class Solution {
  public int maxProfit(int[] prices) {
        if(prices.length<=1)
            return 0;
        int maxProfit = maxProfit(0,prices,0,0,new Integer[prices.length][2]);
        return maxProfit<0?0:maxProfit;
    }
    
    private int maxProfit(int i,int[] prices,int bought,int trx,Integer[][] dp){
        if(i==prices.length)
        {
            return bought==1?-10000:0;
        }
        
        if(dp[i][bought]!=null)
            return dp[i][bought];
        
        int ans =0;
        if(bought==0){
            ans= Math.max(maxProfit(i+1,prices,bought,trx,dp),-prices[i]+maxProfit(i+1,prices,1-bought,trx,dp));
        }else{
            ans= Math.max(maxProfit(i+1,prices,bought,trx,dp),prices[i]+maxProfit(i+1,prices,1-bought,trx+1,dp));
        }
        
        return dp[i][bought]=ans;
        
    }
}