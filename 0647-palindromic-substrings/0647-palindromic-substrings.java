class Solution {
    int count =0;
    public int countSubstrings(String s) {
        
        for(int i=0;i<s.length();i++){
            countPalindrome(i,i,s);
            countPalindrome(i,i+1,s);
        }
        
        return count;
    }
    
    void countPalindrome(int i,int j,String s){
        
        while(i>=0&&j<s.length()&&s.charAt(i)==s.charAt(j)){
            i--;
            j++;
            count++;
        }
        
        
    }
    
}