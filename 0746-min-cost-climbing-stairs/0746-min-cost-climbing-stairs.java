class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] minCost = new int[n+1];
        minCost[0] = 0;
        minCost[1]=cost[0];
        
        for(int i=2;i<=n;i++){
            minCost[i]= cost[i-1]+Math.min(minCost[i-1],minCost[i-2]);
        }
        return Math.min(minCost[n],minCost[n-1]);        
        
    }
}