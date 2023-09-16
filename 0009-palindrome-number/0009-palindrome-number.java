class Solution {
    public boolean isPalindrome(int x) {
        int temp =x;
        int rev=0;
        int sign = x>0?1:-1;
       
        while(temp>0){
            int lastDigit = temp%10;
            rev = rev*10+lastDigit;
            temp = temp/10;
        }
        return x==rev;
    }
}