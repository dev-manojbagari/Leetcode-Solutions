class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        for(int i=0;i<nums.length;i++){
            int val = Math.abs(nums[i]);
            int index = val-1;
            if(nums[index]>0){
                nums[index]*=-1;
            }else{
                res[0]=val;
            }
        }
        
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                res[1]=i+1;
                break;
            }
        }
        
        return res;
    }
}