class Solution {
    public int coinChange(int[] coins, int amount) {
        int ans =f(coins,amount,new Integer[amount+1]);
        return ans == Integer.MAX_VALUE-1?-1:ans;
    }
    
    int f(int[] coins,int amount,Integer[]state){
        if(amount==0)
            return 0;
        
        if(state[amount]!=null)
            return state[amount];
        
        int ans =Integer.MAX_VALUE-1;
        for(int i=0;i<coins.length;i++){
            if(amount-coins[i]>=0){
               ans = Math.min(ans,1+f(coins,amount-coins[i],state));
            }
        }
        
        
        return state[amount] = ans;
    }
    
}