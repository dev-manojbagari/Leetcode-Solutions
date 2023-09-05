import java.util.*;

class Solution {
//     public String decodeString(String s) {
//         Stack<Integer> countStack = new Stack<>();
//         Stack<StringBuilder> stringStack = new Stack<>();
        
//         int k=0;
//         StringBuilder curr= new StringBuilder();
//         for(char c:s.toCharArray()){
            
//             if(Character.isDigit(c)){
//                 k = k*10+c;
//             }else if(c=='['){
//                 countStack.push(k);
//                 stringStack.push(curr);
//                 k=0;
//                 curr=new StringBuilder();
//             }else if(c==']'){
//                 String temp = curr.toString();
//                 curr=stringStack.pop();
                
//                 for(int i=countStack.pop();i>=0;i--)
//                     curr.append(temp);
//             }else{
//                 curr.append(c);
//             }
            
//         }
        
//         return curr.toString();
        
//     }
// }





























   public String decodeString(String s) {
        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<StringBuilder> stringStack = new ArrayDeque<>();
        StringBuilder cur = new StringBuilder();
        int k = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + ch - '0';
            } else if (ch == '[') {
                countStack.push(k);
                stringStack.push(cur);
                cur = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                StringBuilder tmp = cur;
                cur = stringStack.pop();
                for (k = countStack.pop(); k > 0; --k) cur.append(tmp);
            } else cur.append(ch);
        }
        return cur.toString();
    }


}