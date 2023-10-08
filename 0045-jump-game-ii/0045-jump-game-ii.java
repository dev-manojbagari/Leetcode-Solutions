class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n==1)
            return 0;
        int steps = nums[0];
        int maxReach = nums[0];
        int jump=1;
        for(int i=1;i<n-1;i++){
            maxReach = Math.max(maxReach,i+nums[i]);
            steps--;
            if(steps==0){
                steps = maxReach-i;
                jump++;
            }
        }
        
        return jump;
    } 
}