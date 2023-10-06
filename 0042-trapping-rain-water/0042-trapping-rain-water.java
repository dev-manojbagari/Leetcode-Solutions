class Solution {
    public int trap(int[] h) {
        int leftMax = -1,rightMax=-1;
        int left=0,right=h.length-1;
        int tw=0;
        while(left<=right){
            if(h[left]<h[right]){
                if(h[left]>=leftMax){
                    leftMax=h[left];
                }else{
                    tw+= leftMax-h[left];
                }
            left++;
            }else{
                if(h[right]>=rightMax){
                    rightMax=h[right];
                }else
                    tw+=rightMax-h[right];
                
                right--;
            }
            
        }
        
        return tw;
    }
}