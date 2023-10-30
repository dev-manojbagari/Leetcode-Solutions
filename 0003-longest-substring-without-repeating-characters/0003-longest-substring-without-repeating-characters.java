class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start=0,maxLen=0;
        boolean dupFound = false;
        int[] charFreq = new int[256];
        
        for(int end =0;end<s.length();end++){
            char c = s.charAt(end);
            charFreq[c]++;
            if(charFreq[c]==2)
                dupFound=true;
          
            while(dupFound){
                c = s.charAt(start++);
                charFreq[c]--;
                if(charFreq[c]==1)
                    dupFound=false;
            }
            
            maxLen = Math.max(maxLen,end-start+1);
        }
        
        return maxLen;
    }
}