class Solution {
    public String decodeString(String s) {
        
        StringBuilder sb = new StringBuilder();
        int repeat =0;
        Stack<Integer> stack1 = new Stack<>();
        Stack<StringBuilder> stack2 = new Stack<>();
        for(char c:s.toCharArray()){
            
            if(Character.isDigit(c)){
                repeat = repeat*10+c-'0';
            }else if(c=='['){
                stack1.push(repeat);
                stack2.push(sb);
                sb = new StringBuilder();
                repeat=0;
                
            }else if(c==']'){
                int count = stack1.pop();
                StringBuilder oldSb =stack2.isEmpty()?new StringBuilder():stack2.pop();
                for(int i=0;i<count;i++)
                    oldSb.append(sb.toString());
                sb = oldSb;
                //  StringBuilder tmp = sb;
                // sb = stack2.pop();
                // for (repeat = stack1.pop(); repeat > 0; --repeat) sb.append(tmp);
            }else{
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}