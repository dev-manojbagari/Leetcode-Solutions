class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        return f(0,0,0,s1.toCharArray(),s2.toCharArray(),s3.toCharArray(),s1.length(),s2.length(),s3.length(),new Boolean[s1.length()+1][s2.length()+1][s3.length()+1]);
    }
    
    boolean f(int i,int j,int k,char[] s1,char[] s2,char[] s3,int in,int jn,int kn,Boolean[][][] dp){
        if(i==in&&j==jn)
            return k==kn;
        
        if(dp[i][j][k]!=null)
            return dp[i][j][k];
        boolean ans=false;
        if(i<in&&j<jn&&k<kn&&s1[i]==s3[k]&&s2[j]==s3[k])
            ans= f(i+1,j,k+1,s1,s2,s3,in,jn,kn,dp)||f(i,j+1,k+1,s1,s2,s3,in,jn,kn,dp);
        else if(i<in&&k<kn&&s1[i]==s3[k]){
                ans= f(i+1,j,k+1,s1,s2,s3,in,jn,kn,dp);            
        }else if(j<jn&&k<kn&&s2[j]==s3[k]){
                ans=f(i,j+1,k+1,s1,s2,s3,in,jn,kn,dp);
        }else
            ans = false;
        
        return dp[i][j][k]=ans;
    }
}