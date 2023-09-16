class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] cmap = new int[26];
        for(char c:magazine.toCharArray())
            cmap[c-'a']++;
        
        for(char c:ransomNote.toCharArray())
            cmap[c-'a']--;
        
        for(int i=0;i<26;i++)
            if(cmap[i]<0)
                return false;
        
        return true;
        
    }
}