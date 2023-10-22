class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        dp[0]=triangle.get(0).get(0);
        
        for(int i=1;i<n;i++){
            for(int j=i;j>=0;j--){
                if(j==i){
                    dp[j]=dp[j-1]+triangle.get(i).get(j);
                }else if(j==0){
                    dp[j]=dp[j]+triangle.get(i).get(j);
                }else{
                    dp[j]=Math.min(dp[j],dp[j-1])+triangle.get(i).get(j);
                }
            }
        }
        
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
            ans = Math.min(ans,dp[i]);
        
        return ans;
    }
}