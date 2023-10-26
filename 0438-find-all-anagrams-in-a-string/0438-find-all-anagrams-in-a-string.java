class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(p.length()>s.length())
            return res;
        int[] charCount = new int[26];
        
        for(char c:p.toCharArray()){
            charCount[c-'a']++;    
        }
        
        int start=0,end=0;
        int count = p.length();
        for(;end<p.length();end++){
            char c = s.charAt(end);
            charCount[c-'a']--;
            if(charCount[c-'a']>=0)
                count--;
        }
        
        if(count==0)
            res.add(0);
        
        for(;end<s.length();end++){
            char c = s.charAt(start++);
            charCount[c-'a']++;
            if(charCount[c-'a']>0){
                count++;
            }
            c=s.charAt(end);
            charCount[c-'a']--;
            if(charCount[c-'a']>=0)
                count--;
            if(count==0)
                res.add(start);
        }
        
        
        
        return res;        
    }
}