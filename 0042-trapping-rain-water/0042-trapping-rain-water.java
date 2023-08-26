class Solution {
    public int trap(int[] height) {
        int leftMax=0,rightMax=0;
        int left=0,right=height.length-1;
        int tw=0;
        while(left<=right){
            if(height[left]<height[right]){
                if(height[left]>=leftMax){
                    leftMax=height[left];
                }else{
                    tw+= leftMax-height[left];   
                }
                left++;
            }else{
                if(height[right]>=rightMax){
                    rightMax=height[right];
                }else{
                    tw+= rightMax-height[right];   
                }
                right--;
            }
        }
            
         return tw;   
    }
}