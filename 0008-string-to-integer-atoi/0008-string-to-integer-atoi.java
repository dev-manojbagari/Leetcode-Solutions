class Solution {
    public int myAtoi(String s) {
        int index=0,sign=1,n=s.length();
        
        while(index<n&&s.charAt(index)==' ')
            index++;
        if(index==n)
            return 0;
        
        if(s.charAt(index)=='-'||s.charAt(index)=='+'){
            sign = s.charAt(index)=='-'?-1:1;
            index++;
        }
        int num=0;
        while(index<n&&'0'<=s.charAt(index)&&s.charAt(index)<='9'){
            int val = s.charAt(index)-'0';
            if(num>Integer.MAX_VALUE/10||num==Integer.MAX_VALUE/10&&val>Integer.MAX_VALUE%10)
                return sign==-1?Integer.MIN_VALUE:Integer.MAX_VALUE;
            num  = num*10+val;
            index++;
        }
        
        
        return sign*num;
    }
}