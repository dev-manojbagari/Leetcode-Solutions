class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] L = new int[n];
        L[0]=1;
        for(int i=1;i<n;i++){
            L[i] = L[i-1]*nums[i-1];
        }
        
        int[] R = new int[n];
        R[n-1]=1;
        
        for(int i=n-2;i>=0;i--){
            R[i] = R[i+1]*nums[i+1];
        }
        int res[] = new int[n];
        for(int i=0;i<n;i++)
            res[i] = L[i]*R[i];
        
        return res;
    }
}