class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = nums.length-2;
        while(i>=0){
            if(nums[i]<nums[i+1])
                break;
            i--;
        }
        if(i==-1){
            reverse(nums,i+1,n-1);
            return;
        }
        int j=nums.length-1;
        
        while(j>=0&&j>i){
            if(nums[j]>nums[i])
                break;
            j--;
        }
        
        swap(nums,i,j);
        reverse(nums,i+1,n-1);
        
    }
    
    void reverse(int[] nums,int left,int right){
        while(left<right){
            int temp = nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
    }
    
    
    void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}