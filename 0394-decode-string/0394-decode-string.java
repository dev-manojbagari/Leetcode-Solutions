class Solution {
    public String decodeString(String s) {
        int num=0;
        String str="";
        Stack<String> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        for(char c:s.toCharArray()){
            if(Character.isDigit(c)){
                num = num*10+c-'0';
            }else if(Character.isLetter(c)){
                str+=c;
            }else if(c=='['){
                strStack.push(str);
                numStack.push(num);
                str="";
                num=0;
            }else if(c==']'){
                String curString = str;
                str=strStack.pop();
                int count = numStack.pop();
                for(int i=0;i<count;i++)
                    str += curString;
            }
            
        }
        
        return str;        
    }
}