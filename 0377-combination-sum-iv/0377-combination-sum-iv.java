class Solution {
    public int combinationSum4(int[] nums, int target) {
     
        int[] dp = new int[target+1];
        dp[0] = 1;
        
        for(int i=1;i<=target;i++){
            for(int j=0;j<nums.length;j++){
                if(i-nums[j]>=0){
                dp[i] +=dp[i-nums[j]];                    
                    
                }
            }
        }
        
        return dp[target];
        
    }
    
    int f(int[] nums,int target,Integer[] cache){
        if(target==0)
            return 1;
        if(cache[target]!=null)
            return cache[target];
        
        int ans =0;
        for(int i=0;i<nums.length;i++){
            if(target-nums[i]>=0){
                ans += f(nums,target-nums[i],cache);
            }
        }

        return cache[target] = ans;
    }
}