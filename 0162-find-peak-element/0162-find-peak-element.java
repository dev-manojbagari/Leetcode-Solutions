class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n==1)
            return 0;
        int left=0,right=nums.length-1;
        
        if(nums[0]>nums[1])
            return 0;
        if(nums[n-2]<nums[n-1])
            return n-1;
        
        
        int ans=-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            
            if(mid>0&&nums[mid-1]<nums[mid]&&nums[mid]>nums[mid+1]){
                ans = mid;
                break;
            }else if(nums[mid]<nums[mid+1]){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        
        return ans;
    }
}