class Solution {
    public int coinChange(int[] coins, int amount) {
               int ans =  change(0,amount ,coins,new Integer[coins.length+1][amount+1]);
        return ans ==Integer.MAX_VALUE-1?-1:ans;
    }
    
    int change(int index,int amount ,int[] coins,Integer[][] state){
        if(amount==0)
            return 0;

        if(amount<0||index==coins.length)
            return Integer.MAX_VALUE-1;
        
        if(state[index][amount]!=null)
            return state[index][amount];
        
        int exclude = change(index+1,amount,coins,state);
        int include = 1+change(index,amount-coins[index],coins,state);
        
        return state[index][amount]=Math.min(include,exclude);
    }
    
   
}