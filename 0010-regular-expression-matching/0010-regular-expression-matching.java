class Solution {
    public boolean isMatch(String s, String p) {
          return isMatch(0,0,s,p,new Boolean[s.length()+1][p.length()+1]);
    }
    
    boolean isMatch(int i,int j,String s,String p,Boolean[][] cache){
        if(j==p.length())
            return i==s.length();
        
        if(cache[i][j]!=null)
            return cache[i][j];
        
        boolean firstMatch = i<s.length()&&(p.charAt(j)==s.charAt(i)||p.charAt(j)=='.');
      
        if(j+1<p.length()&&p.charAt(j+1)=='*')
            return cache[i][j]=isMatch(i,j+2,s,p,cache)||firstMatch&&isMatch(i+1,j,s,p,cache);
        else
            return cache[i][j]=firstMatch&&isMatch(i+1,j+1,s,p,cache);
  
    }
}