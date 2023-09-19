class Solution {
    public int findMin(int[] nums) {
        int left =0,right=nums.length-1;
        int ans = nums[0];
        while(left<=right){
            int mid = left+(right-left)/2;
            
            if(mid>0&&nums[mid-1]>nums[mid]){
                return nums[mid];
            }else if(nums[mid]<nums[right]){
                right=mid-1;
            }else
                left = mid+1;
            
        }
       return ans; 
        
    }
}