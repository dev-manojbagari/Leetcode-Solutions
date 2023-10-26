class Solution {
    public int characterReplacement(String s, int k) {
        int start=0,maxLen=0,maxCount=0;
        int[] charCount = new int[26];
        for(int end=0;end<s.length();end++){
            char c = s.charAt(end);
            charCount[c-'A']++;
            maxCount = Math.max(maxCount,charCount[c-'A']);
            
            while(end-start+1-maxCount>k){
                c = s.charAt(start++);
                charCount[c-'A']--;
            }
            
            maxLen = Math.max(maxLen ,end-start+1);
        }
        
        return maxLen;
    }
}