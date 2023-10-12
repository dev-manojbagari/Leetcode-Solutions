class Solution {
    public int reverse(int x) {
        int sign = x<0?-1:1;
         x = Math.abs(x);
        int rev = 0;
        while(x>0){
            int lastDigit= x%10;
            if(rev>Integer.MAX_VALUE/10||rev==Integer.MAX_VALUE&&lastDigit>Integer.MAX_VALUE%10)
                return 0;
            rev = rev*10+lastDigit;
            x = x/10;
        }
        
         return sign*rev;
    }
}