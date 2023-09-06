class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if(s.length()<p.length())
            return list;
        int[] charCount = new int[26];
        for(int i=0;i<p.length();i++){
            char c = p.charAt(i);
            charCount[c-'a']++;
        }
        
        int start=0,end=0;
        int diff=p.length();
        for(;end<p.length();end++){
            char c = s.charAt(end);
            charCount[c-'a']--;
            if(charCount[c-'a']>=0)
                diff--;
        }
        
        if(diff==0)
            list.add(0);
        
        while(end<s.length()){
          char c  = s.charAt(start);
            if(charCount[c-'a'] >= 0){ // Change this line
                diff++; 
            }
            charCount[c-'a']++;
            c= s.charAt(end);
            charCount[c-'a']--;
            if(charCount[c-'a']>=0){
                diff--;
            }
            
            if(diff==0)
                list.add(start+1); // Change this line
            start++;
            end++;
        }
        
        
        return list;
    }
}