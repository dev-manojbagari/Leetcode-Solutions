class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int start=0,end=n-1;
        
        while(start<n&&s.charAt(start)==' ')
            start++;
        
        while(end>=0&&s.charAt(end)==' ')
            end--;
        
        for(int i=end;i>=start;i--){
            if(s.charAt(i)==' ')
                continue;
            
            int j = i;
            while(j>=start&&s.charAt(j)!=' ')
                j--;
            
            for(int l=j+1;l<=i;l++){
                sb.append(s.charAt(l));
            }
            if(j>=start)
                sb.append(" ");
            
            i = j;
            
        }
            
        
        
        
        
        
        return sb.toString();
    }
}