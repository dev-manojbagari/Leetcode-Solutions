class Solution {
    public int numSquares(int n) {
        return numSquares(n,new Integer[n+1]);   
    }
    
    int numSquares(int n,Integer[] state){
        if(n==0)
            return 0;
        if(state[n]!=null)
            return state[n];
        
        int min = Integer.MAX_VALUE-1;
        for(int i=1;i*i<=n;i++)
        {
            min = Math.min(min,1+numSquares(n-i*i,state));
        }
        
        return state[n]=min;
    }
}