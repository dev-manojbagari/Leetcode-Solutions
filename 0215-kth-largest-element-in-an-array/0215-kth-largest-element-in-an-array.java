class Solution {
    public int findKthLargest(int[] nums, int k) {
        shuffle(nums);
        int left = 0,right=nums.length-1;
        int ans =0;
        while(left<=right){
            int index = quickSelect(nums,left,right);
            if(index==k-1){
                ans = nums[index];
                break;
            }
            else if(index<k-1){
                left=index+1;
            }else
                right = index-1;
        }
        
        
                
       return ans;
        
    }
    
    void shuffle(int nums[]){
        Random random = new Random();
        for(int i=nums.length-1;i>=0;i--){
            int index = random.nextInt(i+1);
            swap(nums,index,i);
        }
        
        
    }
    
    int quickSelect(int[] nums,int start,int end){
        int pivot = nums[end];
        
        for(int curr=start;curr<end;curr++){
            if(nums[curr]>pivot)
                swap(nums,curr,start++);
        }
        
        swap(nums,start,end);
        
        return start;
    }
    
    void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    
}