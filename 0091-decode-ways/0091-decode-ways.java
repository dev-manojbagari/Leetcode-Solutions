class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0)=='0')
            return 0;
        return numDecodings(0,s,new Integer[s.length()]);
    }
    
    int numDecodings(int index,String s,Integer[] dp){
        if(index>s.length())
            return 0;
        if(index==s.length())
            return 1;
        
        if(s.charAt(index)=='0')
            return 0;
        
        if(dp[index]!=null)
            return dp[index];
        
        int ans = 0;
        
        ans += numDecodings(index+1,s,dp);
        
        if(s.charAt(index)=='1'||(index+1<s.length()&&s.charAt(index)=='2'&&s.charAt(index+1)<='6'))
            ans += numDecodings(index+2,s,dp);
        
        
        return dp[index]=ans;
        
        
    }
    
    
}