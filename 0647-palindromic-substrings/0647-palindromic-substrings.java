class Solution {
    public int countSubstrings(String s) {
        int[] count = {0};
        for(int i=0;i<s.length();i++){
            countSubstrings(s,i,i+1,count);
            countSubstrings(s,i,i,count);
            
        }
        return count[0];
    }
    
    void countSubstrings(String s,int left,int right,int[] count){
        
        while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
            count[0]++;
        }
    }
    
}