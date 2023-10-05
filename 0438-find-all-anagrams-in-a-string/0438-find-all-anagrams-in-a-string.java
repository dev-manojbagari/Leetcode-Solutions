class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(p.length()>s.length())
            return res;
        int[] cmap = new int[26];
        
        for(char c:p.toCharArray()){
            cmap[c-'a']++;
        }
        int start = 0,end=0;
        int count =0;
        for(;end<p.length();end++){
            char c = s.charAt(end);
            if(cmap[c-'a']>0){
                count++;
            }
                cmap[c-'a']--;
        }
        
        if(count==p.length()){
            res.add(start);
        }
            
        for(;end<s.length();end++){
            char c = s.charAt(start++);
            cmap[c-'a']++;
            if(cmap[c-'a']>0){
                count--;
            }
            
            c = s.charAt(end);
            cmap[c-'a']--;
            if(cmap[c-'a']>=0){
                count++;
            }
            
            if(count==p.length()){
                res.add(start);
            }
        }    
                
        return res;
    }
}