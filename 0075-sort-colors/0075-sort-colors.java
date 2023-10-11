class Solution {
    public void sortColors(int[] nums) {
        int left=0,right=nums.length-1;
        int i=0;
        
        while(i<=right){
            if(nums[i]==0){
                swap(nums,i++,left++);
            }else if(nums[i]==2){
                swap(nums,i,right--);
            }else{
                i++;
            }
        }
        
    }
    
    void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}