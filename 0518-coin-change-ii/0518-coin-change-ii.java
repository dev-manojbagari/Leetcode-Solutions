class Solution {
    public int change(int amount, int[] coins) {
        return f(0,coins,amount,new Integer[coins.length+1][amount+1]);
    }
    
    int f(int index,int[] coins,int amount,Integer[][] state){
        if(amount==0)
            return 1;
        if(amount<0||index==coins.length)
            return 0;
        
        if(state[index][amount]!=null)
            return state[index][amount];
        
        int exclude = f(index+1,coins,amount,state);
        int include=0;
        if(coins[index]<=amount)
            include = f(index,coins,amount-coins[index],state);
        
        return state[index][amount]= include+exclude;
    }
    
}