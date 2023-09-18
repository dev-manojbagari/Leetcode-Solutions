class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        
        int i= n-2;
        while(i>=0&&nums[i]>=nums[i+1])
            i--;
        
        if(i==-1)
        {
            reverse(nums,0,n-1);
            return;
        }
        int j= n-1;
        
        while(j>i&&nums[j]<=nums[i])
            j--;
        
        swap(nums,i,j);
        reverse(nums,i+1,n-1);
        
        return;
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
    
    void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}