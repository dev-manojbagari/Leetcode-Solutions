class Solution {
    public boolean isMatch(String s, String p) {
        return isMatch(0,0,s,p,new Boolean[s.length()+1][p.length()+1]);
    }
    
    boolean isMatch(int i,int j,String s,String p,Boolean[][] cache){
        if(i==s.length()){
            if(allStars(p,j))
                return true;
            else
                return false;
        }else if(j==p.length())
            return i==s.length();
            
        if(cache[i][j]!=null)
            return cache[i][j];
        
        if(p.charAt(j)=='?'||s.charAt(i)==p.charAt(j))
            return cache[i][j]=isMatch(i+1,j+1,s,p,cache);
        else if(p.charAt(j)=='*')
            return cache[i][j]=isMatch(i+1,j,s,p,cache)||isMatch(i,j+1,s,p,cache);
        else
            return cache[i][j]=false;
    }
    
    boolean allStars(String p,int j){
        for(int i=j;i<p.length();i++)
            if(p.charAt(i)!='*')
                return false;
        return true;
    }
}