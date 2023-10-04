class Solution {
    public int climbStairs(int n) {
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        int oneStepBefore =2;
        int twoStepBefore = 1;
        int total=0;
        for(int i=3;i<=n;i++){
            total = oneStepBefore+twoStepBefore;
            twoStepBefore = oneStepBefore;
            oneStepBefore =total;
        }
        
        return total;
    }
}