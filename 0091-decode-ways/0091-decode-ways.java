class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        char[] ca = s.toCharArray();
        int dp1=1,dp2=0;
        for(int i=n-1;i>=0;i--){
            int dp = ca[i]=='0'?0:dp1;
            if(i+1<n&&(ca[i]=='1'||ca[i]=='2'&&ca[i+1]<='6'))
                dp += dp2;
            dp2=dp1;
            dp1=dp;
        }
        
        return dp1;
    }
}