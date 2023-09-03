class Solution {
    int count =0;
    public int countSubstrings(String s) {
        for(int i=0;i<s.length();i++)
            countSubstrings(i,s);
        return count;
    }
    
    void countSubstrings(int index,String s){
        if(index==s.length())
            return;
        for(int i=index;i<s.length();i++){
            if(isPalindrome(s.substring(index,i+1))){
                count++;
                //System.out.println(s.substring(index,i+1));
            }
        }        
    }
    
    boolean isPalindrome(String s){
        char[] ca = s.toCharArray();
        int i=0,j=ca.length-1;
        while(i<j){
            if(ca[i]!=ca[j])
                return false;
            i++;
            j--;
        }
        
        return true;
    }
    
}