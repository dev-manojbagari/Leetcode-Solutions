class Solution {
    public boolean isMatch(String s, String p) {
        return isMatch(s,p,s.length()-1,p.length()-1,new Boolean[s.length()+1][p.length()+1]);
    }
    
    private boolean isMatch(String s,String p,int sl,int pl,Boolean[][] dp){
            if(pl==-1)
                return sl==-1;
            else if(sl==-1){
                if(allStars(p,pl))
                    return true;
                else
                    return false;
            }
        
        
        
        if(dp[sl][pl]!=null)
            return dp[sl][pl];
        boolean ans = false;
        if(s.charAt(sl)==p.charAt(pl)||p.charAt(pl)=='?')
            ans =isMatch(s,p,sl-1,pl-1,dp);
        else if(p.charAt(pl)=='*')
            ans = isMatch(s,p,sl,pl-1,dp)||isMatch(s,p,sl-1,pl,dp);
        else 
            ans= false;
        
        return dp[sl][pl]=ans;
    }
    
    boolean allStars(String str,int j){
        for(int i=j;i>=0;i--)
            if(str.charAt(i)!='*')
                return false;
        
        return true;
    }
    
    
}