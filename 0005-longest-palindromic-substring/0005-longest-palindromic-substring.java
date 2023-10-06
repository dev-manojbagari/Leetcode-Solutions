class Solution {
    int start=0,maxLen=0;
    public String longestPalindrome(String s) {
    
        for(int i=0;i<s.length();i++){
            palindrome(s,i,i+1);
            palindrome(s,i,i);
        }    
        
        return s.substring(start,start+maxLen); 
    }
    
      void palindrome(String s,int i,int j){
        
        while(i>=0&&j<s.length()&&s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        
        if(j-i-1>maxLen){
            start = i+1;
            maxLen = j-i-1;
        } 
    }
}