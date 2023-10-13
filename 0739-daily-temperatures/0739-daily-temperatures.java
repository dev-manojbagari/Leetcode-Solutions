class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        int res[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty()&&temp[stack.peek()]<=temp[i])
                stack.pop();
            
               res[i] = stack.isEmpty()?0:stack.peek()-i;
               stack.push(i);
        }
        
        return res;
    }
}