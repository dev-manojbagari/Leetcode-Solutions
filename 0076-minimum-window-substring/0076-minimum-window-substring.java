class Solution {
    public String minWindow(String s, String t) {
       int[] charCount = new int[127];
        for(char c:t.toCharArray()){
            charCount[c]++;
        }
        
        int count = t.length();
        int start=0;
        int minStart=0,minLen=Integer.MAX_VALUE;
        for(int end =0;end<s.length();end++){
            char c = s.charAt(end);
            charCount[c]--;
            if(charCount[c]>=0)
                count--;
            
            while(count==0){
                if(minLen>end-start+1){
                    minStart = start;
                    minLen = end-start+1;
                }
                
                c = s.charAt(start++);
                charCount[c]++;
                if(charCount[c]>0)
                    count++;
            }
        }
        
        return minLen==Integer.MAX_VALUE?"":s.substring(minStart,minStart+minLen);       
    }
}