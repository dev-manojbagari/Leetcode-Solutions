class Solution {
    public int reversePairs(int[] nums) {
       return mergeSort(nums,0,nums.length-1);
        
    }
    
    int mergeSort(int[] nums,int left,int right){
        if(left>=right)
            return 0;
        
        int mid = left+(right-left)/2;
        int count=0;    
     count += mergeSort(nums,left,mid);
     count += mergeSort(nums,mid+1,right);
       
        int i=left,j=mid+1;
        
        while(i<=mid){
            
            while(j<=right&&nums[i]/2.0>nums[j])
                j++;
            
            count += j-(mid+1);
            i++;
            
        }
       Arrays.sort(nums, left, right+1);
        //    sortedMerge(nums,left,mid,right);
         return count;
    }
    
    void sortedMerge(int[] nums,int left,int mid,int right){

        int[] L = new int[mid-left+1];
        int[] R = new int[right-mid];
        
        for(int i=0;i<L.length;i++)
            L[i]= nums[left+i];
        
        for(int i=0;i<R.length;i++)
            R[i]= nums[mid+1+i];
        
        int i=0,j=0,k=left;
        
        while(i<L.length&&j<R.length){
            if(L[i]<=R[j])
                nums[k++] =L[i++];
            else
                nums[k++] =R[j++];
        }
        
        while(i<L.length)
            nums[k++] =L[i++];
        
        while(j<R.length)
                nums[k++] =R[j++];
    }
}