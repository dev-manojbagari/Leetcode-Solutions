class Solution {
    public int countSubstrings(String s) {
         int[] count= {0};
        for(int i=0;i<s.length();i++){
            palindrome(s,i,i+1,count);
            palindrome(s,i,i,count);
        }    
        
        return count[0]++;
    }
    
      void palindrome(String s,int i,int j,int[] count){
        
        while(i>=0&&j<s.length()&&s.charAt(i)==s.charAt(j)){
            i--;
            j++;
            count[0]++;
        }
        
    }
}