class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())
            return false;
        int[] charCount = new int[26];
        
        for(char c:s1.toCharArray()){
            charCount[c-'a']++;
        }
        
        int start=0,count=s1.length();
        int end=0;
        for(;end<s1.length();end++){
            char c = s2.charAt(end);
            if(charCount[c-'a']>0)
                count--;
            charCount[c-'a']--;
        }
        if(count==0)
            return true;
        for(;end<s2.length();end++){
            char c = s2.charAt(start++);
            charCount[c-'a']++;
            if(charCount[c-'a']>0)
                count++;
                
            c=s2.charAt(end);
            charCount[c-'a']--;
            if(charCount[c-'a']>=0)
                count--;
            if(count==0)
                return true;
        }
        
        return false;
    }
}