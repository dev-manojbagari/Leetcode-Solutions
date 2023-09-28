class Solution {
    public int trap(int[] height) {
        int leftMax=height[0],rightMax=height[height.length-1];
        int left=0,right=height.length-1;
        int tw=0;
        while(left<=right){
            if(leftMax<=rightMax){
                if(height[left]>=leftMax){
                    leftMax = height[left];
                }else
                    tw += leftMax-height[left];   
                
                left++;
                
            }else{
                if(height[right]>=rightMax){
                    rightMax = height[right];
                }else
                    tw += rightMax-height[right];   
                
                right--;
                
            }
        }
        
        return tw;
    }
}