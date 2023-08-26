class Solution {
    public boolean isMatch(String s, String p) {
        return isMatch(0,0,s,p,new Boolean[s.length()][p.length()]);
    }
    
    boolean isMatch(int si,int pi,String s,String p,Boolean cache[][]){
        if(pi==p.length())
            return si==s.length();
        if(si==s.length()){
            if(p.charAt(pi)=='*')
                return isMatch(si,pi+1,s,p,cache);
            else
                return false;
        }

        if(cache[si][pi]!=null)
            return cache[si][pi];

        if(p.charAt(pi)=='?')
            return cache[si][pi]=isMatch(si+1,pi+1,s,p,cache);
        
        else if(p.charAt(pi)=='*')
            return cache[si][pi]=isMatch(si,pi+1,s,p,cache)||isMatch(si+1,pi,s,p,cache);
        else
            return cache[si][pi]=s.charAt(si)==p.charAt(pi)&&isMatch(si+1,pi+1,s,p,cache);
    }
    
}