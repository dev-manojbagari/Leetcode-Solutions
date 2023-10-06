class Solution {
    int start=0,maxLen=0;
    public String longestPalindrome(String s) {
        int[] start= {0},maxLen={0};
        for(int i=0;i<s.length();i++){
            palindrome(s,i,i+1,start,maxLen);
            palindrome(s,i,i,start,maxLen);
        }    
        
        return s.substring(start[0],start[0]+maxLen[0]); 
    }
    
      void palindrome(String s,int i,int j,int[] start,int[] maxLen){
        
        while(i>=0&&j<s.length()&&s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        
        if(j-i-1>maxLen[0]){
            start[0] = i+1;
            maxLen[0] = j-i-1;
        } 
    }
}