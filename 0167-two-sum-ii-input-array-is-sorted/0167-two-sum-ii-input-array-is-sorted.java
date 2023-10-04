class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i=0,j=nums.length-1;
        int[] res  = new int[2];
        while(i<j){
            int sum = nums[i]+nums[j];
            
            if(sum==target){
                 res[0]=i+1;
                 res[1]=j+1;
                break;
            }else if(sum<target){
                i++;
                while(i<j&&nums[i]==nums[i-1])
                    i++;
            }else{
                j--;
                while(i<j&&nums[j]==nums[j+1])
                    j--;
            }
        }
        
        return res;
    }
}