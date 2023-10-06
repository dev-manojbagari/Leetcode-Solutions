class Solution {
    public int longestSubstring(String s, int k) {
      int max = 0;
        
      for(int distinct=1;distinct<=26;distinct++){
          max = Math.max(max,longestSubstringUtil(s,k,distinct));
      }
        return max;
    }
    
    int longestSubstringUtil(String s,int k,int targetDistinct){
        
        
        int[] cmap = new int[128];
        
        int start=0,kOrMore=0,distinct=0,max=0;
        
        for(int end=0;end<s.length();end++){
            char c = s.charAt(end);
            cmap[c]++;
            if(cmap[c]==1)
                distinct++;
            if(cmap[c]==k)
                kOrMore++;
            
            while(distinct>targetDistinct){
                c= s.charAt(start++);
                cmap[c]--;
                if(cmap[c]==0)
                    distinct--;
                if(cmap[c]==k-1)
                    kOrMore--;
            }
            
            
            if(distinct==targetDistinct&&distinct<=kOrMore)
                max = Math.max(max,end-start+1);
        }
        
        
        return max;
        
    }
}