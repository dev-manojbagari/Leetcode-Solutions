class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int i=0,j=n-1;
        
        while(i<n&&s.charAt(i)==' ')
            i++;
        
        while(j>=0&&s.charAt(j)==' ')
            j--;
        
        for(int k=j;k>=i;k--){
            while(k>=i&&s.charAt(k)==' ')
                k--;
            if(k==i-1)
                break;
            
            int lastChar = k;
            while(k>=i&&s.charAt(k)!=' ')
                k--;
            int first = k+1;
            
            for(int l=first;l<=lastChar;l++){
                sb.append(s.charAt(l));
            }
            if(first-1<i)
                break;
            sb.append(" ");
            
            k = first;
            
        }
            
        
        
        
        
        
        return sb.toString();
    }
}