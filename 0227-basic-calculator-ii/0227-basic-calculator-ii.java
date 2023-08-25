class Solution {
    public int calculate(String s) {
        char prevSign = '+';
        int num=0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(isDigit(c)){
                num = num*10+c-'0';
            }
            
            if(!isDigit(c)&&c!=' '||i==s.length()-1){
                if(prevSign=='+')
                {
                    stack.push(+num);
                }else if(prevSign=='-'){
                    stack.push(-num);
                }else if(prevSign=='/'){
                    stack.push(stack.pop()/num);
                }else{
                    stack.push(stack.pop()*num);
                }
                
                prevSign = c;
                num=0;
                
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