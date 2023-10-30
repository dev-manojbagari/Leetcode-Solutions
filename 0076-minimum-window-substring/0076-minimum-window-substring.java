class Solution {
    public String minWindow(String s, String t) {
        int start=0,count=t.length();
        int[] charCount = new int[128];
        for(int i=0;i<t.length();i++){
            charCount[t.charAt(i)]++;
        }
        int minStart=0,minLen=Integer.MAX_VALUE;
        for(int end =0;end<s.length();end++){
            char c = s.charAt(end);
            charCount[c]--;
            if(charCount[c]>=0){
                count--;
            }
            
            while(count==0){
                if(end-start+1<minLen){
                    minStart=start;
                    minLen = end-start+1;
                }
                c=s.charAt(start++);
                charCount[c]++;
                if(charCount[c]>0){
                    count++;
                }   
            }
            
                        
        }
        return minLen==Integer.MAX_VALUE?"":s.substring(minStart,minStart+minLen);
    }
}