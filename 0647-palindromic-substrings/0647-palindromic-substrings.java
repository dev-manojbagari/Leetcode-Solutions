class Solution {
    public int countSubstrings(String s) {
        return countSubstrings(0,s);
    }
    
    int countSubstrings(int index,String s){
        if(index==s.length())
            return 0;
        int count = 0;
        for(int i=index;i<s.length();i++){
            if(isPalindrome(s.substring(index,i+1))){
                count++;
            }
        }
        
        return count + countSubstrings(index+1,s);       
    }
    
    boolean isPalindrome(String str){
        int left=0,right=str.length()-1;
        
        while(left<=right){
            if(str.charAt(left)!=str.charAt(right))
                return false;
            left++;
            right--;
        }

       return true;
   }
}
