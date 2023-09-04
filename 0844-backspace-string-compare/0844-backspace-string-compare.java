class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        
        
        for(char c:s.toCharArray()){
            if(c=='#'){
                if(sb1.length()!=0){
                    sb1.setLength(sb1.length()-1);
                }
            }else
                sb1.append(c);
        }
         // System.out.println(sb1.toString());
        
         for(char c:t.toCharArray()){
            if(c=='#'){
                if(sb2.length()!=0){
                    sb2.setLength(sb2.length()-1);
                };
            }else{
    
                    sb2.append(c);
            }
                  // System.out.println(sb2.toString());
        }
                 
                  System.out.println(sb2.toString());
        
        
        return sb1.toString().equals(sb2.toString());
    }
}