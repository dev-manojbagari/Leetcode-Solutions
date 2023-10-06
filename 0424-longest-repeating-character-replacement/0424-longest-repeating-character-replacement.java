class Solution {
    public int characterReplacement(String s, int k) {
        int[] cmap = new int[26];
        int start=0;
        int maxLen=0;
        int unique=0,maxCount=0;
        for(int end=0;end<s.length();end++){
            char c = s.charAt(end);
            cmap[c-'A']++;
            maxCount = Math.max(maxCount,cmap[c-'A']);
            if(end-start+1-maxCount>k){
                c = s.charAt(start++);
                cmap[c-'A']--;
            }
            
            
                maxLen = Math.max(maxLen,end-start+1);
        }
        
        return maxLen;
    }
}