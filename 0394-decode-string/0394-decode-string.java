class Solution {
    public String decodeString(String s) {
        Stack<String> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        String res="";
        int num=0;
        for(char c:s.toCharArray()){
            
            if(Character.isDigit(c)){
                num = num*10+c-'0';
            }else if(Character.isLetter(c)){
                res += c;
            }else if(c=='['){
                strStack.push(res);
                numStack.push(num);
                res="";
                num=0;
            }else if(c==']'){
                String curStr = res;
                res = strStack.pop();
                int count = numStack.pop();
                for(int i=0;i<count;i++)
                    res+=curStr;
                
            }
        }
        
        return res;        
    }
}