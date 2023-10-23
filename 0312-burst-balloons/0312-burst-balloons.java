class Solution {
    public int maxCoins(int[] nums) {
        int[] arr = new int[nums.length+2];
        arr[0]=1;
        arr[arr.length-1]=1;
        int index=1;
        for(int num:nums)
            arr[index++]=num;
        
        return maxCoins(1,arr.length-2,arr,new Integer[arr.length+1][arr.length+1]);
    }
    
    int maxCoins(int i,int j,int[] arr,Integer[][] dp){
        if(i>j)
            return 0;
        
        int max =Integer.MIN_VALUE;
        
        if(dp[i][j]!=null)
            return dp[i][j];
        
        for(int k=i;k<=j;k++){
            int ans = arr[i-1]*arr[k]*arr[j+1]+maxCoins(i,k-1,arr,dp)+maxCoins(k+1,j,arr,dp);
            max = Math.max(max,ans);
        }
        
        return dp[i][j]=max;
    }
}