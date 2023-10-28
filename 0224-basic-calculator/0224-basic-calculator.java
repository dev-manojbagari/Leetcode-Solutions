class Solution {
    public int calculate(String s) {
        int prevSign = 1;
        int num=0;
        int result=0;
        Stack<Integer> stack =new Stack<>();

        for(char c:s.toCharArray()){
            if(Character.isDigit(c)){
                num =num*10+c-'0';
            }else if(c=='+'){
                result += prevSign*num;
                prevSign=1;
                num=0;
            }else if(c=='-'){
                result += prevSign*num;
                prevSign=-1;
                num=0;
            }else if(c=='('){
                stack.push(result);
                stack.push(prevSign);
                prevSign = 1;
                result=0;
                num=0;
            }else if(c==')'){
                result += prevSign*num;
                result *= stack.pop();
                result += stack.pop();
                prevSign=1;
                num=0;
            }
        }
        
        result += prevSign*num;
        return result;
    }
}