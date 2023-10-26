class Solution {
    public int calculate(String s) {
        char curSign = '+';
        int curNum=0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(isDigit(c)){
                curNum = curNum*10+c-'0';
            }
            
            if(!isDigit(c)&&c!=' '||i==s.length()-1){
                if(curSign=='+'){
                    stack.push(curNum);
                }else if(curSign=='-'){
                    stack.push(-curNum);
                }else if(curSign=='*'){
                    stack.push(stack.pop()*curNum);
                }else{
                    stack.push(stack.pop()/curNum);
                }
                curSign = c;
                curNum=0;
            }
        }
        
        int total=0;
        while(!stack.isEmpty()){
            total += stack.pop();
        }
        
        return total;
    }
    
    boolean isDigit(char c){
        return '0'<=c&&c<='9';
    }
}