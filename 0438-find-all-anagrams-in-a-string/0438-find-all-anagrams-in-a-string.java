class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        
        if(p.length()>s.length())
            return list;
        
        int[] cmap= new int[26];
        
        for(char c:p.toCharArray()){
            cmap[c-'a']++;
        }
        int diff = p.length();
        for(int i=0;i<p.length();i++){
            char c = s.charAt(i);
            cmap[c-'a']--;
            if(cmap[c-'a']>=0)
                diff--;
        }
        
        if(diff==0){
            list.add(0);
        }
        
        int start=0, end=p.length();
        for(;end<s.length();end++, start++)
        {
            char c = s.charAt(start);
            if(cmap[c-'a'] >= 0)
                diff++;
            cmap[c-'a']++;
            
            c = s.charAt(end);
            cmap[c-'a']--;
            if(cmap[c-'a'] >= 0)
                diff--;

            // Check if diff is zero after adjusting the character counts
            if(diff==0)
                list.add(start+1);
        }
        
        return list;
    }
}
