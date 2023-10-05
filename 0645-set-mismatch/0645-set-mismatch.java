class Solution {
    public int[] findErrorNums(int[] nums) {
        int repeating=-1,missing=-1;
        int n = nums.length;
        
        for(int i=0;i<n;i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index]>0){
                nums[index]*=-1;
            }else
                repeating = index+1;
        }
        
        
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                missing=i+1;
                break;
            }
        }
        
        return new int[]{repeating,missing};
        
    }
}