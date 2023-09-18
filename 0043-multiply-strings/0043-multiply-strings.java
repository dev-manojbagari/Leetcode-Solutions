class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0"))
            return "0";
        int[] res = new int[num1.length()+num2.length()-1];
        
        for(int i=0;i<num1.length();i++){
            for(int j=0;j<num2.length();j++){
                res[i+j] += (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
            }
        }
        int carry=0;
        for(int i=res.length-1;i>0;i--){
            int sum = res[i]+carry;
            res[i] = (sum)%10;
            carry = (sum)/10;
        }
        
        if(carry>0)
            res[0] += carry;
        
        StringBuilder sb = new StringBuilder();
        for(int num:res)
            sb.append(num);
        
        return sb.toString();
    }
}