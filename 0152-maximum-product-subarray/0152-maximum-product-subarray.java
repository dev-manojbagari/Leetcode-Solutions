class Solution {
    public int maxProduct(int[] nums) {
        int max=nums[0],min=nums[0],maxP=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]==0){
                max=0;
                min=0;
            }else if(nums[i]>0){
                max = Math.max(max*nums[i],nums[i]);
                min = Math.min(min*nums[i],nums[i]);
            }else{
                int t = max;
                max=min;
                min=t;
                
                max = Math.max(max*nums[i],nums[i]);
                min = Math.min(min*nums[i],nums[i]);
            }
            maxP = Math.max(maxP,max);
        }
        
        return maxP;
    }
}