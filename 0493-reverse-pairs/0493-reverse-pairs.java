class Solution {
    record Pair(int index,int val){};
    int[] res;
   int count=0;
    public int reversePairs(int[] nums) {
        Pair[] pairs = new Pair[nums.length];
        
        for(int i=0;i<nums.length;i++){
            pairs[i]= new Pair(i,nums[i]);
        }
        
        res = new int[nums.length];
        
        mergeSort(0,pairs.length-1,pairs);
        
        return count;
    }
    

    
    void mergeSort(int start,int end,Pair[] pairs){
        if(start>=end)
            return;
        
        int mid = start+(end-start)/2;
        
        mergeSort(start,mid,pairs);
        mergeSort(mid+1,end,pairs);
        
        int i=start,j=mid+1;
        
        while(i<=mid){
            
            while(j<=end&&(pairs[i].val/2.0)>pairs[j].val)
                j++;
            
            count+= j-(mid+1);
            i++;
        }
        
        
        
        sortedMerge(start,mid,end,pairs);
    }
    
    void sortedMerge(int start,int mid,int end,Pair[] pairs){
        Pair[] L = new Pair[mid-start+1];        
        Pair[] R = new Pair[end-mid];        
        
        for(int i=0;i<L.length;i++){
            L[i]=pairs[start+i];
        }
        
        for(int i=0;i<R.length;i++){
            R[i]=pairs[mid+1+i];
        }
        
        int i=0,j=0,k=start;
        
        while(i<L.length&&j<R.length){
            if(L[i].val()<=R[j].val()){
                res[L[i].index]+=j;
                pairs[k]=L[i];
                i++;
                k++;
            }else{
                pairs[k]=R[j];
                j++;
                k++;
            }
        }
        
        while(i<L.length){
             res[L[i].index]+=j;
             pairs[k++]=L[i++];
        }
        
        while(j<R.length){
             pairs[k++]=R[j++];
        }
    }
}