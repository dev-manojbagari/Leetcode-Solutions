class Solution {
    public double myPow(double x, int n) {
        if(n<0)
            x = 1/x;
        n  = Math.abs(n);
        return myPowUtil(x,n);
    }
    
    double myPowUtil(double x,int n){
        if(n==0)
            return 1;
        
        
        return n%2==0?myPowUtil(x*x,n/2):x*myPowUtil(x*x,n/2);
    }
}