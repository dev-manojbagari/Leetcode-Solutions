class Solution {
    public int calculate(String s) {
        char prevSign = '+';
        Stack<Integer> stack = new Stack<>();
        int num=0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                num = num*10+c-'0';
            }
            
            if((!Character.isDigit(c)&&c!=' ')||i==s.length()-1){
                if(prevSign=='+'){
                    stack.push(num);
                }else if(prevSign=='-'){
                    stack.push(-num);
                }else if(prevSign=='*'){
                    stack.push(stack.pop()*num);
                }else if(prevSign=='/'){
                    stack.push(stack.pop()/num);
                }
                prevSign=c;
                num=0;
            }
        }
        
        int total = 0;
        while(!stack.isEmpty())
            total+= stack.pop();
        
        return total;
    }
}