class Solution {
    public boolean canPartition(int[] nums) {
        int arraySum = Arrays.stream(nums).sum();
        if(arraySum%2!=0)
            return false;
        return canPartition(nums,arraySum/2);
    }
    
    boolean canPartition(int[] nums,int targetSum){
        
        boolean[][] dp = new boolean[targetSum+1][nums.length+1];
        
        for(int curSum=0;curSum<targetSum+1;curSum++){
            for(int curLen=0;curLen<=nums.length;curLen++){
                if(curSum==0)
                    dp[curSum][curLen]=true;
                else if(curLen==0)
                    dp[curSum][curLen]=false;
                else if(curSum-nums[curLen-1]>=0)
                    dp[curSum][curLen]= dp[curSum][curLen-1]||dp[curSum-nums[curLen-1]][curLen-1];
                else 
                    dp[curSum][curLen]= dp[curSum][curLen-1];
            }
        }
        
        return dp[targetSum][nums.length];
    }
}
