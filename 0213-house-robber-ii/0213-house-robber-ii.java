class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1)
            return nums[0];
        return Math.max(rob(nums,0,n-2),rob(nums,1,n-1));
    }
    
      public int rob(int[] nums,int start,int end) {
        int curIncl = nums[start];
        int curExcl = 0;
        for(int i=start+1;i<=end;i++){
            int prevIncl = curIncl,prevExcl=curExcl;
            curIncl = Math.max(prevExcl+nums[i],prevIncl);
            curExcl = Math.max(prevIncl,prevExcl);
        }
        
        return Math.max(curIncl,curExcl);
    }
}