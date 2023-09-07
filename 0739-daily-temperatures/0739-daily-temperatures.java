class Solution {
    public int[] dailyTemperatures(int[] nums) {

        int n = nums.length;
        Stack<Integer> stack = new Stack<>();

        int[] res = new int[n];
        
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty()&&nums[stack.peek()]<=nums[i]){
                stack.pop();
            }
            res[i]=stack.isEmpty()?0:stack.peek()-i;
            stack.push(i);
        }
        
        return res;
    }
}