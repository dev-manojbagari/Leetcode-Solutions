class Solution {
    public boolean canPartition(int[] nums) {
        int arraySum = Arrays.stream(nums).sum();
        
        if(arraySum%2!=0)
            return false;
        
        return subsetSum(0,nums,arraySum/2);
    }
    
    private boolean subsetSum(int index,int[] nums,int sum){
        int n = nums.length;
        boolean[][] dp = new boolean[n][sum+1];
        
        for(int i=0;i<nums.length;i++){
            for(int curSum=0;curSum<=sum;curSum++){
                if(curSum==0)
                    dp[i][curSum]=true;
                else if(i==0)
                    dp[i][curSum]=false;
                else if(curSum-nums[i]>=0)
                    dp[i][curSum] = dp[i-1][curSum]||dp[i-1][curSum-nums[i]];
                else
                    dp[i][curSum]=dp[i-1][curSum];
            }
        }
        
        return dp[n-1][sum];
    }
}