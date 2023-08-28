class Solution {
    public int firstUniqChar(String s) {
        char[] ca = new char[26];
        
        for(char c:s.toCharArray())
            ca[c-'a']++;
        
        for(int i=0;i<s.length();i++){
            char curChar = s.charAt(i);
            if(ca[curChar-'a']==1)
                return i;
        }
        
        return -1;
    }
}