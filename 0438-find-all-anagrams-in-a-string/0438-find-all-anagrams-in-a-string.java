class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] map = new int[26];
        for(char c:p.toCharArray()){
            map[c-'a']++;
        }
        int diff = p.length();
        List<Integer> res = new ArrayList<>();
        if(s.length()==0||p.length()==0||s.length()<p.length())
            return res;
        int start=0,end=0;
        for(end=0;end<p.length();end++){
            char c = s.charAt(end);
            map[c-'a']--;
            if(map[c-'a']>=0)
                diff--;
        }
        
        if(diff==0)
            res.add(0);

        for(;end<s.length();end++){
            char c = s.charAt(start++);
            map[c-'a']++;
            if(map[c-'a']>0)
                diff++;
            
            c = s.charAt(end);
            map[c-'a']--;
            if(map[c-'a']>=0)
                diff--;
            if(diff==0)
                res.add(start);
            
        }
        
        return res;
    }
}