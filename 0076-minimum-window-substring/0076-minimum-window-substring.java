class Solution {
    public String minWindow(String s, String t) {
        int[] cmap = new int[256];
        
        for(char c:t.toCharArray()){
            cmap[c]++;
        }
        int count = t.length();
        int start=0,minWindow = Integer.MAX_VALUE;int minStart=0;
        for(int end=0;end<s.length();end++){
            char c = s.charAt(end);
            cmap[c]--;
            if(cmap[c]>=0)
                count--;
            
            while(count==0){
                if(end-start+1<minWindow){
                    minStart =start;
                    minWindow = end-start+1;
                }
                c=s.charAt(start++);
                cmap[c]++;
                if(cmap[c]>0)
                    count++;
            }
        }
        
        
        return minWindow==Integer.MAX_VALUE?"":s.substring(minStart,minStart+minWindow);        
        
    }
}