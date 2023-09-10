class Solution {
    public int minDistance(String word1, String word2) {
        return minDistance(word1.length()-1,word2.length()-1,word1,word2,new Integer[word1.length()][word2.length()]);
    }
    
    int minDistance(int i,int j,String word1,String word2,Integer[][] cache){
        if(j==-1){
            return i+1;
        }else if(i==-1){
            return j+1;
        }
        
        if(cache[i][j]!=null)
            return cache[i][j];
        
        int ans =0;
        if(word1.charAt(i)==word2.charAt(j))
            ans =minDistance(i-1,j-1,word1,word2,cache);
        else
            ans= Math.min(1+minDistance(i,j-1,word1,word2,cache),Math.min(1+minDistance(i-1,j,word1,word2,cache),1+minDistance(i-1,j-1,word1,word2,cache)));
        
        return cache[i][j]=ans;
    }
}