class Solution {
public boolean isMatch(String s, String p) {
return isMatch(0,0,s,p,new Boolean[s.length()+1][p.length()+1]);
}
boolean isMatch(int si,int pi,String s,String p,Boolean[][] cache){
if(pi==p.length())
return si==s.length();
if(cache[si][pi]!=null)
return cache[si][pi];
boolean firstMatch = si<s.length()&&(s.charAt(si)==p.charAt(pi)||p.charAt(pi)=='.');
boolean ans = false;
if(pi+1<p.length()&&p.charAt(pi+1)=='*')
ans = isMatch(si,pi+2,s,p,cache)||firstMatch&&isMatch(si+1,pi,s,p,cache);
else
ans = firstMatch&&isMatch(si+1,pi+1,s,p,cache);
return cache[si][pi]=ans;
}
}