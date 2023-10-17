class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=0;
        for(int num:piles)
            max=Math.max(max,num);
        
        int left=1,right=max;
        int ans =-1;
        
        while(left<=right){
            int mid= left+(right-left)/2;
            
            if(countHour(piles,mid)<=h){
                ans =mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        
        return ans;
    }
    
    long countHour(int[] piles,int k){
        long count=0;
        
        for(int i=0;i<piles.length;i++){
            count+= piles[i]/k;
            if((piles[i]%k)>0)
                count++;
        }
        
        return count;
    }
}