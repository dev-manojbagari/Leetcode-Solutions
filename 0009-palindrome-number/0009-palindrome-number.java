class Solution {
    public boolean isPalindrome(int x) {
        String str = Integer.toString(x);
        
        return new StringBuilder(str).reverse().toString().equals(str);
    }
}