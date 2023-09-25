class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=Integer.MIN_VALUE;
        
        for(int num:piles){
            max = Math.max(max,num);
        }
        
        int left = 1,right=max;
        int ans=0;
        
        while(left<=right){
            int mid = left+(right-left)/2;
            
            if(countTime(mid,piles)<=h){
                ans = mid;
                right=mid-1;
            }else{
                left =mid+1;
            }
        }
        
        
        return ans;
    }
    
    long countTime(int freq,int[] piles){
        long count =0;
        
        for(int pile :piles){
            count += pile/freq;
            if(pile%freq!=0)
                count++;
        }
        
        return count;
    }
    
    
}