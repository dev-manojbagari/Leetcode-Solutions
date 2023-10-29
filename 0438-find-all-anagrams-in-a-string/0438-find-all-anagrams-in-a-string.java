class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if(p.length()>s.length())
            return list;
        int[] charCount = new int[26];
        
        for(int i=0;i<p.length();i++){
            char c= p.charAt(i);
            charCount[c-'a']++;
        }
        int start=0,end=0,count=p.length();
        
        for(;end<p.length();end++){
            char c = s.charAt(end);
            charCount[c-'a']--;
            if(charCount[c-'a']>=0)
                count--;
        }
        
        if(count==0)
            list.add(0);
        
        for(;end<s.length();end++){
            char c = s.charAt(start++);
            charCount[c-'a']++;
            if(charCount[c-'a']>0)
                count++;
            c=s.charAt(end);
            charCount[c-'a']--;
            if(charCount[c-'a']>=0)
                count--;
            
            if(count==0)
                list.add(start);
        }
        
        return list;        
    }
}