class Solution {
    public int numDistinct(String s, String t) {
        return f(0,0,s.toCharArray(),t.toCharArray(),new Integer[s.length()][t.length()]);
    }
    
    int f(int i,int j,char[] s,char[] t,Integer[][] state){
        if(j==t.length)
            return 1;
        if(i==s.length)
            return 0;
        
        if(state[i][j]!=null)
            return state[i][j];
        int ans = 0;
        if(s[i]==t[j])
            ans += f(i+1,j+1,s,t,state)+f(i+1,j,s,t,state);
        else
            ans += f(i+1,j,s,t,state);
        return state[i][j]=ans;
    }
}