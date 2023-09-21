class Solution {
    public int characterReplacement(String s, int k) {
        int[] map = new int[26];
        int start=0;
        int dup =0;
        int maxL=0;
        int maxC=0;
        char maxCC='A';
        for(int end =0;end<s.length();end++){
            char c = s.charAt(end);
            map[c-'A']++;
            if(map[c-'A']>maxC){
                maxC = map[c-'A'];
            }
            
            if((end-start+1)-maxC>k){
                c = s.charAt(start);
                map[c-'A']--;
                start++;
            }
            

            
           maxL = Math.max(maxL,end-start+1); 
        }
        
        return maxL;
    }
}