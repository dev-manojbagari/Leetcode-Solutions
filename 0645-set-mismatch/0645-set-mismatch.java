class Solution {
    public int[] findErrorNums(int[] nums) {
        int repeating = 0;
        for(int i=0;i<nums.length;i++){
            int idx = Math.abs(nums[i])-1;
            if(nums[idx]<0){
                repeating = idx+1;
            }else{
                nums[idx] = -1*nums[idx];
            }
        }
        
        int missing=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0)
            {
                missing= i+1;
                break;
            }
        }
        
        return new int[]{repeating,missing};
        
    }
}