class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        
        
        int i=0,j=0;
        
        while(i<v1.length||j<v2.length){
            
            int num1 = i>=v1.length?0:Integer.parseInt(v1[i]);
            int num2 = j>=v2.length?0:Integer.parseInt(v2[j]);
            
            if(num1==num2){
                i++;
                j++;
            }else{
                return Integer.compare(num1,num2);
            }
        }
        
        return 0;
    }
}