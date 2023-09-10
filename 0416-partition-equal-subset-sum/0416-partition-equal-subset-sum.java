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
            for(int j=0;j<=sum;j++){
                if(j==0)
                    dp[i][j]=true;
                else if(i==0)
                    dp[i][j]=false;
                else if(j-nums[i]>=0)
                    dp[i][j] = dp[i-1][j]||dp[i-1][j-nums[i]];
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        
        return dp[n-1][sum];
    }
}