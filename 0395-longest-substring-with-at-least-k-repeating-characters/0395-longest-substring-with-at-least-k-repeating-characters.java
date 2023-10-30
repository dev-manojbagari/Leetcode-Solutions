class Solution {
    public int longestSubstring(String s, int k) {
        int maxLen = 0;
        for(int distinct=1;distinct<=26;distinct++){
            maxLen = Math.max(maxLen,f(s,distinct,k));
        }
        return maxLen;
    }
    
    public int f(String s,int distinctCount, int k) {
       int start=0,maxLen=0;
        int[] charFreq = new int[256];
        int distinctChars = 0;
        int kOrMore=0;
        for(int end =0;end<s.length();end++){
            char c = s.charAt(end);
            charFreq[c]++;
            if(charFreq[c]==1)
                distinctChars++;
            if(charFreq[c]==k)
                kOrMore++;
          
            while(distinctChars>distinctCount){
                c = s.charAt(start++);
                charFreq[c]--;
                if(charFreq[c]==0)
                    distinctChars--;
                 if(charFreq[c]==k-1)
                    kOrMore--;
            }   
            if(distinctChars==distinctCount&&kOrMore>=distinctChars)
                maxLen = Math.max(maxLen,end-start+1);
        }
        
        return maxLen;
    }
}