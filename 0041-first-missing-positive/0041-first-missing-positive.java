class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            while(1<=nums[i]&&nums[i]<=n){
                if(nums[nums[i]-1]!=nums[i]){
                    swap(nums,nums[i]-1,i);
                }else
                    break;
            }
        }
        
        for(int i=0;i<n;i++){
            if(nums[i]!=i+1)
                return i+1;
        }
        
        return n+1;
    }
    
    void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    
}