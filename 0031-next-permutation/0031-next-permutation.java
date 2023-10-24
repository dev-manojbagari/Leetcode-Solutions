class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i=n-2;;
        for(;i>=0;i--){
            if(nums[i]<nums[i+1]){
                break;
            }
        }
        
        if(i>=0){
                int  j = n-1;
            while(j>=0){
                if(nums[j]>nums[i]){
                    break;
                }
                j--;
            }
            
            int temp = nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
        
            reverse(nums,i+1,n-1);
            
        }
    
    
    void reverse(int[] nums,int i,int j){
        while(i<j){
            int temp = nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
    }
    
    
}