class Solution {
    public String multiply(String num1, String num2) {
        int n1 = num1.length(),n2=num2.length();
        if(num1.charAt(0)=='0'||num2.charAt(0)=='0')
            return "0";
        int[] res = new int[n1+n2-1];
        
        for(int i=0;i<n1;i++){
            for(int j=0;j<n2;j++){
                res[i+j]+=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
            }
        }
        
        for(int i=res.length-1;i>0;i--){
            res[i-1]+=res[i]/10;
            res[i] = res[i]%10;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int num:res)
            sb.append(num);
        
        return sb.toString();
    }
}