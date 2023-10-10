class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] L = new int[n];
        L[0]=0;
        int len=0;
        for(int i=0;i<n;i++){
            if(nums[i]<nums[L[0]]){
                L[0]=i;
            }else if(nums[L[len]]<nums[i]){
                len++;
                L[len]=i;
            }else{
                int ceilingIndex = ceiling(nums,0,len,L,nums[i]);
                L[ceilingIndex]=i;
            }
        }
        
        return len+1;
    }
    
    int ceiling(int[] nums,int left,int right,int[] L,int val){
        int ans = -1;
        while(left<=right){
            int mid = left+(right-left)/2;
            
            if(nums[L[mid]]>=val){
                ans = mid;
                right = mid-1;
            }else{
                left=mid+1;
            }
        }
        
        return ans;
    }
}