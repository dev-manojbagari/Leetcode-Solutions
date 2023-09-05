class Solution {
    public int combinationSum4(int[] nums, int target) {
        return f(nums,target,new Integer[target+1]);
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