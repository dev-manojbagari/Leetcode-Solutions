class Solution {
    public String decodeString(String s) {
        Stack<String> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        int num=0;
        String str = "";
        for(char c:s.toCharArray()){
            if('0'<=c&&c<='9'){
                num = num*10+c-'0';
            }else if(Character.isLetter(c)){
                str += c;
            }else if(c=='['){
                strStack.push(str);
                numStack.push(num);
                str="";
                num=0;
            }else if(c==']'){
                int count = numStack.pop();
                String curString = str;
                str = strStack.pop();
                for(int i=0;i<count;i++){
                    str+=curString;
                }
            }
        }
        
        return str;
    }
}