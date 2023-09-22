class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int[] res  = new int[temp.length];
        int ng[] = new int[temp.length];
        Stack<Integer> stack = new Stack<>();
        int n = temp.length;
        
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty()&&temp[stack.peek()]<=temp[i])
                stack.pop();
            res[i] = stack.isEmpty()?0:stack.peek()-i;
            stack.push(i);
        }
        
        return res;
    }
}