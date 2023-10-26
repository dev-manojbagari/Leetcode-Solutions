class Solution {
    int count=0;
    public int reversePairs(int[] nums) {
        mergeSort(0,nums.length-1,nums);
        return count;
    }
    
    void mergeSort(int start,int end,int[] nums){
        if(start>=end)
            return ;
        
        int mid = start+(end-start)/2;
        
        mergeSort(start,mid,nums);
        mergeSort(mid+1,end,nums);
        
        int i= start,j=mid+1;
        
        while(i<=mid){
            while(j <= end && nums[i]/2.0 > nums[j]){
                j++;
            }
            i++;
            count += j-mid-1;
        }
        
        
        sortedMerge(start,mid,end,nums);
    }
    
    void sortedMerge(int start,int mid,int end ,int[] nums){
        
        int[] L  = new int[mid-start+1];
        int[] R = new int[end-mid];
        
        for(int i=0;i<L.length;i++){
            L[i] = nums[start+i];
        }
        
        for(int i=0;i<R.length;i++){
            R[i] = nums[mid+1+i];
        }
        
        int i=0,j=0,k=start;
        
        while(i<L.length&&j<R.length){
            if(L[i]<=R[j]){
                nums[k++]=L[i++];
            }else
                nums[k++]=R[j++];
        }
        
        while(i<L.length){
                nums[k++]=L[i++];
        }
 
        while(j<R.length){
                nums[k++]=R[j++];
        }
    }
    
    
}