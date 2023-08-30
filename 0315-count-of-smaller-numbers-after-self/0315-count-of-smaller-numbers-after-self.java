class Solution {
    class Pair{
        int index,value;
        Pair(int index,int value){
            this.index=index;
            this.value=value;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        Pair[] pair = new Pair[nums.length];
        for(int i=0;i<nums.length;i++){
            pair[i] = new Pair(i,nums[i]);
        }
        int[] countSmaller = new int[nums.length];

        mergeSort(pair,0,pair.length-1,countSmaller);

        return Arrays.stream(countSmaller).boxed().toList();
    }
    
    void mergeSort(Pair[] pair,int start,int end,int[] cs){
        if(start>=end)
            return;
        
        int mid = start+(end-start)/2;
        
        mergeSort(pair,start,mid    ,cs);
        mergeSort(pair,mid+1,end,cs);
        
        sortedMerge(pair,start,mid,end,cs);
    }
    
    void sortedMerge(Pair[] pair ,int start,int mid,int end ,int[] cs){
        Pair L[] = new Pair[mid-start+1];
        Pair R[] = new Pair[end-mid];
        
        for(int i=0;i<L.length;i++)
            L[i]= pair[start+i];
        
        
        for(int i=0;i<R.length;i++)
            R[i]= pair[mid+1+i];
        
        
        int i=0,j=0,k=start;
        
        while(i<L.length&&j<R.length){
            if(L[i].value<=R[j].value){
                cs[L[i].index]+=j;
                pair[k++]=L[i++];
            }else{
                pair[k]=R[j];
                j++;
                k++;
            }
        }
        
        while(i<L.length){
            cs[L[i].index]+=j;
            pair[k++] = L[i++];
        }
       
       while(j<R.length)
            pair[k++] = R[j++];
        
    }
}