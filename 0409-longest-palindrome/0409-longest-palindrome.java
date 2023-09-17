class Solution {
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        int count=0;
        for(char c:s.toCharArray()){
            if(!set.contains(c))
                set.add(c);
            else
            {
                set.remove(c);
                count++;
            }
        }
        return set.isEmpty()?2*count:2*count+1;
    }
}