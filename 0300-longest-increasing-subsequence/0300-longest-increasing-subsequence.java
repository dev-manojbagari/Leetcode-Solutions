class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] L = new int[n];
        int maxL = 0;

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]&&L[j]+1>L[i]){
                    L[i]= 1+L[j];
                    maxL = Math.max(maxL,L[i]);
                }
            }
        }
            
       return maxL+1; 
    }
}