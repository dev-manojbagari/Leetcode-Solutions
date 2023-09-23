class Solution {
    public int countSubstrings(String s) {
        
    int count =0;
        for(int i=0;i<s.length();i++){
          count+=  countPalindrome(i,i,s);
           count+= countPalindrome(i,i+1,s);
        }
        
        return count;
    }
    
    int countPalindrome(int i,int j,String s){
       int count=0; 
        while(i>=0&&j<s.length()&&s.charAt(i)==s.charAt(j)){
            i--;
            j++;
            count++;
        }
        
        return count;
    }
    
}