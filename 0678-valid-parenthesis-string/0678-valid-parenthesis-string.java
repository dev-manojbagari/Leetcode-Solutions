class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> openIdStack = new Stack<>();
        Stack<Integer> starIdStack = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('){
                openIdStack.push(i);
            }else if(c=='*'){
                starIdStack.push(i);
            }else{
                if(openIdStack.isEmpty()&&starIdStack.isEmpty())
                    return false;
                if(!openIdStack.isEmpty())
                    openIdStack.pop();
                else
                    starIdStack.pop();
            }
        }
        
        while(!openIdStack.isEmpty()&&!starIdStack.isEmpty()){
            if(openIdStack.pop()>starIdStack.pop())
                return false;
        }
        
        
        return openIdStack.isEmpty();
    }
}