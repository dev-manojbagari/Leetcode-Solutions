class Solution {
    public String decodeString(String s) {
        Stack<Integer> intStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        int num=0;
        StringBuilder sb=new StringBuilder();
        String str="";
        for(char c:s.toCharArray()){
            if(Character.isDigit(c)){
                num = num*10+c-'0';
            }else if(c=='['){
                intStack.push(num);
                num=0;
                strStack.push(sb);
                sb = new StringBuilder();                
            } else if(c==']'){
                StringBuilder temp= sb;
                num = intStack.pop();
                sb = strStack.pop();
                for(int i=0;i<num;i++)
                    sb.append(temp);
                num=0;
            }else{
                sb.append(c);
            }                
        } 
        
        return sb.toString();
    }
}