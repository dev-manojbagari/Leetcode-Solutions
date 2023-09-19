class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        return isInterleave(0,0,0,s1,s2,s3,new Boolean[s1.length()+1][s2.length()+1][s3.length()+1]);
    }
    
    private boolean isInterleave(int i,int j,int k,String s1,String s2,String s3,Boolean[][][] state){
        if(i==s1.length()&&j==s2.length()&&k==s3.length())
            return true;
        
        if(state[i][j][k]!=null)
            return state[i][j][k];
        
        boolean ans=false;
        
        if(i<s1.length()&&k<s3.length()&&s1.charAt(i)==s3.charAt(k)&&j<s2.length()&&s2.charAt(j)==s3.charAt(k))
            ans = isInterleave(i+1,j,k+1,s1,s2,s3,state)|| isInterleave(i,j+1,k+1,s1,s2,s3,state);
        else if(i<s1.length()&&k<s3.length()&&s1.charAt(i)==s3.charAt(k))
            ans= isInterleave(i+1,j,k+1,s1,s2,s3,state); 
        else if(j<s2.length()&&k<s3.length()&&s2.charAt(j)==s3.charAt(k))
            ans =isInterleave(i,j+1,k+1,s1,s2,s3,state);
        else
            ans= false;
        
        return state[i][j][k] =ans;
    }
}