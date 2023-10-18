class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE&&divisor==-1)
           return Integer.MAX_VALUE;
        
        int sign = dividend>0&&divisor<0||dividend<0&&divisor>0?-1:1;
        
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int q = 0;
        int res=0;
        while(dividend-divisor>=0){
            while(dividend-(divisor<<(1+q))>0){
                q++;
            }
                  
            res += (1<<q);
            dividend = dividend-(divisor<<q);     
            q = 0;
            
        }
        
        
        
        return sign==-1?-res:res;
    }
}