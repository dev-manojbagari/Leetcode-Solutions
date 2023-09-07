class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int dp1=0,dp2=0;
        int n= cost.length;
        for(int i=0;i<n;i++){
            int dp0 = cost[i]+Math.min(dp1,dp2);
            dp2=dp1;
            dp1=dp0;
        }
        
        return Math.min(dp1,dp2);
    }
}