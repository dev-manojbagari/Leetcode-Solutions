public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int rev=0;
        for(int i=0;i<32;i++){
            if((n&1)==1)
                rev++;
            n=n>>1;
            if(i!=31)
            rev=rev<<1;
        }
            
        return rev;
    }
}