class Solution {
    public int largestRectangleArea(int[] h) {
        int n = h.length;
        int[] SL = new int[n];
        Stack<Integer> stack1 = new Stack<>();
        
        for(int i=0;i<n;i++){
            while(!stack1.isEmpty()&&h[stack1.peek()]>=h[i]){
                stack1.pop();
            }
            
            SL[i] = stack1.isEmpty()?-1:stack1.peek();
            stack1.push(i);
        }
        
        int[] SR = new int[n];
        Stack<Integer> stack2 = new Stack<>();
        
        for(int i=n-1;i>=0;i--){
            while(!stack2.isEmpty()&&h[stack2.peek()]>=h[i]){
                stack2.pop();
            }
            
            SR[i] = stack2.isEmpty()?n:stack2.peek();
            stack2.push(i);
        }
        
        
        int maxArea=0;
        for(int i=0;i<n;i++){
            int curArea = (SR[i]-SL[i]-1)*h[i];
            maxArea = Math.max(maxArea,curArea);
        }
        
        return maxArea;
    }
}