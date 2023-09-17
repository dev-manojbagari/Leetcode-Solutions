class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] minCost = new int[cost.length];
        int twoStepBefore=cost[0];
        int oneStepBefore=cost[1];
        
        for(int i=2;i<n;i++){
            int curStep= cost[i]+Math.min(oneStepBefore,twoStepBefore);
            twoStepBefore = oneStepBefore;
            oneStepBefore = curStep;
        }
        
        return Math.min(oneStepBefore,twoStepBefore);
    }
}