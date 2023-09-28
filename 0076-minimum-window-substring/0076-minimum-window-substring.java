class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        
        for(char c:t.toCharArray()){
            map[c]++;
        }
        
        int start=0,count=t.length();
        int minLen = s.length()+1;
        int minStart=0;
        for(int end =0;end<s.length();end++){
            char c = s.charAt(end);
            map[c]--;
            if(map[c]>=0)
                count--;
            
            while(count==0){
                if(minLen>end-start+1){
                    minStart = start;
                    minLen = end-start+1;
                }
                c = s.charAt(start);
                map[c]++;
                if(map[c]>0)
                    count++;
                start++;
            }
            
        }
        
        return minLen==s.length()+1?"":s.substring(minStart,minStart+minLen);
    }
}