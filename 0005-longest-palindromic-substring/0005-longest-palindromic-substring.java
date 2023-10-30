class Solution {
    public String longestPalindrome(String s) {
        int[] start={0},maxLen={0};
        for(int i=0;i<s.length();i++){
            countSubstrings(s,i,i,start,maxLen);
            countSubstrings(s,i,i+1,start,maxLen);
            
        }
        return s.substring(start[0],start[0]+maxLen[0]);
    }
    
    
    void countSubstrings(String s,int left,int right,int[] start,int[] maxLen){
        
        while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        
        if(right-left-1>maxLen[0]){
            start[0] = left+1;
            maxLen[0]=right-left-1;
        }
    }
}