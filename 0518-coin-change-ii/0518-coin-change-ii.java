class Solution {
    public int change(int amount, int[] coins) {
        return change(0,amount ,coins,new Integer[coins.length+1][amount+1]);
    }
    
    int change(int index,int amount ,int[] coins,Integer[][] state){
        if(amount==0)
            return 1;

        if(amount<0||index==coins.length)
            return 0;
        
        if(state[index][amount]!=null)
            return state[index][amount];
        
        int ans = 0;
        ans += change(index+1,amount,coins,state);
        ans +=change(index,amount-coins[index],coins,state);
        
        return state[index][amount]=ans;
    }
    
    
}