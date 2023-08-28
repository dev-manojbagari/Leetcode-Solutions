class Solution {
    public int longestSubstring(String s, int k) {
        int max=0;
        for(int i=1;i<=26;i++){
            max =Math.max(max,longestSubstring(s,k,i));
        }

        return max;
    }
    
    int longestSubstring(String s, int k ,int targetDistinct){
        char[] cmap = new char[26];
        int start =0;
        int totalDistinct=0;
        int kOrMore=0;
        int maxL = 0;
        
        for(int end =0;end<s.length();end++){
            char c = s.charAt(end);
            cmap[c-'a']++;
            if(cmap[c-'a']==1)
                totalDistinct++;
            if(cmap[c-'a']==k)
                kOrMore++;
            
            while(totalDistinct>targetDistinct){
                c = s.charAt(start);
                cmap[c-'a']--;
                if(cmap[c-'a']==0)
                    totalDistinct--;
                if(cmap[c-'a']==k-1)
                    kOrMore--;
                start++;
            }
            
            if(targetDistinct==totalDistinct&&totalDistinct==kOrMore)
                maxL = Math.max(maxL,end-start+1);
        }
        
        return maxL;
    }
}