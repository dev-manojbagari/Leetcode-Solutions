Stack<Integer> countStack = new Stack<>();
Stack<StringBuilder> stringStack = new Stack<>();
int k=0;
StringBuilder curr= new StringBuilder();
for(char c:s.toCharArray()){
if(Character.isDigit(c)){
k = k*10+c-'0';
}else if(c=='['){
countStack.push(k);
stringStack.push(curr);
k=0;
curr=new StringBuilder();
}else if(c==']'){
StringBuilder temp = curr;
curr=stringStack.pop();
int j=countStack.pop();
for(int i=0;i<j;i++)
curr.append(temp);
}else{
curr.append(c);
}
}
return curr.toString();