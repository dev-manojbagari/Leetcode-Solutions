class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int num=0;
        for(String str:tokens){
            if("+".equals(str)){
                stack.push(stack.pop()+stack.pop());
            }else if("-".equals(str)){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b-a);
            }else if("*".equals(str)){
                stack.push(stack.pop()*stack.pop());
            }else if("/".equals(str)){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b/a);
            }else{
                stack.push(Integer.parseInt(str));
            }
        }
        
        int total = 0;
        
        while(!stack.isEmpty()){
            total+=stack.pop();
        }
        return total;   
    }
}