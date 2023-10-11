class Solution {
    public int longestPalindrome(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int evenCount=0,oddCount=0;
        for(int val:map.values()){
            if(val%2==0) 
                evenCount += val;
            else
                evenCount += val-1;
            if(val%2!=0)
                oddCount++;
        }
    
        return oddCount>0?evenCount+1:evenCount;        
    }
}