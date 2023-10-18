class Solution {
    class Pair{
        int val,index;
        Pair(int val,int index){
            this.val=val;
            this.index=index;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        int n =nums.length;
        Pair[] pairs = new Pair[n];
        
        for(int i=0;i<n;i++)
            pairs[i]=new Pair(nums[i],i);
        int[] res = new int[n];
        mergeSort(pairs,0,n-1,res);
        return Arrays.stream(res).boxed().toList();
    }
    
    void mergeSort(Pair[] pairs,int start,int end,int[] res){
        if(start>=end)
            return;
        
        int mid = start+(end-start)/2;
        mergeSort(pairs,start,mid,res);
        mergeSort(pairs,mid+1,end,res);
        
        sortedMerge(pairs,start,mid,end,res);        
    }
    
    void sortedMerge(Pair[] pairs,int start,int mid,int end,int[] res){
        
        Pair[] L = new Pair[mid-start+1];
        Pair[] R = new Pair[end-mid];
        
        for(int i=0;i<L.length;i++)
            L[i] = pairs[start+i];
        
        for(int i=0;i<R.length;i++)
            R[i] = pairs[mid+1+i];
        int i=0,j=0,k=start;
        
        while(i<L.length&&j<R.length){
            if(L[i].val<=R[j].val){
                res[L[i].index]+=j;
                pairs[k++] = L[i++];
            }else{
                pairs[k++]=R[j++];
            }
        }
        
        while(j<R.length){
            pairs[k++]=R[j++];
         }
        while(i<L.length){
            res[L[i].index]+=j;
             pairs[k++]=L[i++];
        }

    }
}