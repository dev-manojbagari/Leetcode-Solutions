class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0)=='0')
            return 0;
        return f(0,s,new Integer[s.length()+1]);
    }
    
    int f(int index,String s,Integer[] cache){
        if(index>s.length())
            return 0;
        if(index==s.length())
            return 1;
        
        if(s.charAt(index)=='0')
            return 0;
        
        if(cache[index]!=null)
            return cache[index];
        
        int ans = 0;
        
        
        ans += f(index+1,s,cache);
        
        if(s.charAt(index)=='1'||(index+1<s.length()&&s.charAt(index)=='2'&&s.charAt(index+1)<='6'))
            ans += f(index+2,s,cache);
            
        return cache[index] = ans;
    }
    
    
}