class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for(String token:tokens){
            if(token.equals("+")){
                stack.push(stack.pop()+stack.pop());                
            }else if("-".equals(token)){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b-a);
            }else if("*".equals(token)){
                stack.push(stack.pop()*stack.pop());
            }else if("/".equals(token)){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b/a);
            }else{
                stack.push(Integer.parseInt(token));
            }
        }
                     
        int num =0;
        
        while(!stack.isEmpty())
            num+=stack.pop();
        
        return num;
        
    }
}