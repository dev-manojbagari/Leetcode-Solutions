class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] cmap= new int[256];
        
        int start=0,end=0,maxLen=0;
        boolean dupFound = false;
        for(;end<s.length();end++){
            char c = s.charAt(end);
            cmap[c]++;
            if(cmap[c]>1)
                dupFound=true;
            
            while(dupFound){
                c = s.charAt(start++);
                cmap[c]--;
                if(cmap[c]==1)
                    dupFound=false;
            }
            
            maxLen = Math.max(maxLen,end-start+1);
        }
        
        return maxLen;
    }
}