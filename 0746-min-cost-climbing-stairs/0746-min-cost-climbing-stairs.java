class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp1=0,dp2=0;
        int minCost=0;    
        for(int i=0;i<n;i++){
            minCost = cost[i]+Math.min(dp1,dp2);
            dp2=dp1;
            dp1=minCost;
        }
        
        return Math.min(dp1,dp2);
    }
}