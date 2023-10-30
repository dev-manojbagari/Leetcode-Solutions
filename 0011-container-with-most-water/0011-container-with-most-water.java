class Solution {
    public int maxArea(int[] h) {
        int maxArea = 0;
        int left=0,right=h.length-1,width=0;
        
        while(left<right){
            width = right-left;
            if(h[left]<=h[right]){
                maxArea = Math.max(maxArea, h[left]*width);
                left++;
            }else{
                maxArea = Math.max(maxArea, h[right]*width);
                right--;
            }
        }
        
        return maxArea;
    }
}