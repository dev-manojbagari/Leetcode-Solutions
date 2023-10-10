class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n =nums.length;
        int left=0,right=n-1;
        int ans = 0;
        while(left<=right){
            int index = quickSelect(left,right,nums);
            
            if(index==k-1){
                ans =nums[index];
                break;
            }else if(index<k-1){
                left = index+1;
            }else{
                right = index-1;
            }
        }
        
        return ans;
    }
    
    int quickSelect(int start,int end,int[] nums){
        int pivot = nums[end];
        for(int curr=start;curr<end;curr++){
            if(nums[curr]>pivot){
                swap(nums,curr,start++);
            }
        }
        swap(nums,start,end);
        
        return start;
        }
        
    void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j]=temp;
    }
    


    }
