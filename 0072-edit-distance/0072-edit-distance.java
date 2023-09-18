class Solution {
    public int minDistance(String word1, String word2) {
        return minDistance(word1.length()-1,word2.length()-1,word1,word2,new Integer[word1.length()+1][word2.length()+1]);
    }
    
    int minDistance(int i,int j,String word1,String word2,Integer[][] state){
        if(i==-1&&j==-1)
            return 0;
        else if(i==-1&&j!=-1)
            return j+1;
        else if(i!=-1&&j==-1)
            return i+1;
        
        if(state[i][j]!=null)
            return state[i][j];
        
        
        
        if(word1.charAt(i)==word2.charAt(j))
            return state[i][j] = minDistance(i-1,j-1,word1,word2,state);
        else
            return  state[i][j] =1+Math.min(minDistance(i-1,j-1,word1,word2,state),Math.min(minDistance(i-1,j,word1,word2,state),minDistance(i,j-1,word1,word2,state)));
    }
}