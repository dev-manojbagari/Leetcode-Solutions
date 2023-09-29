class Solution {
    public int numDistinct(String s, String t) {
        if(t.length()>s.length())
            return 0;
        return numDistinct(0,0,s,t,new Integer[s.length()+1][t.length()+1]);
    }
    
    int numDistinct(int i,int j,String s,String t,Integer[][] dp){
        if(j==t.length())
            return 1;
        if(i==s.length())
            return 0;
        
        if(dp[i][j]!=null)
            return dp[i][j];
            
        
        if(s.charAt(i)!=t .charAt(j)){
            dp[i][j]=numDistinct(i+1,j,s,t,dp);
        }else{
            dp[i][j]=numDistinct(i+1,j+1,s,t,dp)+numDistinct(i+1,j,s,t,dp);
        }        
        
        return dp[i][j];
    }
    
}