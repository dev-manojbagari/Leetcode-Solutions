class Solution {
    public int calculate(String s) {
        int sign = 1;
        int num=0;
        int result=0;
        Stack<Integer> stack = new Stack<>();
        
        for(char c:s.toCharArray()){
            if(c=='('){
                stack.push(result);
                stack.push(sign);
                sign=1;
                result=0;
            }else if(c=='+'){
                result += sign*num;
                sign = 1;
                num=0;
            }else if(c=='-'){
                result += sign*num;
                sign = -1;
                num=0;
            }else if(c==')'){
                result +=sign*num;
                int prevSign = stack.pop();
                int prevResult = stack.pop();
                result = prevSign*result;
                result += prevResult;;
                num=0;
                sign=1;
            }else if('0'<=c&&c<='9'){
                num=num*10+c-'0';
            }
        }
        
        result += sign*num;
        
        return result;
    }
}