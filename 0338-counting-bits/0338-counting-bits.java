class Solution {
    public int[] countBits(int n) {
        int[] arr = new int[n+1];
        
        for(int i=0;i<=n;i++){
            arr[i]=countBitsUtil(i);
        }
        
        return arr;        
    }
    
    int countBitsUtil(int i){
        int count=0;
        for(int j=0;j<32;j++){
            if((i&1)==1)
                count++;
            i=i>>1;
        }
        return count;
    }
    
}