class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int count =0;
        while(sb.length()<b.length()){
            sb.append(a);
            count++;
        }
        
        if(sb.toString().contains(b))
            return count;
        if(sb.append(a).toString().contains(b))
            return count+1;
        
        return -1;
    }
    
    
    boolean isMatch(String a,String b){
        
        for(int k=0;k<a.length();k++){
            int i=k;
            int j=0;
            
            while(i<a.length()&&j<b.length()&&a.charAt(i)==b.charAt(j)){
                i++;
                j++;
            }
            if(j==b.length())
                return true;
        }
        
        
        return false;
    }
    
    
}