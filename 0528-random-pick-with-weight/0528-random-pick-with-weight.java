class Solution {
    int[] preSum;
    Random random = new Random();
    int[] w;
    public Solution(int[] w) {
        this.w=w;
        preSum = new int[w.length];
        preSum[0]=w[0];
        for(int i=1;i<w.length;i++){
            preSum[i]= preSum[i-1]+w[i];
        }
        // System.out.println(Arrays.toString(preSum));
    }
    
    public int pickIndex() {
        
        int randomVal = random.nextInt(preSum[preSum.length-1])+1;
        int ceilingIndex = ceiling(preSum,randomVal);
        
        return ceilingIndex;
    }
    
    int ceiling(int[] preSum,int val){
        int left=0,right=preSum.length-1;
        int ans =-1;

        while(left<=right){
            int mid = left+(right-left)/2;
            
            if(val<=preSum[mid]){
                ans = mid;
                right= mid-1;
            }else{
                left = mid+1;
        }}
        
        return ans;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */