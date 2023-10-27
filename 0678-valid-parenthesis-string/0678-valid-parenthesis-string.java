class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> charIdStack = new Stack<>();
        Stack<Integer> starIdStack = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('){
                charIdStack.push(i);
            }else if(c=='*'){
                starIdStack.push(i);
            }else{
                if(charIdStack.isEmpty()&&starIdStack.isEmpty())
                    return false;
                if(!charIdStack.isEmpty())
                    charIdStack.pop();
                else
                    starIdStack.pop();
            }
        }
        
        while(!charIdStack.isEmpty()&&!starIdStack.isEmpty()){
            if(charIdStack.pop()>starIdStack.pop())
                return false;
        }
        
        
        return charIdStack.isEmpty();
    }
}