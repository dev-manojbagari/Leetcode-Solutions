class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int count=0;
        while(sb.length()<b.length()){
            sb.append(a);
            count++;
        }
        
        if(sb.toString().contains(b)) return count;
        else if(sb.append(a).toString().contains(b))return ++count;
        else
            return -1;
            
        
        
    }
}