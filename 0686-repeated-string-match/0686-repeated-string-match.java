class Solution {
    public int repeatedStringMatch(String a, String b) {
        
        StringBuilder sb = new StringBuilder();
        int count=0;
        while(sb.length()<b.length()){
             sb.append(a);
             count++;
        }
        
        if(isMatch(sb.toString(),b))
            return count;
        else if(isMatch(sb.append(a).toString(),b))
            return count+1;
        else
            return -1;
    }
    
    boolean isMatch(String a,String b){
        
        for(int i=0;i<a.length();i++){
            int j=0;
            while((i+j)<a.length()&&j<b.length()&&a.charAt(i+j)==b.charAt(j)){
                j++;
            }
            if(j==b.length())
                return true;
        }
        
        return false;
    }
    
}