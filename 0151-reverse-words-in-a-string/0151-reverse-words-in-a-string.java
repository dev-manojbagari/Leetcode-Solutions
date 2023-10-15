class Solution {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        int n=s.length();
        int start=0,end=n-1;
        while(start<=end&&s.charAt(start)==' ')
            start++;
        
        if(start==n)
            return "";
        
        while(end>=start&&s.charAt(end)==' ')
            end--;
        
        for(int i=end;i>=start;i--){
            if(s.charAt(i)==' ')
                continue;
            int j=i;
            while(j>=start&&s.charAt(j)!=' ')
                j--;
            
            for(int k=j+1;k<=i;k++)
                res.append(s.charAt(k));
            
            if(j>=start)
                res.append(" ");
            
            i=j;
        }
        
        return res.toString();
    }
}