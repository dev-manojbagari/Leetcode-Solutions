class Solution {
    public int longestPalindromeSubseq(String s) {
        return lcs(s,new StringBuilder(s).reverse().toString());    
    }
    
    public int lcs(String s1, String s2) {
     return lcs(s1.toCharArray(),s2.toCharArray(),new int[s1.length()+1][s2.length()+1]);   
    }
    
    int lcs(char[] s1,char[] s2,int[][] state){
       
        
        for(int i=1;i<=s1.length;i++){
            for(int j=1;j<=s2.length;j++){
                if(s1[i-1]==s2[j-1])
                    state[i][j]=1+state[i-1][j-1];
                else
                    state[i][j]=Math.max(state[i-1][j],state[i][j-1]);
            }
        }
        
        return state[s1.length][s2.length];
        
    }
}