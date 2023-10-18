class Solution {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        
        for(int i=2;i<Math.sqrt(n);i++){
            for(int j=2;i*j<n;j++){
                notPrime[i*j]=true;
            }
        }
        
        int count=0;
        for(int i=2;i<n;i++)
            if(!notPrime[i])
                count++;
        
        return count;
                
    }
}