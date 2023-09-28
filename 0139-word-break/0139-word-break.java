class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        return wordBreak(0,s,set,new Boolean[s.length()]);
    }
    
    private boolean wordBreak(int i,String s,Set<String> set,Boolean[] dp){
        if(i==s.length())
            return true;

        if(dp[i]!=null)
            return dp[i];
        
        for(int j=i;j<s.length();j++){
            if(set.contains(s.substring(i,j+1))){
                if(wordBreak(j+1,s,set,dp)){
                    return dp[i]=true;
                }
            }
        }
        
        return dp[i] =false;
    }
}