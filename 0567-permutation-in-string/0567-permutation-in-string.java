class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())
            return false;
        
        int[] map = new int[26];
        for(char c:s1.toCharArray()){
            map[c-'a']++;
        }
        
        int start=0,end=0;
        int diff=s1.length();
        
        for(;end<s1.length();end++){
            char c = s2.charAt(end);
            map[c-'a']--;
            
            if(map[c-'a']>=0)
                diff--;
        }
        

        if(diff==0)
            return true;
        
        for(;end<s2.length();end++){
            char c = s2.charAt(start++);
            map[c-'a']++;
            
            if(map[c-'a']>0)
                diff++;
            
            c = s2.charAt(end);
            map[c-'a']--;
            
            if(map[c-'a']>=0)
                diff--;
            
            if(diff==0)
                return true;
            
        }
        
                
        return false;
        
        
    }
}