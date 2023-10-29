class Solution {
    public int[] findErrorNums(int[] nums) {
        int repeat=0,missing=0;
        for(int i=0;i<nums.length;i++){
            int index= Math.abs(nums[i])-1;
            if(nums[index]>0){
                nums[index]=-nums[index];
            }else{
                repeat=index+1;
            }
        }
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0)
            {
                missing = i+1;
                break;
            }
        }
        return new int[]{repeat,missing};
    }
}