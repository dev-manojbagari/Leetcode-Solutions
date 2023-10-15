class Solution {
    public int minDistance(String word1, String word2) {
        return minDistance(word1.length()-1,word2.length()-1,word1,word2,new Integer[word1.length()][word2.length()]);
    }
    
    int minDistance(int i,int j,String word1,String word2,Integer[][] dp){
        if(i==-1)
            return j+1;
        
        if(j==-1)
            return i+1;
        if(dp[i][j]!=null)
            return dp[i][j];
        
        if(word1.charAt(i)==word2.charAt(j))
            return dp[i][j]=minDistance(i-1,j-1,word1,word2,dp);
        else
            return dp[i][j]= 1+Math.min(minDistance(i-1,j,word1,word2,dp),Math.min(minDistance(i-1,j-1,word1,word2,dp),minDistance(i,j-1,word1,word2,dp)));
    }
    
    
}