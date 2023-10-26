class Solution {
    public int coinChange(int[] coins, int amount) {
        int ans =f(0,coins,amount,new Integer[coins.length+1][amount+1]);
        return ans == Integer.MAX_VALUE-1?-1:ans;
    }
    

    
        int f(int index,int[] coins,int amount,Integer[][] state){
        if(amount==0)
            return 0;
        if(amount<0||index==coins.length)
            return Integer.MAX_VALUE-1;
        
        if(state[index][amount]!=null)
            return state[index][amount];
        
        int exclude = f(index+1,coins,amount,state);
        int include=Integer.MAX_VALUE;
        if(coins[index]<=amount)
            include = 1+f(index,coins,amount-coins[index],state);
        
        return state[index][amount]= Math.min(include,exclude);
    }
    
}