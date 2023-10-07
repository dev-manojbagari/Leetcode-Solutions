class Solution {
    public int rob(int[] nums) {
        int curIncl = nums[0];
        int curExcl = 0;
        for(int i=1;i<nums.length;i++){
            int prevIncl = curIncl,prevExcl=curExcl;
            curIncl = Math.max(prevExcl+nums[i],prevIncl);
            curExcl = Math.max(prevIncl,prevExcl);
        }
        
        return Math.max(curIncl,curExcl);
    }
}