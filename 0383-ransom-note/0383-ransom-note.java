class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] cmap = new int[26];
        
        for(char c:magazine.toCharArray()){
            cmap[c-'a']++;
        }
        
        for(char c:ransomNote.toCharArray()){
            if(cmap[c-'a']==0){
                return false;
            }
            cmap[c-'a']--;
        }
        
        return true;
    }
}