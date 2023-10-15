class Solution {
    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                if(sb.length()>0)
                    stack.push(sb.toString());
                sb = new StringBuilder();
            }else{
                sb.append(s.charAt(i));
            }    
        }
        if(sb.length()>0)
            stack.push(sb.toString());
        StringBuilder res  = new  StringBuilder();
        while(!stack.isEmpty()){
            res.append(stack.pop());
            if(stack.isEmpty())
                break;
            res.append(" ");
        }
        
        return res.toString();
    }
}