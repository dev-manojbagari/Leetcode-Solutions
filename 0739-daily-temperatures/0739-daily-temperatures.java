class Solution {
    public int[] dailyTemperatures(int[] nums) {
        // next larger
         
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] nl= new int[n];
        
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty()&&nums[stack.peek()]<=nums[i]){
                stack.pop();
            }
            nl[i]=stack.isEmpty()?i:stack.peek();
            stack.push(i);
        }
        int[] res = new int[n];
        
        for(int i=0;i<n;i++){
            res[i]=nl[i]-i;    
        }
        
        
        
        return res;
    }
}