class Solution {
    public boolean isMatch(String s, String p) {
        return isMatch(s,p,0,0,new Boolean[s.length()+1][p.length()+1]);
    }
    
    boolean isMatch(String s,String p,int sl,int pl,Boolean[][] dp){
         if(sl==s.length()&&pl==p.length())
            return true;
        else if(sl!=s.length()&&pl==p.length())
            return false;
        else if(sl==s.length()&&pl!=p.length()){
            if(pl+1<p.length()&&p.charAt(pl+1)=='*')
                return isMatch(s,p,sl,pl+2,dp);
            else
                return false;
        }
        
        boolean ans = false;
        boolean firstMatch = s.charAt(sl)==p.charAt(pl)||p.charAt(pl)=='.';
        
        if(pl+1<p.length()&&p.charAt(pl+1)=='*'){
           ans = isMatch(s,p,sl,pl+2,dp)||(firstMatch&&isMatch(s,p,sl+1,pl,dp));
        }else
            ans= firstMatch&&isMatch(s,p,sl+1,pl+1,dp);
                
        
         return dp[sl][pl]=ans;
    
}

}