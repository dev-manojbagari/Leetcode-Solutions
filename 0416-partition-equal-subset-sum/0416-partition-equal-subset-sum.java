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
            for(int index=0;index<=nums.length;index++){
                if(curSum==0)
                    dp[curSum][index]=true;
                else if(index==0)
                    dp[curSum][index]=false;
                else if(curSum-nums[index-1]>=0)
                    dp[curSum][index]= dp[curSum][index-1]||dp[curSum-nums[index-1]][index-1];
                else 
                    dp[curSum][index]= dp[curSum][index-1];
            }
        }
        
        return dp[targetSum][nums.length];
    }
}
