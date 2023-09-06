class Solution {
    int prefixSum[];
    Random random = new Random();
    int n=0;
    int arraySum=0;
    public Solution(int[] w) {
        n=w.length;
        prefixSum = new int[w.length];
        prefixSum[0] = w[0];
        for(int i=1;i<n;i++){
            prefixSum[i]+= w[i]+prefixSum[i-1];
        }
        arraySum = prefixSum[n-1];
    }
    
    public int pickIndex() {
        int randomSum = random.nextInt(arraySum)+1;
        return binarySearch(prefixSum,randomSum);
    }
    
    int binarySearch(int[] nums,int val){
        int left=0,right=n-1;
        int ans =-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]>=val){
                ans = mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        
        return ans;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */