class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int dp1=0;
        int dp2=0;
        for(int i=0;i<cost.length;i++){
            int dp = cost[i]+Math.min(dp1,dp2);
            dp2=dp1;
            dp1=dp;
        }
        
        return Math.min(dp1,dp2);
    }
}