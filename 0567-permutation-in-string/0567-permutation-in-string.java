class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        
        if(len1>len2)
            return false;
        
        char[] charCount = new char[26];

        for(char i=0;i<len1;i++){
            charCount[s1.charAt(i)-'a']++;
            charCount[s2.charAt(i)-'a']--;
        }
        
        if(allZero(charCount))
            return true;
        
        for(int i=len1;i<s2.length();i++){
            charCount[s2.charAt(i)-'a']--;
            charCount[s2.charAt(i-len1)-'a']++;
            if(allZero(charCount))
                return true;
        }
        
        
        
        return false;
        
    }
    
    private boolean allZero(char[] charCount){
        
        for(int i:charCount)
            if(i!=0)
                return false;
        
        return true;
    }
}