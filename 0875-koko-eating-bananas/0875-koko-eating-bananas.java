class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=0;
        for(int num:piles)
            max = Math.max(max,num);
        
        int left=1,right=max;
        int ans = -1;        
        while(left<=right){
            int mid= left+(right-left)/2;
            
            if(countHour(piles,mid,h)>h){
                left=mid+1;
            }else{
                ans = mid;
                right=mid-1;
            }
        }
        
        
        return ans;
    }
    
    long countHour(int[] piles,int freq,int h){
        long count =0;
        for(int i=0;i<piles.length;i++){
            count += piles[i]/freq;
            if(piles[i]%freq>0)
                count++;
        }
        
        return count;
    }




    
    
    
}