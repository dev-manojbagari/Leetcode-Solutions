class Solution {
    public int maxProduct(int[] nums) {
        int min =nums[0],max=nums[0],maxP=nums[0];
        
        for(int i=1;i<nums.length;i++){
            if(nums[i]==0){
                min=0;
                max=0;
            }else {
                if(nums[i]<0){
                    int temp = min;
                    min=max;
                    max=temp;
                }
                
                min = Math.min(nums[i],nums[i]*min);
                max = Math.max(nums[i],nums[i]*max);
            }
                maxP = Math.max(maxP,max); 
        }
        
        return maxP;
    }
}

