class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> openStack = new Stack<>();
        Stack<Integer> starStack  = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('){
                openStack.push(i);
            }else if(c==')'){
                if(!openStack.isEmpty()){
                    openStack.pop();
                }else if(!starStack.isEmpty()){
                    starStack.pop();
                }else{
                    return false;
                }
            }else{
                    starStack.push(i);                
            }
        }
        
        while(!openStack.isEmpty()&&!starStack.isEmpty()){
            if(openStack.pop()>starStack.pop())
                return false;
        }
        
        
        
        return openStack.isEmpty();
    }
}