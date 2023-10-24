class Solution {
    public boolean isMatch(String s, String p) {
        return isMatch(0,0,s,p,new Boolean[s.length()+1][p.length()+1]);
    }
    
    private boolean isMatch(int i,int j,String s,String p,Boolean[][] dp){
        if(j==p.length())
            return i==s.length();
        if(i==s.length())
        {
            if(j+1<p.length()&&p.charAt(j+1)=='*'){
                return isMatch(i,j+2,s,p,dp);
            }else
                return false;
        }
        
        if(dp[i][j]!=null)
            return dp[i][j];
        
        
        boolean firstMatch = j<p.length()&&i<s.length()&&(p.charAt(j)=='.'||s.charAt(i)==p.charAt(j));
        
        
        if(j+1<p.length()&&p.charAt(j+1)=='*'){
            return dp[i][j]= isMatch(i,j+2,s,p,dp)||firstMatch&&isMatch(i+1,j,s,p,dp);
        }else
            return dp[i][j]= firstMatch&&isMatch(i+1,j+1,s,p,dp);
        
        
        
    }
}