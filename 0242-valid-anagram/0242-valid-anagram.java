class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        int n= s.length();
        int[] charCount = new int[26];
        for(int i=0;i<n;i++){
            charCount[s.charAt(i)-'a']++;
            charCount[t.charAt(i)-'a']--;
        }
        
        for(int i=0;i<26;i++){
            if(charCount[i]!=0)
                return false;
        }
        
        return true;
    }
}