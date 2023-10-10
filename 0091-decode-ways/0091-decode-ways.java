class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        char[] ca = s.toCharArray();
        int[] dp = new int[n+1];
        dp[n]=1;
        
        for(int i=n-1;i>=0;i--){
            if(ca[i]!='0'){
            dp[i] =dp[i+1];
            if(i+1<n&&(ca[i]=='1'||ca[i]=='2'&&ca[i+1]<='6'))
                dp[i] += dp[i+2];
            }
        }
        
        return dp[0];
    }
}