class Solution {
    public int findMin(int[] nums) {
        int left =0,right=nums.length-1;
        int min = nums[0];
        while(left<=right){
             int mid = left+(right-left)/2;
                 
             if(mid>0&&nums[mid-1]>nums[mid]){
                 min = nums[mid];
                 break;
             }else if (nums[mid]<nums[right]){
                 right=mid-1;
             }else{
                 left=mid+1;
             }
        } 
       return min; 
        }
        
    }
