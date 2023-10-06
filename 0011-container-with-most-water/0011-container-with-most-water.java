class Solution {
    public int maxArea(int[] h) {
        int left=0,right=h.length-1;
        int maxWater=0;
        
        while(left<right){
            
            if(h[left]<=h[right]){
                int area = right-left;
                maxWater = Math.max(maxWater,area*h[left]);
                left++;
            }else if(h[left]>h[right]){
                int area = right-left;
                maxWater = Math.max(maxWater,area*h[right]);
                right--;
            }
        }
        
        
        return maxWater;
    }
}