class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        return lcs(0,0,s1,s2,new Integer[s1.length()+1][s2.length()+1]);
    }
    
    int lcs(int i,int j,String s1,String s2,Integer[][] dp){
        if(i==s1.length()||j==s2.length())
            return 0;
        
        if(dp[i][j]!=null)
            return dp[i][j];
        
        
        if(s1.charAt(i)==s2.charAt(j))
            return dp[i][j] = 1+lcs(i+1,j+1,s1,s2,dp);
        else
            return dp[i][j]=Math.max(lcs(i+1,j,s1,s2,dp),lcs(i,j+1,s1,s2,dp));
    }
}