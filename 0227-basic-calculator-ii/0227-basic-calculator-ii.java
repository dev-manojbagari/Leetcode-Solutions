class Solution {
    public int calculate(String s) {
        char sign='+';
        int num=0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if('0'<=c&&c<='9'){
                num = num*10+c-'0';                
            }
            
            if(!Character.isDigit(c)&&c!=' '||i==s.length()-1){
                if(sign=='+'){
                    stack.push(num);
                }else if(sign=='-'){
                    stack.push(-num);
                }else if(sign=='*'){
                    stack.push(stack.pop()*num);
                }else if(sign=='/'){
                    stack.push(stack.pop()/num);
                }
                    sign=c;
                    num=0;
                
            }
            
        }
            int total=0;
            while(!stack.isEmpty()){
                total += stack.pop();
            }
            
            return total;
    }
}