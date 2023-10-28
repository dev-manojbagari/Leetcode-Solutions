class Solution {
public int calculate(String s) {
char prevOp='+';
int num =0;
Stack<Integer> stack = new Stack<>();
for(int i=0;i<s.length();i++){
char curChar = s.charAt(i);
if(Character.isDigit(curChar)){
num = num*10+curChar-'0';
}
if(!Character.isDigit(curChar)&&!Character.isWhitespace(curChar)||i==s.length()-1){
switch(prevOp){
case '+':
stack.push(num);
break;
case '-':
stack.push(-num);
break;
case '*':
stack.push(stack.pop()*num);
break;
case '/':
stack.push(stack.pop()/num);
break;
}
prevOp=curChar;
num=0;
}
}
int sum =0;
while(!stack.isEmpty())
sum += stack.pop();
return sum;
}
boolean isNum(char c){
return '0'<=c&&c<='9';
}
}``