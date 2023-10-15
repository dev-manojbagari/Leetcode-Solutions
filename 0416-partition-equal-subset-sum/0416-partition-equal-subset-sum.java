class Solution {
    public boolean canPartition(int[] nums) {
        int arraySum=0;
        for(int num:nums)
            arraySum+=num;
        if(arraySum%2!=0)
            return false;
        return canPartition(nums,arraySum/2);
    }
    
    boolean canPartition(int[] nums,int sum){
        
        boolean[][] dp = new boolean[nums.length][sum+1];        
       for(int index=0;index<nums.length;index++){ 
            for(int curSum=0;curSum<=sum;curSum++){
                if(curSum==0)
                    dp[index][curSum]=true;
                else if(index==0)
                    dp[index][curSum]=false;
                else{
                    if(curSum-nums[index]>=0)
                        dp[index][curSum] = dp[index-1][curSum]||dp[index-1][curSum-nums[index]];
                    else
                        dp[index][curSum] = dp[index-1][curSum];
                    
                }
         }
       }
        
        return dp[nums.length-1][sum];
        
    }
    
    
}