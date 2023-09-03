class Solution {
    public int characterReplacement(String s, int k) {
        int start=0;
        char[] cmap= new char[26];
        int maxFreq =1;
        char maxChar='\0';
        int maxL=1;
        for(int end=0;end<s.length();end++){
            char c = s.charAt(end);
            cmap[c-'A']++;
            
            if(cmap[c-'A']>maxFreq){
                maxFreq = cmap[c-'A'];
                maxChar=c;
            }
            
            if(end-start+1-maxFreq>k){
                c = s.charAt(start);
                cmap[c-'A']--;
                // if(c==maxChar)
                    // maxFreq--;
                start++;
            
            }
            
            maxL = Math.max(maxL,end-start+1);
        }
        
        return maxL;
    }
}