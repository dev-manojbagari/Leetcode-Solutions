class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        for(int i=0;i<n;i++){
            int index=binarySearch(numbers,i+1,n-1,target-numbers[i]);
            if(index!=-1)
            return new int[]{i+1,index+1};
        }
        
        return new int[]{-1,-1};
    }
    
    int binarySearch(int[] nums,int left,int right,int val){
        
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==val)
                return mid;
            else if(nums[mid]<val)
                left =mid+1;
            else
                right = mid-1;
        }
        return -1;
    }
}