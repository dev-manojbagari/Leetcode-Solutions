class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int dp1 = 0;
        int dp2 = 0;
        int ans = 0;
        for(int i=0;i<cost.length;i++){
            ans = Math.min(dp1,dp2)+cost[i];
            dp2=dp1;
            dp1=ans;
        }
        return Math.min(dp1,dp2);
    }
}