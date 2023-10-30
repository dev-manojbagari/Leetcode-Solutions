class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
     return lcs(0,0,s1.toCharArray(),s2.toCharArray(),new Integer[s1.length()][s2.length()]);   
    }
    
    int lcs(int i,int j,char[] s1,char[] s2,Integer[][] state){
        if(i==s1.length||j==s2.length)
            return 0;
        
        if(state[i][j]!=null)
            return state[i][j];
        
        if(s1[i]==s2[j])
            return state[i][j]= 1+lcs(i+1,j+1,s1,s2,state);
        else
            return state[i][j]= Math.max(lcs(i+1,j,s1,s2,state),lcs(i,j+1,s1,s2,state));
        
    }
}