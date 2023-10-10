class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<Integer> set = new HashSet(wordDict);
                
        return wordBreak(0,s,wordDict,set,new Boolean[s.length()]);
    }
    
    boolean wordBreak(int index,String s,List<String> wordDict,Set<Integer> set,Boolean[] dp){
        if(index==s.length())
            return true;
        
        if(dp[index]!=null)
            return dp[index];
        
        for(int i=index;i<s.length();i++){
            if(set.contains(s.substring(index,i+1))){
                if(wordBreak(i+1,s,wordDict,set,dp)){
                    return dp[index]=true;
                }
            }
        }
        
        return dp[index]=false;
    }
    
}